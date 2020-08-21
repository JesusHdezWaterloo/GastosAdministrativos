package com.jhw.gestion.modules.gasto.ui.gasto;

import com.jhw.gestion.modules.contabilidad.core.domain.CuadreDomain;
import com.jhw.gestion.modules.contabilidad.core.domain.InfoOperacionContableDomain;
import com.jhw.gestion.modules.contabilidad.core.domain.OperacionContableDomain;
import com.jhw.gestion.modules.contabilidad.core.domain.facade.CuadreUI;
import com.jhw.gestion.modules.contabilidad.core.domain.facade.OperacionCuadreDomain;
import com.jhw.gestion.modules.contabilidad.ui.cuadre.OperacionCuadreInputView;
import com.jhw.gestion.modules.contabilidad.ui.info_op.InfoOpInputView;
import com.jhw.gestion.modules.gasto.core.domain.GastoDomain;
import com.jhw.gestion.modules.gasto.core.domain.TipoGastoDomain;
import com.jhw.gestion.modules.gasto.ui.module.GastoSwingModule;
import com.jhw.gestion.modules.gasto.ui.tipo_gasto.TipoGastoICBS;
import com.jhw.swing.material.components.container.layout.HorizontalLayoutComponent;
import com.jhw.swing.material.components.container.layout.HorizontalLayoutContainer;
import com.jhw.swing.material.components.container.layout.VerticalLayoutContainer;
import com.jhw.swing.models.clean.CleanCRUDInputView;

/**
 *
 * @author Jesús Hernández Barrios (jhernandezb96@gmail.com)
 */
public class GastoInputView extends CleanCRUDInputView<GastoDomain> {

    public static GastoInputView from() {
        return new GastoInputView(null, null);
    }

    public static GastoInputView fromModel(GastoDomain model) {
        return new GastoInputView(null, model);
    }

    public static GastoInputView fromBase(TipoGastoDomain base) {
        return new GastoInputView(
                new GastoDomain(0,
                        null,
                        base.getMonedaDefectoFk(),
                        base),
                null);
    }

    private final GastoDomain base;

    public GastoInputView(GastoDomain base, GastoDomain model) {
        super(model, GastoSwingModule.gastoUC, GastoDomain.class);
        if (model != null) {
            this.base = model;
        } else {
            this.base = base;
        }
        initComponents();
        addListener();
        update();
    }

    private void initComponents() {
        setHeader("Crear Gasto", "Editar Gasto");

        tipoGastoICBS = new TipoGastoICBS();
        operacionInputView = new OperacionCuadreInputView();

        VerticalLayoutContainer.builder vlc = VerticalLayoutContainer.builder();
        vlc.add(tipoGastoICBS);
        vlc.add(operacionInputView);
        vlc.add(infoInputView);

        //HorizontalLayoutContainer.builder hlcSalario = HorizontalLayoutContainer.builder((int) textFieldValor.getPreferredSize().getHeight());
        //hlcSalario.add(HorizontalLayoutComponent.builder(textFieldValor).gapRight(5).build());
        //hlcSalario.add(HorizontalLayoutComponent.builder(monedaICBS).gapLeft(5).build());
        //vlc.add(hlcSalario.build());
        this.setComponent(vlc.build());
    }

    // Variables declaration - do not modify
    private OperacionCuadreInputView operacionInputView;
    private InfoOpInputView infoInputView;
    private TipoGastoICBS tipoGastoICBS;
    // End of variables declaration

    @Override
    public void update() {
        if (base == null) {
            operacionInputView.setObject(
                    new OperacionCuadreDomain(
                            base.getValor(),
                            base.getMonedaFk(),
                            base.getCuadreFk().getOperacionContableFk().getCuentaFk(),
                            base.getCuadreFk().getOperacionContableCuadreFk().getCuentaFk()));
        } else {
            operacionInputView.setTipoOp(base.getTipoGastoFk().getTipoOperacionContableDefectoFk());
        }
    }

    @Override
    public GastoDomain getNewModel() throws Exception {
        OperacionCuadreDomain op = operacionInputView.getNewModel();
        InfoOperacionContableDomain info = infoInputView.getNewModel();
        TipoGastoDomain tipo = tipoGastoICBS.getSelectedItem();
        CuadreUI cuadreUI = new CuadreUI(op, info);

        if (getOldModel() == null) {
            CuadreDomain cuadre = new CuadreDomain(cuadreUI);
            return new GastoDomain(op.getValor(), cuadre, op.getMoneda(), tipo);
        } else {
            getOldModel().getCuadreFk().updateWith(cuadreUI);
            getOldModel().setValor(op.getValor());
            getOldModel().setMonedaFk(op.getMoneda());
            getOldModel().setTipoGastoFk(tipo);
            return getOldModel();
        }
    }

    private void addListener() {
        tipoGastoICBS.getComboBox().addActionListener((java.awt.event.ActionEvent evt) -> {
            onGastoComboBoxActionPerformed();
        });
    }

    private void onGastoComboBoxActionPerformed() {
        try {
            TipoGastoDomain gsto = tipoGastoICBS.getSelectedItem();
            if (gsto != null) {
                //monedaICBS.setSelectedItem(gsto.getMonedaDefectoFk());
                //cuentaICBS.setSelectedItem(gsto.getCuentaDefectoFk());
                //checkBoxJustificado.setSelected(gsto.getJustificadoDefecto());
            }
        } catch (Exception e) {
        }
    }

}

package com.jhw.gestion.modules.gasto.ui.gasto;

import com.jhw.gestion.modules.contabilidad.core.domain.CuadreDomain;
import com.jhw.gestion.modules.contabilidad.core.domain.facade.CuadreUI;
import com.jhw.gestion.modules.contabilidad.core.domain.facade.DocNombreUI;
import com.jhw.gestion.modules.contabilidad.core.domain.facade.FechaDescUI;
import com.jhw.gestion.modules.contabilidad.core.domain.facade.OperacionCuadreUI;
import com.jhw.gestion.modules.contabilidad.ui.cuadre.pedazos.DocNombreInputView;
import com.jhw.gestion.modules.contabilidad.ui.cuadre.pedazos.FechaDescInputView;
import com.jhw.gestion.modules.contabilidad.ui.cuadre.pedazos.OperacionCuadreInputView;
import com.jhw.gestion.modules.gasto.core.domain.GastoDomain;
import com.jhw.gestion.modules.gasto.core.domain.TipoGastoDomain;
import com.jhw.gestion.modules.gasto.repo.entities.Gasto;
import com.jhw.gestion.modules.gasto.ui.module.GastoSwingModule;
import com.jhw.gestion.modules.gasto.ui.tipo_gasto.TipoGastoICBS;
import com.jhw.swing.material.components.container.layout.VerticalLayoutContainer;
import com.jhw.swing.models.clean.CleanCRUDInputView;
import java.util.Date;

/**
 *
 * @author Jesús Hernández Barrios (jhernandezb96@gmail.com)
 */
public class GastoInputView extends CleanCRUDInputView<GastoDomain> {

    public static GastoInputView from() {
        return new GastoInputView(null);
    }

    public static GastoInputView fromModel(GastoDomain model) {
        return new GastoInputView(model);
    }

    public static GastoInputView fromBase(TipoGastoDomain tipo) {
        GastoInputView thiss = new GastoInputView(null);
        thiss.setTipoGasto(tipo);
        return thiss;
    }

    public GastoInputView(GastoDomain model) {
        super(model, GastoSwingModule.gastoUC, GastoDomain.class);
        initComponents();
        addListener();
        update();
    }

    private void initComponents() {
        //doc, nombre ....
        docNombreInputView = new DocNombreInputView();

        //valor, cuentas ....
        operacionInputView = new OperacionCuadreInputView();

        //tipo gasto
        tipoGastoICBS = new TipoGastoICBS();

        //fecha, desc ....
        fechaDescInputView = new FechaDescInputView();

        VerticalLayoutContainer.builder vlc = VerticalLayoutContainer.builder(400);
        vlc.add(docNombreInputView);
        vlc.add(operacionInputView);
        vlc.add(tipoGastoICBS);
        vlc.add(fechaDescInputView, true);

        this.setComponent(vlc.build());
    }

    // Variables declaration - do not modify
    private DocNombreInputView docNombreInputView;
    private OperacionCuadreInputView operacionInputView;
    private TipoGastoICBS tipoGastoICBS;
    private FechaDescInputView fechaDescInputView;
    // End of variables declaration

    @Override
    public void update() {
        tipoGastoICBS.update();
        if (getOldModel() == null) {
            setHeader("Crear Gasto");
        } else {
            setHeader("Editar Gasto");
            docNombreInputView.setObject(new DocNombreUI(getOldModel().getCuadreFk().info()));
            fechaDescInputView.setObject(new FechaDescUI(getOldModel().getCuadreFk().info()));
            
            operacionInputView.setObject(new OperacionCuadreUI(getOldModel().getCuadreFk()));
            operacionInputView.getMoneda().setSelectedItem(getOldModel().getMonedaFk());
            operacionInputView.getTextFieldValor().setDouble(getOldModel().getValor());
        }
    }

    @Override
    public GastoDomain getNewModel() throws Exception {
        DocNombreUI docNombre = docNombreInputView.getNewModel();
        OperacionCuadreUI op = operacionInputView.getNewModel();
        FechaDescUI fechaDesc = fechaDescInputView.getNewModel();
        TipoGastoDomain tipoGasto = tipoGastoICBS.getSelectedItem();

        CuadreUI cuadre = new CuadreUI(docNombre, op, fechaDesc, tipoGasto.getTipoOperacionContableDefectoFk());

        GastoDomain neww = new GastoDomain(op.getValor(), cuadre.buildCuadre(), op.getMoneda(), tipoGasto);

        if (getOldModel() == null) {
            return neww;
        } else {
            neww.setIdGasto(getOldModel().getIdGasto());
            neww.getCuadreFk().setIdCuadre(getOldModel().getCuadreFk().getIdCuadre());
            return neww;
        }
    }

    private void addListener() {
        tipoGastoICBS.getComboBox().addActionListener((java.awt.event.ActionEvent evt) -> {
            onGastoComboBoxActionPerformed();
        });
    }

    private void onGastoComboBoxActionPerformed() {
        try {
            setTipoGasto(tipoGastoICBS.getSelectedItem());
        } catch (Exception e) {
        }
    }

    private void setTipoGasto(TipoGastoDomain tipo) {
        fechaDescInputView.setObject(new FechaDescUI(new Date(), tipo.getFormaPagoFk(), tipo.getDescripcion()));
        docNombreInputView.setObject(new DocNombreUI("Pago de " + tipo.getNombreGasto(), ""));

        operacionInputView.getMoneda().setSelectedItem(tipo.getMonedaDefectoFk());
        operacionInputView.getCuentaICBS().setMatchingItem(tipo.getTipoOperacionContableDefectoFk().getTipoCuentaDefectoFk());
        operacionInputView.getCuentaCuadreICBS().setMatchingItem(tipo.getTipoOperacionContableDefectoFk().getTipoCuentaCuadreDefectoFk());

        tipoGastoICBS.setSelectedItem(tipo);
    }

}

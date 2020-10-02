package com.jhw.module.gestion.gastos.ui.gasto;

import com.jhw.module.gestion.contabilidad.core.domain.facade.CuadreUI;
import com.jhw.module.gestion.contabilidad.core.domain.facade.DocNombreUI;
import com.jhw.module.gestion.contabilidad.core.domain.facade.FechaDescUI;
import com.jhw.module.gestion.contabilidad.core.domain.facade.OperacionCuadreUI;
import com.jhw.module.gestion.contabilidad.ui.cuadre.pedazos.DocNombreInputView;
import com.jhw.module.gestion.contabilidad.ui.cuadre.pedazos.FechaDescInputView;
import com.jhw.module.gestion.contabilidad.ui.cuadre.pedazos.OperacionCuadreInputView;
import com.jhw.module.gestion.gastos.core.domain.GastoDomain;
import com.jhw.module.gestion.gastos.core.domain.TipoGastoDomain;
import com.jhw.module.gestion.gastos.ui.module.GastoSwingModule;
import com.jhw.module.gestion.gastos.ui.tipo_gasto.TipoGastoICBS;
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

    private GastoInputView(GastoDomain model) {
        super(model, GastoSwingModule.gastoUC, GastoDomain.class);
        initComponents();
        addListener();
        update();
    }

    private void initComponents() {
        //doc, nombre ....
        docNombreInputView = DocNombreInputView.from();

        //valor, cuentas ....
        operacionInputView = OperacionCuadreInputView.from();

        //tipo gasto
        tipoGastoICBS = new TipoGastoICBS();

        //fecha, desc ....
        fechaDescInputView = FechaDescInputView.from();

        VerticalLayoutContainer.builder vlc = VerticalLayoutContainer.builder(400);
        vlc.add(docNombreInputView);
        vlc.add(operacionInputView);
        vlc.add(tipoGastoICBS);
        vlc.add(fechaDescInputView, true);

        this.setComponent(vlc.build());
        
        operacionInputView.getTipoOperICBS().setEnabled(false);
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
            operacionInputView.getMoneda().setObject(getOldModel().getMonedaFk());
            operacionInputView.getTextFieldValor().setObject(getOldModel().getValor());
        }
    }

    @Override
    public GastoDomain getNewModel() throws Exception {
        DocNombreUI docNombre = docNombreInputView.getNewModel();
        OperacionCuadreUI op = operacionInputView.getNewModel();
        FechaDescUI fechaDesc = fechaDescInputView.getNewModel();
        TipoGastoDomain tipoGasto = tipoGastoICBS.getObject();

        CuadreUI cuadre = new CuadreUI(docNombre, op, fechaDesc);

        GastoDomain neww = new GastoDomain(op.getValor(), op.getMoneda(), cuadre.buildCuadre(), tipoGasto);

        if (getOldModel() == null) {
            return neww;
        } else {
            neww.setIdGasto(getOldModel().getIdGasto());
            neww.getCuadreFk().setIdCuadre(getOldModel().getCuadreFk().getIdCuadre());
            return neww;
        }
    }

    private void addListener() {
        tipoGastoICBS.addActionListener((java.awt.event.ActionEvent evt) -> {
            onGastoComboBoxActionPerformed();
        });
    }

    private void onGastoComboBoxActionPerformed() {
        try {
            setTipoGasto(tipoGastoICBS.getObject());
        } catch (Exception e) {
        }
    }

    private void setTipoGasto(TipoGastoDomain tipo) {
        fechaDescInputView.setObject(new FechaDescUI(new Date(), tipo.getFormaPagoFk(), tipo.getDescripcion()));
        docNombreInputView.setObject(new DocNombreUI("Pago de " + tipo.getNombreGasto(), ""));

        operacionInputView.getMoneda().setObject(tipo.getMonedaDefectoFk());
        operacionInputView.setTipoOp(tipo.getTipoOperacionContableDefectoFk());
        
        tipoGastoICBS.setObject(tipo);
    }

}

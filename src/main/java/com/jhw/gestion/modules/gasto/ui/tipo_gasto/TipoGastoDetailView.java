package com.jhw.gestion.modules.gasto.ui.tipo_gasto;

import com.clean.core.app.services.ExceptionHandler;
import com.jhw.gestion.modules.gasto.core.domain.TipoGastoDomain;
import com.jhw.gestion.modules.gasto.ui.module.GastoSwingModule;
import com.jhw.swing.material.standards.MaterialIcons;
import com.jhw.swing.material.components.button._MaterialButtonIconTransparent;
import com.jhw.swing.models.detail._MaterialPanelDetail;
import com.jhw.swing.material.components.table.Column;
import com.jhw.swing.models.input.dialogs.DialogModelInput;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.jhw.gestion.modules.gasto.ui.gasto.GastoInputView;

/**
 *
 * @author Jesús Hernández Barrios (jhernandezb96@gmail.com)
 */
public class TipoGastoDetailView extends _MaterialPanelDetail<TipoGastoDomain> {

    private static final String COL_GASTO = "Gasto";
    private static final String COL_MONEDA = "Moneda";
    private static final String COL_OPERACION = "Operación";

    public TipoGastoDetailView() {
        super(
                Column.builder().name(COL_GASTO).width(150).build(),
                Column.builder().name(COL_MONEDA).build(),
                Column.builder().name(COL_OPERACION).build()
        );

        this.personalize();
    }

    private void personalize() {
        addActionsExtra();
        this.setHeaderText("Tipos de gastos");
        this.setActionColumnButtonsVisivility(true, true, false);//no pone el view, no esta implementado todavia
    }

    @Override
    public void update() {
        try {
            setCollection(GastoSwingModule.tipoGastoUC.findAll());
            firePropertyChange("update", null, null);
        } catch (Exception e) {
            ExceptionHandler.handleException(e);
        }
    }

    @Override
    public Object[] getRowObject(TipoGastoDomain obj) {
        return new Object[]{
            obj.getNombreGasto(),
            obj.getMonedaDefectoFk(),
            obj.getTipoOperacionContableDefectoFk()};
    }

    @Override
    protected void buttonNuevoActionListener() {
        new DialogModelInput(this, new TipoGastoInputView());
    }

    @Override
    protected TipoGastoDomain deleteAction(TipoGastoDomain obj) {
        try {
            return GastoSwingModule.tipoGastoUC.destroy(obj);
        } catch (Exception ex) {
            ExceptionHandler.handleException(ex);
        }
        return null;
    }

    @Override
    protected void editAction(TipoGastoDomain obj) {
        new DialogModelInput(this, new TipoGastoInputView(obj));
    }

    @Override
    protected void viewAction(TipoGastoDomain obj) {
        System.out.println("NO NECESARIO TODAVÍA.");
    }

    private void addActionsExtra() {
        _MaterialButtonIconTransparent btnPay = new _MaterialButtonIconTransparent();
        btnPay.setIcon(MaterialIcons.MONETIZATION_ON.deriveIcon(18f));
        btnPay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onPayGastoActionPerformed();
            }
        });
        this.addActionExtra(btnPay);
    }

    private void onPayGastoActionPerformed() {
        new DialogModelInput(this, GastoInputView.fromBase(getSelectedElement()));
    }
}

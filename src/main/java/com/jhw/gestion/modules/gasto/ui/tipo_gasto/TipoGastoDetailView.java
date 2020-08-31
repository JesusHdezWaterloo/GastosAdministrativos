package com.jhw.gestion.modules.gasto.ui.tipo_gasto;

import com.clean.core.app.services.ExceptionHandler;
import com.jhw.gestion.modules.gasto.core.domain.TipoGastoDomain;
import com.jhw.gestion.modules.gasto.ui.module.GastoSwingModule;
import com.jhw.swing.material.standards.MaterialIcons;
import com.jhw.swing.models.detail._MaterialPanelDetail;
import com.jhw.swing.material.components.table.Column;
import com.jhw.swing.models.input.dialogs.DialogModelInput;
import java.awt.event.ActionEvent;
import com.jhw.gestion.modules.gasto.ui.gasto.GastoInputView;
import com.jhw.gestion.modules.gasto.ui.module.GastoModuleNavigator;
import javax.swing.AbstractAction;

/**
 *
 * @author Jesús Hernández Barrios (jhernandezb96@gmail.com)
 */
public class TipoGastoDetailView extends _MaterialPanelDetail<TipoGastoDomain> {

    private static final String COL_GASTO = "Gasto";

    public TipoGastoDetailView() {
        super(
                Column.builder().name(COL_GASTO).build()
        );

        this.personalize();
    }

    private void personalize() {
        addActionsExtra();

        this.setHeaderText("Tipos de gastos");
        this.setIcon(GastoModuleNavigator.ICON_TIPO_GASTO);

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
            obj.getNombreGasto()};
    }

    @Override
    protected void buttonNuevoActionListener() {
        new DialogModelInput(this, TipoGastoInputView.from());
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
        new DialogModelInput(this, TipoGastoInputView.fromModel(obj));
    }

    @Override
    protected void viewAction(TipoGastoDomain obj) {
        System.out.println("NO NECESARIO TODAVÍA.");
    }

    private void addActionsExtra() {
        this.addActionExtra(new AbstractAction("Gastar", GastoModuleNavigator.ICON_GASTO.deriveIcon(18f)) {
            @Override
            public void actionPerformed(ActionEvent e) {
                onPayGastoActionPerformed();
            }
        });
    }

    private void onPayGastoActionPerformed() {
        new DialogModelInput(this, GastoInputView.fromBase(getSelectedElement()));
    }
}

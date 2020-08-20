package com.jhw.gestion.modules.gasto.ui.titular;

import com.clean.core.app.services.ExceptionHandler;
import com.jhw.gestion.modules.gasto.ui.module.ContabilidadSwingModule;
import com.jhw.swing.material.components.table.Column;
import com.jhw.swing.models.input.dialogs.DialogModelInput;
import com.jhw.swing.models.detail._MaterialPanelDetail;

/**
 *
 * @author Jesús Hernández Barrios (jhernandezb96@gmail.com)
 */
public class TitularDetailView extends _MaterialPanelDetail<TitularDomain> {

    private static final String COL_NOMBRE = "Titular";
    private static final String COL_DESC = "Descripción";

    public TitularDetailView() {
        super(
                Column.builder().name(COL_NOMBRE).build(),
                Column.builder().name(COL_DESC).build()
        );

        this.personalize();
    }

    private void personalize() {
        this.setHeaderText("Tipos de Cuenta");
        this.setActionColumnButtonsVisivility(true, true, false);//no pone el view, no esta implementado todavia
    }

    @Override
    public void update() {
        try {
            setCollection(ContabilidadSwingModule.titularUC.findAll());
        } catch (Exception e) {
        }
    }

    @Override
    public Object[] getRowObject(TitularDomain obj) {
        return new Object[]{obj.getNombreTitular(),
            obj.getDescripcion()};
    }

    @Override
    protected void buttonNuevoActionListener() {
        new DialogModelInput(this, new TitularInputView());
    }

    @Override
    protected TitularDomain deleteAction(TitularDomain obj) {
        try {
            ContabilidadSwingModule.titularUC.destroy(obj);
            return obj;
        } catch (Exception ex) {
            ExceptionHandler.handleException(ex);
        }
        return null;
    }

    @Override
    protected void editAction(TitularDomain obj) {
        new DialogModelInput(this, new TitularInputView(obj));
    }

    @Override
    protected void viewAction(TitularDomain obj) {
        System.out.println("NO NECESARIO TODAVÍA.");
    }

}

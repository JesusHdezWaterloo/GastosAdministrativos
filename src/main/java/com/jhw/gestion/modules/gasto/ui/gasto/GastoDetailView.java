package com.jhw.gestion.modules.gasto.ui.gasto;

import com.clean.core.app.services.ExceptionHandler;
import com.jhw.gestion.modules.gasto.ui.module.GastoSwingModule;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.jhw.swing.material.standards.MaterialIcons;
import com.jhw.swing.material.components.button._MaterialButtonIconTransparent;
import com.jhw.swing.models.detail._MaterialPanelDetail;
import com.jhw.swing.material.components.table.Column;
import com.jhw.swing.models.input.dialogs.DialogModelInput;
import com.jhw.swing.bundles.dialog.DialogPanel;
import com.jhw.swing.material.components.table.editors_renders.money.MoneyCellRender;
import com.jhw.swing.material.components.table.editors_renders.money.MoneyTableComponent;
import com.jhw.gestion.modules.gasto.core.domain.GastoDomain;
import com.jhw.gestion.modules.gasto.ui.chart.GastosChart;
import com.jhw.gestion.modules.gasto.ui.module.GastoModuleNavigator;
import static com.jhw.utils.others.SDF.SDF;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.AbstractAction;

/**
 *
 * @author Jesús Hernández Barrios (jhernandezb96@gmail.com)
 */
public class GastoDetailView extends _MaterialPanelDetail<GastoDomain> implements PropertyChangeListener {

    private static final String COL_GASTO = "Gasto";
    private static final String COL_VALOR = "Valor";
    private static final String COL_FECHA = "Fecha";
    //private static final String COL_CUADRE = "Cuadre";
    private static final String COL_CUENTA = "Cuenta";

    public GastoDetailView() {
        super(
                Column.builder().name(COL_GASTO).build(),
                Column.builder().name(COL_VALOR).build(),
                Column.builder().name(COL_FECHA).build(),
                //Column.builder().name(COL_CUADRE).build(),
                Column.builder().name(COL_CUENTA).build()
        );

        this.personalize();
    }

    private void personalize() {
        setUpEditorsRenders();

        this.setHeaderText("Gastos Realizados");
        this.setIcon(GastoModuleNavigator.ICON_GASTO);

        addOptionsElements();

        this.getTable().setPageVisibility(true);
        this.setActionColumnButtonsVisivility(true, true, false);//no pone el view, no esta implementado todavia
    }

    @Override
    public void update() {
        try {
            setCollection(GastoSwingModule.gastoUC.findAll());
        } catch (Exception e) {
            ExceptionHandler.handleException(e);
        }
    }

    @Override
    public Object[] getRowObject(GastoDomain obj) {
        return new Object[]{
            obj.getTipoGastoFk(),
            MoneyTableComponent.from(obj.getValor(), obj.getMonedaFk()),
            SDF.format(obj.getCuadreFk().info().getFecha()),
            obj.getCuadreFk().getOperacionContableFk().getCuentaFk()};
    }

    @Override
    protected void buttonNuevoActionListener() {
        new DialogModelInput(this, GastoInputView.from());
    }

    @Override
    protected GastoDomain deleteAction(GastoDomain obj) {
        try {
            return GastoSwingModule.gastoUC.destroy(obj);
        } catch (Exception ex) {
            ExceptionHandler.handleException(ex);
        }
        return null;
    }

    @Override
    protected void editAction(GastoDomain obj) {
        new DialogModelInput(this, GastoInputView.fromModel(obj));
    }

    @Override
    protected void viewAction(GastoDomain obj) {
        System.out.println("NO NECESARIO TODAVÍA.");
    }

    private void addOptionsElements() {
        this.addOptionElement(new AbstractAction("Gráfico con detalles de los gastos.", GastoModuleNavigator.ICON_REPORTE_GASTO.deriveIcon(30f)) {
            @Override
            public void actionPerformed(ActionEvent e) {
                onChartOptionActionPerformed();
            }
        });
    }

    private void onChartOptionActionPerformed() {
        new DialogPanel("Gráfico de gastos", new GastosChart());
    }

    private void setUpEditorsRenders() {
        getTable().getColumn(COL_VALOR).setCellRenderer(new MoneyCellRender());
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        switch (evt.getPropertyName()) {
            case "update":
                update();
                break;
        }
    }
}

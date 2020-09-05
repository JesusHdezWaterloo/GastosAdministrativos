package com.jhw.gestion.modules.gasto.ui.gasto;

import com.clean.core.app.services.ExceptionHandler;
import com.jhw.excel.utils.ExcelListWriter;
import com.jhw.gestion.modules.gasto.ui.module.GastoSwingModule;
import java.awt.event.ActionEvent;
import com.jhw.swing.models.detail._MaterialPanelDetailDragDrop;
import com.jhw.swing.material.components.table.Column;
import com.jhw.swing.models.input.dialogs.DialogModelInput;
import com.jhw.swing.bundles.dialog.DialogPanel;
import com.jhw.swing.material.components.table.editors_renders.money.MoneyCellRender;
import com.jhw.swing.material.components.table.editors_renders.money.MoneyTableComponent;
import com.jhw.gestion.modules.gasto.core.domain.GastoDomain;
import com.jhw.gestion.modules.gasto.ui.report.chart.GastosByTipoChart;
import com.jhw.gestion.modules.gasto.ui.module.GastoModuleNavigator;
import com.jhw.gestion.modules.gasto.ui.report.chart.GastosReport;
import com.jhw.gestion.modules.gasto.ui.report.export.GastoExport;
import com.jhw.swing.material.components.button._MaterialButtonPopup;
import com.jhw.utils.others.SDF;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.function.BiFunction;
import javax.swing.AbstractAction;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Workbook;

/**
 *
 * @author Jesús Hernández Barrios (jhernandezb96@gmail.com)
 */
public class GastoDetailView extends _MaterialPanelDetailDragDrop<GastoDomain> implements PropertyChangeListener {

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

        this.setExportConfig(GastoExport.from(this));
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
            SDF.SDF.format(obj.getCuadreFk().info().getFecha()),
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
        _MaterialButtonPopup reportButton = new _MaterialButtonPopup();
        reportButton.setText("Reportes");
        reportButton.setIconTextGap(10);
        reportButton.setIcon(GastoModuleNavigator.ICON_REPORTE_GASTO);
        reportButton.setToolTipText("Reportes relacionados a los gastos.");//. Click para desplegar TODAS las opciones de exportación.

        reportButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GastosReport.reportGastosByTipo();
            }
        });
        addOptionElement(reportButton);

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

package com.jhw.module.gestion.gastos.ui.gasto;

import com.clean.core.app.services.ExceptionHandler;
import com.jhw.module.gestion.gastos.ui.module.GastoSwingModule;
import java.awt.event.ActionEvent;
import com.jhw.swing.material.components.table.Column;
import com.jhw.swing.material.components.table.editors_renders.money.MoneyCellRender;
import com.jhw.swing.material.components.table.editors_renders.money.MoneyTableComponent;
import com.jhw.module.gestion.gastos.core.domain.GastoDomain;
import com.jhw.module.gestion.gastos.ui.module.GastoModuleNavigator;
import com.jhw.module.gestion.gastos.ui.report.chart.GastosReport;
import com.jhw.module.gestion.gastos.ui.report.export.GastoExport;
import com.jhw.swing.material.components.button._MaterialButtonPopup;
import com.jhw.swing.models.clean.CleanDetailCRUDDragDrop;
import com.jhw.swing.models.input.panels.ModelPanel;
import com.jhw.utils.others.SDF;
import java.awt.event.ActionListener;
import java.util.List;

/**
 *
 * @author Jesús Hernández Barrios (jhernandezb96@gmail.com)
 */
public class GastoDetailView extends CleanDetailCRUDDragDrop<GastoDomain> {

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

    }

    @Override
    protected void personalize() {
        setUpEditorsRenders();

        this.setHeaderText("Gastos Realizados");
        this.setIcon(GastoModuleNavigator.ICON_GASTO);

        addOptionsElements();

        this.getTableByPage().setPageVisibility(true);
        this.setActionColumnButtonsVisivility(true, true, false);//no pone el view, no esta implementado todavia

        this.setExportConfig(GastoExport.from(this));
    }

    @Override
    protected List<GastoDomain> getListUpdate() throws Exception {
        return GastoSwingModule.gastoUC.findAll();
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
    protected void addPropertyChange() {
        GastoSwingModule.gastoUC.addPropertyChangeListener(this);
    }

    @Override
    protected ModelPanel<GastoDomain> getModelPanelNew() {
        return GastoInputView.from();
    }

    @Override
    protected ModelPanel<GastoDomain> getModelPanelEdit(GastoDomain obj) {
        return GastoInputView.fromModel(obj);
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

}

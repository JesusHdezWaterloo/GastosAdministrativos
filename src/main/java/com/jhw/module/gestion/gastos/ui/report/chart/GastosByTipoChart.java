package com.jhw.module.gestion.gastos.ui.report.chart;

import com.clean.core.app.services.ExceptionHandler;
import com.jaga.swing.chart._MaterialBarChart;
import com.jhw.utils.interfaces.Update;
import com.jhw.swing.material.standards.MaterialColors;
import com.jhw.module.gestion.contabilidad.utils.MonedaHandler;
import com.jhw.module.gestion.gastos.core.domain.TipoGastoDomain;
import com.jhw.module.gestion.gastos.ui.module.GastoSwingModule;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Jesús Hernández Barrios (jhernandezb96@gmail.com)
 */
public class GastosByTipoChart extends _MaterialBarChart implements Update {

    public GastosByTipoChart() {
        addCategory("Tipo de gasto", MaterialColors.AMBERA_700);
        update();
    }

    @Override
    public void update() {
        removeAllBars();
        try {
            HashMap<TipoGastoDomain, BigDecimal> h = GastoSwingModule.gastoUC.reporteGastadoPorGasto();
            for (Map.Entry<TipoGastoDomain, BigDecimal> entry : h.entrySet()) {
                addBar(entry.getValue(), 0, entry.getKey().getNombreGasto());
            }
            this.getChart().setTitle("Gastos Realizados por tipo (Conversión a: " + MonedaHandler.getMonedaBase() + ")");
        } catch (Exception ex) {
            ExceptionHandler.handleException(ex);
        }

    }

}

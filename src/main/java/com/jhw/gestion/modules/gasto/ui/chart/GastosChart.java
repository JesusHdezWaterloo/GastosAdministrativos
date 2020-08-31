package com.jhw.gestion.modules.gasto.ui.chart;

import com.clean.core.app.services.ExceptionHandler;
import com.jaga.swing.chart._MaterialBarChart;
import com.jhw.utils.interfaces.Update;
import com.jhw.swing.material.standards.MaterialColors;
import com.jhw.gestion.modules.contabilidad.utils.MonedaHandler;
import com.jhw.gestion.modules.gasto.core.domain.TipoGastoDomain;
import com.jhw.gestion.modules.gasto.ui.module.GastoSwingModule;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Jesús Hernández Barrios (jhernandezb96@gmail.com)
 */
public class GastosChart extends _MaterialBarChart implements Update {

    public GastosChart() {
        addCategory("Gastos", MaterialColors.AMBERA_700);
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
            this.getChart().setTitle("Gastos Realizados (Conversión a: " + MonedaHandler.getMonedaBase() + ")");
        } catch (Exception ex) {
            ExceptionHandler.handleException(ex);
        }

    }

}

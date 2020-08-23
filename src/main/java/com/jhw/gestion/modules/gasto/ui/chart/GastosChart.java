package com.jhw.gestion.modules.gasto.ui.chart;

import com.clean.core.app.services.ExceptionHandler;
import java.util.List;
import com.jaga.swing.chart._MaterialBarChart;
import com.jhw.gestion.modules.contabilidad.core.domain.MonedaDomain;
import com.jhw.utils.interfaces.Update;
import com.jhw.swing.material.standards.MaterialColors;
import com.jhw.gestion.modules.contabilidad.utils.MonedaHandler;
import com.jhw.gestion.modules.gasto.core.domain.GastoDomain;
import com.jhw.gestion.modules.gasto.core.domain.TipoGastoDomain;
import com.jhw.gestion.modules.gasto.ui.module.GastoSwingModule;
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
            HashMap<TipoGastoDomain, Double> h = GastoSwingModule.tipoGastoUC.reportGastadoPorGasto();
            for (Map.Entry<TipoGastoDomain, Double> entry : h.entrySet()) {
                addBar(entry.getValue(), 0, entry.getKey().getNombreGasto());
            }
            this.getChart().setTitle("Gastos Realizados (Conversión a: " + MonedaHandler.getMonedaBase() + ")");
        } catch (Exception ex) {
            ExceptionHandler.handleException(ex);
        }

    }

}

package com.jhw.gestion.modules.gasto.ui.chart;

import java.util.List;
import com.jaga.swing.chart._MaterialBarChart;
import com.jhw.gestion.modules.contabilidad.core.domain.MonedaDomain;
import com.jhw.utils.interfaces.Update;
import com.jhw.swing.material.standards.MaterialColors;
import com.jhw.gestion.modules.contabilidad.utils.MonedaHandler;
import com.jhw.gestion.modules.gasto.core.domain.GastoDomain;
import com.jhw.gestion.modules.gasto.core.domain.TipoGastoDomain;
import com.jhw.gestion.modules.gasto.ui.module.GastoSwingModule;

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

        /*for (TipoGastoDomain tipo : GastoSwingModule.tipoGastoUC.findAll()) {
            addCategory(tipo.getNombreGasto(), MaterialColors.AMBER_400);
        }

        //coje una moneda para convertilas todas
        MonedaDomain monBase = MonedaHandler.getMonedaBase();
        if (monBase == null) {
            return;
        }

        for (GastoDomain gastoDomain : GastoSwingModule.gastoUC.findAll()) {
            addBar(gastoDomain.getValor(), 0, gasto);
        }
        //--------------------------------------------------------

        this.getChart().setTitle("Gastos Realizados (Conversión a: " + monBase + ")");*/
    }

}

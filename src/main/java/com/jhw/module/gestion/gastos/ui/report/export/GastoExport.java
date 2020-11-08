/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.module.gestion.gastos.ui.report.export;

import com.jhw.utils.export.excel.ExcelListWriter;
import com.jhw.module.gestion.gastos.core.domain.GastoDomain;
import com.jhw.module.gestion.gastos.ui.gasto.GastoDetailView;
import com.jhw.swing.material.components.table.editors_renders.money.MoneyTableComponent;
import com.jhw.swing.models.utils.DefaultExportableConfig;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Workbook;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class GastoExport extends DefaultExportableConfig<GastoDomain> {

    public static GastoExport from(GastoDetailView detail) {
        return new GastoExport(detail);
    }

    public GastoExport(GastoDetailView detail) {
        super(detail);
    }

    @Override
    public Object[] getRowObjectExport(GastoDomain obj) {
        return new Object[]{
            obj.getCuadreFk().info().getNombre(),
            obj.getCuadreFk().info().getDocumento(),
            obj.getTipoGastoFk().getNombreGasto(),
            obj.getCuadreFk().info().getFecha(),
            MoneyTableComponent.from(obj.getValor(), obj.getMonedaFk()).toString(),
            obj.getCuadreFk().info().getFormaPagoFk().getNombreFormaPago(),
            obj.getCuadreFk().getOperacionContableFk().getCuentaFk().getNombreCuenta(),
            obj.getCuadreFk().getOperacionContableCuadreFk().getCuentaFk().getNombreCuenta(),
            obj.getCuadreFk().info().getTipoOperacionFk().getNombreOperacion()
        };
    }

    @Override
    public String[] getColumnNamesExport() {
        return new String[]{
            "Nombre",
            "Documento",
            "Tipo de gasto",
            "Fecha",
            "Valor",
            "Forma de pago",
            "Cuenta Inicial",
            "Cuenta Cuadre",
            "Tipo de operación"
        };
    }

    @Override
    public void personalizeBuilder(ExcelListWriter.builder builder) {
        builder.updateValuesColumnCellStyle(3, (Workbook t, CellStyle u) -> {
            u.setDataFormat(t.createDataFormat().getFormat("dd-MMM-yyyy"));
            return u;
        });
    }
}

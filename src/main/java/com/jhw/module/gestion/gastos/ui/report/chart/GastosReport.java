/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.module.gestion.gastos.ui.report.chart;

import com.jhw.swing.bundles.dialog.DialogPanel;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class GastosReport {

    public static void reportGastosByTipo() {
        new DialogPanel("Gráfico de gastos por su tipo", new GastosByTipoChart());
    }
}

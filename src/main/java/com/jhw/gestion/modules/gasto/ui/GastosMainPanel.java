package com.jhw.gestion.modules.gasto.ui;

import com.jhw.gestion.modules.gasto.ui.gasto.GastoDetailView;
import com.jhw.gestion.modules.gasto.ui.tipo_gasto.TipoGastoDetailView;
import com.jhw.utils.interfaces.Update;
import com.jhw.swing.material.components.container.panel._PanelTransparent;
import java.awt.BorderLayout;

/**
 *
 * @author Jesús Hernández Barrios (jhernandezb96@gmail.com)
 */
public class GastosMainPanel extends _PanelTransparent implements Update {

    public GastosMainPanel() {
        initComponents();
    }

    private void initComponents() {
        gastoDetailView = new GastoDetailView();
        tipoGastoDetailView = new TipoGastoDetailView();
        this.setLayout(new BorderLayout());
        this.add(gastoDetailView, BorderLayout.CENTER);
        this.add(tipoGastoDetailView, BorderLayout.EAST);
    }

    // Variables declaration - do not modify
    private TipoGastoDetailView tipoGastoDetailView;
    private GastoDetailView gastoDetailView;
    // End of variables declaration                   

    @Override
    public void update() {
        tipoGastoDetailView.update();
        gastoDetailView.update();
    }
}

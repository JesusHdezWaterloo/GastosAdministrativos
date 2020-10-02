package com.jhw.module.gestion.gastos.ui.module;

import com.clean.core.app.services.NavigationService;
import com.jhw.swing.material.standards.MaterialIcons;
import com.jhw.swing.derivable_icons.DerivableIcon;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class GastoModuleNavigator implements NavigationService {

    public static final String GASTO = "Gastos";

    public static final DerivableIcon ICON_GASTO = MaterialIcons.ADD_SHOPPING_CART;
    public static final DerivableIcon ICON_TIPO_GASTO = MaterialIcons.SHOPPING_CART;
    public static final DerivableIcon ICON_REPORTE_GASTO = MaterialIcons.ASSESSMENT;

    public static final String NAV_GASTO = "modulos.gasto.Gastos";

    @Override
    public void navigateTo(String string, Object... os) {
        switch (string) {
        }
    }

}

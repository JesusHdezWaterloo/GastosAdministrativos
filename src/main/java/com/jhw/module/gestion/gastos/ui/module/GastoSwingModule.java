package com.jhw.module.gestion.gastos.ui.module;

import com.clean.swing.app.AbstractSwingApplication;
import com.clean.swing.app.DefaultAbstractSwingMainModule;
import com.clean.swing.app.dashboard.DashBoardSimple;
import com.clean.swing.app.dashboard.DashboardConstants;
import com.jhw.module.gestion.gastos.core.module.GastoCoreModule;
import com.jhw.module.gestion.gastos.core.usecase_def.GastoUseCase;
import com.jhw.module.gestion.gastos.core.usecase_def.TipoGastoUseCase;
import com.jhw.module.gestion.gastos.repo.module.GastoRepoModule;
import com.jhw.module.gestion.gastos.repo.utils.ResourcesGastos;
import com.jhw.module.gestion.gastos.ui.GastosMainPanel;
import com.jhw.module.util.mysql.services.MySQLHandler;
import com.jhw.swing.material.components.taskpane.SingleCollapseMenu;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

public class GastoSwingModule extends DefaultAbstractSwingMainModule {

    private final GastoModuleNavigator navigator = new GastoModuleNavigator();

    public final static GastoUseCase gastoUC;
    public final static TipoGastoUseCase tipoGastoUC;

    static {
        GastoCoreModule.init(GastoRepoModule.init());

        gastoUC = GastoCoreModule.getInstance().getImplementation(GastoUseCase.class);
        tipoGastoUC = GastoCoreModule.getInstance().getImplementation(TipoGastoUseCase.class);
    }

    private GastoSwingModule() {
    }

    public static GastoSwingModule init() {
        System.out.println("Iniciando 'Gastos'");
        return new GastoSwingModule();
    }

    @Override
    public void register(AbstractSwingApplication app) {
        registerMainElements(app);
    }

    private void registerMainElements(AbstractSwingApplication app) {
        DashBoardSimple dash = app.rootView().dashboard();

        dash.addView(GastoModuleNavigator.NAV_GASTO, new GastosMainPanel());
        SingleCollapseMenu menu = new SingleCollapseMenu(new AbstractAction(GastoModuleNavigator.GASTO, GastoModuleNavigator.ICON_GASTO) {
            @Override
            public void actionPerformed(ActionEvent e) {
                app.navigateTo(GastoModuleNavigator.NAV_GASTO);
            }
        });
        dash.addKeyValue(DashboardConstants.MAIN_ELEMENT, menu);
        /*CollapseMenu menu = new CollapseMenu(MaterialIcons.SHOPPING_CART, GastoModuleNavigator.GASTO);
         dash.addKeyValue(DashboardConstants.MAIN_ELEMENT, menu);
 
         dash.addView(GastoModuleNavigator.GASTO, new GastosMainPanel());
         menu.addMenuItem(new AbstractAction(GastoModuleNavigator.GASTO, MaterialIcons.SHOPPING_CART) {
         @Override
         public void actionPerformed(ActionEvent e) {
         app.navigateTo(GastoModuleNavigator.GASTO);
         }
         });*/

    }

    @Override
    public void navigateTo(String string, Object... o) {
        navigator.navigateTo(string, o);
    }

    @Override
    public void closeModule() {
        MySQLHandler.save(ResourcesGastos.SCHEMA);
    }
}

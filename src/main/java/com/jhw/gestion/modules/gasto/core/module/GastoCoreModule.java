package com.jhw.gestion.modules.gasto.core.module;

import com.clean.core.app.modules.AbstractModule;
import com.clean.core.app.modules.DefaultAbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * Modulo de gasto-core.
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class GastoCoreModule extends DefaultAbstractModule {

    private final Injector inj = Guice.createInjector(new GastoCoreInjectionConfig());

    private static GastoCoreModule INSTANCE;

    public static GastoCoreModule getInstance() {
        if (INSTANCE == null) {
            throw new NullPointerException("El modulo de gastos no se ha inicializado");
        }
        return INSTANCE;
    }

    public static GastoCoreModule init(AbstractModule repoModule) {
        INSTANCE = new GastoCoreModule();
        INSTANCE.registerModule(repoModule);
        return getInstance();
    }

    @Override
    protected <T> T getOwnImplementation(Class<T> type) {
        return inj.getInstance(type);
    }

    @Override
    public String getModuleName() {
        return "Gasto Core Module";
    }

}

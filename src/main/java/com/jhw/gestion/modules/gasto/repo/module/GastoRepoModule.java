package com.jhw.gestion.modules.gasto.repo.module;

import com.clean.core.app.modules.DefaultAbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.jhw.gestion.modules.gasto.repo.utils.Resources;

/**
 * Modulo de contabilidad-repo.
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class GastoRepoModule extends DefaultAbstractModule {

    private final Injector inj = Guice.createInjector(new GastoRepoInjectionConfig());

    private static GastoRepoModule INSTANCE;

    private GastoRepoModule() {
        Resources.initEMF();
    }

    public static GastoRepoModule getInstance() {
        if (INSTANCE == null) {
            throw new NullPointerException("El modulo de Contabilidad no se ha inicializado");
        }
        return INSTANCE;
    }

    public static GastoRepoModule init() {
        INSTANCE = new GastoRepoModule();
        return getInstance();
    }

    @Override
    protected <T> T getOwnImplementation(Class<T> type) {
        return inj.getInstance(type);
    }

    @Override
    public String getModuleName() {
        return "Contabilidad Repo Module";
    }

}

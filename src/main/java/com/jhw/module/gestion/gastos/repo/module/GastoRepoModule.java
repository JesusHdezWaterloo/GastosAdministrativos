package com.jhw.module.gestion.gastos.repo.module;

import com.clean.core.app.modules.DefaultAbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.jhw.module.gestion.gastos.repo.utils.ResourcesGastos;

/**
 * Modulo de Gastos-Repo-Server.
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class GastoRepoModule extends DefaultAbstractModule {

    private final Injector inj = Guice.createInjector(new GastoRepoInjectionConfig());

    private static GastoRepoModule INSTANCE;

    private GastoRepoModule() {
        ResourcesGastos.initEMF();
    }

    public static GastoRepoModule getInstance() {
        if (INSTANCE == null) {
            throw new NullPointerException("El modulo de Gastos Repo Server no se ha inicializado");
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
        return "Gastos Repo Server Module";
    }

}

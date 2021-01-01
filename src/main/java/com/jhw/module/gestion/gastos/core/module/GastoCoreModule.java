package com.jhw.module.gestion.gastos.core.module;

import com.root101.clean.core.app.modules.AbstractModule;
import com.root101.clean.core.app.modules.DefaultAbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.root101.module.gestion.contabilidad.core.module.ContabilidadCoreModule;
import com.jhw.module.gestion.gastos.repo.module.GastoRepoModule;

/**
 * Modulo de Gastos-Core-Server
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class GastoCoreModule extends DefaultAbstractModule {

    private final Injector inj = Guice.createInjector(new GastoCoreInjectionConfig());

    private static GastoCoreModule INSTANCE;

    public static GastoCoreModule getInstance() {
        if (INSTANCE == null) {
            throw new NullPointerException("El modulo de Gastos-Core-Server no se ha inicializado");
        }
        return INSTANCE;
    }

    public static GastoCoreModule init() {
        if (INSTANCE != null) {
            return INSTANCE;
        }
        ContabilidadCoreModule.init();//inicia el modulo de contabilidad del que depende

        INSTANCE = new GastoCoreModule();
        INSTANCE.registerModule(GastoRepoModule.init());

        return getInstance();
    }

    /**
     * Usar init() sin repo por parametro para usar el repo por defecto
     *
     * @param repoModule
     * @return
     * @deprecated
     */
    @Deprecated
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
        return "Gastos Core Server Module";
    }

}

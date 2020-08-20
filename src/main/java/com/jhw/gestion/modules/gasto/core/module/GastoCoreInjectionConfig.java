package com.jhw.gestion.modules.gasto.core.module;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;

/**
 * Configuracion del injection del modulo de job-core.
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class GastoCoreInjectionConfig extends AbstractModule {

    @Override
    protected void configure() {
        bind(TitularUseCase.class).to(TitularUseCaseImpl.class).in(Singleton.class);
    }

}

package com.jhw.gestion.modules.gasto.core.module;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;
import com.jhw.gestion.modules.gasto.core.usecase_def.*;
import com.jhw.gestion.modules.gasto.core.usecase_impl.*;

/**
 * Configuracion del injection del modulo de gasto-core.
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class GastoCoreInjectionConfig extends AbstractModule {

    @Override
    protected void configure() {
        bind(GastoUseCase.class).to(GastoUseCaseImpl.class).in(Singleton.class);
        bind(TipoGastoUseCase.class).to(TipoGastoUseCaseImpl.class).in(Singleton.class);
    }

}

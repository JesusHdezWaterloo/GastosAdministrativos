package com.jhw.module.gestion.gastos.core.module;

import com.jhw.module.gestion.gastos.core.usecase_def.TipoGastoUseCase;
import com.jhw.module.gestion.gastos.core.usecase_def.GastoUseCase;
import com.google.inject.AbstractModule;
import com.google.inject.Singleton;
import com.jhw.module.gestion.gastos.core.usecase_impl.*;

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

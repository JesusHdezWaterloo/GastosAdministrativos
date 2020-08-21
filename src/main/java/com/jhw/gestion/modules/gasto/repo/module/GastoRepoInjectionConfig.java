package com.jhw.gestion.modules.gasto.repo.module;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;
import com.jhw.gestion.modules.gasto.core.repo_def.*;
import com.jhw.gestion.modules.gasto.repo.repo_impl.*;

/**
 * Configuracion del injection del modulo de gasto-repo.
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class GastoRepoInjectionConfig extends AbstractModule {

    @Override
    protected void configure() {
        bind(GastoRepo.class).to(GastoRepoImpl.class).in(Singleton.class);
        bind(TipoGastoRepo.class).to(TipoGastoRepoImpl.class).in(Singleton.class);
    }

}

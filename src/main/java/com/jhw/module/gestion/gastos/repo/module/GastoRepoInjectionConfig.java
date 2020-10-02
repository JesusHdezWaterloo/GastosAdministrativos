package com.jhw.module.gestion.gastos.repo.module;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;
import com.jhw.module.gestion.gastos.core.repo_def.GastoRepo;
import com.jhw.module.gestion.gastos.core.repo_def.TipoGastoRepo;
import com.jhw.module.gestion.gastos.repo.repo_impl.GastoRepoImpl;
import com.jhw.module.gestion.gastos.repo.repo_impl.TipoGastoRepoImpl;

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

package com.jhw.gestion.modules.gasto.repo.module;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;

/**
 * Configuracion del injection del modulo de contabilidad-repo.
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class GastoRepoInjectionConfig extends AbstractModule {

    @Override
    protected void configure() {
        bind(CuadreRepo.class).to(CuadreRepoImpl.class).in(Singleton.class);
        bind(CuentaBancariaRepo.class).to(CuentaBancariaRepoImpl.class).in(Singleton.class);
        bind(CuentaContableRepo.class).to(CuentaContableRepoImpl.class).in(Singleton.class);
        bind(InfoOperacionContableRepo.class).to(InfoOperacionContableRepoImpl.class).in(Singleton.class);
        bind(LiquidacionRepo.class).to(LiquidacionRepoImpl.class).in(Singleton.class);
        bind(FormaPagoRepo.class).to(FormaPagoRepoImpl.class).in(Singleton.class);
        bind(MonedaRepo.class).to(MonedaRepoImpl.class).in(Singleton.class);
        bind(OperacionContableRepo.class).to(OperacionContableRepoImpl.class).in(Singleton.class);
        bind(SubcuentaRepo.class).to(SubcuentaRepoImpl.class).in(Singleton.class);
        bind(TipoCuentaRepo.class).to(TipoCuentaRepoImpl.class).in(Singleton.class);
        bind(TipoOperacionContableRepo.class).to(TipoOperacionContableRepoImpl.class).in(Singleton.class);
        bind(TitularRepo.class).to(TitularRepoImpl.class).in(Singleton.class);
    }

}

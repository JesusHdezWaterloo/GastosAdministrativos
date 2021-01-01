/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.module.gestion.gastos.rest;

import com.root101.module.gestion.contabilidad.service.ResourceServiceImplementation;
import com.jhw.module.gestion.gastos.core.module.*;
import com.jhw.module.gestion.gastos.core.usecase_def.*;
import com.jhw.module.gestion.gastos.repo.module.*;
import com.jhw.module.gestion.gastos.service.ResourceServiceServerImplementation;
import org.springframework.stereotype.Component;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
@Component
public class A_ModuleGestionGastos {

    public static final String BASE_PACKAGE = "com.jhw.module.gestion.gastos";

    public final static TipoGastoUseCase tipoGastoUC;
    public final static GastoUseCase gastoUC;

    static {
        ResourceServiceServerImplementation.init();
        ResourceServiceImplementation.init();

        GastoCoreModule.init();

        tipoGastoUC = GastoCoreModule.getInstance().getImplementation(TipoGastoUseCase.class);
        gastoUC = GastoCoreModule.getInstance().getImplementation(GastoUseCase.class);
    }
}

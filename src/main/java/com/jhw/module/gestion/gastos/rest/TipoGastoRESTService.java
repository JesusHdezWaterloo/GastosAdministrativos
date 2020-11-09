/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.module.gestion.gastos.rest;

import static com.jhw.module.gestion.gastos.core.ModuleGestionGastosConstants.*;
import com.jhw.module.gestion.gastos.core.domain.*;
import com.jhw.module.gestion.gastos.core.usecase_def.*;
import com.jhw.utils.spring.server.*;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
@RestController
@RequestMapping(value = TIPO_GASTO_GENERAL_PATH)
public class TipoGastoRESTService extends RESTServiceTemplate<TipoGastoDomain> implements TipoGastoUseCase {

    private final TipoGastoUseCase tipoGastoUC = A_ModuleGestionGastos.tipoGastoUC;

    public TipoGastoRESTService() {
        setUseCase(tipoGastoUC);
    }
}

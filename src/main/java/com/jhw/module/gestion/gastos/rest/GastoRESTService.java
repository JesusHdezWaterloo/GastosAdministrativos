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
import java.math.BigDecimal;
import java.util.HashMap;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
@RestController
@RequestMapping(value = GASTOS_GASTOS_GENERAL_PATH)
public class GastoRESTService extends RESTServiceTemplate<GastoDomain> implements GastoUseCase {

    private final GastoUseCase gastoUC = A_ModuleGestionGastos.gastoUC;

    public GastoRESTService() {
        setUseCase(gastoUC);
    }

    @Override
    @GetMapping(GASTO_REPORTE_POR_TIPO_PATH)
    public HashMap<TipoGastoDomain, BigDecimal> reporteGastadoPorGasto() throws Exception {
        return gastoUC.reporteGastadoPorGasto();
    }
}

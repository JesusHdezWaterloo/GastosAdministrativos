/*
 * Copyright 2021 Root101 (jhernandezb96@gmail.com, +53-5-426-8660).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Or read it directly from LICENCE.txt file at the root of this project.
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.root101.module.gestion.gastos.rest;

import com.root101.module.gestion.contabilidad.service.ResourceServiceImplementation;
import com.root101.module.gestion.gastos.core.module.*;
import com.root101.module.gestion.gastos.core.usecase_def.*;
import com.root101.module.gestion.gastos.service.ResourceServiceServerImplementation;
import org.springframework.stereotype.Component;

/**
 *
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
 */
@Component
public class A_ModuleGestionGastos {

    public static final String BASE_PACKAGE = "com.root101.module.gestion.gastos";

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

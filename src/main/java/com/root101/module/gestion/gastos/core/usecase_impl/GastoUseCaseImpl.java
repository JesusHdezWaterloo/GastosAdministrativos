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
package com.root101.module.gestion.gastos.core.usecase_impl;

import com.root101.module.gestion.contabilidad.core.domain.MonedaDomain;
import com.root101.module.gestion.contabilidad.core.module.ContabilidadCoreModule;
import com.root101.module.gestion.contabilidad.core.usecase_def.MonedaUseCase;
import com.root101.module.gestion.contabilidad.core.usecase_impl.DefaultPagableUseCaseImpl;
import com.root101.module.gestion.contabilidad.utils.MonedaHandler;
import com.root101.module.gestion.gastos.core.domain.GastoDomain;
import com.root101.module.gestion.gastos.core.domain.TipoGastoDomain;
import com.root101.module.gestion.gastos.core.module.GastoCoreModule;
import com.root101.module.gestion.gastos.core.repo_def.GastoRepo;
import com.root101.module.gestion.gastos.core.usecase_def.GastoUseCase;
import com.root101.module.gestion.gastos.core.usecase_def.TipoGastoUseCase;
import java.math.BigDecimal;
import java.util.HashMap;

/**
 *
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
 */
public class GastoUseCaseImpl extends DefaultPagableUseCaseImpl<GastoDomain> implements GastoUseCase {

    private final GastoRepo repo = GastoCoreModule.getInstance().getImplementation(GastoRepo.class);

    public GastoUseCaseImpl() {
        super.setRepo(repo);
    }

    @Override
    public HashMap<TipoGastoDomain, BigDecimal> reporteGastadoPorGasto() throws Exception {
        HashMap<TipoGastoDomain, BigDecimal> h = new HashMap<>();
        MonedaDomain m = ContabilidadCoreModule.getInstance().getImplementation(MonedaUseCase.class).findMonedaBase();
        if (m == null) {
            return h;
        }
        for (TipoGastoDomain tipoGastoDomain : GastoCoreModule.getInstance().getImplementation(TipoGastoUseCase.class).findAll()) {
            h.put(tipoGastoDomain, BigDecimal.ZERO);
        }
        for (GastoDomain g : GastoCoreModule.getInstance().getImplementation(GastoUseCase.class).findAll()) {
            TipoGastoDomain tipo = g.getTipoGastoFk();
            BigDecimal val = h.get(tipo).add(MonedaHandler.compra(g.getValor(), g.getMonedaFk(), m));
            h.put(tipo, val);
        }
        return h;
    }
}

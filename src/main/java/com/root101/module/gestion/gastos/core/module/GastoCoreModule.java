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
package com.root101.module.gestion.gastos.core.module;

import com.root101.clean.core.app.modules.AbstractModule;
import com.root101.clean.core.app.modules.DefaultAbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.root101.module.gestion.contabilidad.core.module.ContabilidadCoreModule;
import com.root101.module.gestion.gastos.repo.module.GastoRepoModule;

/**
 *
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
 */
public class GastoCoreModule extends DefaultAbstractModule {

    private final Injector inj = Guice.createInjector(new GastoCoreInjectionConfig());

    private static GastoCoreModule INSTANCE;

    public static GastoCoreModule getInstance() {
        if (INSTANCE == null) {
            throw new NullPointerException("El modulo de Gastos-Core-Server no se ha inicializado");
        }
        return INSTANCE;
    }

    public static GastoCoreModule init() {
        if (INSTANCE != null) {
            return INSTANCE;
        }
        ContabilidadCoreModule.init();//inicia el modulo de contabilidad del que depende

        INSTANCE = new GastoCoreModule();
        INSTANCE.registerModule(GastoRepoModule.init());

        return getInstance();
    }

    /**
     * Usar init() sin repo por parametro para usar el repo por defecto
     *
     * @param repoModule
     * @return
     * @deprecated
     */
    @Deprecated
    public static GastoCoreModule init(AbstractModule repoModule) {
        INSTANCE = new GastoCoreModule();
        INSTANCE.registerModule(repoModule);
        return getInstance();
    }

    @Override
    protected <T> T getOwnImplementation(Class<T> type) {
        return inj.getInstance(type);
    }

    @Override
    public String getModuleName() {
        return "Gastos Core Server Module";
    }

}

package com.jhw.module.gestion.gastos.repo.repo_impl;

import com.jhw.module.gestion.gastos.core.domain.GastoDomain;
import com.jhw.module.gestion.gastos.core.repo_def.GastoRepo;
import com.jhw.module.gestion.gastos.repo.entities.Gasto;
import com.jhw.module.gestion.gastos.repo.utils.ResourcesGastos;
import com.jhw.utils.jpa.JPACleanCRUDRepo;

public class GastoRepoImpl extends JPACleanCRUDRepo<GastoDomain, Gasto> implements GastoRepo {

    public GastoRepoImpl() {
        super(ResourcesGastos.EMF, GastoDomain.class, Gasto.class);
    }

}

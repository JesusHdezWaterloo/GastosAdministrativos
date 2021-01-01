package com.jhw.module.gestion.gastos.repo.repo_impl;

import com.jhw.module.gestion.gastos.core.domain.TipoGastoDomain;
import com.jhw.module.gestion.gastos.core.repo_def.TipoGastoRepo;
import com.jhw.module.gestion.gastos.repo.entities.TipoGasto;
import com.jhw.module.gestion.gastos.repo.utils.ResourcesGastos;
import com.root101.repo.jpa.JPACleanCRUDRepo;

public class TipoGastoRepoImpl extends JPACleanCRUDRepo<TipoGastoDomain, TipoGasto> implements TipoGastoRepo {

    public TipoGastoRepoImpl() {
        super(ResourcesGastos.EMF, TipoGastoDomain.class, TipoGasto.class);
    }

}

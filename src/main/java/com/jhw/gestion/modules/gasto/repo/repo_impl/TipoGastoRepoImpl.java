package com.jhw.gestion.modules.gasto.repo.repo_impl;

import com.jhw.gestion.modules.contabilidad.repo.utils.Resources;
import com.jhw.gestion.modules.gasto.core.domain.*;
import com.jhw.gestion.modules.gasto.core.repo_def.*;
import com.jhw.gestion.modules.gasto.repo.entities.*;
import com.jhw.utils.jpa.JPACleanCRUDRepo;

public class TipoGastoRepoImpl extends JPACleanCRUDRepo<TipoGastoDomain, TipoGasto> implements TipoGastoRepo {

    public TipoGastoRepoImpl() {
        super(Resources.EMF, TipoGastoDomain.class, TipoGasto.class);
    }

}

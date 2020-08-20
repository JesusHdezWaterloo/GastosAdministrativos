package com.jhw.gestion.modules.gasto.repo.repo_impl;

import com.jhw.gestion.modules.gasto.repo.utils.Resources;
import com.jhw.utils.jpa.JPACleanCRUDRepo;

public class TitularRepoImpl extends JPACleanCRUDRepo<TitularDomain, Titular> implements TitularRepo {

    public TitularRepoImpl() {
        super(Resources.EMF, TitularDomain.class, Titular.class);
    }

}

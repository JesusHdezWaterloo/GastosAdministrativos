package com.jhw.gestion.modules.gasto.core.usecase_impl;

import com.clean.core.app.usecase.DefaultCRUDUseCase;
import com.jhw.gestion.modules.gasto.core.module.GastoCoreModule;

public class TitularUseCaseImpl extends DefaultCRUDUseCase<TitularDomain> implements TitularUseCase {

    private final TitularRepo repo = GastoCoreModule.getInstance().getImplementation(TitularRepo.class);

    public TitularUseCaseImpl() {
        super.setRepo(repo);
    }

}

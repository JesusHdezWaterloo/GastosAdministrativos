package com.jhw.module.gestion.gastos.core.usecase_impl;

import com.clean.core.app.usecase.DefaultCRUDUseCase;
import com.jhw.module.gestion.gastos.core.domain.TipoGastoDomain;
import com.jhw.module.gestion.gastos.core.module.GastoCoreModule;
import com.jhw.module.gestion.gastos.core.repo_def.TipoGastoRepo;
import com.jhw.module.gestion.gastos.core.usecase_def.TipoGastoUseCase;

public class TipoGastoUseCaseImpl extends DefaultCRUDUseCase<TipoGastoDomain> implements TipoGastoUseCase {

    private final TipoGastoRepo repo = GastoCoreModule.getInstance().getImplementation(TipoGastoRepo.class);

    public TipoGastoUseCaseImpl() {
        super.setRepo(repo);
    }

}

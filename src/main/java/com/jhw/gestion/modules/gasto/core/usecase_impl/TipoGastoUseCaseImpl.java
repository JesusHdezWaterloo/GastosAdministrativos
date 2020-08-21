package com.jhw.gestion.modules.gasto.core.usecase_impl;

import com.clean.core.app.usecase.DefaultCRUDUseCase;
import com.jhw.gestion.modules.gasto.core.domain.*;
import com.jhw.gestion.modules.gasto.core.module.GastoCoreModule;
import com.jhw.gestion.modules.gasto.core.repo_def.*;
import com.jhw.gestion.modules.gasto.core.usecase_def.*;

public class TipoGastoUseCaseImpl extends DefaultCRUDUseCase<TipoGastoDomain> implements TipoGastoUseCase {

    private final TipoGastoRepo repo = GastoCoreModule.getInstance().getImplementation(TipoGastoRepo.class);

    public TipoGastoUseCaseImpl() {
        super.setRepo(repo);
    }

}

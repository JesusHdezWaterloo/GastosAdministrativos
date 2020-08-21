package com.jhw.gestion.modules.gasto.core.usecase_impl;

import com.clean.core.app.usecase.DefaultCRUDUseCase;
import com.jhw.gestion.modules.gasto.core.domain.*;
import com.jhw.gestion.modules.gasto.core.module.GastoCoreModule;
import com.jhw.gestion.modules.gasto.core.repo_def.*;
import com.jhw.gestion.modules.gasto.core.usecase_def.*;

public class GastoUseCaseImpl extends DefaultCRUDUseCase<GastoDomain> implements GastoUseCase {

    private final GastoRepo repo = GastoCoreModule.getInstance().getImplementation(GastoRepo.class);

    public GastoUseCaseImpl() {
        super.setRepo(repo);
    }

}

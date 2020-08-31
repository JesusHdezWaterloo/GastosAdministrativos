package com.jhw.gestion.modules.gasto.core.usecase_impl;

import com.clean.core.app.usecase.DefaultCRUDUseCase;
import com.jhw.gestion.modules.contabilidad.core.domain.MonedaDomain;
import com.jhw.gestion.modules.contabilidad.utils.MonedaHandler;
import com.jhw.gestion.modules.gasto.core.domain.*;
import com.jhw.gestion.modules.gasto.core.module.GastoCoreModule;
import com.jhw.gestion.modules.gasto.core.repo_def.*;
import com.jhw.gestion.modules.gasto.core.usecase_def.*;
import java.math.BigDecimal;
import java.util.HashMap;

public class TipoGastoUseCaseImpl extends DefaultCRUDUseCase<TipoGastoDomain> implements TipoGastoUseCase {

    private final TipoGastoRepo repo = GastoCoreModule.getInstance().getImplementation(TipoGastoRepo.class);

    public TipoGastoUseCaseImpl() {
        super.setRepo(repo);
    }

}

package com.jhw.gestion.modules.gasto.core.usecase_def;

import com.clean.core.app.usecase.CRUDUseCase;
import com.jhw.gestion.modules.gasto.core.domain.*;
import java.util.HashMap;

public interface TipoGastoUseCase extends CRUDUseCase<TipoGastoDomain> {

    public HashMap<TipoGastoDomain, Double> reportGastadoPorGasto() throws Exception;
}

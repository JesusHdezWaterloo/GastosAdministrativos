package com.jhw.gestion.modules.gasto.core.usecase_def;

import com.clean.core.app.usecase.CRUDUseCase;
import com.jhw.gestion.modules.gasto.core.domain.*;
import java.math.BigDecimal;
import java.util.HashMap;

public interface GastoUseCase extends CRUDUseCase<GastoDomain> {

    public HashMap<TipoGastoDomain, BigDecimal> reporteGastadoPorGasto() throws Exception;
}

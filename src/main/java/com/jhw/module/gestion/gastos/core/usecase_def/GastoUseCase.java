package com.jhw.module.gestion.gastos.core.usecase_def;

import com.clean.core.app.usecase.CRUDUseCase;
import com.jhw.module.gestion.gastos.core.domain.GastoDomain;
import com.jhw.module.gestion.gastos.core.domain.TipoGastoDomain;
import java.math.BigDecimal;
import java.util.HashMap;

public interface GastoUseCase extends CRUDUseCase<GastoDomain> {

    public HashMap<TipoGastoDomain, BigDecimal> reporteGastadoPorGasto() throws Exception;
}

package com.jhw.gestion.modules.gasto.core.usecase_impl;

import com.jhw.gestion.modules.contabilidad.core.domain.MonedaDomain;
import com.jhw.gestion.modules.contabilidad.core.usecase_impl.DefaultPagableUseCaseImpl;
import com.jhw.gestion.modules.contabilidad.utils.MonedaHandler;
import com.jhw.gestion.modules.gasto.core.domain.*;
import com.jhw.gestion.modules.gasto.core.module.GastoCoreModule;
import com.jhw.gestion.modules.gasto.core.repo_def.*;
import com.jhw.gestion.modules.gasto.core.usecase_def.*;
import java.math.BigDecimal;
import java.util.HashMap;

public class GastoUseCaseImpl extends DefaultPagableUseCaseImpl<GastoDomain> implements GastoUseCase {

    private final GastoRepo repo = GastoCoreModule.getInstance().getImplementation(GastoRepo.class);

    public GastoUseCaseImpl() {
        super.setRepo(repo);
    }

    @Override
    public HashMap<TipoGastoDomain, BigDecimal> reporteGastadoPorGasto() throws Exception {
        HashMap<TipoGastoDomain, BigDecimal> h = new HashMap<>();
        MonedaDomain m = MonedaHandler.getMonedaBase();
        if (m == null) {
            return h;
        }
        for (TipoGastoDomain tipoGastoDomain : GastoCoreModule.getInstance().getImplementation(TipoGastoUseCase.class).findAll()) {
            h.put(tipoGastoDomain, BigDecimal.ZERO);
        }
        for (GastoDomain g : GastoCoreModule.getInstance().getImplementation(GastoUseCase.class).findAll()) {
            TipoGastoDomain tipo = g.getTipoGastoFk();
            BigDecimal val = h.get(tipo).add(MonedaHandler.compra(g.getValor(), g.getMonedaFk(), m));
            h.put(tipo, val);
        }
        return h;
    }
}

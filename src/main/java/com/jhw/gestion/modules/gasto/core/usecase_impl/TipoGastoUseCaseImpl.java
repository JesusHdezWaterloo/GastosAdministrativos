package com.jhw.gestion.modules.gasto.core.usecase_impl;

import com.clean.core.app.usecase.DefaultCRUDUseCase;
import com.jhw.gestion.modules.contabilidad.core.domain.MonedaDomain;
import com.jhw.gestion.modules.contabilidad.utils.MonedaHandler;
import com.jhw.gestion.modules.gasto.core.domain.*;
import com.jhw.gestion.modules.gasto.core.module.GastoCoreModule;
import com.jhw.gestion.modules.gasto.core.repo_def.*;
import com.jhw.gestion.modules.gasto.core.usecase_def.*;
import java.util.HashMap;

public class TipoGastoUseCaseImpl extends DefaultCRUDUseCase<TipoGastoDomain> implements TipoGastoUseCase {

    private final TipoGastoRepo repo = GastoCoreModule.getInstance().getImplementation(TipoGastoRepo.class);

    public TipoGastoUseCaseImpl() {
        super.setRepo(repo);
    }

    @Override
    public HashMap<TipoGastoDomain, Double> reportGastadoPorGasto() throws Exception {
        HashMap<TipoGastoDomain, Double> h = new HashMap<>();
        MonedaDomain m = MonedaHandler.getMonedaBase();
        if (m == null) {
            return h;
        }
        for (TipoGastoDomain tipoGastoDomain : findAll()) {
            h.put(tipoGastoDomain, 0d);
        }
        for (GastoDomain g : GastoCoreModule.getInstance().getImplementation(GastoUseCase.class).findAll()) {
            TipoGastoDomain tipo = g.getTipoGastoFk();
            double val = h.get(tipo) + MonedaHandler.venta(g.getValor(), g.getMonedaFk(), m);
            h.put(tipo, val);
        }
        return h;
    }
}

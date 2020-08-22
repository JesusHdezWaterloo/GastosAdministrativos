package com.jhw.gestion.modules.gasto.core.usecase_impl;

import com.clean.core.app.usecase.DefaultCRUDUseCase;
import com.jhw.gestion.modules.contabilidad.core.domain.CuadreDomain;
import com.jhw.gestion.modules.contabilidad.core.module.ContabilidadCoreModule;
import com.jhw.gestion.modules.contabilidad.core.usecase_def.CuadreUseCase;
import com.jhw.gestion.modules.gasto.core.domain.*;
import com.jhw.gestion.modules.gasto.core.module.GastoCoreModule;
import com.jhw.gestion.modules.gasto.core.repo_def.*;
import com.jhw.gestion.modules.gasto.core.usecase_def.*;

public class GastoUseCaseImpl extends DefaultCRUDUseCase<GastoDomain> implements GastoUseCase {

    private final GastoRepo repo = GastoCoreModule.getInstance().getImplementation(GastoRepo.class);

    private final CuadreUseCase cuadreUC = ContabilidadCoreModule.getInstance().getImplementation(CuadreUseCase.class);

    public GastoUseCaseImpl() {
        super.setRepo(repo);
    }

    @Override
    public GastoDomain destroy(GastoDomain objectToDestroy) throws Exception {
        //destruye el cuadre y por defecto el gasto. Destruye el cuadre viejo xq el nuevo viene con el valor cambiado
        cuadreUC.destroy(cuadreUC.findBy(objectToDestroy.getCuadreFk().getIdCuadre()));
        return objectToDestroy;
    }

    @Override
    public GastoDomain edit(GastoDomain objectToUpdate) throws Exception {
        destroy(objectToUpdate);
        return create(objectToUpdate);
    }

    @Override
    public GastoDomain create(GastoDomain newObject) throws Exception {
        CuadreDomain cuadre = cuadreUC.create(newObject.getCuadreFk());
        newObject.setCuadreFk(cuadre);
        return super.create(newObject);
    }

}

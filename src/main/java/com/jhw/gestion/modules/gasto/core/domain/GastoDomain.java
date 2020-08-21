/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.gestion.modules.gasto.core.domain;

import com.clean.core.utils.SortBy;
import javax.validation.constraints.NotNull;
import com.jhw.gestion.modules.contabilidad.repo.entities.Cuadre;
import com.jhw.gestion.modules.contabilidad.repo.entities.Moneda;
import com.jhw.utils.clean.EntityDomainObjectValidated;
import javax.validation.constraints.PositiveOrZero;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
@SortBy(priority = {"cuadreFk"})
public class GastoDomain extends EntityDomainObjectValidated {

    private Integer idGasto;

    @PositiveOrZero(message = "#msg.module.gasto.validation.gasto_valor_negativo#")
    private double valor;

    @NotNull(message = "#msg.module.gasto.validation.gasto_cuadre_null#")
    private Cuadre cuadreFk;

    @NotNull(message = "#msg.module.gasto.validation.gasto_moneda_null#")
    private Moneda monedaFk;

    @NotNull(message = "#msg.module.gasto.validation.gasto_tipo_null#")
    private TipoGastoDomain tipoGastoFk;

    public GastoDomain() {
    }

    public GastoDomain(Integer idGasto) {
        this.idGasto = idGasto;
    }

    public GastoDomain(double valor, Cuadre cuadreFk, Moneda monedaFk, TipoGastoDomain tipoGastoFk) {
        this.valor = valor;
        this.cuadreFk = cuadreFk;
        this.monedaFk = monedaFk;
        this.tipoGastoFk = tipoGastoFk;
    }

    public Integer getIdGasto() {
        return idGasto;
    }

    public void setIdGasto(Integer idGasto) {
        this.idGasto = idGasto;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Cuadre getCuadreFk() {
        return cuadreFk;
    }

    public void setCuadreFk(Cuadre cuadreFk) {
        this.cuadreFk = cuadreFk;
    }

    public Moneda getMonedaFk() {
        return monedaFk;
    }

    public void setMonedaFk(Moneda monedaFk) {
        this.monedaFk = monedaFk;
    }

    public TipoGastoDomain getTipoGastoFk() {
        return tipoGastoFk;
    }

    public void setTipoGastoFk(TipoGastoDomain tipoGastoFk) {
        this.tipoGastoFk = tipoGastoFk;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idGasto != null ? idGasto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GastoDomain)) {
            return false;
        }
        GastoDomain other = (GastoDomain) object;
        if ((this.idGasto == null && other.idGasto != null) || (this.idGasto != null && !this.idGasto.equals(other.idGasto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.jhw.gestion.modules.gasto.repo.entities.Gasto[ idGasto=" + idGasto + " ]";
    }

}

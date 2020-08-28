/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.gestion.modules.gasto.core.domain;

import com.jhw.gestion.modules.contabilidad.core.domain.*;
import javax.validation.constraints.NotNull;
import com.jhw.utils.clean.EntityDomainObjectValidated;
import java.math.BigDecimal;
import javax.validation.constraints.Max;
import javax.validation.constraints.PositiveOrZero;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class GastoDomain extends EntityDomainObjectValidated implements Comparable<GastoDomain>, Pagable{

    private Integer idGasto;

    @Max(value = Long.MAX_VALUE, message = "#msg.module.contabilidad.validation.valor_muy_grande#")
    @PositiveOrZero(message = "#msg.module.gasto.validation.gasto_valor_negativo#")
    private BigDecimal valor;

    @NotNull(message = "#msg.module.gasto.validation.gasto_cuadre_null#")
    private CuadreDomain cuadreFk;

    @NotNull(message = "#msg.module.gasto.validation.gasto_moneda_null#")
    private MonedaDomain monedaFk;

    @NotNull(message = "#msg.module.gasto.validation.gasto_tipo_null#")
    private TipoGastoDomain tipoGastoFk;

    public GastoDomain() {
    }

    public GastoDomain(Integer idGasto) {
        this.idGasto = idGasto;
    }

    public GastoDomain(BigDecimal valor, MonedaDomain monedaFk, CuadreDomain cuadreFk, TipoGastoDomain tipoGastoFk) {
        this.valor = valor;
        this.monedaFk = monedaFk;
        this.cuadreFk = cuadreFk;
        this.tipoGastoFk = tipoGastoFk;
        validate();
    }

    public Integer getIdGasto() {
        return idGasto;
    }

    public void setIdGasto(Integer idGasto) {
        this.idGasto = idGasto;
    }

    @Override
    public BigDecimal getValor() {
        return valor;
    }

    @Override
    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    @Override
    public CuadreDomain getCuadreFk() {
        return cuadreFk;
    }

    @Override
    public void setCuadreFk(CuadreDomain cuadreFk) {
        this.cuadreFk = cuadreFk;
    }

    @Override
    public MonedaDomain getMonedaFk() {
        return monedaFk;
    }

    public void setMonedaFk(MonedaDomain monedaFk) {
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
        return cuadreFk.info().getNombre();
    }

    @Override
    public int compareTo(GastoDomain o) {
        return -getCuadreFk().info().getFecha().compareTo(o.getCuadreFk().info().getFecha());
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.gestion.modules.gasto.core.domain;

import com.clean.core.utils.SortBy;
import com.jhw.gestion.modules.contabilidad.repo.entities.Moneda;
import com.jhw.gestion.modules.contabilidad.repo.entities.TipoOperacionContable;
import com.jhw.utils.clean.EntityDomainObjectValidated;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
@SortBy(priority = {"nombreGasto"})
public class TipoGastoDomain extends EntityDomainObjectValidated {

    private Integer idTipoGasto;

    @NotEmpty(message = "#msg.module.gasto.validation.tipo_gasto_nombre_vacio#")
    @Size(max = 95, message = "#msg.module.gasto.validation.tipo_gasto_nombre_largo#")
    private String nombreGasto;

    @Size(max = 495, message = "#msg.module.contabilidad.validation.descripcion_larga#")
    private String descripcion;

    @NotNull(message = "#msg.module.gasto.validation.tipo_gasto_moneda_null#")
    private Moneda monedaDefectoFk;

    @NotNull(message = "#msg.module.gasto.validation.tipo_gasto_operacion_null#")
    private TipoOperacionContable tipoOperacionContableDefectoFk;

    public TipoGastoDomain() {
    }

    public TipoGastoDomain(Integer idTipoGasto) {
        this.idTipoGasto = idTipoGasto;
    }

    public TipoGastoDomain(String nombreGasto, String descripcion, Moneda monedaDefectoFk, TipoOperacionContable tipoOperacionContableDefectoFk) {
        this.nombreGasto = nombreGasto;
        this.descripcion = descripcion;
        this.monedaDefectoFk = monedaDefectoFk;
        this.tipoOperacionContableDefectoFk = tipoOperacionContableDefectoFk;
    }

    public Integer getIdTipoGasto() {
        return idTipoGasto;
    }

    public void setIdTipoGasto(Integer idTipoGasto) {
        this.idTipoGasto = idTipoGasto;
    }

    public String getNombreGasto() {
        return nombreGasto;
    }

    public void setNombreGasto(String nombreGasto) {
        this.nombreGasto = nombreGasto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Moneda getMonedaDefectoFk() {
        return monedaDefectoFk;
    }

    public void setMonedaDefectoFk(Moneda monedaDefectoFk) {
        this.monedaDefectoFk = monedaDefectoFk;
    }

    public TipoOperacionContable getTipoOperacionContableDefectoFk() {
        return tipoOperacionContableDefectoFk;
    }

    public void setTipoOperacionContableDefectoFk(TipoOperacionContable tipoOperacionContableDefectoFk) {
        this.tipoOperacionContableDefectoFk = tipoOperacionContableDefectoFk;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoGasto != null ? idTipoGasto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoGastoDomain)) {
            return false;
        }
        TipoGastoDomain other = (TipoGastoDomain) object;
        if ((this.idTipoGasto == null && other.idTipoGasto != null) || (this.idTipoGasto != null && !this.idTipoGasto.equals(other.idTipoGasto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nombreGasto;
    }

}

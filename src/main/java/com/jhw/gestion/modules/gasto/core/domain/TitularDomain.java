/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.gestion.modules.gasto.core.domain;

import com.clean.core.utils.SortBy;
import com.jhw.utils.clean.EntityDomainObjectValidated;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
@SortBy(priority = {"nombreTitular"})
public class TitularDomain extends EntityDomainObjectValidated {

    private Integer idTitular;

    @NotEmpty(message = "#msg.module.contabilidad.validation.titular_nombre_vacio#")
    @Size(max = 95, message = "#msg.module.contabilidad.validation.titular_nombre_largo#")
    private String nombreTitular;

    @Size(max = 495, message = "#msg.module.contabilidad.validation.descripcion_larga#")
    private String descripcion;

    public TitularDomain() {
    }

    public TitularDomain(Integer idTitular) {
        this.idTitular = idTitular;
    }

    public TitularDomain(String nombreTitular, String descripcion) {
        this.nombreTitular = nombreTitular;
        this.descripcion = descripcion;
        validate();
    }

    public Integer getIdTitular() {
        return idTitular;
    }

    public void setIdTitular(Integer idTitular) {
        this.idTitular = idTitular;
    }

    public String getNombreTitular() {
        return nombreTitular;
    }

    public void setNombreTitular(String nombreTitular) {
        this.nombreTitular = nombreTitular;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTitular != null ? idTitular.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TitularDomain)) {
            return false;
        }
        TitularDomain other = (TitularDomain) object;
        if ((this.idTitular == null && other.idTitular != null) || (this.idTitular != null && !this.idTitular.equals(other.idTitular))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nombreTitular;
    }

}

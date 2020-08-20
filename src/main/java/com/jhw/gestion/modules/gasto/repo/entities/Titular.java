/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.gestion.modules.gasto.repo.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
@Entity
@Table(name = "titular", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"nombre_titular"})})
@NamedQueries({
    @NamedQuery(name = "Titular.findAll", query = "SELECT t FROM Titular t"),
    @NamedQuery(name = "Titular.findByIdTitular", query = "SELECT t FROM Titular t WHERE t.idTitular = :idTitular"),
    @NamedQuery(name = "Titular.findByNombreTitular", query = "SELECT t FROM Titular t WHERE t.nombreTitular = :nombreTitular"),
    @NamedQuery(name = "Titular.findByDescripcion", query = "SELECT t FROM Titular t WHERE t.descripcion = :descripcion")})
public class Titular implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_titular", nullable = false)
    private Integer idTitular;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombre_titular", nullable = false, length = 100)
    private String nombreTitular;
    
    @Basic(optional = false)
    @NotNull
    @Size(max = 500)
    @Column(name = "descripcion", nullable = false, length = 500)
    private String descripcion;

    public Titular() {
    }

    public Titular(Integer idTitular) {
        this.idTitular = idTitular;
    }

    public Titular(Integer idTitular, String nombreTitular, String descripcion) {
        this.idTitular = idTitular;
        this.nombreTitular = nombreTitular;
        this.descripcion = descripcion;
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
        if (!(object instanceof Titular)) {
            return false;
        }
        Titular other = (Titular) object;
        if ((this.idTitular == null && other.idTitular != null) || (this.idTitular != null && !this.idTitular.equals(other.idTitular))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "testJPA.entities.contabilidad_empresarial.Titular[ idTitular=" + idTitular + " ]";
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.gestion.modules.gasto.repo.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import com.jhw.gestion.modules.contabilidad.repo.entities.Cuadre;
import com.jhw.gestion.modules.contabilidad.repo.entities.Moneda;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
@Entity
@Table(name = "gasto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Gasto.findAll", query = "SELECT g FROM Gasto g"),
    @NamedQuery(name = "Gasto.findByIdGasto", query = "SELECT g FROM Gasto g WHERE g.idGasto = :idGasto"),
    @NamedQuery(name = "Gasto.findByValor", query = "SELECT g FROM Gasto g WHERE g.valor = :valor")})
public class Gasto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_gasto", nullable = false)
    private Integer idGasto;

    @Basic(optional = false)
    @NotNull
    @Column(name = "valor", nullable = false)
    private double valor;

    @JoinColumn(name = "cuadre_fk", referencedColumnName = "id_cuadre", nullable = false)
    @ManyToOne(optional = false)
    private Cuadre cuadreFk;

    @JoinColumn(name = "moneda_fk", referencedColumnName = "id_moneda", nullable = false)
    @ManyToOne(optional = false)
    private Moneda monedaFk;

    @JoinColumn(name = "tipo_gasto_fk", referencedColumnName = "id_tipo_gasto", nullable = false)
    @ManyToOne(optional = false)
    private TipoGasto tipoGastoFk;

    public Gasto() {
    }

    public Gasto(Integer idGasto) {
        this.idGasto = idGasto;
    }

    public Gasto(Integer idGasto, double valor, Cuadre cuadreFk, Moneda monedaFk, TipoGasto tipoGastoFk) {
        this.idGasto = idGasto;
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

    public TipoGasto getTipoGastoFk() {
        return tipoGastoFk;
    }

    public void setTipoGastoFk(TipoGasto tipoGastoFk) {
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
        if (!(object instanceof Gasto)) {
            return false;
        }
        Gasto other = (Gasto) object;
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

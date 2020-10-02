/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.module.gestion.gastos.repo.entities;

import com.jhw.module.gestion.contabilidad.repo.entities.FormaPago;
import com.jhw.module.gestion.contabilidad.repo.entities.Moneda;
import com.jhw.module.gestion.contabilidad.repo.entities.TipoOperacionContable;
import com.jhw.module.gestion.gastos.repo.utils.ResourcesGastos;
import java.io.Serializable;
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
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
@Entity
@Table(name = "tipo_gasto", schema = ResourcesGastos.SCHEMA, uniqueConstraints = {
    @UniqueConstraint(columnNames = {"nombre_gasto"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoGasto.findAll", query = "SELECT t FROM TipoGasto t"),
    @NamedQuery(name = "TipoGasto.findByIdTipoGasto", query = "SELECT t FROM TipoGasto t WHERE t.idTipoGasto = :idTipoGasto"),
    @NamedQuery(name = "TipoGasto.findByNombreGasto", query = "SELECT t FROM TipoGasto t WHERE t.nombreGasto = :nombreGasto"),
    @NamedQuery(name = "TipoGasto.findByDescripcion", query = "SELECT t FROM TipoGasto t WHERE t.descripcion = :descripcion")})
public class TipoGasto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_gasto", nullable = false)
    private Integer idTipoGasto;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombre_gasto", nullable = false, length = 100)
    private String nombreGasto;

    @Basic(optional = false)
    @NotNull
    @Size(max = 500)
    @Column(name = "descripcion", nullable = false, length = 500)
    private String descripcion;

    @JoinColumn(name = "moneda_defecto_fk", referencedColumnName = "id_moneda", nullable = false)
    @ManyToOne(optional = false)
    private Moneda monedaDefectoFk;

    @JoinColumn(name = "tipo_operacion_contable_defecto_fk", referencedColumnName = "id_tipo_operacion", nullable = false)
    @ManyToOne(optional = false)
    private TipoOperacionContable tipoOperacionContableDefectoFk;

    @JoinColumn(name = "forma_pago_fk", referencedColumnName = "id_forma_pago", nullable = false)
    @ManyToOne(optional = false)
    private FormaPago formaPagoFk;

    public TipoGasto() {
    }

    public TipoGasto(Integer idTipoGasto) {
        this.idTipoGasto = idTipoGasto;
    }

    public TipoGasto(Integer idTipoGasto, String nombreGasto, String descripcion, Moneda monedaDefectoFk, TipoOperacionContable tipoOperacionContableDefectoFk, FormaPago formaPagoFk) {
        this.idTipoGasto = idTipoGasto;
        this.nombreGasto = nombreGasto;
        this.descripcion = descripcion;
        this.monedaDefectoFk = monedaDefectoFk;
        this.tipoOperacionContableDefectoFk = tipoOperacionContableDefectoFk;
        this.formaPagoFk = formaPagoFk;
    }

    public FormaPago getFormaPagoFk() {
        return formaPagoFk;
    }

    public void setFormaPagoFk(FormaPago formaPagoFk) {
        this.formaPagoFk = formaPagoFk;
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
        if (!(object instanceof TipoGasto)) {
            return false;
        }
        TipoGasto other = (TipoGasto) object;
        if ((this.idTipoGasto == null && other.idTipoGasto != null) || (this.idTipoGasto != null && !this.idTipoGasto.equals(other.idTipoGasto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.jhw.gestion.modules.gasto.repo.entities.TipoGasto[ idTipoGasto=" + idTipoGasto + " ]";
    }

}

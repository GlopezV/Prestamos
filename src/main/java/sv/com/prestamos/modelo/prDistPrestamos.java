/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.prestamos.modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author egalvez
 */
@Entity
@Table(name = "pr_dist_prestamos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "prDistPrestamos.findAll", query = "SELECT p FROM prDistPrestamos p"),
    @NamedQuery(name = "prDistPrestamos.findByIdDistPrestamo", query = "SELECT p FROM prDistPrestamos p WHERE p.idDistPrestamo = :idDistPrestamo"),
    @NamedQuery(name = "prDistPrestamos.findByDescripcion", query = "SELECT p FROM prDistPrestamos p WHERE p.descripcion = :descripcion"),
    @NamedQuery(name = "prDistPrestamos.findByPorcentajeAplicacion", query = "SELECT p FROM prDistPrestamos p WHERE p.porcentajeAplicacion = :porcentajeAplicacion"),
    @NamedQuery(name = "prDistPrestamos.findByAplicaDefault", query = "SELECT p FROM prDistPrestamos p WHERE p.aplicaDefault = :aplicaDefault")})
public class prDistPrestamos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Size(min = 1, max = 10)
    @Column(name = "id_dist_prestamo")
    private String idDistPrestamo;
    @Size(max = 75)
    @Column(name = "descripcion")
    private String descripcion;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "porcentaje_aplicacion")
    private BigDecimal porcentajeAplicacion;
    @Column(name = "aplica_default")
    private Boolean aplicaDefault;

    public prDistPrestamos() {
    }

    public prDistPrestamos(String idDistPrestamo) {
        this.idDistPrestamo = idDistPrestamo;
    }

    public String getIdDistPrestamo() {
        return idDistPrestamo;
    }

    public void setIdDistPrestamo(String idDistPrestamo) {
        this.idDistPrestamo = idDistPrestamo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getPorcentajeAplicacion() {
        return porcentajeAplicacion;
    }

    public void setPorcentajeAplicacion(BigDecimal porcentajeAplicacion) {
        this.porcentajeAplicacion = porcentajeAplicacion;
    }

    public Boolean getAplicaDefault() {
        return aplicaDefault;
    }

    public void setAplicaDefault(Boolean aplicaDefault) {
        this.aplicaDefault = aplicaDefault;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDistPrestamo != null ? idDistPrestamo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof prDistPrestamos)) {
            return false;
        }
        prDistPrestamos other = (prDistPrestamos) object;
        if ((this.idDistPrestamo == null && other.idDistPrestamo != null) || (this.idDistPrestamo != null && !this.idDistPrestamo.equals(other.idDistPrestamo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.prestamos.modelo.prDistPrestamos[ idDistPrestamo=" + idDistPrestamo + " ]";
    }
    
}

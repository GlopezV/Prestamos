/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.prestamos.modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author egalvez
 */
@Entity
@Table(name = "pr_lineas_prestamos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "prLineasPrestamos.findAll", query = "SELECT p FROM prLineasPrestamos p"),
    @NamedQuery(name = "prLineasPrestamos.findByIdLineaPrestamo", query = "SELECT p FROM prLineasPrestamos p WHERE p.idLineaPrestamo = :idLineaPrestamo"),
    @NamedQuery(name = "prLineasPrestamos.findByDescripcion", query = "SELECT p FROM prLineasPrestamos p WHERE p.descripcion = :descripcion"),
    @NamedQuery(name = "prLineasPrestamos.findByTasa", query = "SELECT p FROM prLineasPrestamos p WHERE p.tasa = :tasa"),
    @NamedQuery(name = "prLineasPrestamos.findByPrioridad", query = "SELECT p FROM prLineasPrestamos p WHERE p.prioridad = :prioridad"),
    @NamedQuery(name = "prLineasPrestamos.findByTipoCalculo", query = "SELECT p FROM prLineasPrestamos p WHERE p.tipoCalculo = :tipoCalculo"),
    @NamedQuery(name = "prLineasPrestamos.findByUsuarioCreador", query = "SELECT p FROM prLineasPrestamos p WHERE p.usuarioCreador = :usuarioCreador"),
    @NamedQuery(name = "prLineasPrestamos.findByFechaCreacion", query = "SELECT p FROM prLineasPrestamos p WHERE p.fechaCreacion = :fechaCreacion"),
    @NamedQuery(name = "prLineasPrestamos.findByUsuarioModificador", query = "SELECT p FROM prLineasPrestamos p WHERE p.usuarioModificador = :usuarioModificador"),
    @NamedQuery(name = "prLineasPrestamos.findByFechaModificacion", query = "SELECT p FROM prLineasPrestamos p WHERE p.fechaModificacion = :fechaModificacion"),
    @NamedQuery(name = "prLineasPrestamos.findByUsuarioInactivador", query = "SELECT p FROM prLineasPrestamos p WHERE p.usuarioInactivador = :usuarioInactivador"),
    @NamedQuery(name = "prLineasPrestamos.findByFechaInactivacion", query = "SELECT p FROM prLineasPrestamos p WHERE p.fechaInactivacion = :fechaInactivacion"),
    @NamedQuery(name = "prLineasPrestamos.findByActivo", query = "SELECT p FROM prLineasPrestamos p WHERE p.activo = :activo")})
public class prLineasPrestamos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Size(min = 1, max = 15)
    @Column(name = "id_linea_prestamo")
    private String idLineaPrestamo;
    @Size(max = 100)
    @Column(name = "descripcion")
    private String descripcion;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "tasa")
    private BigDecimal tasa;
    @Column(name = "prioridad")
    private Integer prioridad;
    @Column(name = "tipo_calculo")
    private Character tipoCalculo;
    @Size(max = 30)
    @Column(name = "usuario_creador")
    private String usuarioCreador;
    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar fechaCreacion;
    @Size(max = 30)
    @Column(name = "usuario_modificador")
    private String usuarioModificador;
    @Column(name = "fecha_modificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar fechaModificacion;
    @Size(max = 30)
    @Column(name = "usuario_inactivador")
    private String usuarioInactivador;
    @Column(name = "fecha_inactivacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar fechaInactivacion;
    @Column(name = "activo")
    private Boolean activo;

    public prLineasPrestamos() {
    }

    public prLineasPrestamos(String idLineaPrestamo) {
        this.idLineaPrestamo = idLineaPrestamo;
    }

    public String getIdLineaPrestamo() {
        return idLineaPrestamo;
    }

    public void setIdLineaPrestamo(String idLineaPrestamo) {
        this.idLineaPrestamo = idLineaPrestamo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getTasa() {
        return tasa;
    }

    public void setTasa(BigDecimal tasa) {
        this.tasa = tasa;
    }

    public Integer getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(Integer prioridad) {
        this.prioridad = prioridad;
    }

    public Character getTipoCalculo() {
        return tipoCalculo;
    }

    public void setTipoCalculo(Character tipoCalculo) {
        this.tipoCalculo = tipoCalculo;
    }

    public String getUsuarioCreador() {
        return usuarioCreador;
    }

    public void setUsuarioCreador(String usuarioCreador) {
        this.usuarioCreador = usuarioCreador;
    }

    public Calendar getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Calendar fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getUsuarioModificador() {
        return usuarioModificador;
    }

    public void setUsuarioModificador(String usuarioModificador) {
        this.usuarioModificador = usuarioModificador;
    }

    public Calendar getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Calendar fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public String getUsuarioInactivador() {
        return usuarioInactivador;
    }

    public void setUsuarioInactivador(String usuarioInactivador) {
        this.usuarioInactivador = usuarioInactivador;
    }

    public Calendar getFechaInactivacion() {
        return fechaInactivacion;
    }

    public void setFechaInactivacion(Calendar fechaInactivacion) {
        this.fechaInactivacion = fechaInactivacion;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLineaPrestamo != null ? idLineaPrestamo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof prLineasPrestamos)) {
            return false;
        }
        prLineasPrestamos other = (prLineasPrestamos) object;
        if ((this.idLineaPrestamo == null && other.idLineaPrestamo != null) || (this.idLineaPrestamo != null && !this.idLineaPrestamo.equals(other.idLineaPrestamo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.prestamos.modelo.prLineasPrestamos[ idLineaPrestamo=" + idLineaPrestamo + " ]";
    }
    
}

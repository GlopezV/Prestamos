/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.prestamos.modelo;

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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author egalvez
 */
@Entity
@Table(name = "pr_log_transacciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "prLogTransacciones.findAll", query = "SELECT p FROM prLogTransacciones p"),
    @NamedQuery(name = "prLogTransacciones.findByIdLogTransaccion", query = "SELECT p FROM prLogTransacciones p WHERE p.idLogTransaccion = :idLogTransaccion"),
    @NamedQuery(name = "prLogTransacciones.findByFecha", query = "SELECT p FROM prLogTransacciones p WHERE p.fecha = :fecha"),
    @NamedQuery(name = "prLogTransacciones.findByTipoTransaccion", query = "SELECT p FROM prLogTransacciones p WHERE p.tipoTransaccion = :tipoTransaccion"),
    @NamedQuery(name = "prLogTransacciones.findByIdTransaccion", query = "SELECT p FROM prLogTransacciones p WHERE p.idTransaccion = :idTransaccion"),
    @NamedQuery(name = "prLogTransacciones.findByTipoOperacion", query = "SELECT p FROM prLogTransacciones p WHERE p.tipoOperacion = :tipoOperacion"),
    @NamedQuery(name = "prLogTransacciones.findByFechaCreacion", query = "SELECT p FROM prLogTransacciones p WHERE p.fechaCreacion = :fechaCreacion"),
    @NamedQuery(name = "prLogTransacciones.findByFechaModificacion", query = "SELECT p FROM prLogTransacciones p WHERE p.fechaModificacion = :fechaModificacion"),
    @NamedQuery(name = "prLogTransacciones.findByFechaEliminacion", query = "SELECT p FROM prLogTransacciones p WHERE p.fechaEliminacion = :fechaEliminacion")})
public class prLogTransacciones implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Size(min = 1, max = 15)
    @Column(name = "id_log_transaccion")
    private String idLogTransaccion;
    
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    
    @Size(max = 15)
    @Column(name = "tipo_transaccion")
    private String tipoTransaccion;
    
    @Size(max = 15)
    @Column(name = "id_transaccion")
    private String idTransaccion;
    
    @Size(max = 15)
    @Column(name = "tipo_operacion")
    private String tipoOperacion;
    
    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;
    
    @Column(name = "fecha_modificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModificacion;
    
    @Column(name = "fecha_eliminacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaEliminacion;
    
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    @ManyToOne
    private prUsuarios Usuario;

    public prLogTransacciones() {
    }

    public prLogTransacciones(String idLogTransaccion) {
        this.idLogTransaccion = idLogTransaccion;
    }

    public String getIdLogTransaccion() {
        return idLogTransaccion;
    }

    public void setIdLogTransaccion(String idLogTransaccion) {
        this.idLogTransaccion = idLogTransaccion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getTipoTransaccion() {
        return tipoTransaccion;
    }

    public void setTipoTransaccion(String tipoTransaccion) {
        this.tipoTransaccion = tipoTransaccion;
    }

    public String getIdTransaccion() {
        return idTransaccion;
    }

    public void setIdTransaccion(String idTransaccion) {
        this.idTransaccion = idTransaccion;
    }

    public String getTipoOperacion() {
        return tipoOperacion;
    }

    public void setTipoOperacion(String tipoOperacion) {
        this.tipoOperacion = tipoOperacion;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public Date getFechaEliminacion() {
        return fechaEliminacion;
    }

    public void setFechaEliminacion(Date fechaEliminacion) {
        this.fechaEliminacion = fechaEliminacion;
    }

    public prUsuarios getIdUsuario() {
        return Usuario;
    }

    public void setIdUsuario(prUsuarios Usuario) {
        this.Usuario = Usuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLogTransaccion != null ? idLogTransaccion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof prLogTransacciones)) {
            return false;
        }
        prLogTransacciones other = (prLogTransacciones) object;
        if ((this.idLogTransaccion == null && other.idLogTransaccion != null) || (this.idLogTransaccion != null && !this.idLogTransaccion.equals(other.idLogTransaccion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.prestamos.modelo.prLogTransacciones[ idLogTransaccion=" + idLogTransaccion + " ]";
    }
    
}

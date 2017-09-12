/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.prestamos.modelo;

import java.io.Serializable;
import java.util.Calendar;
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
@Table(name = "pr_contactos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "prContactos.findAll", query = "SELECT p FROM prContactos p"),
    @NamedQuery(name = "prContactos.findByIdContacto", query = "SELECT p FROM prContactos p WHERE p.idContacto = :idContacto"),
    @NamedQuery(name = "prContactos.findByNombres", query = "SELECT p FROM prContactos p WHERE p.nombres = :nombres"),
    @NamedQuery(name = "prContactos.findByTelefonoFijo", query = "SELECT p FROM prContactos p WHERE p.telefonoFijo = :telefonoFijo"),
    @NamedQuery(name = "prContactos.findByTelefonoMovil", query = "SELECT p FROM prContactos p WHERE p.telefonoMovil = :telefonoMovil"),
    @NamedQuery(name = "prContactos.findByDireccion", query = "SELECT p FROM prContactos p WHERE p.direccion = :direccion"),
    @NamedQuery(name = "prContactos.findByUsuarioCreador", query = "SELECT p FROM prContactos p WHERE p.usuarioCreador = :usuarioCreador"),
    @NamedQuery(name = "prContactos.findByFechaCreacion", query = "SELECT p FROM prContactos p WHERE p.fechaCreacion = :fechaCreacion"),
    @NamedQuery(name = "prContactos.findByUsuarioModificacion", query = "SELECT p FROM prContactos p WHERE p.usuarioModificacion = :usuarioModificacion"),
    @NamedQuery(name = "prContactos.findByFechaModificacion", query = "SELECT p FROM prContactos p WHERE p.fechaModificacion = :fechaModificacion"),
    @NamedQuery(name = "prContactos.findByUsuarioInactivador", query = "SELECT p FROM prContactos p WHERE p.usuarioInactivador = :usuarioInactivador"),
    @NamedQuery(name = "prContactos.findByFechaInactivacion", query = "SELECT p FROM prContactos p WHERE p.fechaInactivacion = :fechaInactivacion"),
    @NamedQuery(name = "prContactos.findByActivo", query = "SELECT p FROM prContactos p WHERE p.activo = :activo")})
public class prContactos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Size(min = 1, max = 10)
    @Column(name = "id_contacto")
    private String idContacto;
    @Size(max = 100)
    @Column(name = "nombres")
    private String nombres;
    @Size(max = 9)
    @Column(name = "telefono_fijo")
    private String telefonoFijo;
    @Size(max = 9)
    @Column(name = "telefono_movil")
    private String telefonoMovil;
    @Size(max = 300)
    @Column(name = "direccion")
    private String direccion;
    @Size(max = 30)
    @Column(name = "usuario_creador")
    private String usuarioCreador;
    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar fechaCreacion;
    @Size(max = 30)
    @Column(name = "usuario_modificacion")
    private String usuarioModificacion;
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
    @JoinColumn(name = "id_cliente", referencedColumnName = "id_cliente")
    @ManyToOne
    private prClientes idCliente;

    public prContactos() {
    }

    public prContactos(String idContacto) {
        this.idContacto = idContacto;
    }

    public String getIdContacto() {
        return idContacto;
    }

    public void setIdContacto(String idContacto) {
        this.idContacto = idContacto;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getTelefonoFijo() {
        return telefonoFijo;
    }

    public void setTelefonoFijo(String telefonoFijo) {
        this.telefonoFijo = telefonoFijo;
    }

    public String getTelefonoMovil() {
        return telefonoMovil;
    }

    public void setTelefonoMovil(String telefonoMovil) {
        this.telefonoMovil = telefonoMovil;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
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

    public String getUsuarioModificacion() {
        return usuarioModificacion;
    }

    public void setUsuarioModificacion(String usuarioModificacion) {
        this.usuarioModificacion = usuarioModificacion;
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

    public prClientes getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(prClientes idCliente) {
        this.idCliente = idCliente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idContacto != null ? idContacto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof prContactos)) {
            return false;
        }
        prContactos other = (prContactos) object;
        if ((this.idContacto == null && other.idContacto != null) || (this.idContacto != null && !this.idContacto.equals(other.idContacto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.prestamos.modelo.prContactos[ idContacto=" + idContacto + " ]";
    }
    
}

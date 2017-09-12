/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.prestamos.modelo;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author egalvez
 */
@Entity
@Table(name = "pr_clientes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "prClientes.findAll", query = "SELECT p FROM prClientes p"),
    @NamedQuery(name = "prClientes.findByIdCliente", query = "SELECT p FROM prClientes p WHERE p.idCliente = :idCliente"),
    @NamedQuery(name = "prClientes.findByNombres", query = "SELECT p FROM prClientes p WHERE p.nombres = :nombres"),
    @NamedQuery(name = "prClientes.findByApellidos", query = "SELECT p FROM prClientes p WHERE p.apellidos = :apellidos"),
    @NamedQuery(name = "prClientes.findByDui", query = "SELECT p FROM prClientes p WHERE p.dui = :dui"),
    @NamedQuery(name = "prClientes.findByNit", query = "SELECT p FROM prClientes p WHERE p.nit = :nit"),
    @NamedQuery(name = "prClientes.findByTelefonoFijo", query = "SELECT p FROM prClientes p WHERE p.telefonoFijo = :telefonoFijo"),
    @NamedQuery(name = "prClientes.findByTelefonoMobil", query = "SELECT p FROM prClientes p WHERE p.telefonoMobil = :telefonoMobil"),
    @NamedQuery(name = "prClientes.findByDireccion", query = "SELECT p FROM prClientes p WHERE p.direccion = :direccion"),
    @NamedQuery(name = "prClientes.findByActivo", query = "SELECT p FROM prClientes p WHERE p.activo = :activo"),
    @NamedQuery(name = "prClientes.findBySexo", query = "SELECT p FROM prClientes p WHERE p.sexo = :sexo"),
    @NamedQuery(name = "prClientes.findByFechaNacimiento", query = "SELECT p FROM prClientes p WHERE p.fechaNacimiento = :fechaNacimiento"),
    @NamedQuery(name = "prClientes.findByLugarTrabajo", query = "SELECT p FROM prClientes p WHERE p.lugarTrabajo = :lugarTrabajo"),
    @NamedQuery(name = "prClientes.findByDireccionTrabajo", query = "SELECT p FROM prClientes p WHERE p.direccionTrabajo = :direccionTrabajo"),
    @NamedQuery(name = "prClientes.findByTelefonoTrabajo", query = "SELECT p FROM prClientes p WHERE p.telefonoTrabajo = :telefonoTrabajo"),
    @NamedQuery(name = "prClientes.findByUsuarioCreador", query = "SELECT p FROM prClientes p WHERE p.usuarioCreador = :usuarioCreador"),
    @NamedQuery(name = "prClientes.findByFechaCreacion", query = "SELECT p FROM prClientes p WHERE p.fechaCreacion = :fechaCreacion"),
    @NamedQuery(name = "prClientes.findByUsuarioModificador", query = "SELECT p FROM prClientes p WHERE p.usuarioModificador = :usuarioModificador"),
    @NamedQuery(name = "prClientes.findByFechaModificacion", query = "SELECT p FROM prClientes p WHERE p.fechaModificacion = :fechaModificacion"),
    @NamedQuery(name = "prClientes.findByUsuarioInactivador", query = "SELECT p FROM prClientes p WHERE p.usuarioInactivador = :usuarioInactivador"),
    @NamedQuery(name = "prClientes.findByFechaInactivacion", query = "SELECT p FROM prClientes p WHERE p.fechaInactivacion = :fechaInactivacion")})
public class prClientes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Size(min = 1, max = 10)
    @Column(name = "id_cliente")
    private String idCliente;
    @Size(max = 100)
    @Column(name = "nombres")
    private String nombres;
    @Size(max = 100)
    @Column(name = "apellidos")
    private String apellidos;
    @Size(max = 10)
    @Column(name = "dui")
    private String dui;
    @Size(max = 14)
    @Column(name = "nit")
    private String nit;
    @Size(max = 9)
    @Column(name = "telefono_fijo")
    private String telefonoFijo;
    @Size(max = 9)
    @Column(name = "telefono_mobil")
    private String telefonoMobil;
    @Size(max = 300)
    @Column(name = "direccion")
    private String direccion;
    @Column(name = "activo")
    private Boolean activo;
    @Size(max = 1)
    @Column(name = "sexo")
    private String sexo;
    @Column(name = "fecha_nacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    @Size(max = 100)
    @Column(name = "lugar_trabajo")
    private String lugarTrabajo;
    @Size(max = 300)
    @Column(name = "direccion_trabajo")
    private String direccionTrabajo;
    @Size(max = 9)
    @Column(name = "telefono_trabajo")
    private String telefonoTrabajo;
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
    @OneToMany(mappedBy = "idCliente")
    private List<prContactos> prContactosList;
    @OneToMany(mappedBy = "idCliente")
    private List<prTransaccionesPrestamos> prTransaccionesPrestamosList;
    @OneToMany(mappedBy = "idCliente")
    private List<prPrestamos> prPrestamosList;

    public prClientes() {
    }

    public prClientes(String idCliente) {
        this.idCliente = idCliente;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDui() {
        return dui;
    }

    public void setDui(String dui) {
        this.dui = dui;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getTelefonoFijo() {
        return telefonoFijo;
    }

    public void setTelefonoFijo(String telefonoFijo) {
        this.telefonoFijo = telefonoFijo;
    }

    public String getTelefonoMobil() {
        return telefonoMobil;
    }

    public void setTelefonoMobil(String telefonoMobil) {
        this.telefonoMobil = telefonoMobil;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getLugarTrabajo() {
        return lugarTrabajo;
    }

    public void setLugarTrabajo(String lugarTrabajo) {
        this.lugarTrabajo = lugarTrabajo;
    }

    public String getDireccionTrabajo() {
        return direccionTrabajo;
    }

    public void setDireccionTrabajo(String direccionTrabajo) {
        this.direccionTrabajo = direccionTrabajo;
    }

    public String getTelefonoTrabajo() {
        return telefonoTrabajo;
    }

    public void setTelefonoTrabajo(String telefonoTrabajo) {
        this.telefonoTrabajo = telefonoTrabajo;
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

    @XmlTransient
    public List<prContactos> getPrContactosList() {
        return prContactosList;
    }

    public void setPrContactosList(List<prContactos> prContactosList) {
        this.prContactosList = prContactosList;
    }

    @XmlTransient
    public List<prTransaccionesPrestamos> getPrTransaccionesPrestamosList() {
        return prTransaccionesPrestamosList;
    }

    public void setPrTransaccionesPrestamosList(List<prTransaccionesPrestamos> prTransaccionesPrestamosList) {
        this.prTransaccionesPrestamosList = prTransaccionesPrestamosList;
    }

    @XmlTransient
    public List<prPrestamos> getPrPrestamosList() {
        return prPrestamosList;
    }

    public void setPrPrestamosList(List<prPrestamos> prPrestamosList) {
        this.prPrestamosList = prPrestamosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCliente != null ? idCliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof prClientes)) {
            return false;
        }
        prClientes other = (prClientes) object;
        if ((this.idCliente == null && other.idCliente != null) || (this.idCliente != null && !this.idCliente.equals(other.idCliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.prestamos.modelo.prClientes[ idCliente=" + idCliente + " ]";
    }
    
}

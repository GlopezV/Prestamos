/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.prestamos.modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
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
@Table(name = "pr_prestamos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "prPrestamos.findAll", query = "SELECT p FROM prPrestamos p"),
    @NamedQuery(name = "prPrestamos.findByIdPrestamo", query = "SELECT p FROM prPrestamos p WHERE p.idPrestamo = :idPrestamo"),
    @NamedQuery(name = "prPrestamos.findByFecha", query = "SELECT p FROM prPrestamos p WHERE p.fecha = :fecha"),
    @NamedQuery(name = "prPrestamos.findByMontoOtorgado", query = "SELECT p FROM prPrestamos p WHERE p.montoOtorgado = :montoOtorgado"),
    @NamedQuery(name = "prPrestamos.findByTipoPeriodo", query = "SELECT p FROM prPrestamos p WHERE p.tipoPeriodo = :tipoPeriodo"),
    @NamedQuery(name = "prPrestamos.findByPlazo", query = "SELECT p FROM prPrestamos p WHERE p.plazo = :plazo"),
    @NamedQuery(name = "prPrestamos.findByMontoCuota", query = "SELECT p FROM prPrestamos p WHERE p.montoCuota = :montoCuota"),
    @NamedQuery(name = "prPrestamos.findByUsuarioCreador", query = "SELECT p FROM prPrestamos p WHERE p.usuarioCreador = :usuarioCreador"),
    @NamedQuery(name = "prPrestamos.findByFechaCreacion", query = "SELECT p FROM prPrestamos p WHERE p.fechaCreacion = :fechaCreacion"),
    @NamedQuery(name = "prPrestamos.findByUsuarioModificador", query = "SELECT p FROM prPrestamos p WHERE p.usuarioModificador = :usuarioModificador"),
    @NamedQuery(name = "prPrestamos.findByFechaModificacion", query = "SELECT p FROM prPrestamos p WHERE p.fechaModificacion = :fechaModificacion"),
    @NamedQuery(name = "prPrestamos.findByUsuarioInactivador", query = "SELECT p FROM prPrestamos p WHERE p.usuarioInactivador = :usuarioInactivador"),
    @NamedQuery(name = "prPrestamos.findByFechaInactivacion", query = "SELECT p FROM prPrestamos p WHERE p.fechaInactivacion = :fechaInactivacion"),
    @NamedQuery(name = "prPrestamos.findByActivo", query = "SELECT p FROM prPrestamos p WHERE p.activo = :activo")})
public class prPrestamos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Size(min = 1, max = 15)
    @Column(name = "id_prestamo")
    private String idPrestamo;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "monto_otorgado")
    private BigDecimal montoOtorgado;
    @Size(max = 10)
    @Column(name = "tipo_periodo")
    private String tipoPeriodo;
    @Column(name = "plazo")
    private Integer plazo;
    @Column(name = "monto_cuota")
    private BigDecimal montoCuota;
    @Size(max = 30)
    @Column(name = "usuario_creador")
    private String usuarioCreador;
    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;
    @Size(max = 30)
    @Column(name = "usuario_modificador")
    private String usuarioModificador;
    @Column(name = "fecha_modificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModificacion;
    @Size(max = 30)
    @Column(name = "usuario_inactivador")
    private String usuarioInactivador;
    @Column(name = "fecha_inactivacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaInactivacion;
    @Column(name = "activo")
    private Boolean activo;
    @OneToMany(mappedBy = "idPrestamo")
    private List<prDetallePrestamos> prDetallePrestamosList;
    @OneToMany(mappedBy = "idPrestamo")
    private List<prDistPrestamos> prDistPrestamosList;
    @OneToMany(mappedBy = "idPrestamo")
    private List<prTransaccionesPrestamos> prTransaccionesPrestamosList;
    @JoinColumn(name = "id_cliente", referencedColumnName = "id_cliente")
    @ManyToOne
    private prClientes idCliente;

    public prPrestamos() {
    }

    public prPrestamos(String idPrestamo) {
        this.idPrestamo = idPrestamo;
    }

    public String getIdPrestamo() {
        return idPrestamo;
    }

    public void setIdPrestamo(String idPrestamo) {
        this.idPrestamo = idPrestamo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public BigDecimal getMontoOtorgado() {
        return montoOtorgado;
    }

    public void setMontoOtorgado(BigDecimal montoOtorgado) {
        this.montoOtorgado = montoOtorgado;
    }

    public String getTipoPeriodo() {
        return tipoPeriodo;
    }

    public void setTipoPeriodo(String tipoPeriodo) {
        this.tipoPeriodo = tipoPeriodo;
    }

    public Integer getPlazo() {
        return plazo;
    }

    public void setPlazo(Integer plazo) {
        this.plazo = plazo;
    }

    public BigDecimal getMontoCuota() {
        return montoCuota;
    }

    public void setMontoCuota(BigDecimal montoCuota) {
        this.montoCuota = montoCuota;
    }

    public String getUsuarioCreador() {
        return usuarioCreador;
    }

    public void setUsuarioCreador(String usuarioCreador) {
        this.usuarioCreador = usuarioCreador;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getUsuarioModificador() {
        return usuarioModificador;
    }

    public void setUsuarioModificador(String usuarioModificador) {
        this.usuarioModificador = usuarioModificador;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public String getUsuarioInactivador() {
        return usuarioInactivador;
    }

    public void setUsuarioInactivador(String usuarioInactivador) {
        this.usuarioInactivador = usuarioInactivador;
    }

    public Date getFechaInactivacion() {
        return fechaInactivacion;
    }

    public void setFechaInactivacion(Date fechaInactivacion) {
        this.fechaInactivacion = fechaInactivacion;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    @XmlTransient
    public List<prDetallePrestamos> getPrDetallePrestamosList() {
        return prDetallePrestamosList;
    }

    public void setPrDetallePrestamosList(List<prDetallePrestamos> prDetallePrestamosList) {
        this.prDetallePrestamosList = prDetallePrestamosList;
    }

    @XmlTransient
    public List<prDistPrestamos> getPrDistPrestamosList() {
        return prDistPrestamosList;
    }

    public void setPrDistPrestamosList(List<prDistPrestamos> prDistPrestamosList) {
        this.prDistPrestamosList = prDistPrestamosList;
    }

    @XmlTransient
    public List<prTransaccionesPrestamos> getPrTransaccionesPrestamosList() {
        return prTransaccionesPrestamosList;
    }

    public void setPrTransaccionesPrestamosList(List<prTransaccionesPrestamos> prTransaccionesPrestamosList) {
        this.prTransaccionesPrestamosList = prTransaccionesPrestamosList;
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
        hash += (idPrestamo != null ? idPrestamo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof prPrestamos)) {
            return false;
        }
        prPrestamos other = (prPrestamos) object;
        if ((this.idPrestamo == null && other.idPrestamo != null) || (this.idPrestamo != null && !this.idPrestamo.equals(other.idPrestamo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.prestamos.modelo.prPrestamos[ idPrestamo=" + idPrestamo + " ]";
    }
    
}

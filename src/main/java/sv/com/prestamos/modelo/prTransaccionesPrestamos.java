/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.prestamos.modelo;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "pr_transacciones_prestamos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "prTransaccionesPrestamos.findAll", query = "SELECT p FROM prTransaccionesPrestamos p"),
    @NamedQuery(name = "prTransaccionesPrestamos.findByIdTranPrestamo", query = "SELECT p FROM prTransaccionesPrestamos p WHERE p.idTranPrestamo = :idTranPrestamo"),
    @NamedQuery(name = "prTransaccionesPrestamos.findByFechaTransaccion", query = "SELECT p FROM prTransaccionesPrestamos p WHERE p.fechaTransaccion = :fechaTransaccion"),
    @NamedQuery(name = "prTransaccionesPrestamos.findByTipoTransaccion", query = "SELECT p FROM prTransaccionesPrestamos p WHERE p.tipoTransaccion = :tipoTransaccion"),
    @NamedQuery(name = "prTransaccionesPrestamos.findByMontoCuota", query = "SELECT p FROM prTransaccionesPrestamos p WHERE p.montoCuota = :montoCuota"),
    @NamedQuery(name = "prTransaccionesPrestamos.findByMontoCapital", query = "SELECT p FROM prTransaccionesPrestamos p WHERE p.montoCapital = :montoCapital"),
    @NamedQuery(name = "prTransaccionesPrestamos.findByMontoIntereses", query = "SELECT p FROM prTransaccionesPrestamos p WHERE p.montoIntereses = :montoIntereses"),
    @NamedQuery(name = "prTransaccionesPrestamos.findByMontoAportacion", query = "SELECT p FROM prTransaccionesPrestamos p WHERE p.montoAportacion = :montoAportacion"),
    @NamedQuery(name = "prTransaccionesPrestamos.findByMontoAdmon", query = "SELECT p FROM prTransaccionesPrestamos p WHERE p.montoAdmon = :montoAdmon"),
    @NamedQuery(name = "prTransaccionesPrestamos.findByMontoInteresesMoratorios", query = "SELECT p FROM prTransaccionesPrestamos p WHERE p.montoInteresesMoratorios = :montoInteresesMoratorios"),
    @NamedQuery(name = "prTransaccionesPrestamos.findByMontoCapitalAdo", query = "SELECT p FROM prTransaccionesPrestamos p WHERE p.montoCapitalAdo = :montoCapitalAdo"),
    @NamedQuery(name = "prTransaccionesPrestamos.findByMontoInteresesAdo", query = "SELECT p FROM prTransaccionesPrestamos p WHERE p.montoInteresesAdo = :montoInteresesAdo"),
    @NamedQuery(name = "prTransaccionesPrestamos.findByNumDias", query = "SELECT p FROM prTransaccionesPrestamos p WHERE p.numDias = :numDias"),
    @NamedQuery(name = "prTransaccionesPrestamos.findByUsuarioCreador", query = "SELECT p FROM prTransaccionesPrestamos p WHERE p.usuarioCreador = :usuarioCreador"),
    @NamedQuery(name = "prTransaccionesPrestamos.findByFechaCreacion", query = "SELECT p FROM prTransaccionesPrestamos p WHERE p.fechaCreacion = :fechaCreacion"),
    @NamedQuery(name = "prTransaccionesPrestamos.findByUsuarioModificador", query = "SELECT p FROM prTransaccionesPrestamos p WHERE p.usuarioModificador = :usuarioModificador"),
    @NamedQuery(name = "prTransaccionesPrestamos.findByFechaModificacion", query = "SELECT p FROM prTransaccionesPrestamos p WHERE p.fechaModificacion = :fechaModificacion"),
    @NamedQuery(name = "prTransaccionesPrestamos.findByUsuarioInactivador", query = "SELECT p FROM prTransaccionesPrestamos p WHERE p.usuarioInactivador = :usuarioInactivador"),
    @NamedQuery(name = "prTransaccionesPrestamos.findByFechaInactivacion", query = "SELECT p FROM prTransaccionesPrestamos p WHERE p.fechaInactivacion = :fechaInactivacion"),
    @NamedQuery(name = "prTransaccionesPrestamos.findByActivo", query = "SELECT p FROM prTransaccionesPrestamos p WHERE p.activo = :activo")})
public class prTransaccionesPrestamos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Size(min = 1, max = 25)
    @Column(name = "id_tran_prestamo")
    private String idTranPrestamo;
    @Column(name = "fecha_transaccion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaTransaccion;
    @Size(max = 10)
    @Column(name = "tipo_transaccion")
    private String tipoTransaccion;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "monto_cuota")
    private BigDecimal montoCuota;
    @Column(name = "monto_capital")
    private BigDecimal montoCapital;
    @Column(name = "monto_intereses")
    private BigDecimal montoIntereses;
    @Column(name = "monto_aportacion")
    private BigDecimal montoAportacion;
    @Column(name = "monto_admon")
    private BigDecimal montoAdmon;
    @Column(name = "monto_intereses_moratorios")
    private BigDecimal montoInteresesMoratorios;
    @Column(name = "monto_capital_ado")
    private BigDecimal montoCapitalAdo;
    @Column(name = "monto_intereses_ado")
    private BigDecimal montoInteresesAdo;
    @Column(name = "num_dias")
    private Integer numDias;
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
    @JoinColumn(name = "id_prestamo", referencedColumnName = "id_prestamo")
    @ManyToOne
    private prPrestamos idPrestamo;
    @JoinColumn(name = "id_cliente", referencedColumnName = "id_cliente")
    @ManyToOne
    private prClientes idCliente;

    public prTransaccionesPrestamos() {
    }

    public prTransaccionesPrestamos(String idTranPrestamo) {
        this.idTranPrestamo = idTranPrestamo;
    }

    public String getIdTranPrestamo() {
        return idTranPrestamo;
    }

    public void setIdTranPrestamo(String idTranPrestamo) {
        this.idTranPrestamo = idTranPrestamo;
    }

    public Date getFechaTransaccion() {
        return fechaTransaccion;
    }

    public void setFechaTransaccion(Date fechaTransaccion) {
        this.fechaTransaccion = fechaTransaccion;
    }

    public String getTipoTransaccion() {
        return tipoTransaccion;
    }

    public void setTipoTransaccion(String tipoTransaccion) {
        this.tipoTransaccion = tipoTransaccion;
    }

    public BigDecimal getMontoCuota() {
        return montoCuota;
    }

    public void setMontoCuota(BigDecimal montoCuota) {
        this.montoCuota = montoCuota;
    }

    public BigDecimal getMontoCapital() {
        return montoCapital;
    }

    public void setMontoCapital(BigDecimal montoCapital) {
        this.montoCapital = montoCapital;
    }

    public BigDecimal getMontoIntereses() {
        return montoIntereses;
    }

    public void setMontoIntereses(BigDecimal montoIntereses) {
        this.montoIntereses = montoIntereses;
    }

    public BigDecimal getMontoAportacion() {
        return montoAportacion;
    }

    public void setMontoAportacion(BigDecimal montoAportacion) {
        this.montoAportacion = montoAportacion;
    }

    public BigDecimal getMontoAdmon() {
        return montoAdmon;
    }

    public void setMontoAdmon(BigDecimal montoAdmon) {
        this.montoAdmon = montoAdmon;
    }

    public BigDecimal getMontoInteresesMoratorios() {
        return montoInteresesMoratorios;
    }

    public void setMontoInteresesMoratorios(BigDecimal montoInteresesMoratorios) {
        this.montoInteresesMoratorios = montoInteresesMoratorios;
    }

    public BigDecimal getMontoCapitalAdo() {
        return montoCapitalAdo;
    }

    public void setMontoCapitalAdo(BigDecimal montoCapitalAdo) {
        this.montoCapitalAdo = montoCapitalAdo;
    }

    public BigDecimal getMontoInteresesAdo() {
        return montoInteresesAdo;
    }

    public void setMontoInteresesAdo(BigDecimal montoInteresesAdo) {
        this.montoInteresesAdo = montoInteresesAdo;
    }

    public Integer getNumDias() {
        return numDias;
    }

    public void setNumDias(Integer numDias) {
        this.numDias = numDias;
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

    public prPrestamos getIdPrestamo() {
        return idPrestamo;
    }

    public void setIdPrestamo(prPrestamos idPrestamo) {
        this.idPrestamo = idPrestamo;
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
        hash += (idTranPrestamo != null ? idTranPrestamo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof prTransaccionesPrestamos)) {
            return false;
        }
        prTransaccionesPrestamos other = (prTransaccionesPrestamos) object;
        if ((this.idTranPrestamo == null && other.idTranPrestamo != null) || (this.idTranPrestamo != null && !this.idTranPrestamo.equals(other.idTranPrestamo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.prestamos.modelo.prTransaccionesPrestamos[ idTranPrestamo=" + idTranPrestamo + " ]";
    }
    
}

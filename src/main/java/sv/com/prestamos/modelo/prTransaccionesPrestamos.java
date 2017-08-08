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
    @NamedQuery(name = "prTransaccionesPrestamos.findByMontoOtros", query = "SELECT p FROM prTransaccionesPrestamos p WHERE p.montoOtros = :montoOtros")})
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
    
    @Column(name = "monto_otros")
    private BigDecimal montoOtros;
    
    @JoinColumn(name = "id_prestamo", referencedColumnName = "id_prestamo")
    @ManyToOne
    private prPrestamos Prestamo;
    
    @JoinColumn(name = "id_cliente", referencedColumnName = "id_cliente")
    @ManyToOne
    private prClientes Cliente;

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

    public BigDecimal getMontoOtros() {
        return montoOtros;
    }

    public void setMontoOtros(BigDecimal montoOtros) {
        this.montoOtros = montoOtros;
    }

    public prPrestamos getIdPrestamo() {
        return Prestamo;
    }

    public void setIdPrestamo(prPrestamos Prestamo) {
        this.Prestamo = Prestamo;
    }

    public prClientes getIdCliente() {
        return Cliente;
    }

    public void setIdCliente(prClientes Cliente) {
        this.Cliente = Cliente;
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

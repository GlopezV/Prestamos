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
@Table(name = "pr_detalle_prestamos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PrDetallePrestamos.findAll", query = "SELECT p FROM PrDetallePrestamos p"),
    @NamedQuery(name = "PrDetallePrestamos.findByIdDetPrestamo", query = "SELECT p FROM PrDetallePrestamos p WHERE p.idDetPrestamo = :idDetPrestamo"),
    @NamedQuery(name = "PrDetallePrestamos.findByFechaPago", query = "SELECT p FROM PrDetallePrestamos p WHERE p.fechaPago = :fechaPago"),
    @NamedQuery(name = "PrDetallePrestamos.findByMontoCuota", query = "SELECT p FROM PrDetallePrestamos p WHERE p.montoCuota = :montoCuota"),
    @NamedQuery(name = "PrDetallePrestamos.findByMontoCapital", query = "SELECT p FROM PrDetallePrestamos p WHERE p.montoCapital = :montoCapital"),
    @NamedQuery(name = "PrDetallePrestamos.findByMontoInteres", query = "SELECT p FROM PrDetallePrestamos p WHERE p.montoInteres = :montoInteres"),
    @NamedQuery(name = "PrDetallePrestamos.findByMontoAportacion", query = "SELECT p FROM PrDetallePrestamos p WHERE p.montoAportacion = :montoAportacion"),
    @NamedQuery(name = "PrDetallePrestamos.findByMontoAdmon", query = "SELECT p FROM PrDetallePrestamos p WHERE p.montoAdmon = :montoAdmon")})
public class PrDetallePrestamos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Size(min = 1, max = 25)
    @Column(name = "id_det_prestamo")
    private String idDetPrestamo;
    @Column(name = "fecha_pago")
    @Temporal(TemporalType.DATE)
    private Date fechaPago;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "monto_cuota")
    private BigDecimal montoCuota;
    @Column(name = "monto_capital")
    private BigDecimal montoCapital;
    @Column(name = "monto_interes")
    private BigDecimal montoInteres;
    @Column(name = "monto_aportacion")
    private BigDecimal montoAportacion;
    @Column(name = "monto_admon")
    private BigDecimal montoAdmon;
    @JoinColumn(name = "id_prestamo", referencedColumnName = "id_prestamo")
    @ManyToOne
    private PrPrestamos idPrestamo;

    public PrDetallePrestamos() {
    }

    public PrDetallePrestamos(String idDetPrestamo) {
        this.idDetPrestamo = idDetPrestamo;
    }

    public String getIdDetPrestamo() {
        return idDetPrestamo;
    }

    public void setIdDetPrestamo(String idDetPrestamo) {
        this.idDetPrestamo = idDetPrestamo;
    }

    public Date getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
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

    public BigDecimal getMontoInteres() {
        return montoInteres;
    }

    public void setMontoInteres(BigDecimal montoInteres) {
        this.montoInteres = montoInteres;
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

    public PrPrestamos getIdPrestamo() {
        return idPrestamo;
    }

    public void setIdPrestamo(PrPrestamos idPrestamo) {
        this.idPrestamo = idPrestamo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDetPrestamo != null ? idDetPrestamo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PrDetallePrestamos)) {
            return false;
        }
        PrDetallePrestamos other = (PrDetallePrestamos) object;
        if ((this.idDetPrestamo == null && other.idDetPrestamo != null) || (this.idDetPrestamo != null && !this.idDetPrestamo.equals(other.idDetPrestamo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.prestamos.modelo.PrDetallePrestamos[ idDetPrestamo=" + idDetPrestamo + " ]";
    }
    
}

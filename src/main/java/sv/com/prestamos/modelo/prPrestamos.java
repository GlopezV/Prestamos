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
    @NamedQuery(name = "prPrestamos.findByNumeroPeriodo", query = "SELECT p FROM prPrestamos p WHERE p.numeroPeriodo = :numeroPeriodo")})
public class prPrestamos implements Serializable {
    
    @OneToMany(mappedBy = "Prestamo")
    private List<prDetallePrestamos> ListaDetallePrestamos;
    
    @OneToMany(mappedBy = "Prestamo")
    private List<prTransaccionesPrestamos> ListaTransaccionesPrestamos;
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Size(min = 1, max = 15)
    @Column(name = "id_prestamo")
    private String idPrestamo;
    
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "monto_otorgado")
    private BigDecimal montoOtorgado;
    
    @Size(max = 10)
    @Column(name = "tipo_periodo")
    private String tipoPeriodo;
    
    @Column(name = "numero_periodo")
    private Integer numeroPeriodo;
    
    @JoinColumn(name = "id_linea_prestamo", referencedColumnName = "id_linea_prestamo")
    @ManyToOne
    private prlineasPrestamos LineaPrestamo;
    
   
    @JoinColumn(name = "id_cliente", referencedColumnName = "id_cliente")
    @ManyToOne
    private prClientes Cliente;

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

    public Integer getNumeroPeriodo() {
        return numeroPeriodo;
    }

    public void setNumeroPeriodo(Integer numeroPeriodo) {
        this.numeroPeriodo = numeroPeriodo;
    }

    public prlineasPrestamos getIdLineaPrestamo() {
        return LineaPrestamo;
    }

    public void setIdLineaPrestamo(prlineasPrestamos LineaPrestamo) {
        this.LineaPrestamo = LineaPrestamo;
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

    @XmlTransient
    public List<prDetallePrestamos> getPrDetallePrestamosList() {
        return ListaDetallePrestamos;
    }

    public void setPrDetallePrestamosList(List<prDetallePrestamos> ListaDetallePrestamos) {
        this.ListaDetallePrestamos = ListaDetallePrestamos;
    }

    @XmlTransient
    public List<prTransaccionesPrestamos> getPrTransaccionesPrestamosList() {
        return ListaTransaccionesPrestamos;
    }

    public void setPrTransaccionesPrestamosList(List<prTransaccionesPrestamos> ListaTransaccionesPrestamos) {
        this.ListaTransaccionesPrestamos = ListaTransaccionesPrestamos;
    }
    
}

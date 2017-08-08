/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.prestamos.modelo;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author egalvez
 */
@Entity
@Table(name = "pr_lineas_prestamos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "prlineasPrestamos.findAll", query = "SELECT p FROM prlineasPrestamos p"),
    @NamedQuery(name = "prlineasPrestamos.findByIdLineaPrestamo", query = "SELECT p FROM prlineasPrestamos p WHERE p.idLineaPrestamo = :idLineaPrestamo"),
    @NamedQuery(name = "prlineasPrestamos.findByDescripcion", query = "SELECT p FROM prlineasPrestamos p WHERE p.descripcion = :descripcion"),
    @NamedQuery(name = "prlineasPrestamos.findByTasa", query = "SELECT p FROM prlineasPrestamos p WHERE p.tasa = :tasa")})
public class prlineasPrestamos implements Serializable {
    
    @OneToMany(mappedBy = "LineaPrestamo")
    private List<prPrestamos> ListaPrestamos;
    
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

    public prlineasPrestamos() {
    }

    public prlineasPrestamos(String idLineaPrestamo) {
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLineaPrestamo != null ? idLineaPrestamo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof prlineasPrestamos)) {
            return false;
        }
        prlineasPrestamos other = (prlineasPrestamos) object;
        if ((this.idLineaPrestamo == null && other.idLineaPrestamo != null) || (this.idLineaPrestamo != null && !this.idLineaPrestamo.equals(other.idLineaPrestamo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.prestamos.modelo.prlineasPrestamos[ idLineaPrestamo=" + idLineaPrestamo + " ]";
    }

    @XmlTransient
    public List<prPrestamos> getPrPrestamosList() {
        return ListaPrestamos;
    }

    public void setPrPrestamosList(List<prPrestamos> ListaPrestamos) {
        this.ListaPrestamos = ListaPrestamos;
    }
    
}

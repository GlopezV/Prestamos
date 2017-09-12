/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.prestamos.modelo;

import java.io.Serializable;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author egalvez
 */
@Entity
@Table(name = "pr_dist_prestamos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "prDistPrestamos.findAll", query = "SELECT p FROM prDistPrestamos p"),
    @NamedQuery(name = "prDistPrestamos.findByIdDistPrestamo", query = "SELECT p FROM prDistPrestamos p WHERE p.idDistPrestamo = :idDistPrestamo")})
public class prDistPrestamos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Size(min = 1, max = 10)
    @Column(name = "id_dist_prestamo")
    private String idDistPrestamo;
    @JoinColumn(name = "id_prestamo", referencedColumnName = "id_prestamo")
    @ManyToOne
    private prPrestamos idPrestamo;
    @JoinColumn(name = "id_linea_prestamo", referencedColumnName = "id_linea_prestamo")
    @ManyToOne
    private prLineasPrestamos idLineaPrestamo;

    public prDistPrestamos() {
    }

    public prDistPrestamos(String idDistPrestamo) {
        this.idDistPrestamo = idDistPrestamo;
    }

    public String getIdDistPrestamo() {
        return idDistPrestamo;
    }

    public void setIdDistPrestamo(String idDistPrestamo) {
        this.idDistPrestamo = idDistPrestamo;
    }

    public prPrestamos getIdPrestamo() {
        return idPrestamo;
    }

    public void setIdPrestamo(prPrestamos idPrestamo) {
        this.idPrestamo = idPrestamo;
    }

    public prLineasPrestamos getIdLineaPrestamo() {
        return idLineaPrestamo;
    }

    public void setIdLineaPrestamo(prLineasPrestamos idLineaPrestamo) {
        this.idLineaPrestamo = idLineaPrestamo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDistPrestamo != null ? idDistPrestamo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof prDistPrestamos)) {
            return false;
        }
        prDistPrestamos other = (prDistPrestamos) object;
        if ((this.idDistPrestamo == null && other.idDistPrestamo != null) || (this.idDistPrestamo != null && !this.idDistPrestamo.equals(other.idDistPrestamo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.prestamos.modelo.prDistPrestamos[ idDistPrestamo=" + idDistPrestamo + " ]";
    }
    
}

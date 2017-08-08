
package sv.com.prestamos.modelo;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Objects;
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

@Entity
@Table(name = "pr_clientes")
@XmlRootElement
@NamedQueries({
@NamedQuery(name = "prClientes.findAllClientes",query = "SELECT p FROM prClientes p"),
@NamedQuery(name = "prClientes.findClienteByidCliente",query = "SELECT p FROM prClientes p WHERE p.idCliente=:idCliente")
})
public class prClientes implements Serializable{
    
    @OneToMany(mappedBy = "Cliente")
    private List<prTransaccionesPrestamos> ListaTransaccionesPrestamos;
    
    @OneToMany(mappedBy = "Cliente")
    private List<prPrestamos> ListaPrestamos;
    
    private static  final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Size(min = 1,max = 10)
    @Column(name = "id_cliente")
    private String idCliente;
    
    @Size(max = 100)
    @Column(name = "nombres")
    private String nombres;
    
    @Size(max=100)
    @Column(name = "apellidos")
    private String apellidos;
    
    @Size(max=10)
    @Column(name = "dui")
    private String dui;
    
    @Size(max = 14)
    @Column(name = "nit")
    private String nit;
    
    @Size(max = 10)
    @Column(name = "telefono_fijo")
    private String telefonoFijo;
    
    @Size(max = 10)
    @Column(name="telefono_mobil")
    private String telefonoMobil;
    
    @Size(max = 300)
    @Column(name = "direcccion")
    private String direccion;
    
    @Size(max = 10)
    @Column(name="sexo")
    private String sexo;
    
    @Column(name = "activo")
    private Boolean activo;
    
    @Column(name="fecha_nacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    
    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar fecha_creacion;
    
    @Column(name = "fecha_modificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar fecha_modificacion;
    
    @Size(max=50)
    @Column(name = "usuario_creador")
    private String usuario_creador;
    
    @Size(max=50)
    @Column(name = "usuario_modificador")
    private String usuario_modificador;
    
    
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

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    
    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }  

    public Calendar getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(Calendar fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public Calendar getFecha_modificacion() {
        return fecha_modificacion;
    }

    public void setFecha_modificacion(Calendar fecha_modificacion) {
        this.fecha_modificacion = fecha_modificacion;
    }

    public String getUsuario_creador() {
        return usuario_creador;
    }

    public void setUsuario_creador(String usuario_creador) {
        this.usuario_creador = usuario_creador;
    }

    public String getUsuario_modificador() {
        return usuario_modificador;
    }

    public void setUsuario_modificador(String usuario_modificador) {
        this.usuario_modificador = usuario_modificador;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.idCliente);
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

  
    @XmlTransient
    public List<prPrestamos> getPrPrestamosList() {
        return ListaPrestamos;
    }

    public void setPrPrestamosList(List<prPrestamos> ListaPrestamos) {
        this.ListaPrestamos = ListaPrestamos;
    }

    @XmlTransient
    public List<prTransaccionesPrestamos> getPrTransaccionesPrestamosList() {
        return ListaTransaccionesPrestamos;
    }

    public void setPrTransaccionesPrestamosList(List<prTransaccionesPrestamos> ListaTransaccionesPrestamos) {
        this.ListaTransaccionesPrestamos = ListaTransaccionesPrestamos;
    }
    
    
    
}
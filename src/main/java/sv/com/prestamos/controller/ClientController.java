
package sv.com.prestamos.controller;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
//import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import sv.com.prestamos.bs.ClientesBs;
import sv.com.prestamos.modelo.prClientes;

@Named
@ViewScoped
public class ClientController implements Serializable{
    
    @EJB
    private ClientesBs clienteBs;
    @Inject
    private prClientes cliente;
    private List<prClientes> listaCliente;
    private String nombres;
    private String apellidos;
    private String dui;
    private String idCliente;
    private String accion;
    private String Header; 
    private String opcionBusqueda;
    
    @PostConstruct
    public void init(){
          listarClientesTop();
          
      }
      
    public prClientes getCliente() {
        return cliente;
    }

    public void setCliente(prClientes cliente) {
        this.cliente = cliente;
    }

    public List<prClientes> getListaCliente() {
        return listaCliente;
    }

    public void setListaCliente(List<prClientes> listaCliente) {
        this.listaCliente = listaCliente;
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

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
         if(accion.equals("N")){
            this.setHeader("Nuevo Cliente");
           
        }else{
            this.setHeader("Editar Cliente");
            
        }
    }

    public String getHeader() {
        return Header;
    }

    public void setHeader(String Header) {
        this.Header = Header;
    }

    public String getOpcionBusqueda() {
        return opcionBusqueda;
    }

    public void setOpcionBusqueda(String opcionBusqueda) {
        this.opcionBusqueda = opcionBusqueda;
    }

    public String getDui() {
        return dui;
    }

    public void setDui(String dui) {
        this.dui = dui;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }
    
    public void createCliente(){
        try {
            if(clienteBs.crear(cliente).equals("Exitoso")){
                listarClientesTop();
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Se registro Exitosamente"));
            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso", "Fallo el registro"));
        }
    }
    
    public void editarCliente(){
      try {
            if(clienteBs.editar(cliente).equals("Exitoso")){
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Se Actualizo Exitosamente"));
            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso", "Fallo la Actualizacion"));
        }  
    }
    
    public void EliminarCliente(prClientes clienteEliminar){
        try {
            if(clienteBs.remover(clienteEliminar).equals("Exitoso")){
                listarClientesTop();
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Se Elimino Exitosamente"));
            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso", "Fallo la Eliminacion"));
        }  
    }
    
    public void SeleccionCliente(prClientes clienteSeleccionado){
        cliente=clienteSeleccionado;
        this.setAccion("M");
    }
    
    public void nuevoCliente(){
        //return cliente;
        cliente=new prClientes();
         this.setAccion("N");
        //return "/clientes.prestamos";
    }
    
    public void buscarClienteByNombreApellidos(){
         try {
           listaCliente= clienteBs.findByNombreApellidos(nombres, apellidos);
           listaCliente= clienteBs.findByClientesTop();
         } catch (Exception e) {
         }
     }
    
    public void listarClientesTop(){
         try {
           listaCliente= clienteBs.findByClientesTop();
         } catch (Exception e) {
         }
     }
    
    public void listaClienteByOpciones(){
     
        try{
            if (opcionBusqueda.equalsIgnoreCase("C")){
                listaCliente=clienteBs.findByCodigo(idCliente);
                this.setIdCliente(null);
            }else if(opcionBusqueda.equalsIgnoreCase("N")){
                listaCliente=clienteBs.findByNombreApellidos(nombres,apellidos);
                this.setNombres(null);
                this.setApellidos(null);
                     
            }else if(opcionBusqueda.equalsIgnoreCase("D")){
                listaCliente=clienteBs.findByDui(dui);
                this.setDui(null);
            }
            
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, 
                    new FacesMessage(FacesMessage.SEVERITY_WARN, 
                            "Aviso", "No existe el Cliente"));
        }
    }
    
    
    
   
    
    
   
}

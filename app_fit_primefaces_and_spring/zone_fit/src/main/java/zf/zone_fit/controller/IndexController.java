package zf.zone_fit.controller;

import java.util.*;

import org.primefaces.PrimeFaces;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import lombok.Data;
import zf.zone_fit.models.Clients;
import zf.zone_fit.services.IClientService;

@Controller
@Data
@ViewScoped
public class IndexController {

    @Autowired
    IClientService clientService;
    private Clients selectedClient;
    private List<Clients> clients;
    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

    @PostConstruct
    public void init() {
        loadData();
    }

    public void loadData() {
        this.clients = this.clientService.listClients();
        this.clients.forEach(clients -> logger.info(clients.toString()));
    }

    public void addClient(){
        this.selectedClient = new Clients();
    }

    public void saveClient(){
        logger.info("Cliente a guardar: " + this.selectedClient);

        //Agregar
        if (this.selectedClient.getId() == null) {
            this.clientService.saveClient(this.selectedClient);
            this.clients.add(this.selectedClient);
            FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Cliente agregado"));
        }else{
        //Modificar
            this.clientService.saveClient(this.selectedClient);
            FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Cliente modificado"));
        }

        //Ocultar modal
        PrimeFaces.current().executeScript("PF('windowModalClient').hide()");
        //Refrescar tabla
        PrimeFaces.current().ajax().update("form-clients:msg","form-clients:clients-table");
        //reset objeto cliente seleccionado
        this.selectedClient = null;
        
    }

    public void deleteClient(){
        logger.info("Cliente a eliminar " + this.selectedClient);
        this.clientService.deleteClient(this.selectedClient);
        //Eliminar del listado en memoria
        this.clients.remove(this.selectedClient);
        //Reset objeto cliente
        this.selectedClient = null;
        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Cliente eliminado"));
        PrimeFaces.current().ajax().update("form-clients:msg","form-clients:clients-table");

    }
}

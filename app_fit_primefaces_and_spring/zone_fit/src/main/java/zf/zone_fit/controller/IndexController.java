package zf.zone_fit.controller;

import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import jakarta.annotation.PostConstruct;
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
}

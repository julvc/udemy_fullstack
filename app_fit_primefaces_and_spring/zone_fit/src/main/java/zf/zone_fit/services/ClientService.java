package zf.zone_fit.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zf.zone_fit.models.Clients;
import zf.zone_fit.repositories.ClientRepository;

@Service
public class ClientService implements IClientService{

    @Autowired
    private ClientRepository clientRepository;


    @Override
    public List<Clients> listClients() {
        List<Clients> clients = clientRepository.findAll();
        return clients;
    }

    @Override
    public Clients searClientById(Integer idClient) {
        Clients client = clientRepository.findById(idClient).orElse(null);
        return client;
    }

    @Override
    public void saveClient(Clients client) {
        clientRepository.save(client);
    }

    @Override
    public void deleteClient(Clients client) {
        clientRepository.delete(client);
    }

}

package zf.zone_fit.services;

import java.util.List;
import zf.zone_fit.models.Clients;

public interface IClientService {
    public List<Clients> listClients();
    public Clients searClientById(Integer idClient);
    public void saveClient(Clients client);
    public void deleteClient(Clients client);
}

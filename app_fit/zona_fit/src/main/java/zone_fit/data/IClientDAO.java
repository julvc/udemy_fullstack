package zone_fit.data;

import java.util.List;
import zone_fit.dom.Client;

public interface IClientDAO {

    List<Client> listClients();
    boolean searchClientById (Client client);
    boolean addClient (Client client);
    boolean modifyClient (Client client);
    boolean deleteClient (Client client);

}

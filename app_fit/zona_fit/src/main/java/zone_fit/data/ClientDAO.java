package zone_fit.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import static zone_fit.database.ConnectionDB.getDBConnection;
import zone_fit.dom.Client;

public class ClientDAO implements IClientDAO{

    @Override
    public List<Client> listClients() {
        List<Client> clients = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;
        Connection con = getDBConnection();
        var sql = "SELECT * FROM clients ORDER BY id";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                var client = new Client();
                client.setId(rs.getInt("id"));
                client.setName(rs.getString("name"));
                client.setLastname(rs.getString("lastname"));
                client.setMemberId(rs.getInt("memberId"));
                clients.add(client);
            }
        } catch (Exception e) {
            System.out.println("Error al listar clientes " + e.getMessage());
        }finally{
            try {
                con.close();
            } catch (Exception e) {
                System.out.println("Error al cerrar conexion " + e.getMessage());
            }
        }
        return clients;
    }

    @Override
    public boolean searchClientById(Client client) {
        PreparedStatement ps;
        ResultSet rs;
        Connection con = getDBConnection();
        var sql = "SELECT * FROM clients WHERE id = ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, client.getId());
            rs = ps.executeQuery();
            if (rs.next()) {
                client.setName(rs.getString("name"));
                client.setLastname(rs.getString("lastname"));
                client.setMemberId(rs.getInt("memberId"));
                return true;
            }
        } catch (Exception e) {
            System.out.println("Error al consultar usuario por id " + e.getLocalizedMessage());
        }finally{
            try {
                con.close();
            } catch (Exception e) {
                System.out.println("Error al cerrar conexion " + e.getMessage());
            }
        }
        return false;
    }

    @Override
    public boolean addClient(Client client) {
        PreparedStatement ps;
        Connection con = getDBConnection();
        String sql = "INSERT INTO clients(name, lastname, memberId) VALUES (?,?,?)";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, client.getName());
            ps.setString(2, client.getLastname());
            ps.setInt(3, client.getMemberId());
            ps.execute();
            return true;

        } catch (Exception e) {
            System.out.println("Error al agregar cliente " + e.getMessage());
        }finally{
            try {
                con.close();
            } catch (Exception e) {
                System.out.println("Error al cerrar conexion de base datos " + e.getMessage());
            }
        }
        return false;
    }

    @Override
    public boolean modifyClient(Client client) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'modifyClient'");
    }

    @Override
    public boolean deleteClient(Client client) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteClient'");
    }

    public static void main(String[] args) {
        //Listar clientes
        // System.out.println("*** Listar Clientes ***");
        IClientDAO clienteDAO = new ClientDAO();
        // var clients = clienteDAO.listClients();

        // clients.forEach(System.out::println);

        //Buscar por ID
        var clientOne = new Client(2);
        System.out.println("Cliente antes de la busqueda " + clientOne);
        var foundIt = clienteDAO.searchClientById(clientOne);
        if (foundIt) {
            System.out.println("Cliente encontrado: " + clientOne);
        } else {
            System.out.println("No se encontro Cliente : " + clientOne.getId());
        }
    }
}

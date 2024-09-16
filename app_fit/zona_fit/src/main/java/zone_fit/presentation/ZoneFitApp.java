package zone_fit.presentation;

import java.util.Scanner;

import zone_fit.data.ClientDAO;
import zone_fit.data.IClientDAO;
import zone_fit.dom.Client;

public class ZoneFitApp {

    public static void main(String[] args) {
        zonaFitApp();
    }

    private static void zonaFitApp(){
        var output = false;
        var console = new Scanner(System.in);
        // Crear objeto clase ClienteDAO
        IClientDAO clienteDAO = new ClientDAO();

        while (!output) {
            try {
                var option = showMeenu(console);
                output = executeOptions(console,option,clienteDAO);
            } catch (Exception e) {
                System.out.println("Error al ejecutar opciones: " + e.getMessage());
            }
            System.out.println();
        }


    }

    private static int showMeenu(Scanner console){
        System.out.println("""
                ****Bienvenido a ZoneFit****
                1. Listar clientes
                2. Buscar cliente
                3. Agregar cliente
                4. Modificar cliente
                5. Eliminar cliente
                6. Salir
                Elije una opcion:\s""");
        return Integer.parseInt(console.nextLine());
    }
    
    private static boolean executeOptions(Scanner console, int option, IClientDAO clienteDAO) {
        var output = false;
        switch (option) {
            case 1 -> {
                System.out.println("--- Listado de clientes ---");
                var clients = clienteDAO.listClients();
                clients.forEach(System.out::println);
                }
            case 2 -> {
                System.out.println("--- Introduce id del cliente a buscar ---");
                var idClient = Integer.parseInt(console.nextLine());
                var client = new Client(idClient);
                var clientFound = clienteDAO.searchClientById(client);
                if (clientFound) {
                    System.out.println("Cliente encontrado " + client);
                } else {
                    System.out.println("Cliente No encontrado " + client);
                }
            }
            case 3 -> {
                System.out.println("--- Agregar nuevo cliente ---");
                System.out.println("Nombre :");
                var name = console.nextLine();
                System.out.println("Apellido :");
                var lastName = console.nextLine();
                System.out.println("Membresia :");
                var memberId = Integer.parseInt(console.nextLine());
                var client = new Client(name, lastName, memberId);
                var added = clienteDAO.addClient(client);
                if (added) {
                    System.out.println("Cliente agregado con exito " + client);
                }else{
                    System.out.println("Error al agregar cliente");
                }
            }
            case 4 ->{
                System.out.println("--- Modificar cliente ---");
                System.out.println("Id cliente :");
                var idClient = Integer.parseInt(console.nextLine());
                System.out.println("Nombre: ");
                var name = console.nextLine();
                System.out.println("Apellido: ");
                var lastName = console.nextLine();
                System.out.println("Membresia :");
                var memberId = Integer.parseInt(console.nextLine());
                var client = new Client(idClient, name,lastName,memberId);
                var modified = clienteDAO.modifyClient(client);
                if (modified) {
                    System.out.println("Cliente modificado: " + client);
                } else {
                    System.out.println("No se pudo modificar cliente " + client);
                }
            } 
            case 5 -> {
                System.out.println("--- Eliminar cliente ---");
                System.out.println("Id cliente :");
                var idClient = Integer.parseInt(console.nextLine());
                var client = new Client(idClient);
                var deleted = clienteDAO.deleteClient(client);
                if (deleted) {
                    System.out.println("Cliente eliminado correctamente " + client);
                }else{
                    System.out.println("No se pudo eliminar cliente " + client);
                }
            }
            case 6 ->{
                System.out.println("Hasta pronto");
                output = true;
            }

            default -> System.out.println("Opcion no reconocida " + option);
        }
        return output;
    }

}

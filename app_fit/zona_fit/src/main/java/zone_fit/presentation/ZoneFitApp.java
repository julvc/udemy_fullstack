package zone_fit.presentation;

import java.util.Scanner;

import zone_fit.data.ClientDAO;
import zone_fit.data.IClientDAO;

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
        }
        return output;
    }

}

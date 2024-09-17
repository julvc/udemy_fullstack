package zf.zone_fit;

import java.util.List;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import zf.zone_fit.models.Clients;
import zf.zone_fit.services.IClientService;

//@SpringBootApplication
public class ZoneFitApplication implements CommandLineRunner{

	@Autowired
	private IClientService clientService;

	private static final Logger logger = LoggerFactory.getLogger(ZoneFitApplication.class);

	public static void main(String[] args) {
		logger.info("Iniciando la aplicacion");
		SpringApplication.run(ZoneFitApplication.class, args);
		logger.info("Aplicacion finalizada");
	}

	@Override
	public void run(String... args) throws Exception {
		zoneFitApp();
	}

	private void zoneFitApp(){
		//logger.info("*** Zona FIT (GYM) ***");
		var output = false;
		var console = new Scanner(System.in);
		while (!output) {
			var option = showMenu(console);
			output = executeOption(console, option);
			logger.info("");
		}
	}

	private int showMenu(Scanner console){
		logger.info("""
			\n*** Zona FIT (GYM) ***"
			1. Listar clientes
			2. Buscar clientes
			3. Agregar cliente
			4. Modificar cliente
			5. Eliminar cliente
			6. Salir
			Elige una opcion:\s
		""");
		var option = Integer.parseInt(console.nextLine());
		return option;
	}

	private boolean executeOption(Scanner console, int option){
		var output = false;
		switch (option) {
			case 1 ->{
				logger.info("\n ------- Listado de Clientes ------- \n");
				List<zf.zone_fit.models.Clients> clients = clientService.listClients();
				clients.forEach(client -> logger.info(client.toString() + "\n"));
			}
			case 2 ->{
				logger.info("\n ------- Buscar Cliente ------- \n");
				logger.info("\n Id de cliente a buscar: \n");
				var idClient = Integer.parseInt(console.nextLine());
				Clients client = clientService.searClientById(idClient);
				if (client != null) {
					logger.info("Cliente encontrado : " + client + "\n");
				}else{
					logger.info("Cliente NO encontrado : " + client + "\n");
				}
			}
			case 3 ->{
				logger.info("\n ------- Agregar Cliente ------- \n");
				logger.info("Nombre : ");
				var name = console.nextLine();
				logger.info("Apellido : ");
				var lastname = console.nextLine();
				logger.info("Membresia : ");
				var memberid = console.nextLine();
				var client = new Clients();
				client.setName(name);
				client.setLastname(lastname);
				client.setMemberid(memberid);
				clientService.saveClient(client);
				logger.info("Cliente agregado con exito : " + client + "\n");
			}
			case 4 ->{
				logger.info("\n ------- Modificar Cliente ------- \n");
				logger.info("\n Id Cliente \n");
				var idCliente = Integer.parseInt(console.nextLine());
				Clients client = clientService.searClientById(idCliente);
				if (client != null) {
					logger.info("Nombre : ");
					var name = console.nextLine();
					logger.info("Apellido : ");
					var lastname = console.nextLine();
					logger.info("Membresia : ");
					var memberid = console.nextLine();
					client.setName(name);
					client.setLastname(lastname);
					client.setMemberid(memberid);
					clientService.saveClient(client);
					logger.info("Cliente modificado con exito : " + client + "\n");
				} else {
					logger.info("Cliente no encontrado " + client + "\n");
				}

			}
			case 5 ->{
				logger.info("\n ------- Eliminar Cliente ------- \n");
				logger.info("\n Id Cliente \n");
				var idClient = Integer.parseInt(console.nextLine());
				var client = clientService.searClientById(idClient);
				if (client != null) {
					clientService.deleteClient(client);
					logger.info("Cliente eliminado con exito : " + client + "\n");
				} else {
					logger.info("No pudo ser eliminado el cliente o no existe " + client + "\n");
				}
			}
			case 6 ->{
				logger.info("\n ------- Hasta Pronto ------- \n\n");
				output = true;
			}
			default ->{logger.info("Opcion no encontrada " + option);}
		}

		return output;
	}
}

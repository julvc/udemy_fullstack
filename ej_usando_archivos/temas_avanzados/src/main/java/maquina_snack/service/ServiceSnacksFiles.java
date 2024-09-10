package maquina_snack.service;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import maquina_snack.domain.Snack;

public class ServiceSnacksFiles implements IServiceSnack{
    
    private final String NOMBRE_ARCHIVO = "snacks.txt";
    private List<Snack> snacks = new ArrayList<>();
    
    public ServiceSnacksFiles(){
        //creamos archivo si no existe
        var archivo = new File(NOMBRE_ARCHIVO);
        boolean exist = false;

        try {
            exist = archivo.exists();
            if (exist) {
                this.snacks = ObtainSnacks();
            }else{
                var out = new PrintWriter(new FileWriter(archivo));
                out.close();
                System.out.println("Se ha creado el archivo");
            }

            if(!exist){
                setInitialSnacks();
            }


        } catch (Exception e) {
            System.out.println("Error al crear archivo " + e.getMessage());
        }
    }

    private void setInitialSnacks(){
        this.addSnack(new Snack("Pepsi", 150));
        this.addSnack(new Snack("Score", 150));
        this.addSnack(new Snack("Lays", 200));
        this.addSnack(new Snack("Doritos", 250));
    }

    @Override
    public void addSnack(Snack snack) {
        //se agrega nuevo snack
        this.snacks.add(snack);
        //se guarda en el archivo
        this.addSnackFile(snack);

    }

    private void addSnackFile(Snack snack){
        boolean added = false;
        var file = new File(NOMBRE_ARCHIVO);

        try {
            added = file.exists();
            var output = new PrintWriter(new FileWriter(file, added));
            output.println(snack.writeSnack());
            output.close();

        } catch (Exception e) {
            System.out.println("Error al agregar snack " + e.getMessage());
        }
    }

    @Override
    public void showSnack() {
        System.out.println("---- Snacks en el inventario ----");
        var inventorySnacks = "";
        for (var snack : this.snacks) {
            inventorySnacks += snack.toString() + "\n";
        }
        System.out.println(inventorySnacks);
    }

    public List<Snack> ObtainSnacks() {
        var snacks = new ArrayList<Snack>();
        try {
            List<String> lines = Files.readAllLines(Paths.get(NOMBRE_ARCHIVO));
            for (String line : lines) {
                String[] lineSnack = line.split(",");
                //var idSnack = lineSnack[0];
                var name = lineSnack[1];
                var price = Double.parseDouble(lineSnack[2]);
                var snack = new Snack(name, price);
                snacks.add(snack);
            }


        } catch (Exception e) {
            System.out.println("Error al leer archivo de snacks " + e.getMessage());
            e.printStackTrace();
        }

        return snacks;
    }

    @Override
    public List<Snack> getSnacks(){
        return this.snacks;
    }
}

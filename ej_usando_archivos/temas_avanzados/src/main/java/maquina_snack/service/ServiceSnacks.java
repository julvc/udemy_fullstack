package maquina_snack.service;

import java.util.ArrayList;
import java.util.List;

import maquina_snack.domain.Snack;

public class ServiceSnacks implements IServiceSnack{

    private static final List<Snack> snacks;

    static{
        snacks = new ArrayList<>();
        snacks.add(new Snack("Lays", 1500));
        snacks.add(new Snack("Pepsi", 1500));
        snacks.add(new Snack("Score energy", 1500));
    }

    @Override
    public void addSnack(Snack snack) {
        snacks.add(snack);
    }

    @Override
    public void showSnack() {
        var inventorySnack = "";
        for (var snack : snacks) {
            inventorySnack += snack.toString() + "\n";
        }
        System.out.println("--- Snacks del inventario ---");
        System.out.println(inventorySnack);
    }

    @Override
    public List<Snack> getSnacks() {
        return snacks;
    }

}

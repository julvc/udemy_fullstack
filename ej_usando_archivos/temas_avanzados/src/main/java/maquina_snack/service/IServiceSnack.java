package maquina_snack.service;

import java.util.List;

import maquina_snack.domain.Snack;

public interface IServiceSnack {

    void addSnack(Snack snack);
    void showSnack();
    List<Snack> getSnacks();
}

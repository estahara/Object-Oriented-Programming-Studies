package main.java.br.edu.ifsp.Aulas.Simulados.simuladoP2Imposto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public final class DeclaracaoCompleta extends Declaracao{

    private final List<Gasto> gastos;

    public DeclaracaoCompleta(long id, double ganhoTributavel, double valorPago) {
        super(id, ganhoTributavel, valorPago);
        gastos = new ArrayList<>();
    }

    @Override
    public double getValorImposto() {
        double valorImposto = 0.0;
        double ganhoTributavelAtual = getGanhoTributavel();

        if (ganhoTributavelAtual > 55_976.16) {
            valorImposto += (ganhoTributavelAtual - 55_976.16) * 0.275;
            ganhoTributavelAtual = 55_976.16;
        }

        if (ganhoTributavelAtual > 45_012.73) {
            valorImposto += (ganhoTributavelAtual - 45_012.73) * 0.225;
            ganhoTributavelAtual = 45_012.73;
        }

        if (ganhoTributavelAtual > 33_919.93) {
            valorImposto += (ganhoTributavelAtual - 33_919.93) * 0.15;
            ganhoTributavelAtual = 33_919.93;
        }

        if (ganhoTributavelAtual > 22_847.88) {
            valorImposto += (ganhoTributavelAtual - 22_847.88) * 0.075;
            ganhoTributavelAtual = 22_847.88;
        }

        return valorImposto;
    }

    @Override
    public double getGastosDedutiveis() {
        return gastos.stream()
                .mapToDouble(Gasto::getValorDedutivel)
                .sum();
    }

    public void addGasto(Gasto gasto) { gastos.add(gasto);}
    public void removeGasto(Gasto gasto) { gastos.remove(gasto);}

    @Override
    public String toString() {
        return "+++ DECLARAÇÃO COMPLETA +++\n" + super.toString() + "\nGastos dedutiveis: \n"
                + gastos.stream().map(Gasto::toString).collect(Collectors.joining("\n"));
    }
}

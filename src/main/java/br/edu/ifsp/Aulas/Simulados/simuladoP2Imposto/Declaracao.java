package main.java.br.edu.ifsp.Aulas.Simulados.simuladoP2Imposto;

import java.util.Objects;

public sealed abstract class Declaracao implements Entidade<Long> permits DeclaracaoSimplificada, DeclaracaoCompleta{
    private final long id;
    private double ganhoTributavel;
    private double valorPago;

     public Declaracao(long id, double ganhoTributavel, double valorPago) {
         this.id = id;
         this.ganhoTributavel = ganhoTributavel;
         this.valorPago = valorPago;
     }


    public final double getValorAPagar() {
         return getValorImposto() - valorPago - getGastosDedutiveis();
    }

    public double getGastosDedutiveis() {
         return 0.0;
    }

    public abstract double getValorImposto();

    public double getGanhoTributavel() {return ganhoTributavel;}
    public void setGanhoTributavel(double ganhoTributavel) {this.ganhoTributavel = ganhoTributavel;}
    public double getValorPago() {return valorPago;}
    public void setValorPago(double valorPago) {this.valorPago = valorPago;}

    @Override
    public Long getId() {return id;}

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Declaracao that = (Declaracao) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return String.format("| id = %d | Ganho tributável = R$%.2f | Valor já pago = R$%.2f | Valor a pagar = R$%.2f",
                id, ganhoTributavel, valorPago, getValorImposto(), getValorAPagar());
    }
}

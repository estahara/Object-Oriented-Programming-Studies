package main.java.br.edu.ifsp.Aulas.Simulados.simuladoP2Imposto;

public sealed abstract class Gasto implements Entidade<Long> permits GastoSaude, GastoEducacao {
    private final long id;
    private String descricao;
    private double valor;
    private String cnpj;

    public Gasto(long id, String descricao, double valor, String cnpj) {
        this.id = id;
        this.descricao = descricao;
        this.valor = valor;
        this.cnpj = cnpj;
    }

    public abstract double getValorDedutivel();

    @Override
    public Long getId() {return id;}

    public String getDescricao() {return descricao;}
    public void setDescricao(String descricao) {this.descricao = descricao;}
    public double getValor() {return valor;}
    public void setValor(double valor) {this.valor = valor;}
    public String getCnpj() {return cnpj;}
    public void setCnpj(String cnpj) {this.cnpj = cnpj;}

    @Override
    public String toString() {
        return String.format("| id = %d | cnpj = %s descricao = %s | valor = R$%.2f| ",
                id, cnpj, descricao, valor);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Gasto gasto = (Gasto) o;
        return id == gasto.id;
    }

    @Override
    public int hashCode() {
        return Long.hashCode(id);
    }
}

package main.java.br.edu.ifsp.Aulas.Simulados.simuladoP2Imposto;

public final class GastoSaude extends Gasto{
    private String registroConselho;
    public static final double DEDUCAO_MAX_SAUDE = 1_500.00;

    public GastoSaude(long id, String descricao, double valor, String cnpj, String registroConselho) {
        super(id, descricao, valor, cnpj);
        this.registroConselho = registroConselho;
    }

    @Override
    public double getValorDedutivel() {
        return Math.min(getValor(), DEDUCAO_MAX_SAUDE);
    }

    @Override
    public String toString() {
        return "Gasto com Saude | " + " registro = " + registroConselho + " " + super.toString();
    }

    public String getRegistroConselho() {return registroConselho;}

    public void setRegistroConselho(String registroConselho) {this.registroConselho = registroConselho;}
}

package main.java.br.edu.ifsp.Aulas.Simulados.simuladoP2Imposto;

public final class GastoEducacao extends Gasto {
    private String nomeInstituicao;
    public static final double DEDUCAO_MAX_EDUCA = 2_000.00;

    public GastoEducacao(long id, String descricao, double valor, String cnpj, String nomeInstituicao) {
        super(id, descricao, valor, cnpj);
        this.nomeInstituicao = nomeInstituicao;
    }


    @Override
    public double getValorDedutivel() {
        return Math.min(getValor(), DEDUCAO_MAX_EDUCA);
    }

    @Override
    public String toString() {
        return "Gasto com Educacao | " + " registro = " + nomeInstituicao + " " + super.toString();
    }

    public String getNomeInstituicao() {return nomeInstituicao;}

    public void setNomeInstituicao(String nomeInstituicao) {this.nomeInstituicao = nomeInstituicao;}
}

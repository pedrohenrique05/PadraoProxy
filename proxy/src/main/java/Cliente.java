import java.util.Arrays;
import java.util.List;

public class Cliente implements ICliente{
    String nome;
    String plano;
    String faturaAberta;
    int valorPlano;
    String desconexao;
    int codCliente;

    public Cliente(Integer codCliente){
    this.codCliente = codCliente;
    Cliente objeto = BD.getCliente(codCliente);
    this.nome = objeto.nome;
    this.plano = objeto.plano;
    this.faturaAberta = objeto.faturaAberta;
    this.valorPlano = objeto.valorPlano;
    this.desconexao = objeto.desconexao;
    }
    public Cliente(String nome, String plano, String faturaAberta, int valorPlano, String desconexao, Integer codCliente) {
        this.nome = nome;
        this.plano = plano;
        this.faturaAberta = faturaAberta;
        this.valorPlano = valorPlano;
        this.desconexao = desconexao;
        this.codCliente = codCliente;
    }

    @Override
    public List<String> obterInformacao() {
        return Arrays.asList(this.nome,this.plano);
    }

    @Override
    public String obterDadosFinanceiro(Funcionario funcionario) {
        return "Nome: "+this.nome+"\nPlano: "+this.plano+"\nFatura aberta: "+this.faturaAberta+"\nValor do Plano: "+this.valorPlano;
    }

    @Override
    public String obterDadosConexao(Funcionario funcionario) {
        return "Desconexão: "+this.desconexao+"\nPlano: "+this.plano;
    }

    public String getNome() {
        return this.nome;
    }

    public String getPlano() {
        return this.plano;
    }

    public String getFaturaAberta() {
        return this.faturaAberta;
    }

    public int getValorPlano() {
        return this.valorPlano;
    }

    public String getDesconexao() {
        return this.desconexao;
    }

    public int getCodCliente() {
        return this.codCliente;
    }
}


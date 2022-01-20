import java.util.List;

public interface ICliente {
    List<String> obterInformacao();
    String obterDadosFinanceiro(Funcionario funcionario);
    String obterDadosConexao(Funcionario funcionario);
}

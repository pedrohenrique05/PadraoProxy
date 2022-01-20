import java.util.List;

public class ClienteProxy implements ICliente{

    Cliente clienteProxy;
    private Integer codCliente;

    public ClienteProxy(Integer codCliente) {
        this.codCliente = codCliente;
    }

    @Override
    public List<String> obterInformacao() {
        if(this.clienteProxy == null){
            this.clienteProxy =  new Cliente(this.codCliente);
        }
        return this.clienteProxy.obterInformacao();
    }

    @Override
    public String obterDadosFinanceiro(Funcionario funcionario) {
        if(!funcionario.isAtendente()){
            throw new IllegalArgumentException("Funcionario sem autorizacao!");
        }
        if(this.clienteProxy == null){
            this.clienteProxy = new Cliente(this.codCliente);
        }
        return this.clienteProxy.obterDadosFinanceiro(funcionario);
    }

    @Override
    public String obterDadosConexao(Funcionario funcionario) {
        if(!funcionario.isTecnico()){
            throw new IllegalArgumentException("Funcionario não é tecnico!");
        }
        if(this.clienteProxy == null){
            this.clienteProxy = new Cliente(this.codCliente);
        }
        return this.clienteProxy.obterDadosConexao(funcionario);
    }
}

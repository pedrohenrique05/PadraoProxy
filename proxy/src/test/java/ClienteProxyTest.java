import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ClienteProxyTest {
    @BeforeEach
    void setUp(){
        BD.addCliente(new Cliente("João", "150megas","sem fatura em aberto", 88,
                "sem desconexão", 001));
        BD.addCliente(new Cliente("Maria", "6megas","duas faturas em aberto", 120,
                "duas desconexão em 30 dias", 002));
    }
    @Test
    void deveRetornarInformacoes(){
        ClienteProxy cliente = new ClienteProxy(001);

        assertEquals(Arrays.asList("João","150megas"),cliente.obterInformacao());
    }

    @Test
    void deveRetornarDadosConexao(){
        Funcionario funcionario = new Funcionario("Pedro",true,false);
        ClienteProxy cliente = new ClienteProxy(001);

        assertEquals("Desconexão: sem desconexão\n" +
                "Plano: 150megas",cliente.obterDadosConexao(funcionario));
    }

    @Test
    void deveRetornarFinanceiro(){
        Funcionario funcionario = new Funcionario("Pedro",false,true);
        ClienteProxy cliente = new ClienteProxy(002);

        assertEquals("Nome: Maria\n" +
                "Plano: 6megas\n" +
                "Fatura aberta: duas faturas em aberto\n" +
                "Valor do Plano: 120",cliente.obterDadosFinanceiro(funcionario));
    }

    @Test
    void deveRetornarErroNaoTecnico(){

        try {
            Funcionario funcionario = new Funcionario("Pedro", false, false);
            ClienteProxy cliente = new ClienteProxy(001);
            cliente.obterDadosConexao(funcionario);
            fail();
        }catch (IllegalArgumentException e){
            assertEquals("Funcionario não é tecnico!",e.getMessage());
        }
    }

    @Test
    void deveRetornarErroNaoAtendente(){

        try {
            Funcionario funcionario = new Funcionario("Pedro", false, false);
            ClienteProxy cliente = new ClienteProxy(002);
            cliente.obterDadosFinanceiro(funcionario);
            fail();
        }catch (IllegalArgumentException e){
            assertEquals("Funcionario sem autorizacao!",e.getMessage());
        }
    }

}
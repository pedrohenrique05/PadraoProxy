import java.util.HashMap;
import java.util.Map;

public class BD {
    private static Map<Integer, Cliente> clientes = new HashMap<>();
    public static Cliente getCliente(int codCliente){
        return clientes.get(codCliente);
    }

    public static void addCliente(Cliente cliente){
        clientes.put(cliente.getCodCliente(), cliente);
    }
}

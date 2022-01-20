public class Funcionario {

    String nome;
    boolean tecnico;
    boolean atendente;

    public Funcionario(String nome, boolean tecnico, boolean atendente) {
        this.nome = nome;
        this.tecnico = tecnico;
        this.atendente = atendente;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isTecnico() {
        return this.tecnico;
    }

    public void setTecnico(boolean tecnico) {
        this.tecnico = tecnico;
    }

    public boolean isAtendente() {
        return this.atendente;
    }

    public void setAtendende(boolean atendente) {
        this.atendente = atendente;
    }
}

package classes;

public class Pessoa {
    private String nome;
    private String cpf;
    private Aeronave[] aeronaves;

    public Aeronave[] getAeronaves() {
        return aeronaves;
    }

    public void setAeronaves(Aeronave[] aeronaves) {
        this.aeronaves = aeronaves;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;

    }

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}

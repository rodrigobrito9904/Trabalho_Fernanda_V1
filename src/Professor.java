public class Professor extends Pessoa {
    private String especialidade;

    public Professor(String Nome, int idade, String cpf, String genero, String endereco, String especialidade) {
        super(Nome, idade, cpf, genero, endereco);
        this.especialidade = especialidade;
    }

    @Override
    public String toString() {
        return super.toString() + 
               ", Especialidade: " + especialidade;
    }
}

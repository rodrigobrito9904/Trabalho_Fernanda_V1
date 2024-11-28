public class Personal extends Pessoa {
    private int alunosAtendidos;

    public Personal(String nome, int idade, String cpf, String genero, String endereco) {
        super(nome, idade, cpf, genero, endereco);
        this.alunosAtendidos = 0;
    }

    public void atenderAluno() {
        this.alunosAtendidos++;
    }

    @Override
    public String toString() {
        return super.toString() + 
               ", Alunos Atendidos: " + alunosAtendidos;
    }
}

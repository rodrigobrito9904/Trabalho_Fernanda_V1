public abstract class Pessoa {
    protected String nome;
    protected int idade;
    protected String cpf;
    protected String genero;
    protected String endereco;

    public Pessoa(String nome, int idade, String cpf, String genero, String endereco) {
        this.nome = nome;
        this.idade = idade;
        this.cpf = cpf;
        this.genero = genero;
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + 
               ", Idade: " + idade + 
               ", CPF: " + cpf + 
               ", Gênero: " + genero + 
               ", Endereço: " + endereco;
    }
}

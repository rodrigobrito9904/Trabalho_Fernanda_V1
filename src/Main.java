import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Aluno> alunos = new ArrayList<>();
    private static ArrayList<Professor> professores = new ArrayList<>();
    private static ArrayList<Personal> personals = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;

        do {
            System.out.println("\n=== Sistema da Academia ===");
            System.out.println("1. Cadastrar Aluno");
            System.out.println("2. Cadastrar Professor");
            System.out.println("3. Cadastrar Personal");
            System.out.println("4. Listar Alunos");
            System.out.println("5. Listar Professores");
            System.out.println("6. Listar Personais");
            System.out.println("7. Registrar Pagamento de Aluno");
            System.out.println("8. Consultar Treinos do Aluno");
            System.out.println("9. Atender Aluno com Personal");
            System.out.println("10. Sair");
            opcao = obterOpcaoMenu();

            switch (opcao) {
                case 1:
                    cadastrarAluno();
                    break;
                case 2:
                    cadastrarProfessor();
                    break;
                case 3:
                    cadastrarPersonal();
                    break;
                case 4:
                    listarAlunos();
                    break;
                case 5:
                    listarProfessores();
                    break;
                case 6:
                    listarPersonais();
                    break;
                case 7:
                    registrarPagamentoAluno();
                    break;
                case 8:
                    consultarTreinosAluno();
                    break;
                case 9:
                    atenderAlunoComPersonal();
                    break;
                case 10:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while (opcao != 10);
    }

    private static int obterOpcaoMenu() {
        int opcao;
        while (true) {
            System.out.print("Escolha uma opção: ");
            if (scanner.hasNextInt()) {
                opcao = scanner.nextInt();
                scanner.nextLine(); // Consumir quebra de linha
                if (opcao >= 1 && opcao <= 10) {
                    break;
                } else {
                    System.out.println("Opção inválida. Tente novamente.");
                }
            } else {
                System.out.println("Entrada inválida. Digite um número.");
                scanner.nextLine(); // Limpar buffer
            }
        }
        return opcao;
    }

    private static void cadastrarAluno() {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Idade: ");
        int idade = scanner.nextInt();
        scanner.nextLine();
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        System.out.print("Gênero: ");
        String genero = scanner.nextLine();
        System.out.print("Endereço: ");
        String endereco = scanner.nextLine();
        System.out.print("Plano (1 - Mensal, 2 - Anual): ");
        Plano plano = Plano.values()[scanner.nextInt() - 1];
        System.out.println("Escolha o nível de treino (1 - Iniciante, 2 - Intermediário, 3 - Avançado): ");
        NivelTreino nivelTreino = NivelTreino.values()[scanner.nextInt() - 1];
        System.out.println("Escolha a frequência semanal (1 - 3 dias, 2 - 4 dias, 3 - 5 dias): ");
        FrequenciaSemanal frequencia = FrequenciaSemanal.values()[scanner.nextInt() - 1];

        alunos.add(new Aluno(nome, idade, cpf, genero, endereco, plano, nivelTreino, frequencia));
        System.out.println("Aluno cadastrado com sucesso!");
    }

    private static void listarAlunos() {
        if (alunos.isEmpty()) {
            System.out.println("Nenhum aluno cadastrado.");
        } else {
            for (Aluno aluno : alunos) {
                System.out.println(aluno);
            }
        }
    }

    private static void cadastrarProfessor() {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Idade: ");
        int idade = scanner.nextInt();
        scanner.nextLine();
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        System.out.print("Gênero: ");
        String genero = scanner.nextLine();
        System.out.print("Endereço: ");
        String endereco = scanner.nextLine();
        System.out.print("Especialidade: ");
        String especialidade = scanner.nextLine();

        professores.add(new Professor(nome, idade, cpf, genero, endereco, especialidade));
        System.out.println("Professor cadastrado com sucesso!");
    }

    private static void listarProfessores() {
        if (professores.isEmpty()) {
            System.out.println("Nenhum professor cadastrado.");
        } else {
            for (Professor professor : professores) {
                System.out.println(professor);
            }
        }
    }

    private static void cadastrarPersonal() {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Idade: ");
        int idade = scanner.nextInt();
        scanner.nextLine();
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        System.out.print("Gênero: ");
        String genero = scanner.nextLine();
        System.out.print("Endereço: ");
        String endereco = scanner.nextLine();

        personals.add(new Personal(nome, idade, cpf, genero, endereco));
        System.out.println("Personal cadastrado com sucesso!");
    }

    private static void listarPersonais() {
        if (personals.isEmpty()) {
            System.out.println("Nenhum personal cadastrado.");
        } else {
            for (Personal personal : personals) {
                System.out.println(personal);
            }
        }
    }

    private static void registrarPagamentoAluno() {
        System.out.print("Informe o nome do aluno: ");
        String nome = scanner.nextLine();

        for (Aluno aluno : alunos) {
            if (aluno.getNome().equalsIgnoreCase(nome)) {
                aluno.registrarPagamento();
                System.out.println("Pagamento registrado com sucesso!");
                return;
            }
        }
        System.out.println("Aluno não encontrado.");
    }

    private static void consultarTreinosAluno() {
        System.out.print("Informe o nome do aluno: ");
        String nome = scanner.nextLine();

        for (Aluno aluno : alunos) {
            if (aluno.getNome().equalsIgnoreCase(nome)) {
                String[] treinos = Treino.getTreino(aluno.getNivelTreino(), aluno.getFrequencia());
                if (treinos != null) {
                    System.out.println("Treinos disponíveis:");
                    for (String treino : treinos) {
                        System.out.println("- " + treino);
                    }
                } else {
                    System.out.println("Nenhum treino encontrado.");
                }
                return;
            }
        }
        System.out.println("Aluno não encontrado.");
    }

    private static void atenderAlunoComPersonal() {
        System.out.print("Informe o nome do personal: ");
        String nomePersonal = scanner.nextLine();

        for (Personal personal : personals) {
            if (personal.getNome().equalsIgnoreCase(nomePersonal)) {
                personal.atenderAluno();
                System.out.println("Aluno atendido pelo personal " + personal.getNome());
                return;
            }
        }
        System.out.println("Personal não encontrado.");
    }
}

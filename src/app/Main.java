package app;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GestorCandidaturas gestor = new GestorCandidaturas(100);

        // Cursos já existentes no sistema
        gestor.adicionarCurso(new Curso("LEI", "Licenciatura em Engenharia Informatica", 3, 14));
        gestor.adicionarCurso(new Curso("LEE", "Licenciatura em Engenharia Eletrotecnica", 2, 12));
        gestor.adicionarCurso(new Curso("LEM", "Licenciatura em Engenharia Mecanica", 2, 10));

        int opcao;

        do {
            System.out.println("\n=== SISTEMA DE CANDIDATURAS AO ISEL ===");
            System.out.println("1 - Adicionar curso");
            System.out.println("2 - Adicionar candidato");
            System.out.println("3 - Registar candidatura");
            System.out.println("4 - Listar cursos");
            System.out.println("5 - Listar candidatos");
            System.out.println("6 - Listar candidaturas");
            System.out.println("7 - Atribuir vagas");
            System.out.println("8 - Mostrar admitidos");
            System.out.println("9 - Pesquisar candidato");
            System.out.println("10 - Guardar dados em ficheiro");
            System.out.println("11 - Carregar dados do ficheiro");
            System.out.println("0 - Sair");
            System.out.print("Opcao: ");

            while (!sc.hasNextInt()) {
                sc.nextLine();
                System.out.print("Opcao: ");
            }

            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    adicionarCurso(sc, gestor);
                    break;
                case 2:
                    adicionarCandidato(sc, gestor);
                    break;
                case 3:
                    criarCandidatura(sc, gestor);
                    break;
                case 4:
                    gestor.listarCursos();
                    break;
                case 5:
                    gestor.listarCandidatos();
                    break;
                case 6:
                    gestor.listarCandidaturas();
                    break;
                case 7:
                    gestor.atribuirVagas();
                    break;
                case 8:
                    gestor.mostrarAdmitidos();
                    break;
                case 9:
                    pesquisarCandidato(sc, gestor);
                    break;
                case 10:
                    FicheiroDados.guardarDados(gestor, "dados.txt");
                    break;
                case 11:
                    FicheiroDados.carregarDados(gestor, "dados.txt");
                    break;
                case 0:
                    System.out.println("Programa terminado.");
                    break;
                default:
                    System.out.println("Opcao invalida.");
            }

        } while (opcao != 0);

        sc.close();
    }

    public static void adicionarCurso(Scanner sc, GestorCandidaturas gestor) {
        System.out.print("Codigo do curso: ");
        String codigo = sc.nextLine();

        System.out.print("Nome do curso: ");
        String nome = sc.nextLine();

        System.out.print("Numero de vagas: ");
        int vagas = lerInteiroPositivo(sc);

        System.out.print("Nota minima (0 a 20): ");
        double notaMinima = lerNota(sc);

        Curso curso = new Curso(codigo, nome, vagas, notaMinima);
        gestor.adicionarCurso(curso);
    }

    public static void adicionarCandidato(Scanner sc, GestorCandidaturas gestor) {
        System.out.print("Nome do candidato: ");
        String nome = sc.nextLine();

        String email = lerEmail(sc);

        System.out.print("Numero do candidato: ");
        int numero = lerInteiroPositivo(sc);

        System.out.print("Nota de acesso (0 a 20): ");
        double nota = lerNota(sc);

        Candidato candidato = new Candidato(nome, email, numero, nota);
        gestor.adicionarCandidato(candidato);
    }

    public static void criarCandidatura(Scanner sc, GestorCandidaturas gestor) {
        System.out.print("Numero do candidato: ");
        int numero = lerInteiroPositivo(sc);

        System.out.print("Codigo do curso: ");
        String codigo = sc.nextLine();

        gestor.criarCandidatura(numero, codigo);
    }

    public static void pesquisarCandidato(Scanner sc, GestorCandidaturas gestor) {
        System.out.print("Numero do candidato a pesquisar: ");
        int numero = lerInteiroPositivo(sc);

        Candidato candidato = gestor.procurarCandidato(numero);

        if (candidato != null) {
            candidato.print();
        } else {
            System.out.println("Candidato nao encontrado.");
        }
    }

    public static String lerEmail(Scanner sc) {
        String email;

        while (true) {
            System.out.print("Email do candidato: ");
            email = sc.nextLine().trim();

            if (email.contains("@") && email.contains(".") && !email.contains(" ")) {
                return email;
            }

            System.out.println("Email invalido. Tente novamente.");
        }
    }

    public static int lerInteiroPositivo(Scanner sc) {
        int valor;

        while (true) {
            while (!sc.hasNextInt()) {
                sc.nextLine();
                System.out.print("Introduza um numero inteiro: ");
            }

            valor = sc.nextInt();
            sc.nextLine();

            if (valor > 0) {
                return valor;
            }

            System.out.print("Introduza um numero positivo: ");
        }
    }

    public static double lerNota(Scanner sc) {
        double valor;

        while (true) {
            while (!sc.hasNextDouble()) {
                sc.nextLine();
                System.out.print("Introduza uma nota valida: ");
            }

            valor = sc.nextDouble();
            sc.nextLine();

            if (valor >= 0 && valor <= 20) {
                return valor;
            }

            System.out.print("A nota tem de estar entre 0 e 20: ");
        }
    }
}
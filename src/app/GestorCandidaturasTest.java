package app;

public class GestorCandidaturasTest {

    public static void main(String[] args) {
        GestorCandidaturas gestor = new GestorCandidaturas(10);

        Curso curso1 = new Curso("LEI", "Licenciatura em Engenharia Informatica", 2, 14);
        Curso curso2 = new Curso("LEM", "Licenciatura em Engenharia Mecanica", 1, 10);

        Candidato candidato1 = new Candidato("Ana", "ana@email.com", 1, 16);
        Candidato candidato2 = new Candidato("Bruno", "bruno@email.com", 2, 12);
        Candidato candidato3 = new Candidato("Carla", "carla@email.com", 3, 15);

        gestor.adicionarCurso(curso1);
        gestor.adicionarCurso(curso2);

        gestor.adicionarCandidato(candidato1);
        gestor.adicionarCandidato(candidato2);
        gestor.adicionarCandidato(candidato3);

        gestor.criarCandidatura(1, "LEI");
        gestor.criarCandidatura(2, "LEI");
        gestor.criarCandidatura(3, "LEM");

        gestor.atribuirVagas();

        System.out.println("=== TESTE DE CANDIDATURAS ===");
        gestor.listarCandidaturas();

        System.out.println("\n=== TESTE DE ADMITIDOS ===");
        gestor.mostrarAdmitidos();

        System.out.println("\n=== TESTE DE PESQUISA ===");
        Candidato encontrado = gestor.procurarCandidato(1);
        if (encontrado != null) {
            System.out.println("Teste OK - candidato encontrado:");
            encontrado.print();
        } else {
            System.out.println("Teste falhou - candidato nao encontrado.");
        }
    }
}
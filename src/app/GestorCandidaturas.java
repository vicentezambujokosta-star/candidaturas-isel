package app;

public class GestorCandidaturas {
    private Candidato[] candidatos;
    private Curso[] cursos;
    private Candidatura[] candidaturas;

    private int numCandidatos;
    private int numCursos;
    private int numCandidaturas;

    public GestorCandidaturas(int capacidade) {
        candidatos = new Candidato[capacidade];
        cursos = new Curso[capacidade];
        candidaturas = new Candidatura[capacidade];

        numCandidatos = 0;
        numCursos = 0;
        numCandidaturas = 0;
    }

    public void adicionarCandidato(Candidato candidato) {
        if (numCandidatos < candidatos.length) {
            candidatos[numCandidatos] = candidato;
            numCandidatos++;
        } else {
            System.out.println("Nao ha espaco para mais candidatos.");
        }
    }

    public void adicionarCurso(Curso curso) {
        if (numCursos < cursos.length) {
            cursos[numCursos] = curso;
            numCursos++;
        } else {
            System.out.println("Nao ha espaco para mais cursos.");
        }
    }

    public void criarCandidatura(int numeroCandidato, String codigoCurso) {
        Candidato candidato = procurarCandidato(numeroCandidato);
        Curso curso = procurarCurso(codigoCurso);

        if (candidato == null) {
            System.out.println("Candidato nao encontrado.");
            return;
        }

        if (curso == null) {
            System.out.println("Curso nao encontrado.");
            return;
        }

        if (numCandidaturas < candidaturas.length) {
            candidaturas[numCandidaturas] = new Candidatura(candidato, curso);
            numCandidaturas++;
            System.out.println("Candidatura criada com sucesso.");
        } else {
            System.out.println("Nao ha espaco para mais candidaturas.");
        }
    }

    public void listarCandidatos() {
        System.out.println("\n=== CANDIDATOS ===");
        if (numCandidatos == 0) {
            System.out.println("Nao existem candidatos.");
            return;
        }

        for (int i = 0; i < numCandidatos; i++) {
            candidatos[i].print();
        }
    }

    public void listarCursos() {
        System.out.println("\n=== CURSOS ===");
        if (numCursos == 0) {
            System.out.println("Nao existem cursos.");
            return;
        }

        for (int i = 0; i < numCursos; i++) {
            cursos[i].print();
        }
    }

    public void listarCandidaturas() {
        System.out.println("\n=== CANDIDATURAS ===");
        if (numCandidaturas == 0) {
            System.out.println("Nao existem candidaturas.");
            return;
        }

        for (int i = 0; i < numCandidaturas; i++) {
            candidaturas[i].print();
        }
    }

    public Candidato procurarCandidato(int numeroCandidato) {
        for (int i = 0; i < numCandidatos; i++) {
            if (candidatos[i].getNumeroCandidato() == numeroCandidato) {
                return candidatos[i];
            }
        }
        return null;
    }

    public Curso procurarCurso(String codigoCurso) {
        for (int i = 0; i < numCursos; i++) {
            if (cursos[i].getCodigo().equalsIgnoreCase(codigoCurso)) {
                return cursos[i];
            }
        }
        return null;
    }

    public void atribuirVagas() {
        if (numCandidaturas == 0) {
            System.out.println("Nao existem candidaturas.");
            return;
        }

        ordenarCandidaturasPorNota();

        for (int i = 0; i < numCandidaturas; i++) {
            Candidatura candidatura = candidaturas[i];
            Candidato candidato = candidatura.getCandidato();
            Curso curso = candidatura.getCurso();

            if (candidato.getNotaAcesso() >= curso.getNotaMinima() && curso.getVagas() > 0) {
                candidatura.setEstado("Admitida");
                curso.setVagas(curso.getVagas() - 1);
            } else {
                candidatura.setEstado("Nao colocada");
            }
        }

        System.out.println("Vagas atribuidas com sucesso.");
    }

    public void mostrarAdmitidos() {
        System.out.println("\n=== ADMITIDOS ===");
        boolean encontrou = false;

        for (int i = 0; i < numCandidaturas; i++) {
            if (candidaturas[i].getEstado().equals("Admitida")) {
                candidaturas[i].print();
                encontrou = true;
            }
        }

        if (!encontrou) {
            System.out.println("Nao existem candidatos admitidos.");
        }
    }

    public void ordenarCandidaturasPorNota() {
        for (int i = 0; i < numCandidaturas - 1; i++) {
            for (int j = 0; j < numCandidaturas - 1 - i; j++) {
                if (candidaturas[j].getCandidato().getNotaAcesso() <
                    candidaturas[j + 1].getCandidato().getNotaAcesso()) {

                    Candidatura temp = candidaturas[j];
                    candidaturas[j] = candidaturas[j + 1];
                    candidaturas[j + 1] = temp;
                }
            }
        }
    }

    public Candidato[] getCandidatos() {
        return candidatos;
    }

    public Curso[] getCursos() {
        return cursos;
    }

    public Candidatura[] getCandidaturas() {
        return candidaturas;
    }

    public int getNumCandidatos() {
        return numCandidatos;
    }

    public int getNumCursos() {
        return numCursos;
    }

    public int getNumCandidaturas() {
        return numCandidaturas;
    }

    public void limparDados() {
        numCandidatos = 0;
        numCursos = 0;
        numCandidaturas = 0;
    }
}

package app;

public class Candidatura {
    private Candidato candidato;
    private Curso curso;
    private String estado;

    public Candidatura(Candidato candidato, Curso curso) {
        this.candidato = candidato;
        this.curso = curso;
        this.estado = "Pendente";
    }

    public Candidato getCandidato() {
        return candidato;
    }

    public Curso getCurso() {
        return curso;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void print() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return "Candidatura{candidato=" + candidato.getNumeroCandidato()
                + ", curso='" + curso.getCodigo()
                + "', estado='" + estado + "'}";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Candidatura) {
            Candidatura outra = (Candidatura) obj;
            return candidato.equals(outra.candidato)
                    && curso.equals(outra.curso)
                    && estado.equals(outra.estado);
        }
        return false;
    }
}
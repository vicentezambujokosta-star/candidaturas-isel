package app;

public class Candidato extends Pessoa {
    private int numeroCandidato;
    private double notaAcesso;

    public Candidato(String nome, String email, int numeroCandidato, double notaAcesso) {
        super(nome, email);
        this.numeroCandidato = numeroCandidato;
        this.notaAcesso = notaAcesso;
    }

    public int getNumeroCandidato() {
        return numeroCandidato;
    }

    public double getNotaAcesso() {
        return notaAcesso;
    }

    public void setNotaAcesso(double notaAcesso) {
        this.notaAcesso = notaAcesso;
    }

    public void print() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return "Candidato{nome='" + getNome() + "', email='" + getEmail()
                + "', numeroCandidato=" + numeroCandidato
                + ", notaAcesso=" + notaAcesso + "}";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Candidato) {
            Candidato outro = (Candidato) obj;
            return getNome().equals(outro.getNome())
                    && getEmail().equals(outro.getEmail())
                    && numeroCandidato == outro.numeroCandidato
                    && notaAcesso == outro.notaAcesso;
        }
        return false;
    }
}

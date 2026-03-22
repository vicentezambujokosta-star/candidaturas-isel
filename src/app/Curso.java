package app;

public class Curso {
    private String codigo;
    private String nome;
    private int vagas;
    private double notaMinima;

    public Curso(String codigo, String nome, int vagas, double notaMinima) {
        this.codigo = codigo;
        this.nome = nome;
        this.vagas = vagas;
        this.notaMinima = notaMinima;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public int getVagas() {
        return vagas;
    }

    public void setVagas(int vagas) {
        this.vagas = vagas;
    }

    public double getNotaMinima() {
        return notaMinima;
    }

    public void setNotaMinima(double notaMinima) {
        this.notaMinima = notaMinima;
    }

    public void print() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return "Curso{codigo='" + codigo + "', nome='" + nome
                + "', vagas=" + vagas + ", notaMinima=" + notaMinima + "}";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Curso) {
            Curso outro = (Curso) obj;
            return codigo.equals(outro.codigo)
                    && nome.equals(outro.nome)
                    && vagas == outro.vagas
                    && notaMinima == outro.notaMinima;
        }
        return false;
    }
}
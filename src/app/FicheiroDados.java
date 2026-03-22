package app;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FicheiroDados {

    public static void guardarDados(GestorCandidaturas gestor, String nomeFicheiro) {
        try {
            PrintWriter out = new PrintWriter(nomeFicheiro);

            out.println("CURSOS");
            for (int i = 0; i < gestor.getNumCursos(); i++) {
                Curso c = gestor.getCursos()[i];
                out.println(c.getCodigo() + ";" + c.getNome() + ";" + c.getVagas() + ";" + c.getNotaMinima());
            }

            out.println("CANDIDATOS");
            for (int i = 0; i < gestor.getNumCandidatos(); i++) {
                Candidato c = gestor.getCandidatos()[i];
                out.println(c.getNome() + ";" + c.getEmail() + ";" + c.getNumeroCandidato() + ";" + c.getNotaAcesso());
            }

            out.println("CANDIDATURAS");
            for (int i = 0; i < gestor.getNumCandidaturas(); i++) {
                Candidatura c = gestor.getCandidaturas()[i];
                out.println(c.getCandidato().getNumeroCandidato() + ";" + c.getCurso().getCodigo() + ";" + c.getEstado());
            }

            out.close();
            System.out.println("Dados guardados com sucesso.");
        } catch (FileNotFoundException e) {
            System.out.println("Erro ao guardar ficheiro.");
        }
    }

    public static void carregarDados(GestorCandidaturas gestor, String nomeFicheiro) {
        File ficheiro = new File(nomeFicheiro);

        if (!ficheiro.exists()) {
            System.out.println("Ficheiro nao encontrado.");
            return;
        }

        gestor.limparDados();

        try {
            Scanner sc = new Scanner(ficheiro);
            String secao = "";

            while (sc.hasNextLine()) {
                String linha = sc.nextLine();

                if (linha.equals("CURSOS") || linha.equals("CANDIDATOS") || linha.equals("CANDIDATURAS")) {
                    secao = linha;
                } else if (!linha.isEmpty()) {
                    String[] partes = linha.split(";");

                    if (secao.equals("CURSOS")) {
                        Curso curso = new Curso(partes[0], partes[1], Integer.parseInt(partes[2]), Double.parseDouble(partes[3]));
                        gestor.adicionarCurso(curso);
                    } else if (secao.equals("CANDIDATOS")) {
                        Candidato candidato = new Candidato(partes[0], partes[1], Integer.parseInt(partes[2]), Double.parseDouble(partes[3]));
                        gestor.adicionarCandidato(candidato);
                    } else if (secao.equals("CANDIDATURAS")) {
                        gestor.criarCandidatura(Integer.parseInt(partes[0]), partes[1]);

                        Candidatura ultima = gestor.getCandidaturas()[gestor.getNumCandidaturas() - 1];
                        ultima.setEstado(partes[2]);
                    }
                }
            }

            sc.close();
            System.out.println("Dados carregados com sucesso.");
        } catch (Exception e) {
            System.out.println("Erro ao carregar ficheiro.");
        }
    }
}

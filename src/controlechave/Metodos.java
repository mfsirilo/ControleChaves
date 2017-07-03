package controlechave;

import java.util.*;
import java.io.*;

public class Metodos implements Serializable {

    String enderecoChave = "/home/marcos/Documentos/pratica3/Trabalhos/Chaves.bin";
    String enderecoProfessor = "/home/marcos/Documentos/pratica3/Trabalhos/Professor.bin";
    String enderecoReserva = "/home/marcos/Documentos/pratica3/Trabalhos/Reserva.bin";

    ArrayList<Reserva> listareserva = new ArrayList();

    Scanner scan = new Scanner(System.in);
    int codProf, codRes = 0;

    public static void limparTela() {
        System.out.println("Limpando tela");
        for (int i = 0; i != 50; ++i) {
            System.out.println("");
        }
        System.out.println("Tela limpa");
    }

    public void MenuPrincipal() {
        System.out.println("=======================================");
        System.out.println("Menu principal ");
        System.out.println("=======================================");
        System.out.println("Informe uma opção de acordo com o Menu: ");
        System.out.println("Digite 1 para Professores");
        System.out.println("Digite 2 para Chaves");
        System.out.println("Digite 3 para Reservas");
        System.out.println("");
        System.out.println("Digite 0 para sair");
        System.out.println("");
        System.out.println("=======================================");

    }

    public void MenuProfessor() {
        System.out.println("=======================================");
        System.out.println("Menu professor ");
        System.out.println("=======================================");
        System.out.println("Informe uma opção de acordo com o menu ");
        System.out.println("Digite 1 para cadastrar um professor ");
        System.out.println("Digite 2 para excluir um professor ");
        System.out.println("Digite 3 para imprimir todos os professores ");
        System.out.println("");
        System.out.println("Digite 0 para sair");
        System.out.println("");
        System.out.println("=======================================");

    }

    public void CadastroProfessor(ArrayList<Professor> listaprof, String nome, String disciplina) {
        listaprof = ControleChave.leituramentoArquivo(listaprof, enderecoProfessor);

        Professor professor = new Professor(codProf, nome, disciplina);
        if (listaprof.size() > 0) {
            int ultimoprof;
            ultimoprof = listaprof.get(listaprof.size() - 1).getCodProf();
            professor.setCodProf(ultimoprof + 1);
            listaprof.add(professor);
            ControleChave.gravamentoArquivo(listaprof, enderecoProfessor);
            professor = listaprof.get(codProf);
            codProf++;
        } else {
            listaprof.add(professor);
            ControleChave.gravamentoArquivo(listaprof, enderecoProfessor);
            professor = listaprof.get(codProf);
            codProf++;
        }
    }

    public void EcluirProf(ArrayList<Professor> listaprof, int codProf) {
        listaprof = ControleChave.leituramentoArquivo(listaprof, enderecoProfessor);
        listaprof.remove(retornaIndiceProfessor(codProf, listaprof));
    }

    public static int retornaIndiceProfessor(int codigo, ArrayList<Professor> listaprof) {
        int index = 0;
        for (int i = 0; i < listaprof.size(); i++) {
            if (listaprof.get(i).getCodProf() == codigo) {
                index = i;
            }
        }
        return index;
    }

    public int ultimocodigo(ArrayList<Professor> listaprof) {
        listaprof = ControleChave.leituramentoArquivo(listaprof, enderecoProfessor);
        int ultimocodigo = listaprof.get(listaprof.size() - 1).getCodProf();
        return ultimocodigo;
    }

    public void ImprimeProf(ArrayList<Professor> listaprof, int codigo) {
        listaprof = ControleChave.leituramentoArquivo(listaprof, enderecoProfessor);
        if (codigo == 0) {
            for (Professor prof : listaprof) {
                System.out.println("Codigo: " + prof.getCodProf());
                System.out.println("Nome: " + prof.getNome());
                System.out.println("Disciplina: " + prof.getDisciplina());
                System.out.println("");
                System.out.println("----------------------------------");
            }
        } else {
            int indice = retornaIndiceProfessor(codigo, listaprof);
            System.out.println("=======================================");
            System.out.println("O professor cadastrador foi: ");
            System.out.println("=======================================");
            System.out.println("Codigo: " + listaprof.get(indice).getCodProf());
            System.out.println("Nome: " + listaprof.get(indice).getNome());
            System.out.println("Disciplina: " + listaprof.get(indice).getDisciplina());
            System.out.println("");
            System.out.println("----------------------------------");
        }
    }

    public void MenuChave() {
        System.out.println("=======================================");
        System.out.println("Menu chave ");
        System.out.println("=======================================");
        System.out.println("Informe uma opção de acordo com o menu ");
        System.out.println("Digite 1 para cadastrar uma chave ");
        System.out.println("Digite 2 para excluir uma chave ");
        System.out.println("Digite 3 para imprimir todas as chaves ");
        System.out.println("");
        System.out.println("Digite 0 para sair");
        System.out.println("");
        System.out.println("=======================================");
    }

    public void CadastraChave(ArrayList<Chave> listachave, int codChave, int numLab) {
        Chave chave = new Chave(codChave, numLab);
        listachave.add(chave);
        ControleChave.gravamentoArquivo(listachave, enderecoChave);
    }

    public void ExluirChave(ArrayList<Chave> listachave, int codChave) {
        listachave.remove(retornaIndiceChave(codChave, listachave));
        ControleChave.gravamentoArquivo(listachave, enderecoChave);
    }

    public static int retornaIndiceChave(int codigo, ArrayList<Chave> listachave) {
        int index = 0;
        for (int i = 0; i < listachave.size(); i++) {
            if (listachave.get(i).getCodChave() == codigo) {
                index = i;
            }
        }
        return index;
    }

    public void ImprimeChave(ArrayList<Chave> listachave) {
        listachave = ControleChave.leituramentoArquivo(listachave, enderecoChave);
        for (Chave chav : listachave) {
            System.out.println("Laboratoio: " + chav.getNumLab());
            System.out.println("Codigo chave: " + chav.getCodChave());
            System.out.println("-----------------");
            System.out.println("");
        }

    }

    public void MenuReserva() {
        System.out.println("=======================================");
        System.out.println("Menu reservas de chave ");
        System.out.println("=======================================");
        System.out.println("Informe uma opção de acordo com o menu ");
        System.out.println("Digite 1 para cadastrar uma reserva de chave ");
        System.out.println("Digite 2 para excluir uma reserva de chave ");
        System.out.println("Digite 3 para imprimir todas as resevas");
        System.out.println("");
        System.out.println("Digite 0 para sair");
        System.out.println("");
        System.out.println("=======================================");
    }

    public void CadastroReserva(Professor professor, Chave chave, int data, int hora) {
        int codProf, codChave;
        codProf = professor.getCodProf();
        codChave = chave.getCodChave();
        Reserva reserva = new Reserva(codRes, codChave, data, hora);
        String enderecoAr;
        enderecoAr = "/home/marcos/Documentos/pratica3/Trabalhos/" + professor.getNome() + professor.getCodProf() + ".bin";
        listareserva = ControleChave.leituramentoArquivo(listareserva, enderecoAr);
        listareserva.add(reserva);
        listareserva = ControleChave.gravamentoArquivo(listareserva, enderecoAr);
    }

    public void ExcluiReserva(Professor professor) {
        String enderecoAr;
        enderecoAr = "/home/marcos/Documentos/pratica3/Trabalhos/" + professor.getNome() + professor.getCodProf() + ".bin";
        listareserva = ControleChave.leituramentoArquivo(listareserva, enderecoAr);
        for (Reserva res : listareserva) {
            System.out.println("Codigo da reserva " + res.getCodRes());
        }
        System.out.println("=======================================");
        System.out.println("Informe o codigo da reserva a ser excluido");
        int codRes = scan.nextInt();
        scan.nextLine();
        listareserva.remove(retornaIndiceReserva(codRes, listareserva));
        listareserva = ControleChave.gravamentoArquivo(listareserva, enderecoAr);
    }

    public static int retornaIndiceReserva(int codigo, ArrayList<Reserva> listareserva) {
        int index = 0;
        for (int i = 0; i < listareserva.size(); i++) {
            if (listareserva.get(i).getCodChave() == codigo) {
                index = i;
            }
        }
        return index;
    }

    public void HistoricoReserva(ArrayList<Professor> listaprofessor, int codigo) {
        Professor professor = new Professor();
        professor = retornaProfessor(listaprofessor, codigo);
        String enderecoAr;
        enderecoAr = "/home/marcos/Documentos/pratica3/Trabalhos/" + professor.getNome() + professor.getCodProf() + ".bin";
        listareserva.clear();
        listareserva = ControleChave.leituramentoArquivo(listareserva, enderecoAr);
        for (Reserva rev : listareserva) {
            System.out.println("Codigo da reserva: " + rev.getCodRes());
            System.out.println("Dia reservado: " + rev.getData());
            System.out.println("Hora da reserva: " + rev.getHora());
            System.out.println("--------------------------");
        }
    }

    public Professor retornaProfessor(ArrayList<Professor> listaprofessor, int codigo) {
        listaprofessor = ControleChave.leituramentoArquivo(listaprofessor, enderecoChave);
        int indice = retornaIndiceProfessor(codigo, listaprofessor);
        Professor professor = new Professor();
        professor = listaprofessor.get(indice);
        return professor;
    }
}

package controlechave;

import java.util.*;
import java.io.*;

public class ControleChave {

    public static ArrayList gravamentoArquivo(ArrayList arraylist, String enderecoArquivo) {
        try {
            FileOutputStream saida = new FileOutputStream(enderecoArquivo);
            ObjectOutputStream escritorObjetos = new ObjectOutputStream(saida);
            escritorObjetos.writeObject(arraylist);
            saida.close();
            System.out.println("Arquivo Gravado!!");
            return arraylist;
        } catch (Exception e) {
            System.out.println("ERRO!");
            return arraylist;
        }
    }

    public static ArrayList leituramentoArquivo(ArrayList arraylist, String enderecoArquivo) {
        try {
            InputStream entrada = new FileInputStream(enderecoArquivo);
            ObjectInputStream leitorObjetos = new ObjectInputStream(entrada);
            arraylist = (ArrayList) leitorObjetos.readObject();
            entrada.close();
            return arraylist;
        } catch (Exception e) {
            System.out.println("Erro");
            return arraylist;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayList<Professor> listaprof = new ArrayList();
        ArrayList<Chave> listachave = new ArrayList();
        ArrayList<Reserva> listareserva = new ArrayList();

        Metodos metodo = new Metodos();

        String opcao1, opcao2;
        metodo.MenuPrincipal();

        opcao1 = scan.nextLine();
        while (!(opcao1).equals("0")) {
            switch (opcao1) {
                case "1":
                    metodo.MenuProfessor();
                    opcao2 = scan.nextLine();
                    while (!(opcao2).equals("0")) {
                        switch (opcao2) {
                            case "1":
                                metodo.limparTela();
                                System.out.println("=======================================");
                                System.out.println("Cadastro de professor");
                                System.out.println("=======================================");
                                String nome;
                                String disciplina;
                                System.out.println("Informe o nome do professor");
                                nome = scan.nextLine();
                                System.out.println("Infome a disciplina ");
                                disciplina = scan.nextLine();
                                metodo.CadastroProfessor(listaprof, nome, disciplina);
                                metodo.limparTela();
                                listaprof = leituramentoArquivo(listaprof, metodo.enderecoProfessor);
                                metodo.ImprimeProf(listaprof, metodo.ultimocodigo(listaprof));
                                break;

                            case "2":
                                metodo.limparTela();
                                System.out.println("=======================================");
                                System.out.println("Exclusão de professor");
                                System.out.println("=======================================");
                                System.out.println("Informe o codigo do professor ");
                                int codigo = scan.nextInt();
                                scan.nextLine();
                                metodo.EcluirProf(listaprof, codigo);
                                break;
                            case "3":
                                metodo.limparTela();

                                System.out.println("=======================================");
                                System.out.println("Lista de todos os clientes");
                                System.out.println("=======================================");
                                metodo.ImprimeProf(listaprof, 0);
                                System.out.println("----------------------------------");
                                break;
                        }
                        metodo.MenuProfessor();
                        opcao2 = scan.nextLine();
                    }
                case "2":
                    metodo.MenuChave();
                    opcao2 = scan.nextLine();
                    while (!(opcao2).equals("0")) {
                        switch (opcao2) {

                            case "1":
                                metodo.limparTela();
                                System.out.println("=======================================");
                                System.out.println("Cadastro de professor");
                                System.out.println("=======================================");
                                System.out.println("Informe o número do laboratorio");
                                int numLab = scan.nextInt();
                                scan.nextLine();
                                System.out.println("Informe o codigo da chave");
                                int codChave = scan.nextInt();
                                scan.nextLine();
                                listachave = leituramentoArquivo(listachave, metodo.enderecoChave);
                                metodo.CadastraChave(listachave, codChave, numLab);
                                break;

                            case "2":
                                metodo.limparTela();
                                System.out.println("=======================================");
                                System.out.println("Exclusão de chave");
                                System.out.println("=======================================");
                                System.out.println("Informe o codigo da chave a ser excluida");
                                codChave = scan.nextInt();
                                listachave = leituramentoArquivo(listachave, metodo.enderecoChave);
                                metodo.ExluirChave(listachave, codChave);
                                System.out.println("");
                                System.out.println("=======================================");
                                System.out.println("Chave excluida com sucesso");
                                System.out.println("=======================================");
                                
                                break;

                            case "3":
                                metodo.limparTela();
                                System.out.println("=======================================");
                                System.out.println("Lista de chaves cadastradas");
                                System.out.println("=======================================");
                                System.out.println("");
                                metodo.ImprimeChave(listachave);
                                System.out.println("");
                                System.out.println("=======================================");
                                System.out.println("FIM DA LISTA DE VOOS");
                                System.out.println("=======================================");
                                System.out.println("");
                                break;

                        }
                        metodo.MenuChave();
                        opcao2 = scan.nextLine();
                    }

                    metodo.MenuPrincipal();
                    opcao1 = scan.nextLine();
            }

        }

    }

}

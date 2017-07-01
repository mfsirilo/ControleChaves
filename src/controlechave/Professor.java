package controlechave;

import java.util.*;
import java.io.*;

public class Professor implements Serializable {

    private int CodProf;
    private String nome;
    private String disciplina;

    Professor() {
    }

    public Professor(int CodProf, String nome, String disciplina) {
        this.CodProf = CodProf;
        this.nome = nome;
        this.disciplina = disciplina;
    }

    public int getCodProf() {
        return CodProf;
    }

    public void setCodProf(int CodProf) {
        this.CodProf = CodProf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

}

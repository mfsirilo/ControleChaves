package controlechave;

import java.util.*;
import java.io.*;

public class Chave implements Serializable {

    private int codChave;
    private int numLab;

    Chave() {
    }

    public Chave(int codChave, int numLab) {
        this.codChave = codChave;
        this.numLab = numLab;
    }

    public int getCodChave() {
        return codChave;
    }

    public void setCodChave(int codChave) {
        this.codChave = codChave;
    }

    public int getNumLab() {
        return numLab;
    }

    public void setNumLab(int numLab) {
        this.numLab = numLab;
    }

}

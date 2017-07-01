package controlechave;
import java.util.*;
import java.io.*;
public class Reserva implements Serializable{
    private int codRes;
    private int codChave;
    private int data;
    private int hora;

    public Reserva(int codRes, int codChave, int data, int hora) {
        this.codRes = codRes;
        this.codChave = codChave;
        this.data = data;
        this.hora = hora;
    }

    public int getCodRes() {
        return codRes;
    }

    public void setCodRes(int codRes) {
        this.codRes = codRes;
    }

    public int getCodChave() {
        return codChave;
    }

    public void setCodChave(int codChave) {
        this.codChave = codChave;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }
    
    
}

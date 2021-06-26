package POO;

import java.util.ArrayList;

public class Alumno {
    private int Id;
    private int Carnet;
    private String Nombre;
    private String Fecha;
    private char Genero;
    private ArrayList<Curso> cursos;

    public Alumno(){}

    public Alumno(int Id, int Carnet, String Nombre, String Fecha, char Genero) {
        this.Id = Id;
        this.Carnet = Carnet;
        this.Nombre = Nombre;
        this.Fecha = Fecha;
        this.Genero = Genero;
        this.cursos = new ArrayList<Curso>();
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public int getCarnet() {
        return Carnet;
    }

    public void setCarnet(int Carnet) {
        this.Carnet = Carnet;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

    public char getGenero() {
        return Genero;
    }

    public void setGenero(char Genero) {
        this.Genero = Genero;
    }

    public ArrayList<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(ArrayList<Curso> cursos) {
        this.cursos = cursos;
    }
    
    
}

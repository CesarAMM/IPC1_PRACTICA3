package POO;
public class Curso {
    private int Id;
    private int Codigo;
    private String Nombre;
    private Float Nota;

    public Curso() {
    }

    public Curso(int Id, int Codigo, String Nombre, Float Nota) {
        this.Id = Id;
        this.Codigo = Codigo;
        this.Nombre = Nombre;
        this.Nota = Nota;
    }

    public Curso(int Id, int Codigo, String Nombre) {
        this.Id = Id;
        this.Codigo = Codigo;
        this.Nombre = Nombre;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public int getCodigo() {
        return Codigo;
    }

    public void setCodigo(int Codigo) {
        this.Codigo = Codigo;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public Float getNota() {
        return Nota;
    }

    public void setNota(Float Nota) {
        this.Nota = Nota;
    }
}

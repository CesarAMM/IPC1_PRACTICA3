package ipc1_practica3;

import POO.*;
import Views.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class FuncionesGenerales {
    
    private static ArrayList<Curso> cursos = new ArrayList<Curso>();
    private static ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
    
    public static void CargarAlumnos(){
        String datos_a = consola.LeerArchivo();
        String datos[] = datos_a.split("\n");
        for(int i = 0; i< datos.length; i++){
            if(i > 0){
                try {
                    String Id = datos[i].split(",")[0].trim();
                    String Carnet = datos[i].split(",")[1].trim();
                    String Nombre = datos[i].split(",")[2].trim();
                    String Fecha = datos[i].split(",")[3].trim();
                    String Genero = datos[i].split(",")[4].trim();
                    if(consola.ValidaEntrada(Id) && consola.ValidaEntrada(Carnet) &&consola.ValidaEntrada(Nombre) && consola.ValidaEntrada(Genero) && consola.ValidaEntrada(Fecha)){
                        if(consola.ValidarNumero(Id) && consola.ValidarNumero(Carnet)){
                            boolean estado = true;
                            int int_id = Integer.parseInt(Id), int_Carner = Integer.parseInt(Carnet);
                            for (Alumno alumno : alumnos) {
                                if(alumno.getId() == int_id || alumno.getCarnet() == int_Carner){
                                    System.out.println("Este Id :" + Id +" o Este Carnet: " + Carnet + " Ya estan registrados");
                                    estado = false;
                                    break;
                                }
                            }
                            if(estado == true){
                                if(consola.ValidarGenero(Genero)){
                                    alumnos.add(new Alumno(Integer.parseInt(Id), int_Carner, Nombre, Fecha, Genero.charAt(0)));
                                }else{
                                    System.out.println("Ha ingresado un dato incorrecto en genero: "+ Genero);
                                }
                            }else{
                                System.out.println("El Carner o el Id ya existe en el sistema.");
                            }
                        }else{
                            if(!consola.ValidarNumero(Id)){
                                System.out.println("En el id no es un numero:" + Id);
                            }
                            if(!consola.ValidarNumero(Carnet)){
                                System.out.println("Esto no es un carner: "+ Carnet);
                            }
                        }
                    }else{
                        if(!consola.ValidaEntrada(Id)){
                            System.out.println("No hay datos en Id");
                        }
                        if(!consola.ValidaEntrada(Carnet)){
                            System.out.println("No hay datos en Carnet");
                        }
                        if(!consola.ValidaEntrada(Nombre)){
                            System.out.println("No hay datos para Nombre");
                        }
                        if(!consola.ValidaEntrada(Genero)){
                            System.out.println("No hay datos en genero");
                        }
                        if (!consola.ValidaEntrada(Fecha)) {
                            System.out.println("No hay datos en la fecha");
                        }
                    }
                    
                } catch (Exception e) {
                    System.out.println("**<<     Hubo un error no controlado     >>**");
                    System.out.println(e);
                }
            }
        }
    }
    
    public static void CargaCursos(){
        String datos_a = consola.LeerArchivo();
        String datos[] = datos_a.split("\n");
        for(int i = 0; i< datos.length; i++){
            if(i > 0){
                try {
                    String Id = datos[i].split(",")[0].trim();
                    String Codigo = datos[i].split(",")[1].trim();
                    String Nombre = datos[i].split(",")[2].trim();
                    if(consola.ValidaEntrada(Id) && consola.ValidaEntrada(Codigo) && consola.ValidaEntrada(Nombre)){
                        if(consola.ValidarNumero(Id) && consola.ValidarNumero(Codigo)){
                            boolean estado = true;
                            for (Curso curso : cursos) {
                                if(curso.getCodigo() == Integer.parseInt(Codigo) && curso.getId() == Integer.parseInt(Id)){
                                    System.out.println("Ya contamos con un curso con estas credenciales");
                                    estado = false;
                                    break;
                                }
                            }
                            if(estado == true){
                                cursos.add(new Curso(Integer.parseInt(Id), Integer.parseInt(Codigo), Nombre));
                            }
                        }else{
                            if(!consola.ValidarNumero(Id)){
                                System.out.println("Esto no es un id: "+ Id);
                            }
                            if(!consola.ValidarNumero(Codigo)){
                                System.out.println("Esto no es un codigo: " +  Codigo);
                            }
                        }
                    }else{
                        if(!consola.ValidaEntrada(Id)){
                            System.out.println("No hay datos en el Id");
                        }
                        if(!consola.ValidaEntrada(Codigo)){
                            System.out.println("No hay nada en codigo");
                        }
                        if(!consola.ValidaEntrada(Nombre)){
                            System.out.println("No hay datos en el Nombre");
                        }
                    }
                } catch (Exception e) {
                    System.out.println("**<<     Hubo un error no controlado     >>**");
                    System.out.println(e);
                }
            }
        }
    }
    
    public static void CargaAsignacionesCursos(){
        String datos_a = consola.LeerArchivo();
        String datos[] = datos_a.split("\n");
        for(int i = 0; i< datos.length; i++){
            if(i > 0){
                try {
                    String IdAlumno = datos[i].split(",")[0].trim();
                    String IdCurso = datos[i].split(",")[1].trim();
                    String Nota = datos[i].split(",")[2 ].trim();
                    if(consola.ValidaEntrada(IdCurso) && consola.ValidaEntrada(IdAlumno) && consola.ValidaEntrada(Nota)){
                        if(consola.ValidarNumero(IdAlumno) && consola.ValidarNumero(IdCurso) && consola.ValidarDoble(Nota)){
                            Curso auxCurso = null; boolean estado = false;
                            for (Curso curso : cursos) {
                                if(curso.getId() == Integer.parseInt(IdCurso)){
                                    estado = true;
                                    auxCurso = curso;
                                    break;
                                }
                            }
                            if(estado == true && auxCurso != null){
                                int contador = 0;
                                for (Alumno alumno : alumnos) {
                                    if (alumno.getId() == Integer.parseInt(IdAlumno)) {
                                        for (Curso curso : alumno.getCursos()) {
                                            if(curso.getId() == auxCurso.getId()){
                                                estado =false;
                                                break;
                                            }
                                        }
                                        if(estado == true){
                                            alumnos.get(contador).getCursos().add(new Curso(auxCurso.getId(), auxCurso.getCodigo(), auxCurso.getNombre(), auxCurso.getNota()));
                                        }
                                    }
                                    contador++;
                                }
                            }else{
                                System.out.println("No hay cursos con el Id: "+ IdCurso);
                            }
                        }else {
                            if(!consola.ValidarDoble(Nota)){
                                System.out.println("Esto no es valido para una nota: "+ Nota);
                            }
                            if(!consola.ValidarNumero(IdCurso)){
                                System.out.println("Esto no es valido para buscar el Id del curso: "+ IdCurso);
                            }
                            if(!consola.ValidarNumero(IdAlumno)){
                                System.out.println("Esto no es valido para buscar un alumno: "+ IdAlumno);
                            }
                        }
                    }else{
                        if(!consola.ValidaEntrada(IdCurso)){
                            System.out.println("No hay dato del Id del Curoso");
                        }
                        if(!consola.ValidaEntrada(Nota)){
                            System.out.println("No hay datos para la nota");
                        }
                        if(!consola.ValidaEntrada(IdAlumno)){
                            System.out.println("No hay id del estudiante");
                        }
                    }
                } catch (Exception e) {
                    System.out.println("**<<     Hubo un error no controlado     >>**");
                    System.out.println(e);
                }
            }
        }
    }
    
    public static void Verdatos(){
        for (Curso curso : cursos) {
            System.out.println("Id Curso: " + curso.getId() +" Codigo del Curso: "+ curso.getCodigo() + " Nombre del Curso: "+ curso.getNombre());
        }
        for (Alumno alumno : alumnos) {
            System.out.println("Id del Alumno: " + alumno.getId() + " Carnet del Alumno: " + alumno.getCarnet() + " Nombre del Alumnos: "+ alumno.getNombre() +" Fecha de Nacimiento: "+ alumno.getFecha());
            for (Curso curso : alumno.getCursos()) {
                System.out.println("-->Id del Curso: "+ curso.getId() + " Codigo del Curso: "+ curso.getCodigo()+ " Nombre del Curso: "+ curso.getNombre() + " Nota en el Curso: "+ curso.getNota());
            }
        }
    }

    public static void CrearGraficas(String str) {
        if(consola.ValidarNumero(str.trim())){
            Curso auxCurso = null;
            for (Curso curso : cursos) {
                if(curso.getCodigo() == Integer.parseInt(str.trim())){
                    auxCurso = curso;
                    break;
                }
            }
            if(auxCurso != null){
                Main v1 = new Main();
                v1.setVisible(false);
                ConfigGraphics v2 = new ConfigGraphics(auxCurso);
                v2.setVisible(true);
            }else{
                JOptionPane.showMessageDialog(null, "El Curso no Existe.");
            }
        }else{
            JOptionPane.showMessageDialog(null, "No has ingresado un numero");
        }
    }
}

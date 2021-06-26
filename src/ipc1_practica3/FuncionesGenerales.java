package ipc1_practica3;
public class FuncionesGenerales {
    public static void CargarAlumnos(){
        String datos_a = consola.LeerArchivo();
        String datos[] = datos_a.split("\n");
        for(int i = 0; i< datos.length; i++){
            if(i > 0){
                try {
                    int Id = Integer.parseInt(datos[i].split(",")[0].trim());
                    int Carnet = Integer.parseInt(datos[i].split(",")[1].trim());
                    String Nombre = datos[i].split(",")[2].trim();
                    String Fecha = datos[i].split(",")[3].trim();
                    char Genero = datos[i].split(",")[4].trim().charAt(0);
                    int dia = Integer.parseInt(Fecha.split("/")[0].trim());
                    int mes = Integer.parseInt(Fecha.split("/")[1].trim());
                    int ayo = Integer.parseInt(Fecha.split("/")[2].trim());
                    
                } catch (Exception e) {
                }
            }
        }
    }
}

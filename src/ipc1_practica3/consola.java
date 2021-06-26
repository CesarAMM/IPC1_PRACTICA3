package ipc1_practica3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class consola {
    
    public static boolean ValidarNumero(String str){
        try {
            int i = Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    public static boolean ValidaEntrada(String str){
        int i = str.length();
        if(i != 0){
            return true;
        }else{
            return false;
        }
    }
    
    public static String LeerArchivo(){
        JFileChooser fc = new JFileChooser();
        FileNameExtensionFilter extencion = new FileNameExtensionFilter("*.csv", "csv");
        fc.setFileFilter(extencion);
        int seleccion = fc.showOpenDialog(null);
        if(seleccion == JFileChooser.APPROVE_OPTION){
            File archivo = null;
            FileReader fr = null;
            BufferedReader br = null;
        try {
        // Apertura del fichero y creacion de BufferedReader para poder
        // hacer una lectura comoda (disponer del metodo readLine()).
            archivo = fc.getSelectedFile();
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
        // Lectura del fichero
            String content = "";
            String linea;
            while ((linea = br.readLine()) != null) {
                content += linea + "\n";
            }
        return content;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        // En el finally cerramos el fichero, para asegurarnos
        // que se cierra tanto si todo va bien como si salta
        // una excepcion.
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        }
        return "";
    }
}

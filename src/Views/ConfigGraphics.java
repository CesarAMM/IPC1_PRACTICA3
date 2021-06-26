package Views;

import javax.swing.JFrame;
import javax.swing.JPanel;
import Componentes.*;
import POO.*;


public class ConfigGraphics extends JFrame{
    private JPanel JPmain;
    private Curso curso;
    public ConfigGraphics(Curso curso){
        this.curso = curso;
        this.setTitle("Graficas del Curso: "+ curso.getNombre());
        this.setSize(500, 600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        Init_Componentes();
    }
    
    private void Init_Componentes(){
        JPmain = new JPanel();
        JPmain.setLayout(null);
        this.getContentPane().add(JPmain);
        Init_Buttons();
        Init_Labe();
    }

    private void Init_Buttons() {
        Boton graphics_for_sex = new Boton("Grafica por Sexo", 30, 50, 250, 20);
        Boton graphics_for_edad = new Boton("Grafica por Edad", 30, 75, 250, 20);
        Boton graphics_for_notas = new Boton("Grafica Por Ordenamiento de Notas", 30, 100, 250, 20);
        JPmain.add(graphics_for_edad);
        JPmain.add(graphics_for_notas);
        JPmain.add(graphics_for_sex);
    }

    private void Init_Labe() {
        Label title = new Label("Graficas: " + curso.getNombre(), 150, 30, 200, 20);
        JPmain.add(title);
    }
}

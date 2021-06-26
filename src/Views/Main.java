package Views;

import Componentes.Boton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main extends JFrame{
    JPanel JPmain;
    public Main(){
        this.setTitle("Graphics");
        this.setSize(500, 600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        Init_Comonents();
    }
    private void Init_Comonents(){
        JPmain = new JPanel();
        JPmain.setLayout(null);
        this.getContentPane().add(JPmain);
        Init_Buttons();
    }
    
    private void Init_Buttons(){
        Boton Alumno = new Boton("Carga de Alumnos", 20, 70, 150, 20);
        Boton Curos = new Boton("Carga de Curso", 20,95,150,20);
        Boton Notas = new Boton("Carga de Notas", 20,120, 150, 20);
        JPmain.add(Curos);
        JPmain.add(Alumno);
        JPmain.add(Notas);
        
    }
}

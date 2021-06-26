package Views;

import Componentes.*;
import ipc1_practica3.FuncionesGenerales;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
        Init_Labe();
    }
    
    private void Init_Labe(){
        Label title = new Label("Grafias", 200, 20, 100, 20);
        JPmain.add(title);
        Label label1 = new Label("Ingrese el Codigo del Curos", 20, 175, 160, 20);
        JPmain.add(label1);        
    }
    
    private void Init_Buttons(){
        TextBox texto = new TextBox(185, 175, 100, 20);
        JPmain.add(texto);
        Boton Alumno = new Boton("Carga de Alumnos", 20, 70, 150, 20);
        Boton Curos = new Boton("Carga de Curso", 20,95,150,20);
        Boton Notas = new Boton("Carga de Notas", 20,120, 150, 20);
        Boton Ver = new Boton("Ver Datos", 20,145,150, 20);
        Boton Graficar = new Boton("Hacer graficos", 295,175,150,20);
        Alumno.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                FuncionesGenerales.CargarAlumnos();
            }
        });
        Curos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                FuncionesGenerales.CargaCursos();
            }
        });
        Notas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                FuncionesGenerales.CargaAsignacionesCursos();
            }
        });
        Ver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                FuncionesGenerales.Verdatos();
            }
        });
        Graficar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                FuncionesGenerales.CrearGraficas(texto.getText());
            }
        });
        JPmain.add(Graficar);
        JPmain.add(Ver);
        JPmain.add(Curos);
        JPmain.add(Alumno);
        JPmain.add(Notas);
        
    }
}

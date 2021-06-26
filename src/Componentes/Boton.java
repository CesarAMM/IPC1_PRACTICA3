package Componentes;

import javax.swing.JButton;

public class Boton extends JButton{
    public Boton (String texto, int x, int y, int X, int Y){
        this.setText(texto);
        this.setBounds(x, y, X, Y);
    }
}

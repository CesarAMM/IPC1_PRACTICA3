package Componentes;

import javax.swing.JLabel;

public class Label extends JLabel{
    public Label(String texto, int x, int y, int X, int Y){
        this.setText(texto);
        this.setBounds(x, y, X, Y);
    }
}

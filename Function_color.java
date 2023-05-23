import java.awt.Color;
import java.awt.color.*;
public class Function_color {
    GUI gui;
    String color;
    public Function_color(GUI gui){
        this.gui=gui;

    }
    public void changecolor(String color){
        switch (color) {
            case "White":
                gui.window.getContentPane().setBackground(Color.white);
                gui.textArea.setBackground(Color.white);
                gui.textArea.setForeground(Color.BLACK);
                break;
            case "Blue":
                gui.window.getContentPane().setBackground(Color.BLACK);
                gui.textArea.setBackground(Color.BLACK);
                gui.textArea.setForeground(Color.BLACK); 
                break;
            case "Yellow":
                gui.window.getContentPane().setBackground(Color.YELLOW); 
                gui.textArea.setBackground(Color.YELLOW);
                gui.textArea.setForeground(Color.BLACK);   
                break;
        }
    }
    
}

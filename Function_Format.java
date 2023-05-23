import java.awt.Font;
import java.awt.font.*;
public class Function_Format {
    GUI gui;
    Font arial,comicSansMS,timesNewRoman;
    String selectedFont;
    public Function_Format(GUI gui){
        this.gui=gui;

    }
    public void wordWrap(){
        if(gui.wordWrapon==false){
            gui.wordWrapon=true;
            gui.textArea.setLineWrap(true);
            gui.textArea.setWrapStyleWord(true);
            gui.iwrap.setText("Word wrap On");
        }
        else if(gui.wordWrapon==true){
            gui.wordWrapon=false;
            gui.textArea.setLineWrap(false);
            gui.textArea.setWrapStyleWord(false);
            gui.iwrap.setText("Word wrap off");

        }
    }
    public void createFont(int fontSize){
         arial=new Font("Arial",Font.PLAIN,fontSize);
         comicSansMS=new Font("comic Sans MS",Font.PLAIN,fontSize);
         timesNewRoman=new Font("Times New Roman",Font.PLAIN,fontSize);

    }
    public void setFont(String font){
        selectedFont=font;
        switch(selectedFont){
            case "Arial":
                gui.textArea.setFont(arial);break;
            case "comic sans MS" :
                gui.textArea.setFont(comicSansMS);
                break;
            case "Times New Roman":
                gui.textArea.setFont(timesNewRoman);break;     
        }

    }
    
}

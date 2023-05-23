import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JMenu;
import java.awt.event.*;
import java.awt.event.ActionListener;
public class GUI implements ActionListener{
    JFrame window;
    JScrollPane scrollPane;
    boolean wordWrapon=false;
    JMenu menuFile,menuEdit,menuFormat,menucolor;
    JMenuItem iNew,iOpen,iSave, iSaveAs,iExit;
    JTextArea textArea;
    Function_File file=new Function_File(this);
    JMenuItem iwrap,iFontArial,iFontcsms,iFontTNR,iFontSize8,iFontSize12,iFontSize16,iFontSize20;
    JMenu menuFont,menuFontSize;
    Function_Format format=new Function_Format(this);
    JMenuItem icolor1,icolor2,icoolor3;
    Function_color color=new Function_color(this);
    public static void main(String[] args){
        new GUI();
    }
    public GUI(){
        createWindw();
        createTextArea();
        createMenuBar();
        createFileMenu();
        createFormatMenu();
        createcolorMenu();
        format.selectedFont="Arial";
        format.createFont(16);
        format.wordWrap();
        color.changecolor("White");
        window.setVisible(true);
        
        
    }
    public void createWindw(){
        window= new JFrame("Notepad");
        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void createTextArea(){
        this.textArea=new JTextArea();
        JScrollPane scrollpane=new JScrollPane(textArea,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        window.add(scrollpane);

    }
    public void createMenuBar(){
        JMenuBar menuBar =new JMenuBar();
        window.setJMenuBar(menuBar);

        menuFile=new JMenu("File");
        menuBar.add(menuFile);
        
        menuFormat=new JMenu("Format");
        menuBar.add(menuFormat);

        menucolor=new JMenu("Color");
        menuBar.add(menucolor);


    }
    public void createFileMenu(){
        iNew=new JMenuItem("New");
        iNew.addActionListener(this);
        iNew.setActionCommand("New");
        menuFile.add(iNew);
        iOpen=new JMenuItem("Open");
        iOpen.addActionListener(this);
        iOpen.setActionCommand("Open");
        menuFile.add(iOpen);
        iSave=new JMenuItem("Save");
        iSave.addActionListener(this);
        iSave.setActionCommand("Save");
        menuFile.add(iSave);
        iSaveAs=new JMenuItem("Save As");
        iSaveAs.addActionListener(this);
        iSaveAs.setActionCommand("Save As");
        menuFile.add(iSaveAs);
        iExit=new JMenuItem("Exit");
        iExit.addActionListener(this);
        iExit.setActionCommand("Exit");
        menuFile.add(iExit);
        
    }
    public void createFormatMenu(){
        iwrap=new JMenuItem("word wrap:off");
        iwrap.addActionListener(this);
        iwrap.setActionCommand("word wrap");
        menuFormat.add(iwrap);

        menuFont=new JMenu("Font Style");
        menuFormat.add(menuFont);

        iFontArial=new JMenuItem("Arial");
        iFontArial.addActionListener(this);
        iFontArial.setActionCommand("Arial");
        menuFont.add(iFontArial);

        iFontcsms=new JMenuItem("Comic Sans MS");
        iFontcsms.addActionListener(this);
        iFontcsms.setActionCommand("comic Sans MS");
        menuFont.add(iFontcsms);
        
        iFontTNR=new JMenuItem("Times New Roman");
        iFontTNR.addActionListener(this);
        iFontTNR.setActionCommand("Times New Roman");
        menuFont.add(iFontTNR);
        
        menuFontSize=new JMenu("Font Size");
        menuFormat.add(menuFontSize);

        iFontSize8 =new JMenuItem("8");
        iFontSize8.addActionListener(this);
        iFontSize8.setActionCommand("size8");
        menuFontSize.add(iFontSize8);

        iFontSize12=new JMenuItem("12");
        iFontSize8.addActionListener(this);
        iFontSize12.setActionCommand("size12");
        menuFontSize.add(iFontSize12);

        iFontSize16=new JMenuItem("16");
        iFontSize16.addActionListener(this);
        iFontSize16.setActionCommand("size16");
        menuFontSize.add(iFontSize16);

        
        iFontSize20=new JMenuItem("20");
        iFontSize20.addActionListener(this);
        iFontSize16.setActionCommand("size20");
        menuFontSize.add(iFontSize20);



       
    }
    public void createcolorMenu(){
        icolor1=new JMenuItem("White");
        icolor1.addActionListener(this);
        icolor1.setActionCommand("White");
        menucolor.add(icolor1);
        icolor2=new JMenuItem("Black");
        icolor2.addActionListener(this);
        icolor2.setActionCommand("Black");
        menucolor.add(icolor2);

        icoolor3=new JMenuItem("Yellow");
        icoolor3.addActionListener(this);
        icoolor3.setActionCommand("Yellow");
        menucolor.add(icoolor3);



    }
    public void actionPerformed(ActionEvent e){
          String command=e.getActionCommand();
          switch(command){
            case "New":file.newFile();break;
            case "Open":file.openFile();break;
            case "Save":file.saveFile();break;
            case "Save As":file.saveFileAs();break;
            case "Exit":file.ExitAs();break;
            case "word wrap":format.wordWrap();break;
            case "Arial":format.setFont(command);break;
            case "comic Sans MS":format.setFont(command);break;
            case "Times New Roman":format.setFont(command);break;
            case "size8":format.createFont(8);break;
            case "size12":format.createFont(12);break;
            case "size16":format.createFont(16);break;
            case "size20":format.createFont(20);break;
            case "White":color.changecolor(command);break;
            case "Blue":color.changecolor(command);break;
            case "Yellow":color.changecolor(command);break;
          }
    }


    
}
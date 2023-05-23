import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Function_File {
    GUI gui;
    String fileName;
    String filePath;
    
    public Function_File(GUI gui) {
        this.gui = gui;
    }
    
    public void newFile() {
        gui.textArea.setText("");
        gui.window.setTitle("New");
        fileName = null;
        filePath = null;
    }
    
    public void openFile() {
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Text Files", "txt");
        fileChooser.setFileFilter(filter);
        
        int result = fileChooser.showOpenDialog(gui.window);
        if (result == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            fileName = file.getName();
            filePath = file.getAbsolutePath();
            gui.window.setTitle(fileName);
            
            try {
                BufferedReader reader = new BufferedReader(new FileReader(file));
                gui.textArea.read(reader, null);
                reader.close();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(gui.window, "Error opening file: " + ex.getMessage());
            }
        }
    }
    
    public void saveFile() {
        if (fileName == null) {
            saveFileAs();
        } else {
            File file = new File(filePath);
            try {
                FileWriter writer = new FileWriter(file);
                gui.textArea.write(writer);
                writer.close();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(gui.window, "Error saving file: " + ex.getMessage());
            }
        }
    }
    
    public void saveFileAs() {
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Text Files", "txt");
        fileChooser.setFileFilter(filter);
        
        int result = fileChooser.showSaveDialog(gui.window);
        if (result == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            fileName = file.getName();
            filePath = file.getAbsolutePath();
            gui.window.setTitle(fileName);
            
            try {
                FileWriter writer = new FileWriter(file);
                gui.textArea.write(writer);
                writer.close();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(gui.window, "Error saving file: " + ex.getMessage());
            }
        }
    }
    public void ExitAs(){
        System.exit(0);
    }
}

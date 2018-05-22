/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package btnMenu;

import Main.Principal;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author kilroy
 */
public class Guardar {
    JFileChooser j= new JFileChooser();
    Principal mn = new Principal();
    public Guardar(){
        try
        {
            j = new JFileChooser();
           
            
            j.setFileSelectionMode( JFileChooser.FILES_ONLY );
            FileNameExtensionFilter filtroTxt=new FileNameExtensionFilter("Documento de Texto","txt");
            j.setFileFilter(filtroTxt);
            j.setFileHidingEnabled(false);
            int fin = this.getTitle().lastIndexOf('.');
            if(fin == -1)fin = this.getTitle().length();
            j.setSelectedFile(new File(this.getTitle().substring(0,fin)));
          
            int select = j.showSaveDialog(this);
            File guarda = j.getSelectedFile();
            
            if(select == JFileChooser.APPROVE_OPTION)
            {
                if(guarda !=null)
                {
                    FileWriter  save=new FileWriter(guarda+".txt");
                    save.write(mn.Texto_cod.getText());
                    save.close();
                    JOptionPane.showMessageDialog(null,"Se ha guardado el archivo","Información",JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
        catch(IOException ex)
        {
            JOptionPane.showMessageDialog(null,"Su archivo no se ha guardado","Advertencia",JOptionPane.WARNING_MESSAGE);
        } 
    }
}

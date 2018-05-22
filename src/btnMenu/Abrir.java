/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package btnMenu;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.StreamTokenizer;
import java.util.StringTokenizer;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import Main.Principal;

/**
 *
 * @author kilroy
 */
public class Abrir {
    //declaracion de variables
    private String lectura="";
    JFileChooser j= new JFileChooser();
    FileNameExtensionFilter filtro= new FileNameExtensionFilter("Archivos Word y txt","docx","txt");
    String path;
    File f;
    
    
    public Abrir(){
        j.getSelectedFile();
        j.setFileFilter(filtro);//Añado el filtro
        j.showOpenDialog(j);

        int contPalabra=0;//Creo un contador para las palabras
        try{
            //Aqui se manda la ruta del archivo
            path= j.getSelectedFile().getAbsolutePath();//Obtiene la Ruta completa
            String name=j.getSelectedFile().getName();//Obtiene el nombre del archivo
            
            f = new File(path);

            try{

                FileReader fr = new FileReader(f);
                BufferedReader br = new BufferedReader(fr);
                String aux;
                //Aqui cuenta cuantas palabras hay
                StreamTokenizer st=new StreamTokenizer(new FileReader(f));
                    while(st.nextToken()!=StreamTokenizer.TT_EOF){
                        //ttype contiene el tipo de token que el metodo nextoken() acaba de leer convierte a int
                        //TT_WORD indica que el token es una cadena
                        if(st.ttype==StreamTokenizer.TT_WORD){
                            contPalabra++;

                        }
                    }

                
                //Aqui empieza a leer el archivo linea por linea hasta que en el texto ya no haya nada
                while((aux = br.readLine())!=null)
                lectura = lectura+aux+"\n";//se acumula en un string

            }catch(IOException e){
                 System.out.println("error "+e);
            }
        }catch(NullPointerException e){

            javax.swing.JOptionPane.showMessageDialog(j, "Has seleccionado cerrar programa, saliendo...");

            System.exit(0);

        }
    }
    public void setLectura(String lectura) {
        this.lectura = lectura;
    }
    
    public String getLectura() {
        return lectura;
    }   
}

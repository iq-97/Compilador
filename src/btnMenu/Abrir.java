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
    JFileChooser j= new JFileChooser();
    FileNameExtensionFilter filtro= new FileNameExtensionFilter("Archivos Word y txt","docx","txt");
    String path;
    File f;
    Principal mn = new Principal();
    public void abrir(){
        j.setCurrentDirectory(new File("src\\lexicosintactico"));
        j.getSelectedFile();
        j.setFileFilter(filtro);//Añado el filtro
        j.showOpenDialog(j);

        int contPalabra=0;//Creo un contador para las palabras
        try{
            //Aqui se manda la ruta del archivo
            path= j.getSelectedFile().getAbsolutePath();//Obtiene la Ruta
            String name=j.getSelectedFile().getName();//Obtiene el nombre
            String lectura="";
            f = new File(path);

            try{

                FileReader fr = new FileReader(f);
                BufferedReader br = new BufferedReader(fr);
                String aux;
                //Aqui cuento cuantas palabras hay
                StreamTokenizer st=new StreamTokenizer(new FileReader(f));
                while(st.nextToken()!=StreamTokenizer.TT_EOF){
                    if(st.ttype==StreamTokenizer.TT_WORD){
                        contPalabra++;

                    }
                    //lblPalabras.setText("Total de Palabras:"+contPalabra);
                    //txtNombre.setText(name);
                    //txtRuta.setText(path);

                }

                //Aqui empieza a leer el archivo linea por linea hasta que en el texto ya no haya nada

                while((aux = br.readLine())!=null)

                lectura = lectura+aux+"\n";//Voy acumulando todo en un string

            }catch(IOException e){}

            mn.Texto_cod.setText(lectura);//Mando lo que resulto de la lectura
            int contador=0;
            StringTokenizer st = new StringTokenizer(txtATexto1.getText(),"\n",true);
            String Text = "",token;
            contador = 1;

            while (st.hasMoreTokens()){
                token= st.nextToken();
                if("\n".equals(token)) contador++;
            }

            for(int i = 1; i <= contador; i++){
                Text += i+"\n";
            }
            Lineas.setText(Text);

            //contarCaracteres(lectura);//Mando llamar el metodo de contar caracteres
            //mayusculasyminusculas(lectura);
        }catch(NullPointerException e){

            javax.swing.JOptionPane.showMessageDialog(j, "Has seleccionado cerrar programa, saliendo...");

            System.exit(0);

        }
    }
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.util.Arrays;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;

/**
 *
 * @author kilroy
 */
public class Analizador {
    static String [] tb_validas = {"alumnos","profesores","calificaciones"};
    
    
    public static void Op_Insert(String cadena){
        StringTokenizer token = new StringTokenizer(cadena.toLowerCase()," ");
        String finCadena = new String();
        String tokenActual;
        tokenActual = token.nextToken();
        
        while(token.hasMoreTokens()){
            tokenActual = token.nextToken();
            if(tokenActual.contains("into")){
                tokenActual = token.nextToken();
                if(Arrays.asList(tb_validas).contains(tokenActual)){
                    JOptionPane.showMessageDialog(null, "exito");
                    return;
                }
                else{
                  if(!Arrays.asList(tb_validas).contains(tokenActual)){
                    JOptionPane.showMessageDialog(null, "la tabla '"+tokenActual+"' NO EXISTE o no es una tabla");
                    return;
                    
                    }
                  /*if(tokenActual.contains("into")){
                    JOptionPane.showMessageDialog(null, "No se ingreso nada");
                    return;
                    }*/
                }
            }
            else{
                
                if(!tokenActual.contains("into")){
                    JOptionPane.showMessageDialog(null, "Se esperaba la palabra reservadaa INTO, no '"+tokenActual+"'");
                    return;                   
                }
                /*if(tokenActual.contains("insert")){
                    JOptionPane.showMessageDialog(null, "No se ingreso nada");
                    return;
                }*/
                
            }
        
        }
    }
    
}

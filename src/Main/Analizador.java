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
        StringTokenizer token = new StringTokenizer(cadena.toLowerCase());
        String finCadena = new String();
        String flag = "";
        String flag2 = "";
        String flag3 = "";
        
        String tokenActual;
        token.nextToken();
        tokenActual = token.nextToken();
        
        //evaluar si la palabra into va despues de insert
        if(! tokenActual.equals("into")){
            JOptionPane.showMessageDialog(null, "Se esperaba la palabra reservadaa INTO, no '"+tokenActual+"'");
            return;
            
        }else{ 
            flag = "p1";
            //evaluar ahora el nombre de la tabla
            tokenActual = token.nextToken();
            if(! Arrays.asList(tb_validas).contains(tokenActual)){
                JOptionPane.showMessageDialog(null, "la tabla '"+tokenActual+"' NO EXISTE o no es una tabla");
                return;
            }else{ flag2 = "p2";
              tokenActual = token.nextToken();
                if(! tokenActual.equals("values")){
                    JOptionPane.showMessageDialog(null,"Se esperaba la palabra reservada VALUES, no '"+tokenActual+"'");
                    return;
                }//else{flag3 = "p3";}  
            }
        
        }
        
        
        
        
        /*if(flag.equals("p1") && flag2.equals("p2") && flag3.equals("p3")){
            JOptionPane.showMessageDialog(null, "Expresion correcta");
        }*/
        
        
    }
    
}

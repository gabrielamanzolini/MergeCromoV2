/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mergearvorebinaria;


import java.io.IOException;
import control.CtrlMergeCromo;

/**
 *
 * @author gabriela
 */
public class MergeCromo2 {
	
    public static void main(String[] args) throws IOException {
     
    	String[] file = new String[3]; 
    	file[0]	= "/home/gabriela/Desktop/ListaSNP/Cromo/cromo22.csv";
    	file[1] = "/home/gabriela/Desktop/ListaSNP/Cromo/bae2.cromo22.csv";
    	file[2] = "/home/gabriela/Desktop/ListaSNP/Cromo/bae3.cromo22.csv";
    	
    	CtrlMergeCromo mcCntrl = new CtrlMergeCromo(file);
    }  

}              

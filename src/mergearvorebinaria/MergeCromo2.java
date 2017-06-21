/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mergearvorebinaria;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.swing.ListModel;

import control.CtrlMergeCromo;
import javafx.animation.Interpolator;

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
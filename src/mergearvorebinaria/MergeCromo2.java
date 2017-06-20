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

import javafx.animation.Interpolator;
import model.Snp;

import model.Snp;

/**
 *
 * @author gabriela
 */
public class MergeCromo2 {

    public static void main(String[] args) throws IOException {
     
    	String file1 = "/home/gabriela/Desktop/ListaSNP/Cromo/cromo22.csv";
    	String file2 = "/home/gabriela/Desktop/ListaSNP/Cromo/bae2.cromo22.csv";
    	String file3 = "/home/gabriela/Desktop/ListaSNP/Cromo/bae3.cromo22.csv";
    	
    	String mergeFile = "/home/gabriela/Desktop/ListaSNP/Cromo/mergedCromo22.csv";
    	
    	File[] arquivos = new File[3];
    	arquivos[0] = new File (file1);
    	arquivos[1] = new File (file2);
    	arquivos[2] = new File (file3);
  	
    	File fileMerged = new File (mergeFile);
    	juntarFiles (arquivos, fileMerged);
    	
    
    }  
	
<<<<<<< HEAD
    /**
     * 
     * @param base - aqui recebe como parâmetro a base de dados que estará na memória
     * @param snp - aqui recebe como parâmetro um snp - a fim de comparar com a base
     * @return
     */
	public LinkedList<Snp> comparaFile(LinkedList<Snp> base, Snp snp) {
		//Coloquei um iterator para percorrer a lista de snps
		Iterator<Snp> it = base.iterator();
		
		while(it.hasNext()){
			Snp snpBase = it.next(); //precisamos testar essa linha pra ver se está certa.
			if (snpBase.getNome() == snp.getNome()){
				snpBase.setOnda(snpBase.getOnda()+ snp.getOnda());
			}
=======
	public ArrayList<Snp> comparaFile(String nome, int onda) {
		Snp snp = new Snp();
		if(nome==snp.getNome()){
			snp.getOnda();
			
			
>>>>>>> refs/remotes/origin/master
		}
		
		return null;
	}

	private static void juntarFiles(File[] arquivos, File fileMerged) {
		// TODO Auto-generated method stub
		FileWriter fstream = null;
		BufferedWriter out = null;
		
		
		try{
			fstream = new FileWriter(fileMerged, true);
			out = new BufferedWriter(new FileWriter("/home/gabriela/Desktop/ListaSNP/Cromo/mergedCromo22.csv"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		for (File f: arquivos) {
			System.out.println("merging: "+ f.getName());
			FileInputStream fis;
			try{
				fis= new FileInputStream(f);
				BufferedReader in = new BufferedReader(new InputStreamReader(fis));
				
				String aLine = null;
				
				//gravar o arquivo linha por linha
				while ((aLine = in.readLine()) != null){
					out.write(aLine);
					out.newLine();
				}
				
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try {
			out.close();
		} catch (IOException e){
			e.printStackTrace();
		}
		
	}
            
}
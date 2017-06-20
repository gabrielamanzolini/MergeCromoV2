package dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import model.Snp;

public class DaoSnp {

	public LinkedList<Snp> readFile(String fileName, int onda){
		try {
			File file = new File(fileName);
			BufferedReader br = new BufferedReader(new FileReader(file));
			LinkedList<Snp> list = new LinkedList<>();
			
			while(br.ready()){
				String line = br.readLine();
				String[] sLine = line.split("/t");
				//atribuindo valores para o obj snp
				Snp snp = new Snp();
				snp.setOnda(onda);
				snp.setNome(sLine[1]);
				snp.setPosicao(sLine[2]);
				snp.setMarcador1(sLine[3]);
				snp.setMarcador2(sLine[4]);
				
				int listSize = sLine.length;
				ArrayList<Double> prob = new ArrayList<>();
				for (int i=5 ; i < listSize ; i++){
					prob.add(Double.parseDouble(sLine[i]));
				}
				snp.setProbab(prob);
				
				//adicionando o obj snp na lista
				list.add(snp);
			}
			br.close();
			return list;
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}		
	}
	
	public void writeFile(List<Snp> lista, String fileWriterName){
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(fileWriterName));
			
			Iterator<Snp> it = lista.listIterator();
			
			while(it.hasNext()){
				Snp snp = it.next();
				String line = new String();
				line = snp.getNome() + "/t" + snp.getOnda() "/t" + snp.getPosicao() + "/t" + snp.getMarcador1() + "/t" + snp.getMarcador2();
				
				//terminar de colocar as probalilidades para escrever no arquivo
				
				bw.write(line);
			}
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}

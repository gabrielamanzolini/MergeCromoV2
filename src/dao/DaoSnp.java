package dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import model.Snp;

public class DaoSnp {

	public ArrayList<Snp> readFile(String fileName, int onda){
		try {
			File file = new File(fileName);
			BufferedReader br = new BufferedReader(new FileReader(file));
			ArrayList<Snp> list = new ArrayList<>();
			
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
			
			return list;
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}		
	}
	
	
	
}

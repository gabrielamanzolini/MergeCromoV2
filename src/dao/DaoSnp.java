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

	/**
	 * Método que lê um arquivo de probabilidades
	 * @param fileName
	 * @param onda
	 * @return LinkedList com os dados de um arquivo
	 */
	public LinkedList<Snp> readFile(String fileName, int onda){
		try {
			File file = new File(fileName);
			BufferedReader br = new BufferedReader(new FileReader(file));
			LinkedList<Snp> list = new LinkedList<>();
			
			while(br.ready()){
				String line = br.readLine();
				
				String[] sLine = new String[6];
				sLine = line.split(" ");
				//atribuindo valores para o obj snp
				Snp snp = new Snp();
				snp.setOnda(onda);
				snp.setNome(sLine[1]);
				System.out.println(snp.getNome());
				snp.setPosicao(sLine[2]);
				System.out.println(snp.getPosicao());
				snp.setMarcador1(sLine[3]);
				System.out.println(snp.getMarcador1());
				snp.setMarcador2(sLine[4]);
				System.out.println(snp.getMarcador2());
				
				String[] tabLine = new String[5000];
				tabLine= line.split("\t");
				int listSize = tabLine.length;
				ArrayList<Double> prob = new ArrayList<>();
				for (int i=1 ; i < listSize ; i++){
					prob.add(Double.parseDouble(tabLine[i]));
					System.out.println(prob.get(i-1));
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
	/**
	 * Método que escreve no arquivo.
	 * @param lista
	 * @param fileWriterName
	 */
	public void writeFile(List<Snp> lista, String fileWriterName){
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(fileWriterName));
			
			Iterator<Snp> it = lista.listIterator();
			
			while(it.hasNext()){
				Snp snp = it.next();
				String line = new String();
				line = snp.getNome() + "/t" + snp.getOnda() + "/t" + snp.getPosicao() + "/t" + snp.getMarcador1() + "/t" + snp.getMarcador2();
				
				//iterator que roda as listas de probabilidades e escreve na linha
				Iterator<Double> itProb = snp.getProbab().iterator();
				while (itProb.hasNext()){
					line += "/t" + itProb.next().toString();
				}
				bw.write(line);
			}
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}

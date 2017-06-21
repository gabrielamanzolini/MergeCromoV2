package control;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import dao.DaoSnp;
import model.Snp;

public class CtrlMergeCromo {
	
	/**
	 * Lista principal onde trabalharemos a Base de dados
	 */
	LinkedList<Snp> base = new LinkedList<>();

	//lista que coloca 999.99 nas probab. das ondas 1 e 2
	int NA1 = 0;
	int NA2 = 0;
	
	
	public CtrlMergeCromo(String[] file) {
		
		DaoSnp dao = new DaoSnp();
		base = dao.readFile(file[0], 1);
		NA1 = base.get(0).getProbab().size();
		comparaBase(file[1], 2, dao);
		comparaBase(file[2], 3, dao);
		String fileResult = "/home/gabriela/Desktop/ListaSNP/Cromo/mergedCromo22.csv";
		dao.writeFile(base, fileResult);
	}	
	
    /**
     * Método que compara se um SNP já está na base
     * @param snp - aqui recebe como parâmetro um snp - a fim de comparar com a base
     * @return boolean se o snp existia na base ou não
     */
	private boolean existeNaBase(Snp snp) {
		//Coloquei um iterator para percorrer a lista de snps
		Iterator<Snp> it = base.iterator();
		boolean existenteNaBase = false;
		while(it.hasNext()){
			Snp snpBase = it.next();
			if (snpBase.getNome() == snp.getNome()){
				snpBase.setOnda(snpBase.getOnda()+ snp.getOnda());
				Iterator<String> itCompara = snp.getProbab().iterator();
				while (itCompara.hasNext()){
					String element = itCompara.next();
					snpBase.getProbab().add(element);
				}
				existenteNaBase = true;
			}
		}
		return existenteNaBase;
	}

	private void comparaBase(String file, int onda, DaoSnp dao){
		LinkedList<Snp> compBase = dao.readFile(file, onda);
		
		if (onda == 2)NA2 = compBase.get(0).getProbab().size();
		
		Iterator<Snp> it = compBase.iterator();
		while (it.hasNext()){
			Snp snp = it.next();
			if (!existeNaBase(snp)){
				snp.setProbab(insereNA(snp.getProbab(), onda));
				base.add(snp);
			}
		}
	}
	
	private List<String> insereNA (List<String> prob, int onda){
		ArrayList<String> novaProb = new ArrayList<String>();
		Iterator<String> it;
		if (onda == 2){
			for (int i = 0 ; i < NA1 ; i++ ){
				novaProb.add("NA");
			}
		}else{
			for (int i = 0 ; i < NA2 ; i++ ){
				novaProb.add("NA");
			}
		}
		novaProb.addAll(prob);
		
		return novaProb;
	}
}
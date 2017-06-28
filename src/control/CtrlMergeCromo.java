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
	
	
	public CtrlMergeCromo(String file, String outFile) {
		carregaOnda1(file);
		comparaBase();
		DaoSnp dao = new DaoSnp();
		dao.writeFile(base, outFile);
	}	
	
	/**
	 * Método que carrega a onda1 em memória
	 * @param file
	 */
	private void carregaOnda1(String file){
		DaoSnp dao = new DaoSnp();
		base = dao.readFile(file);
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

	/**
	 * Método utilizado para comparar a base.
	 */
	private void comparaBase(){
		Iterator<Snp> it = base.iterator();
		while (it.hasNext()){
			Snp snp = it.next();
			if (snp.getPosicao()== it.next().getPosicao()){
				
				snp.setProbab(insereNA(snp.getProbab(), snp.getOnda()));
				base.add(snp);
			}else{
				
			}
		}
	}
	
	/**
	 * Método para inserir "NA" nas probabilidades vazias.
	 * @param prob
	 * @param onda
	 * @return Lista de Probabilidades com "NA" nos lugares necessários
	 */
	private List<String> insereNA (List<String> prob, int onda){
		ArrayList<String> novaProb = new ArrayList<String>();
		Iterator<String> it;2
		switch (onda) {
		case 2:
			for (int i = 0 ; i < NA1 ; i++ ){
				novaProb.add("NA");
			}
			break;
		case 3:
			for (int i = 0 ; i < NA2 ; i++ ){
				novaProb.add("NA");
			}
			break;
		default:
			break;
		}
		novaProb.addAll(prob);
		return novaProb;
	}
}
package model;

import java.util.List;

public class Snp {

	private int onda;
	private String nome;
	private String posicao;
	private List<Double> probab;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getPosicao() {
		return posicao;
	}
	public void setPosicao(String posicao) {
		this.posicao = posicao;
	}
	public List<Double> getProbab(){
		return probab;
	}
	public void setProbab(List<Double> probab) {
		this.probab = probab;
	}
	public int getOnda() {
		return onda;
	}
	public void setOnda(int onda) {
		this.onda = onda;
	}
}

package model;

import java.util.List;

public class Snp {

	private int onda;
	private String nome;
	private String posicao;
	private String marcador1;
	private String marcador2;
	private List<String> probab;
	
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
	public String getMarcador1() {
		return marcador1;
	}
	public void setMarcador1(String marcador1) {
		this.marcador1 = marcador1;
	}
	public String getMarcador2() {
		return marcador2;
	}
	public void setMarcador2(String marcador2) {
		this.marcador2 = marcador2;
	}
	public List<String> getProbab(){
		return probab;
	}
	public void setProbab(List<String> probab) {
		this.probab = probab;
	}
	public int getOnda() {
		return onda;
	}
	public void setOnda(int onda) {
		this.onda = onda;
	}
}

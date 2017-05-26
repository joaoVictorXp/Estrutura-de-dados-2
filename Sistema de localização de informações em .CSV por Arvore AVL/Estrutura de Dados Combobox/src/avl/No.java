package avl;

import dados.Dados;

public class No {
    private No esquerda;
	private No direita;
	private No pai;
	private String chave;
	private int balanceamento;
    
	private int folha = 1;
	
	private Dados dados;

    public Dados getDados() {
        return dados;
    }

    public void setDados(Dados dados) {
        this.dados = dados;
    }

	public No(String dado, Dados d) {
		setEsquerda(setDireita(setPai(null)));
		setBalanceamento(0);
		setChave(dado);
        setDados(d);
	}

	public String getChave() {
		return chave;
	}

	public void setChave(String chave) {
		this.chave = chave;
	}

	public int getBalanceamento() {
		return balanceamento;
	}

	public void setBalanceamento(int balanceamento) {
		this.balanceamento = balanceamento;
	}

	public No getPai() {
		return pai;
	}

	public No setPai(No pai) {
		this.pai = pai;
		return pai;
	}

	public No getDireita() {
		return direita;
	}

	public No setDireita(No direita) {
		this.direita = direita;
		return direita;
	}

	public No getEsquerda() {
		return esquerda;
	}

	public void setEsquerda(No esquerda) {
		this.esquerda = esquerda;
	}

	public int getFolha() {
		return folha;
	}

	public void setFolha(int folha) {
		this.folha = folha;
	}
}

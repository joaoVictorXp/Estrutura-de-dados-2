package avl;

import dados.Dados;
import java.util.ArrayList;
//import java.util.HashSet;

public class Avl {
	protected No raiz;
    protected No ant;
    protected No maior;
    protected No menor;
    
	public void inserir(String k, Dados d) {
		No n = new No(k, d);
		int i;
		if(ant != null){
			i = n.getChave().compareToIgnoreCase(ant.getChave());
			if(i <= 0){
				inserirAVL(ant, n, i);
				return;
			}else{
				i = n.getChave().compareToIgnoreCase(maior.getChave());
				if(i >= 0) {
					inserirAVL(maior, n, i);
					maior = n;
					return;
				}
				else {
					i = n.getChave().compareToIgnoreCase(menor.getChave());
					if(i <= 0) {
						inserirAVL(menor, n, i);
						menor = n;
						return;
					}
				}
				inserirAVL(this.raiz, n, i);
				return;
			}				
		}
		else{
			this.raiz = n;
			ant = n;
			maior = n;
			menor = n;
		}
	}

	public void inserirAVL(No aComparar, No aInserir, int t) {			
            if (t <= 0) {
				if (aComparar.getEsquerda() == null) {
					aComparar.setEsquerda(aInserir);
					aInserir.setPai(aComparar);
					verificarBalanceamento(aComparar);
					
					ant = aInserir;
					//hset.add(aInserir);

				} else {
					int int1 = aInserir.getChave().compareToIgnoreCase(aComparar.getChave());
					inserirAVL(aComparar.getEsquerda(), aInserir, int1);
				}
			} else if (t > 0) {

				if (aComparar.getDireita() == null) {
					aComparar.setDireita(aInserir);
					aInserir.setPai(aComparar);
					verificarBalanceamento(aComparar);
					
					ant = aInserir;
					//hset.add(aInserir);
				} else {
					int int1 = aInserir.getChave().compareToIgnoreCase(aComparar.getChave());
					inserirAVL(aComparar.getDireita(), aInserir, int1);
				}

			}
	}

	public void verificarBalanceamento(No atual) {
		setBalanceamento(atual);
		int balanceamento = atual.getBalanceamento();

		if (balanceamento == -2) {

			if (altura(atual.getEsquerda().getEsquerda()) >= altura(atual.getEsquerda().getDireita())) {
				atual = rotacaoDireita(atual);

			} else {
				atual = duplaRotacaoEsquerdaDireita(atual);
			}

		} else if (balanceamento == 2) {

			if (altura(atual.getDireita().getDireita()) >= altura(atual.getDireita().getEsquerda())) {
				atual = rotacaoEsquerda(atual);

			} else {
				atual = duplaRotacaoDireitaEsquerda(atual);
			}
		}

		if (atual.getPai() != null) {
			verificarBalanceamento(atual.getPai());
		} else {
			this.raiz = atual;
		}
	}
	
	public No rotacaoEsquerda(No inicial) {

		No direita = inicial.getDireita();
		direita.setPai(inicial.getPai());

		inicial.setDireita(direita.getEsquerda());

		if (inicial.getDireita() != null) {
			inicial.getDireita().setPai(inicial);
		}

		direita.setEsquerda(inicial);
		inicial.setPai(direita);

		if (direita.getPai() != null) {

			if (direita.getPai().getDireita() == inicial) {
				direita.getPai().setDireita(direita);
			
			} else if (direita.getPai().getEsquerda() == inicial) {
				direita.getPai().setEsquerda(direita);
			}
		}

		setBalanceamento(inicial);
		setBalanceamento(direita);

		return direita;
	}

	public No rotacaoDireita(No inicial) {

		No esquerda = inicial.getEsquerda();
		esquerda.setPai(inicial.getPai());

		inicial.setEsquerda(esquerda.getDireita());

		if (inicial.getEsquerda() != null) {
			inicial.getEsquerda().setPai(inicial);
		}

		esquerda.setDireita(inicial);
		inicial.setPai(esquerda);

		if (esquerda.getPai() != null) {

			if (esquerda.getPai().getDireita() == inicial) {
				esquerda.getPai().setDireita(esquerda);
			
			} else if (esquerda.getPai().getEsquerda() == inicial) {
				esquerda.getPai().setEsquerda(esquerda);
			}
		}

		setBalanceamento(inicial);
		setBalanceamento(esquerda);

		return esquerda;
	}

	public No duplaRotacaoEsquerdaDireita(No inicial) {
		inicial.setEsquerda(rotacaoEsquerda(inicial.getEsquerda()));
		return rotacaoDireita(inicial);
	}

	public No duplaRotacaoDireitaEsquerda(No inicial) {
		inicial.setDireita(rotacaoDireita(inicial.getDireita()));
		return rotacaoEsquerda(inicial);
	}
	
	private int altura(No atual) {
		if (atual == null) {
			return -1;
		}

		if (atual.getEsquerda() == null && atual.getDireita() == null) {
			return 0;
		
		} else if (atual.getEsquerda() == null) {
			return 1 + altura(atual.getDireita());
		
		} else if (atual.getDireita() == null) {
			return 1 + altura(atual.getEsquerda());
		
		} else {
			return 1 + Math.max(altura(atual.getEsquerda()), altura(atual.getDireita()));
		}
	}

	private void setBalanceamento(No no) {
		no.setBalanceamento(altura(no.getDireita()) - altura(no.getEsquerda()));
	}
          
	public ArrayList<No> inorder(String chave) {
		ArrayList<No> ret = new ArrayList<>();
		inorder(raiz, ret, chave);
		return ret;
	}
	final protected void inorder(No no, ArrayList<No> lista, String chave) {
            if (no == null) {
                return;
            }
            
            inorder(no.getEsquerda(), lista, chave);
            
            if(no.getChave().toLowerCase().contains(chave.toLowerCase())){
              lista.add(no);
            }   
            
            inorder(no.getDireita(), lista, chave);
	}
}

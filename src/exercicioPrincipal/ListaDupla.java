package exercicioPrincipal;

public class ListaDupla {

	private Nodo inicio;
	private int contador = 0;

	public ListaDupla() {
		this.inicio = null;
	}

	public void insereFinal(int valor) {
		Nodo novo = new Nodo();
		novo.setAnter(null);
		novo.setProx(null);
		novo.setValor(valor);

		if (this.inicio == null) {
			this.inicio = novo;
		} else {
			Nodo aux = inicio;
			while (aux.getProx() != null) {
				aux = aux.getProx();
			}
			aux.setProx(novo);
			novo.setAnter(aux);
		}
	}

	public void insereInicio(int valor) {
		Nodo novo = new Nodo();
		novo.setAnter(null);
		novo.setProx(null);
		novo.setValor(valor);

		if (this.inicio == null) {
			this.inicio = novo;
		} else {
			novo.setProx(this.inicio);
			this.inicio.setAnter(novo);
		}
		this.inicio = novo;
	}

	public Nodo pesquisa(int valor) {
		Nodo aux = this.inicio;
		if (this.inicio != null) {
			while (aux != null && aux.getValor() != valor) {
				aux = aux.getProx();
			}
		}
		return aux;
	}

	public void removePorValor(int valor) {
		Nodo aux = pesquisa(valor);
		if (aux == null) {
			System.out.println("Valor não encontrado!");
		} else {
			if (aux.getAnter() != null) {
				aux.getAnter().setProx(aux.getProx());
			} else {
				this.inicio = aux.getProx();
			}
			if (aux.getProx() != null) {
				aux.getProx().setAnter(aux.getAnter());
			}
			aux = null;
		}
	}

	public void insereCrescente(int valor) {
		Nodo aux = null;
		Nodo novo = new Nodo();
		novo.setAnter(null);
		novo.setProx(null);
		novo.setValor(valor);
		contador++;
		System.out.println("\n" + contador + " nodos criados");

		if (this.inicio == null) {
			System.out.println("Lista Vazia!/n Sendo preenchida . . .");
			this.inicio = novo;
		} else {
			aux = this.inicio;
			if (aux.getProx() == null) {
				// Aqui ele testa se tem apenas 1 nodo
				if (aux.getValor() < novo.getValor()) {
					aux.setProx(novo);
					novo.setAnter(aux);
				} else {
					novo.setProx(aux);
					aux.setAnter(novo);
					this.inicio = novo;
				}
			} else {
				// Se chegou aqui tem mais de 1 nodo
				if (aux.getProx() == null || aux.getAnter() == this.inicio) {
					if (aux.getValor() < novo.getValor()) {
						aux.setProx(novo);
						novo.setAnter(aux);
					}
					else {
						aux.getAnter().setProx(novo);
						aux.setAnter(novo);
						novo.setProx(aux);
						novo.setAnter(this.inicio);
					}
				}
				while (aux.getProx() != null) {
					// While para chegar ate o fim da lista
					System.out.println("Entrou 100");
					if (novo.getValor() < aux.getValor()) {
						// Se o valor do novo for maior que o valor do proximo ele passa
						aux.getProx().setAnter(novo);
						novo.setProx(aux.getProx());
						aux.setProx(novo);
					} else {
					}
					aux = aux.getProx();

				}
				if (aux.getAnter() == this.inicio) {
					if (novo.getValor() < aux.getValor()) {
						// Se o valor do novo for maior que o valor do proximo ele passa
						novo.setAnter(aux.getAnter());
						novo.setProx(aux);
						aux.setAnter(novo);
						aux.getAnter().setProx(novo);

					} else {
					}
				}
				// Se chegou aqui tem mais de 2 nodos na lista e aux esta no final
				while (aux.getAnter() != this.inicio) {
					System.out.println("Entrou 113");
					if (aux.getValor() < novo.getValor()) {
						imprimeListaDupla();
						aux.setProx(novo);
						novo.setAnter(aux);
						System.out.println("Novo é maior 108");
					} else {
						System.out.println("Novo é menor 120");
						aux.setAnter(novo);
						novo.setProx(aux);
					}
					if (aux.getValor() > novo.getValor()) {
						System.out.println("Novo é menor 110");
						this.insereInicio(valor);
					}
					/*
					 * else {
					 * 
					 * while (aux.getValor() < novo.getValor() && (aux.getProx() != null ||
					 * aux.getProx().getValor() < novo.getValor())) { aux = aux.getProx(); } if
					 * (aux.getProx() == null) { novo.setAnter(aux); aux.setProx(novo); } else {
					 * aux.getProx().setAnter(novo); novo.setProx(aux.getProx()); aux.setProx(novo);
					 * novo.setAnter(aux); } }
					 */
					aux = aux.getAnter();
				}
			}

		}
	}

	/*
	 * public void inserePorValor(int valor) { Nodo aux = pesquisa(valor); Nodo novo
	 * = new Nodo(); novo.setAnter(null); novo.setProx(null); novo.setValor(valor);
	 * 
	 * if (aux == null) { System.out.println("Valor não encontrado!"); } else {
	 * if(aux.getAnter()!= null) { aux.getAnter().setProx(aux.getProx()); } else {
	 * this.inicio=aux.getProx(); } if (aux.getProx()!= null){
	 * aux.getProx().setAnter(aux.getAnter()); } aux = null; } }
	 */

	public void imprimeListaDupla() {
		if (this.inicio == null)
			System.out.println("Lista Vazia!");
		else {
			Nodo aux = this.inicio;
			System.out.println("\n");
			while (aux != null) {
				System.out.println("Valor Lista Dupla: " + aux.getValor());
				aux = aux.getProx();
			}
		}
	}

	public void pesquisaValor(int valor) {
		int contador = 0;
		if (this.inicio == null) {
			System.out.println("Lista Vazia");
		} else {
			boolean achou = false;
			Nodo aux = this.inicio;
			while (aux != null && !achou) {
				contador++;
				if (valor == aux.getValor()) {
					achou = true;
					break;
				} else {
					aux = aux.getProx();
				}
			}
			if (achou) {
				System.out.println("\nValor Encontrado!\n Nodos passados: " + contador + "\n");
			} else {
				System.out.println("\nValor Não Encontrado!\n Nodos passados: " + contador + "\n");
			}
		}
	}

}

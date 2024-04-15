package exercicioPrincipal;

public class Nodo {
	private int valor;
	private Nodo prox;
	private Nodo anter;
	
	public Nodo() {
		this.valor = 0;
		this.prox = null;
		this.anter = null;
	}
	
	public Nodo (int val, Nodo p, Nodo a) {
		this.valor = val;
		this.anter = a;
		this.prox = p;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public Nodo getProx() {
		return prox;
	}

	public void setProx(Nodo prox) {
		this.prox = prox;
	}

	public Nodo getAnter() {
		return anter;
	}

	public void setAnter(Nodo anter) {
		this.anter = anter;
	}
	


}

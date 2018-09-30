/**
 * No
 */
public class No {

	private int conteudo;
	private No prox;

	public No() {
		this.conteudo = 0;
		this.prox = null;
	}

	public int getConteudo() {
		return this.conteudo;
	}

	public void setConteudo(int conteudo) {
		this.conteudo = conteudo;
	}

	public No getProx() {
		return this.prox;
	}

	public void setProx(No prox) {
		this.prox = prox;
	}

}
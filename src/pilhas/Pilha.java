
/**
 * Pilha
 */
public class Pilha {

  private No topo;
  private int nElementos;

  public Pilha() {
    this.topo = null;
    this.nElementos = 0;
  }

  public boolean vazia() {
    return this.nElementos == 0;
  }

  public int tamanho() {
    return this.nElementos;
  }

  public int top() {
    if(vazia()) {
      return -1;
    }

    return topo.getConteudo();
  }

  public boolean push(int valor) {
    No novoNo = new No();
    novoNo.setConteudo(valor);

    novoNo.setProx(this.topo);
    this.topo = novoNo;
    this.nElementos++;

    return true;
  }

  public int pop() {
    if(vazia()) {
      return -1;
    }

    No aux = this.topo;
    int valor = aux.getConteudo();

    this.topo = aux.getProx();
    aux = null;
    return valor;

  }

}
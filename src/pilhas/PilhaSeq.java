/**
 * PilhaSeq
 */
public class PilhaSeq {

  private int[] dados;
  private int topo;
  private int tamMax;

  public PilhaSeq() {
    this.tamMax = 100;
    this.topo = -1;
    this.dados = new int[this.tamMax];
  }

  public PilhaSeq(int tam) {
    this.tamMax = tam;
    this.topo = -1;
    this.dados = new int[this.tamMax];
  }

  public boolean vazia() {
    return this.topo == -1;
  }

  public boolean cheia() {
    return (this.topo == (this.tamMax - 1));
  }

  public int tamanho() {
    return this.topo + 1;
  }

  public int top() {
    if (vazia()) {
      return -1;
    }

    return this.dados[this.topo];
  }

  public boolean push(int dado) {
    if (cheia()) {
      return false;
    }

    this.topo++;
    this.dados[topo] = dado;

    return true;
  }

  public int pop() {
    if (vazia()) {
      return -1;
    }

    int valor = this.dados[this.topo];
    this.topo--;
    return valor;
  }
}
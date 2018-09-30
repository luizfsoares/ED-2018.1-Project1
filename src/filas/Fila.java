/**
 * Fila
 */
public class Fila {
  private No inicio;
  private No fim;
  private int nElementos;

  public Fila() {
    this.inicio = null;
    this.fim = null;
    this.nElementos = 0;
  }

  public boolean vazia() {
    return this.nElementos == 0;
  }

  public int tamanho() {
    return this.nElementos;
  }

  public int primeiro() {
    if (vazia()) {
      return -1;
    }

    return this.inicio.getConteudo();
  }

  public boolean insere(int valor) {
    No novoNo = new No();
    novoNo.setConteudo(valor);
    novoNo.setProx(null);

    if (vazia()) {
      this.inicio = novoNo;
      this.fim = novoNo;
    } else {
      this.fim.setProx(novoNo);
      this.fim = novoNo;
    }
    this.nElementos++;
    return true;

  }

  public int remove() {
    if (vazia()) {
      return -1;
    }

    int valor = primeiro();
    if (this.inicio == this.fim) {
      this.fim = null;
    }

    No p = this.inicio;
    this.inicio = p.getProx();
    this.nElementos--;

    p = null;
    return valor;

  }

}
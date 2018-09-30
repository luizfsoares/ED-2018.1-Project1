/**
 * FilaSeq
 */
public class FilaSeq {

  private int dados[];
  private int inicio;
  private int fim;
  private int tamMax;
  private int nElementos;

  public FilaSeq() {
    this.inicio = 0;
    this.fim = -1;
    this.nElementos = 0;

    this.tamMax = 100;
    this.dados = new int[this.tamMax];
  }

  public FilaSeq(int tam) {
    this.inicio = 0;
    this.fim = -1;
    this.nElementos = 0;

    this.tamMax = tam;
    this.dados = new int[this.tamMax];
  }

  public boolean vazia() {
    return this.nElementos == 0;
  }

  public boolean cheia() {
    return this.nElementos == this.tamMax;
  }

  public int tamanho() {
    return this.nElementos;
  }

  public int primeiro() {
    if (vazia()) {
      return -1;
    }

    return this.dados[this.inicio];
  }

  public boolean insere(int valor) {
    if (cheia()) {
      return false;
    }

    this.fim = (this.fim + 1) % this.tamMax;
    this.dados[this.fim] = valor;
    this.nElementos++;

    return true;
  }

  public int remove() {
    if (vazia()) {
      return -1;
    }

    int res = primeiro();
    this.inicio = (this.inicio + 1) % this.tamMax;
    this.nElementos--;
    return res;
  }

}
package arvore;

/**
 * No
 */
public class No {
  private int conteudo;
  private No esq;
  private No dir;

  public No() {
    this.esq = null;
    this.dir = null;
    this.conteudo = -1;
  }

  public int getConteudo() {
    return this.conteudo;
  }

  public void setConteudo(int conteudo) {
    this.conteudo = conteudo;
  }

  public No getEsq() {
    return this.esq;
  }

  public void setEsq(No esq) {
    this.esq = esq;
  }

  public No getDir() {
    return this.dir;
  }

  public void setDir(No dir) {
    this.dir = dir;
  }
}
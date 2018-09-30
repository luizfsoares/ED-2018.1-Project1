package arvore;

/**
 * ArvBin
 */
public class ArvBin {
  private No raiz;

  public ArvBin() {
    this.raiz = null;
  }

  public No getRaiz() {
    return this.raiz;
  }

  public void setRaiz(No raiz) {
    this.raiz = raiz;
  }

  public boolean vazia() {
    return this.raiz == null;
  }

  public No busca(No T, int valor) {

    if(T == null) {
      return null;
    }
    if(T.getConteudo() == valor) {
      return T;
    } 
    No aux = busca(T.getEsq(), valor);
    if(aux == null) {
      aux = busca(T.getDir(), valor)
    }

    return aux;
   

  }

}
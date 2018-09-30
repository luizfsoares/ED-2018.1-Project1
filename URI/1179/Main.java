// 1179 - Preenchimento de Vetor IV

import java.io.IOException;
import java.util.Scanner;

public class Main {
  
  public static int MAX_SIZE = 5;

  public static void main(String[] args) throws IOException {
    ListaSeq odd = new ListaSeq(MAX_SIZE);
    ListaSeq even = new ListaSeq(MAX_SIZE);
    Scanner sc = new Scanner(System.in);

    int nNums = 15;
    int evenCount = 0;
    int oddCount = 0;

    for(int i = 0; i < nNums; i++) {
      int num = sc.nextInt();

      if(isEven(num)) {
        /* is even */
          even.insere(evenCount + 1, num);
          evenCount++;
      } else {
        /* is odd */
          odd.insere(oddCount + 1, num);
          oddCount++;
      }

      if(even.cheia()) {
        printList(even, "par");
        even = new ListaSeq(MAX_SIZE);
        evenCount = 0;
      }
      if(odd.cheia()) {
        printList(odd, "impar");
        odd = new ListaSeq(MAX_SIZE);
        oddCount = 0;
      }
      
    }

    printList(odd, "impar");
    printList(even, "par");
  }

  public static boolean isEven(int num) {
    return num % 2 == 0;
  }

  public static void printList(ListaSeq list, String name) {
    for(int i = 0; i < list.tamanho(); i++) {
      System.out.println(name+"["+i+"]" + " = " + list.elemento(i + 1));
    }
  }

}

/**
 * ListaSeq
 */
class ListaSeq {
  private int[] dados;
  private int nElementos;
  private int tamMax;

  public ListaSeq() {
    this.tamMax = 100;
    this.dados = new int[this.tamMax];
    this.nElementos = 0;
  }

  public ListaSeq(int tam) {
    this.dados = new int[tam];
    this.tamMax = tam;
    this.nElementos = 0;
  }

  /**
   * Verifica se a lista está cheia.
   */
  public boolean cheia() {
    return this.nElementos == this.tamMax;
  }

  /**
   * Verifica se a lista está vazia.
   */
  public boolean vazia() {
    return this.nElementos == 0;
  }  

  /**
   * Retorna o tamanho da lista.
   */ 
  public int tamanho() { 
    return this.nElementos;
  }

  /**
   * Obtem o i-ésimo elemento da lista. Retorna -1 se a posição for inválida.
   */
  public int elemento(int pos) {
    // Posição inválida.
    if ((pos > this.nElementos) || (pos < 1)) {
      // TODO: Lançar exceção aqui.
      return -1;
    }
    return this.dados[pos - 1];
  }

  /**
   * Pesquisa elemento na lista. Retorna -1 caso não for encontrado.
   */
  public int posicao(int valor) {
    for (int i = 0; i < this.nElementos; i++) {
      if (this.dados[i] == valor) {
        // Retorna pos = index + 1
        return (i + 1);
      }
    }
    // TODO: Lançar exceção aqui.
    return -1;
  }

  /**
   * Pesquisa elemento na lista. Retorna -1 caso não for encontrado.
   */
  public int posicao(int valor, int deslocamento) {
    for (int i = deslocamento + 1; i < this.nElementos; i++) {
      if (this.dados[i] == valor) {
        return (i + 1);
      }
    }
    // TODO: lançar exceção aqui.
    return -1;
  }

  /**
   * Insere um elemento na i-ésima posição. Retorna false se não conseguir
   * inserir.
   */
  public boolean insere(int pos, int dado) {
    if (cheia() || (pos > this.nElementos + 1) || (pos < 1)) {
      return false;
    }

    /**
     * Deslocar os elementos para adicionar os novos. Da Direita para esquerda.
     */
    for (int i = this.nElementos; i >= pos; i--) {
      this.dados[i] = this.dados[i - 1];
    }

    this.dados[pos - 1] = dado;
    this.nElementos++;

    return true;
  }

  /**
   * Remove um elemento de determinada posição. Retorna -1 se for inválido.
   */
  public int remove(int pos) {
    int dado;
    if ((pos > this.nElementos) || (pos < 1)) {
      return -1;
    }

    dado = this.dados[pos - 1];

    for (int i = pos - 1; i < this.nElementos - 1; i++) {
      this.dados[i] = this.dados[i + 1];
    }
    this.nElementos--;

    return dado;
  }

  /**
   * Representação da lista como String.
   */
  public String toString() {
    String s = "[";
    for (int i = 0; i < this.nElementos; i++) {
      s += this.dados[i];
      if (i >= 0 && i < (this.nElementos - 1)) {
        s += ", ";
      }

    }
    s += "]";

    return s;
  }
}
1// 2506 - Medical Clinic Queue
import java.util.*;
import java.io.*;

/**
 * Main
 */
public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String input;
    do {
      input = br.readLine();
      int valor = Integer.parseInt(input);

      FilaSeq pacientes = new FilaSeq(valor + 1);

      for (int i = 0; i < valor; i++) {
        String[] line = br.readLine().trim().split(" ");
        int h = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);
        int c = Integer.parseInt(line[2]);
        // System.out.println(((h*60) + m) + " - " + ((h*60) + m + c));
        Paciente p = new Paciente(h, m, c);
        pacientes.insere(p);
      }
      int resultado = validarPacientes(pacientes);
      System.out.println(resultado);
    } while(br.ready());
    // while ((input = br.readLine()) != null) {
      

    // }

  }

  public static int validarPacientes(FilaSeq pacientes) {
    int contCritico = 0;
    int hora = 7 * 60;

    // primeiro paciente sempre é atendido na hora que chega
    Paciente primeiro = pacientes.remove();
    hora = ((primeiro.getHora() / 60) * 60) + 30;

    while (!pacientes.vazia()) {
      Paciente atual = pacientes.primeiro();
      while (hora < atual.getHora()) {
        hora += 30;
      }
      if (atual.getHoraCritica() < hora) {
        // paciente vivo
        pacientes.remove();
        contCritico++;
      } else {
        // paciente morre
        pacientes.remove();
        hora += 30;
      }
    }
    return contCritico;
  }
}

class Paciente {
  private int hora;
  private int horaCritica;

  public Paciente(int h, int m, int c) {
    this.hora = (h * 60) + m;
    this.horaCritica = this.hora + c;
  }

  public int getHora() {
    return this.hora;
  }

  public void setHora(int hora) {
    this.hora = hora;
  }

  public int getHoraCritica() {
    return this.horaCritica;
  }

  public void setHoraCritica(int horaCritica) {
    this.horaCritica = horaCritica;
  }

}

class FilaSeq {
  private Paciente dados[];
  private int inicio;
  private int fim;

  private int nElementos;
  private int tamMax;

  public FilaSeq() {
    inicio = 0;
    fim = -1;
    nElementos = 0;

    tamMax = 100;
    dados = new Paciente[tamMax];
  }

  public FilaSeq(int n) {
    inicio = 0;
    fim = -1;
    nElementos = 0;

    tamMax = n;
    dados = new Paciente[tamMax];
  }

  /** Verifica se a Fila está vazia */
  public boolean vazia() {
    if (nElementos == 0)
      return true;
    else
      return false;
  }

  /** Verifica se a Fila está cheia */
  public boolean cheia() {
    if (nElementos == tamMax)
      return true;
    else
      return false;
  }

  /** Obtém o tamanho da Fila */
  public int tamanho() {
    return nElementos;
  }

  /**
   * Consulta o elemento do início da fila. Retorna -1 se a fila estiver vazia.
   */
  public Paciente primeiro() {
    if (vazia())
      return null; // Erro: Fila vazia

    return dados[inicio];
  }

  /**
   * Insere um elemento no fim de uma fila Retorna false se a fila estiver cheia,
   * true caso contrário.
   */
  public boolean insere(Paciente p) {
    if (cheia()) {
      return false;
    }

    fim = (fim + 1) % tamMax; // Circularidade
    dados[fim] = p;
    nElementos++;
    return true;
  }

  /**
   * Remove o elemento do início da fila e retorna o valor removido. Retorna -1 se
   * a fila estiver vazia.
   */
  public Paciente remove() {
    if (vazia())
      return null;

    Paciente p = primeiro();
    inicio = (inicio + 1) % tamMax; // Circularidade
    nElementos--;
    return p;
  }

}

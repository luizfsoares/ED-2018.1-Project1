// 1068 - Balanço de Parênteses I
import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    String line;

    while((line = bf.readLine()) != null) {
      boolean isValid = validExpression(line);
      if(isValid) {
        System.out.println("correct");
      } else {
        System.out.println("incorrect");
      }
    }
  }

  public static boolean validExpression(String expression) {
    PilhaSeq stack = new PilhaSeq(1001);
    for(int i =0; i < expression.length(); i++) {
      char charAt = expression.charAt(i);
      if(charAt == '(') {
        stack.push(1);
      } else if(charAt == ')') {
        if(stack.vazia()) {
          return false;
        }
        stack.pop();
      }
    }

    
    return stack.vazia();
  }
}

class PilhaSeq {
	private int dados[]; // Vetor que contém os dados da lista 
	private int topo; 
	private int tamMax;
    
    public PilhaSeq(){
    		tamMax = 100;
    		dados = new int[tamMax];
    		
    		topo = -1;
    	}
    
    public PilhaSeq(int n){
    		tamMax = n;
    		dados = new int[tamMax];
    		
    		topo = -1;
    }

    /** Verifica se a Pilha está vazia */
    public boolean vazia(){
    		if (topo == -1)
    			return true;
    	   else 
    	      return false;
	}
	
    /**Verifica se a Pilha está cheia */
    public boolean cheia(){
        if (topo == (tamMax-1))
  		  return true;
      else
  		  return false;
	}
	
    /**Obtém o tamanho da Pilha*/
    public int tamanho(){
		return topo+1;
	}
    
    /** Consulta o elemento do topo da Pilha.
		Retorna -1 se a pilha estiver vazia, 
		caso contrário retorna o valor que está no topo da pilha. */
 	public int top () {
      if (vazia()) 
         return -1; // pilha vazia
 	  
      return dados[topo];
 	}
     
	 /** Insere um elemento no topo da pilha.
	  Retorna false se a pilha estiver cheia. 
	  Caso contrário retorna true */
 	public boolean push (int valor) {
 		if (cheia()) 
 			return false;  // err: pilha cheia 
 		
 		topo++;
 		dados[topo] = valor; 
 		return true;
	 }   

	 /** Retira o elemento do topo da pilha.
	  Retorna -1 se a pilha estiver vazia. */
 	public int pop() {          
 		if (vazia()) 
 			return -1; // Pilha vazia
 		
 		int valor = dados[topo]; 
 		topo--; 
 		return valor;
 	}
}

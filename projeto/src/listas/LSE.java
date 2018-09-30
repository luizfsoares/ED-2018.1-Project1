package listas;

public class LSE {
	private No cabeca;
	private int nElementos;

	public LSE(){
		cabeca = null;
		nElementos = 0;
	}
	
	/** Verifica se a Lista está vazia */
	public boolean vazia() {
	    if (nElementos == 0)
	        return true;
	    else
	        return false;
	}

	/**Obtém o tamanho da Lista*/
	public int tamanho() {
	    //return nElementos;
		No aux = cabeca;
		int cont = 0;
		while(aux != null){
			aux = aux.getProx();
			cont++;
		}
		return cont;
	}

	/** Obtém o i-ésimo elemento de uma lista
	    Retorna o valor encontrado. */
	public No elemento (int pos) {
	    if (vazia()) {
	        return null; // Consulta falhou 
	    }

	    if ((pos < 1) || (pos > tamanho())){
	        return null; // Posicao invalida 
	    }
	    
	    No aux = cabeca;
	    // Percorre a lista do 1o elemento até pos 
	    for (int i =1; i < pos; i++){
	        // modifica "aux" para apontar para o proximo elemento da lista 
	        aux = aux.getProx();
	    }

	    return aux;
	}

	/**Retorna a posição de um elemento pesquisado.
	    Retorna -1 caso não seja encontrado */
	public int posicao (int dado) {
	    int cont = 1;
	    No aux;

	    /* Lista vazia */
	    if (vazia()) {
	        return -1;
	    }

	    /* Percorre a lista do inicio ao fim até encontrar o elemento*/
	    aux = cabeca;
		while (aux != null) {
	        /* Se encontrar o elemento, retorna sua posicao n;*/
	        if (aux.getConteudo() == dado){
	            return cont;
	        }

	        /* modifica "aux" para apontar para o proximo elemento da lista */
	        aux = aux.getProx();
	        cont++;
	    }

	    return -1;
	}

	/** Insere nó em lista vazia */
	private boolean insereInicioLista(int valor) {
	    // Aloca memoria para novo no 
	    No novoNo = new No();
	    
	    // Insere novo elemento na cabeca da lista
	    novoNo.setConteudo(valor);
	    
	    novoNo.setProx(cabeca);
	    cabeca = novoNo;
	    nElementos++;
	    return true;
	}

	/** Insere nó no meio da lista */
	private boolean insereMeioLista(int pos, int dado){
	    
	    // Aloca memoria para novo no
	    No novoNo = new No();
	    novoNo.setConteudo(dado);

	    // Localiza a pos. ANTERIOR onde será inserido o novo nó
	    No aux = cabeca;
	    for (int i =1; i < pos-1; i++){
	        // modifica "aux" para apontar para o proximo elemento da lista 
	        aux = aux.getProx();
	    }
	    /*while ((cont < pos-1) && (aux != null)){
	          aux = aux.getProx();
	          cont++;
	    }

	    if (aux == null) {  // pos. inválida 
	    		return false;
	    }*/

	    // Insere novo elemento apos aux
	    /*novoNo.setProx(aux.getProx());
	    aux.setProx(novoNo);*/
	    
	    // Insere novo elemento apos aux
	    No p = aux.getProx();
	    novoNo.setProx(p);
	    aux.setProx(novoNo);
	    
	    nElementos++;
	    return true;
	}

	/** Insere nó no fim da lista */
	private boolean insereFimLista(int dado){
	    // Aloca memoria para novo no 
	    No novoNo = new No();
	    novoNo.setConteudo(dado);

	    // Procura o final da lista 
	    No aux = this.cabeca;
	    while(aux.getProx() != null){
	        aux = aux.getProx();
	    }

	    novoNo.setProx(null);
	    aux.setProx(novoNo);

	    this.nElementos++;
	    return true;
	}

	/**Insere um elemento em uma determinada posição
	    Retorna true se conseguir inserir e 
	    false caso contrario */
	public boolean insere(int pos, int dado) {
		if ((vazia()) && (pos != 1)){
	        return false; /* lista vazia mas posicao inv*/
	    }

	 	/* inserção no início da lista (ou lista vazia)*/
	    if (pos == 1){
	        return insereInicioLista(dado);
	    }
	    /* inserção no fim da lista */
	    else if (pos == nElementos+1){
	        return insereFimLista(dado);
	   }
	   /* inserção no meio da lista */
	   else{
	        return insereMeioLista(pos, dado);
	   }
	}

	/** Remove elemento do início da lista */
	private int removeInicioLista(){
	    No p = cabeca;

	    // Dado recebe o dado removido
	    int dado = p.getConteudo();

	    // Retira o 1o elemento da lista (p)
	    cabeca = p.getProx();
	    nElementos--;

	    // Sugere ao garbage collector que libere a memoria
	    //  da regiao apontada por p
	    p = null;

	    return dado;
	}

	/** Remove elemento no meio da lista */
	private int removeNaLista(int pos){
	     No atual = null, antecessor = null;
	     int dado = -1;
	     int cont = 1;

	     /* Localiza o nó que será removido*/
	     atual = cabeca;
	     while((cont < pos) && (atual != null)){
	           antecessor = atual;
	           atual = atual.getProx();
	           cont++;
	     }

	     if (atual == null) { /* pos. inválida */
	        return -1;
	     }

	    /* retira o elemento da lista */
	    dado = atual.getConteudo();
	    antecessor.setProx(atual.getProx());
	    nElementos--;

	    /* sugere ao garbage collector que libere a memoria
	     *  da regiao apontada por p*/
	    atual = null;
	    return dado;
	}

	/**Remove um elemento de uma determinada posição
	    Retorna o valor a ser removido. 
	    -1 se a posição for inválida ou a lista estiver vazia*/
	public int remove(int pos) {
		// Lista vazia 
	    if (vazia()) {
	    		return -1;
	    }

	    // Remoção do elemento da cabeça da lista 
	    if (pos == 1){
	        return removeInicioLista();
	    }
	    // Remoção em outro lugar da lista
	    else{
	        return removeNaLista(pos);
	    }
	}
}

import java.util.Random;

class Matriz{
	private int[][] mat;
	private int tamLinha;
	private int tamColuna;

	Matriz(){
		mat = new int[6][6];
		this.setTamanhoLinha(6);	
		this.setTamanhoColuna(6);
	}

	Matriz(int numLinhas, int numColunas){
		mat = new int[numLinhas][numColunas];
		this.setTamanhoLinha(numLinhas);	
		this.setTamanhoColuna(numColunas);
	}


	public int getValor(int indiceI,int indiceJ){
		return mat[indiceI][indiceJ];
	}	
	
	public void setValor(int indiceI,int indiceJ, int novoValor){
		mat[indiceI][indiceJ] = novoValor;
	}

	public int getTamanhoLinha(){
		return tamLinha;
	}	
	
	public int getTamanhoColuna(){
		return tamColuna;
	}	

	private void setTamanhoLinha(int novoValor){
		tamLinha = novoValor;
	}

	private void setTamanhoColuna(int novoValor){
		tamColuna = novoValor;
	}

	public void imprime(){
		int conti,contj;	
		for(conti = 0; conti < this.getTamanhoLinha(); conti++){
			System.out.println();
			for(contj = 0; contj < this.getTamanhoColuna(); contj++){
				System.out.print(this.getValor(conti,contj) + " ");
			}
		}
		System.out.println();	
	}

	public void inicializaRandomico(){
		int conti,contj, novoValor;
		int ordem = this.getTamanhoLinha();
		Random gerador = new Random();
		for(conti = 0; conti < this.getTamanhoLinha(); conti++){
			for(contj = 0; contj < this.getTamanhoColuna(); contj++){
				novoValor = gerador.nextInt(ordem);
				this.setValor(conti,contj,novoValor);
			}
		}
	}

	// caso matriz nao quadrada, retorna -1
	public int retorneOrdem(){
		int numL, numC, ordem;

		numL = this.getTamanhoLinha();
		numC = this.getTamanhoColuna();
		ordem = -1;
		if(numL == numC){
			ordem = numL;
		}

		return ordem;
	}	

	private int detOrdem1(Matriz mat){
		return mat.getValor(0,0);
	}
	
	private int detOrdem2(Matriz mat){
		int diagonalP, diagonalI;

		diagonalP = mat.getValor(0,0) * mat.getValor(1,1);		
		diagonalI = mat.getValor(1,0) * mat.getValor(0,1);		

		return (diagonalP - diagonalI);
	}

	private int calculaSinal(int indiceL, int indiceC){
		int sinal;

		sinal = -1;

		if( ((indiceL + indiceC)% 2) == 0 ){
			sinal = 1;
		}

		return sinal;		
	}

	public void copiaMatrizMaiorParaMenor(Matriz maior,Matriz menor,int isqn,int jsqn){
		int contAi,contAj,contBi,contBj,temp,numL,numC;
		numL = menor.getTamanhoLinha();
		numC = menor.getTamanhoColuna();

		contAi = 0;
		for(contBi = 0; contBi < numL; contBi++){
			if(contAi == isqn){
				contAi++;
			}
			contAj = 0;
			for(contBj = 0; contBj < numC; contBj++){
				if(contAj == jsqn){
					contAj++;
				}
				temp = maior.getValor(contAi,contAj);
				menor.setValor(contBi,contBj,temp);
				contAj++;
			}
			contAi++;
		}
	}

	private int detOrdemN(Matriz mat){
		int sinal,cofator,detTemp,resposta,contC,numL,numC;
		Matriz matmenor;
		numL = this.getTamanhoLinha();
		numC = this.getTamanhoColuna();
		
		resposta = 0;
		for(contC = 0; contC < mat.getTamanhoColuna(); contC++){
			//alterar essa parte para achar a linha ou coluna com mais zeros
			cofator = mat.getValor(0,contC);
			sinal = this.calculaSinal(0,contC);
			matmenor = new Matriz(numL-1,numC-1);
			this.copiaMatrizMaiorParaMenor(mat,matmenor,0,contC);
			detTemp = matmenor.determinante();
			resposta = resposta + (cofator * sinal * detTemp);
		}
		return (resposta);
	}

	public int determinante(){
		int ordem,det;

		ordem = this.retorneOrdem();
		det = 0;

		if(ordem > 0){
			switch (ordem) {
			    case 1:  det = this.detOrdem1(this);
				     break;
			    case 2:  det = this.detOrdem2(this);;
				     break;
			    default: det = this.detOrdemN(this);;
				     break;
			}
			
		}
		else{
			System.out.println("Matriz nao eh quadrada!! retornando 0");
		}

		return det;
	}

	public int encontreColunaComMaisZeros() {
		int maiorQuantidadeZeros = 0;
		int colunaComMaisZeros = -1;
	
		for (int j = 0; j < this.getTamanhoColuna(); j++) {
			int quantidadeZeros = 0;
			for (int i = 0; i < this.getTamanhoLinha(); i++) {
				if (this.getValor(i, j) == 0) {
					quantidadeZeros++;
				}
			}
	
			if (quantidadeZeros > maiorQuantidadeZeros) {
				maiorQuantidadeZeros = quantidadeZeros;
				colunaComMaisZeros = j;
			}
		}
	
		return colunaComMaisZeros;
	}
	
	public int encontreLinhaComMaisZeros() {
		int maiorQuantidadeZeros = 0;
		int linhaComMaisZeros = -1;
	
		for (int i = 0; i < this.getTamanhoLinha(); i++) {
			int quantidadeZeros = 0;
			for (int j = 0; j < this.getTamanhoColuna(); j++) {
				if (this.getValor(i, j) == 0) {
					quantidadeZeros++;
				}
			}
	
			if (quantidadeZeros > maiorQuantidadeZeros) {
				maiorQuantidadeZeros = quantidadeZeros;
				linhaComMaisZeros = i;
			}
		}
	
		return linhaComMaisZeros;
	}

	public int encontraLinhaOuColunaParaCofator() {
		int linhaComMaisZeros,colunaComMaisZeros;
		int quantidadeZerosColuna = 0;
		int quantidadeZerosLinha = 0;

		linhaComMaisZeros = encontreLinhaComMaisZeros();
		colunaComMaisZeros = encontreColunaComMaisZeros();

		// System.out.println("linha: " + linhaComMaisZeros);
		// System.out.println("coluna: " + colunaComMaisZeros);	
		if (linhaComMaisZeros != -1 || colunaComMaisZeros != -1 ){

		//quantidade de zeros da linha com mais zeros
		for (int j = 0; j < this.getTamanhoColuna(); j++) {
				if (this.getValor(linhaComMaisZeros, j) == 0) {
					quantidadeZerosLinha++;
				}
			}
		//quanridade de zeros da linha com mais zeros
		for (int i = 0; i < this.getTamanhoLinha(); i++) {
				if (this.getValor(i, colunaComMaisZeros) == 0) {
					quantidadeZerosColuna++;
				}
			}

		}
		else{
			// System.out.println("não existe zero na matriz");
			//codigo para nenhum zero na matriz o que significa que não da pra determinar o determinante com esse metodo de otimizaçãO
			
			return 0;
		}
		
		if (quantidadeZerosLinha > quantidadeZerosColuna) {
			// System.out.println("a quantidade de zeros da linha: " + linhaComMaisZeros + " é igual a: " + quantidadeZerosLinha + " e ela é a com mais zeros");
			return -linhaComMaisZeros;
		}
		else{
			// System.out.println("a quantidade de zeros da coluna: " + colunaComMaisZeros + " é igual a: " + quantidadeZerosColuna + "e ela é a com mais zeros");
			return colunaComMaisZeros;
		}
		

	}

	public int determinanteOtimizadoZero(){
		int ordem,det;
		
		ordem = this.retorneOrdem();
		det = 0;

		if(ordem > 0){
			switch (ordem) {
			    case 1:  det = this.detOrdem1(this);
				     break;
			    case 2:  det = this.detOrdem2(this);;
				     break;
			    default: det = this.detOrdemNOtimizadoZero(this);;
				     break;
			}
			
		}
		else{
			System.out.println("Matriz nao eh quadrada!! retornando 0");
		}

		return det;
	}

	
	private int detOrdemNOtimizadoZero(Matriz mat){
		int sinal,cofator,detTemp,resposta,contC,numL,numC;
		Matriz matmenor;
		numL = this.getTamanhoLinha();
		numC = this.getTamanhoColuna();
		
		int linhaOuColunaParaCofator = mat.encontraLinhaOuColunaParaCofator();

		
		resposta = 0;
		if (linhaOuColunaParaCofator < 0){
			linhaOuColunaParaCofator = linhaOuColunaParaCofator*-1;
			for(contC = 0; contC < mat.getTamanhoLinha(); contC++){
			//alterar essa parte para achar a linha ou coluna com mais zeros
			cofator = mat.getValor(contC,linhaOuColunaParaCofator);
			sinal = this.calculaSinal(contC,linhaOuColunaParaCofator);
			matmenor = new Matriz(numL-1,numC-1);
			//talvez ineverter aq
			this.copiaMatrizMaiorParaMenor(mat,matmenor,contC,linhaOuColunaParaCofator);
			detTemp = matmenor.determinanteOtimizadoZero();
			resposta = resposta + (cofator * sinal * detTemp);
		}
		return (resposta);
		} 
		else{
			for(contC = 0; contC < mat.getTamanhoColuna(); contC++){
			//alterar essa parte para achar a linha ou coluna com mais zeros
			cofator = mat.getValor(linhaOuColunaParaCofator,contC);
			sinal = this.calculaSinal(linhaOuColunaParaCofator,contC);
			matmenor = new Matriz(numL-1,numC-1);
			this.copiaMatrizMaiorParaMenor(mat,matmenor,linhaOuColunaParaCofator,contC);
			detTemp = matmenor.determinanteOtimizadoZero();
			resposta = resposta + (cofator * sinal * detTemp);
		}
		return (resposta);
		}
		
	}
	
	

	


	

}

class Main{
		
	public static void main(String[] args){
		Matriz mat1;
        int det;
        long inicio, fim, resultado;

        mat1 = new Matriz(4, 4);
        mat1.inicializaRandomico();

        mat1.imprime();
        inicio = System.currentTimeMillis();
        det = mat1.determinante();
        fim = System.currentTimeMillis();
        resultado = fim - inicio;
        System.out.println("Determinante:" + det);
        System.out.println("Tempo: " + resultado + " ms");

		mat1.encontraLinhaOuColunaParaCofator();

		// mat1.imprime();
        // inicio = System.currentTimeMillis();
        // det = mat1.determinanteOtimizacaoZeros();
        // fim = System.currentTimeMillis();
        // resultado = fim - inicio;
        // System.out.println("Determinante:" + det);
        // System.out.println("Tempo: " + resultado + " ms");
		
		
		
		
		/*
		
		array com as ordens [3,5,7,9,11,13]
		
		enquanto tiver ordem no array faca
			ordemMatriz = ordemDaVez
			
		 	para cada ordem faca
		 		cria a matriz com a ordem
		 		para cara repeticao faca	
		 			inicializa randomicamente com a ordem	
		 			calculaDet com metodoBase
		 			calculaDet com otimiV1
		 			calculaDet com otimiV2
		 		fim-para
		 	fim-para	
		 		

		*/


	}

}

class Main{
		
	public static void main(String[] args){
	// 	Matriz mat1;
    //     int det;
    //     long inicio, fim, resultado;

    //     mat1 = new Matriz(7, 7);
    //     mat1.inicializaRandomico();
		

	// System.out.println("----------Sem otimização---------------");

    //     mat1.imprime();
    //     inicio = System.currentTimeMillis();
    //     det = mat1.determinante();
    //     fim = System.currentTimeMillis();
    //     resultado = fim - inicio;
    //     System.out.println("Determinante:" + det);
    //     System.out.println("Tempo: " + resultado + " ms");

	// System.out.println("----------Otimização Dos Zeros---------------");

	// 	mat1.imprime();
    //     inicio = System.currentTimeMillis();
    //     det = mat1.determinanteOtimizadoZero();
    //     fim = System.currentTimeMillis();
    //     resultado = fim - inicio;
    //     System.out.println("Determinante:" + det);
    //     System.out.println("Tempo: " + resultado + " ms");

	// System.out.println("----------Otimização Das proporções---------------");

	// 	mat1.imprime();
    //     inicio = System.currentTimeMillis();
    //     det = mat1.determinanteOtimizadoProporcional();
    //     fim = System.currentTimeMillis();
    //     resultado = fim - inicio;
    //     System.out.println("Determinante:" + det);
    //     System.out.println("Tempo: " + resultado + " ms");
		
		
	Matriz matOrdens;
	matOrdens = new Matriz(1, 7);
	matOrdens.configuraMatrizDasOdens();
		
		int ordemDaVez;
		for(int j = 0; j < matOrdens.getTamanhoColuna() - 1; j++){
			ordemDaVez = matOrdens.getValor(0, j);
			System.out.println("--------------------------------------"+ ordemDaVez + "----------------------------------------");
			Matriz mat1;
        	int det;
			long inicio, fim, resultado;

       		mat1 = new Matriz(ordemDaVez, ordemDaVez);
        	mat1.inicializaRandomico();
		

			System.out.println("----------Sem otimização---------------");

				mat1.imprime();
				inicio = System.nanoTime();
				det = mat1.determinante();
				fim = System.nanoTime();
				resultado = fim - inicio;
				System.out.println("Determinante:" + det);
				System.out.println("Tempo: " + resultado + " nanoSegundos");

			System.out.println("----------Otimização Dos Zeros---------------");

				mat1.imprime();
				inicio = System.nanoTime();
				det = mat1.determinanteOtimizadoZero();
				fim = System.nanoTime();
				resultado = fim - inicio;
				System.out.println("Determinante:" + det);
				System.out.println("Tempo: " + resultado + " nanoSegundos");

			System.out.println("----------Otimização Das proporções---------------");

				mat1.imprime();
				inicio = System.nanoTime();
				det = mat1.determinanteOtimizadoProporcional();
				fim = System.nanoTime();
				resultado = fim - inicio;
				System.out.println("Determinante:" + det);
				System.out.println("Tempo: " + resultado + " nanoSegundos");
		}
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

import java.util.Scanner;
class Main{
		
	public static void main(String[] args){
	Scanner keyboard = new Scanner(System.in);
	
	System.out.println("------------------BEM VINDO A CALCULADORA DE DETERMINANTES----------------------\n\n" );	
	
	System.out.println("Escolha uma das opções: \n");
	System.out.println("1-Determinantes calculados em Milisegundos\n");
	System.out.println("2-Determinante calculado em NanoSegundos\n");
	int resposta = keyboard.nextInt();

	if (resposta == 1) {
	Matriz matOrdens;
	matOrdens = new Matriz(1, 6);
	matOrdens.configuraMatrizDasOdens();
		System.out.println("------------------DETERMINANTES CALCULADOS EM MILISEGUNDOS----------------------\n\n" );
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
				inicio = System.currentTimeMillis();
				det = mat1.determinante();
				fim = System.currentTimeMillis();
				resultado = fim - inicio;
				System.out.println("Determinante:" + det);
				System.out.println("Tempo: " + resultado + " miliSegundos");

			System.out.println("----------Otimização Dos Zeros---------------");

				mat1.imprime();
				inicio = System.currentTimeMillis();
				det = mat1.determinanteOtimizadoZero();
				fim = System.currentTimeMillis();
				resultado = fim - inicio;
				System.out.println("Determinante:" + det);
				System.out.println("Tempo: " + resultado + " miliSegundos");

			System.out.println("----------Otimização Das proporções---------------");

				mat1.imprime();
				inicio = System.currentTimeMillis();
				det = mat1.determinanteOtimizadoProporcional();
				fim = System.currentTimeMillis();
				resultado = fim - inicio;
				System.out.println("Determinante:" + det);
				System.out.println("Tempo: " + resultado + " miliSegundos");
		}
	}
	else if (resposta == 2) {
		System.out.println("------------------DETERMINANTES CALCULADOS EM NANOSEGUNDOS----------------------\n\n" );
	Matriz matOrdens;
	matOrdens = new Matriz(1, 6);
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
				System.out.println("Tempo: " + resultado + " nanosegundos");

			System.out.println("----------Otimização Dos Zeros---------------");

				mat1.imprime();
				inicio = System.nanoTime();
				det = mat1.determinanteOtimizadoZero();
				fim = System.nanoTime();
				resultado = fim - inicio;
				System.out.println("Determinante:" + det);
				System.out.println("Tempo: " + resultado + " nanosegundos");

			System.out.println("----------Otimização Das proporções---------------");

				mat1.imprime();
				inicio = System.nanoTime();
				det = mat1.determinanteOtimizadoProporcional();
				fim = System.nanoTime();
				resultado = fim - inicio;
				System.out.println("Determinante:" + det);
				System.out.println("Tempo: " + resultado + " nanosegundos");
		}

	}
	else{
		System.out.println("\nAlternativa não suportada\n");
	}
	System.out.println("\n\nPara voltar pro MENU digite java Main novamente em seu terminal\n");
	

	}

}

import java.util.Arrays;
import java.util.Scanner;

public class Teste {

    public static void main(String[] args) {
	System.out.println("Análise de Notas de Alunos com Vetores e Algoritmos de Ordenação");
	double[][] notas = inserirNotas("Insira as notas as notas para começar: ");
	boolean flag = true;
	while (flag) {
	    mapaOpcoes();
	    Scanner opcao = new Scanner(System.in);
	    int key = opcao.nextInt();
	    switch (key) {
	    case 1:
		imprimirMatriz(notas);
		break;
	    case 2:
		double[][] notas_ordenadas = ordenarMatriz(notas);
		imprimirMatriz(notas_ordenadas);
		break;
	    case 3:
		imprimirEstatisticas(notas);
		break;
	    case 4:
		System.out.println("DIGITAR O NUMERO DO ALUNO");
		int aluno = opcao.nextInt();
		calculaMediaaluno(notas, aluno);
		break;
	    case 5:
		calculaMediaturma(notas);
		break;
	    case 6:
		System.out.println("DIGITAR A NOTA DESEJADA");
		double nota = opcao.nextDouble();
		buscaNota(notas, nota);
		break;
	    case 7:
		flag = false;
		break;
	    default:
		System.out.println("Digite uma opção válida");
		break;
	    }
	}
    }

    public static double[][] inserirNotas(String mensagem) {
	System.out.println(mensagem);
	double[][] matriz = new double[10][3];
	Scanner scanner = new Scanner(System.in);

	for (int linha = 0; linha < matriz.length; linha++) {
	    for (int coluna = 0; coluna < matriz[0].length; coluna++) {
		System.out.println("Insira a nota do aluno: " + linha + " - da matéria: " + coluna + ": ");
		double notas = scanner.nextDouble();
		matriz[linha][coluna] = notas;
	    }
	}
	return matriz;
    }

    public static double[][] ordenarMatriz(double[][] matriz) {
	int totalElementos = matriz.length * matriz[0].length;
	double[] vetor = new double[totalElementos];
	int index = 0;

	for (int i = 0; i < matriz.length; i++) {
	    for (int j = 0; j < matriz[0].length; j++) {
		vetor[index] = matriz[i][j];
		index++;
	    }
	}

	Arrays.sort(vetor);

	double[][] matriz_ordenada = new double[matriz.length][matriz[0].length];
	index = 0;
	for (int i = 0; i < matriz_ordenada.length; i++) {
	    for (int j = 0; j < matriz_ordenada[0].length; j++) {
		matriz_ordenada[i][j] = vetor[index];
		index++;
	    }
	}

	return matriz_ordenada;
    }

    public static void buscaNota(double[][] matriz, double nota_procurada) {
	int aluno = 0;
	int materia = 0;
	for (int linha = 0; linha < matriz.length; linha++) {
	    for (int coluna = 0; coluna < matriz[0].length; coluna++) {
		if (matriz[linha][coluna] == nota_procurada) {
		    aluno = linha;
		    materia = coluna;
		    System.out.println("Nota encontrada - Aluno: " + linha + " Matéria: " + coluna);
		}
	    }
	}
    }

    public static void calculaMediaaluno(double[][] matriz, int aluno) {
	double acumulador = 0;
	double materias = matriz[0].length;
	double alunos = matriz.length;
	for (int linha = 0; linha < alunos; linha++) {
	    for (int coluna = 0; coluna < materias; coluna++) {
		if (linha == aluno) {
		    acumulador += matriz[linha][coluna];
		}
	    }
	}
	System.out.println("Média do aluno " + aluno + ": " + (acumulador / materias));
    }

    public static void calculaMediaturma(double[][] matriz) {
	double acumulador = 0;
	double acumulador_Medias = 0;
	double materias = matriz[0].length;
	double alunos = matriz.length;
	for (int linha = 0; linha < alunos; linha++) {
	    acumulador = 0;
	    for (int coluna = 0; coluna < materias; coluna++) {
		acumulador += matriz[linha][coluna];
	    }
	    acumulador_Medias += (acumulador / materias);
	}
	System.out.println("Média da Turma: " + (acumulador_Medias / alunos));
    }

    public static void imprimirMatriz(double[][] matriz) {
	for (int linha = 0; linha < matriz.length; linha++) {
	    for (int coluna = 0; coluna < matriz[0].length; coluna++) {
		System.out.print(matriz[linha][coluna]);
		System.out.print(" ");
	    }
	    System.out.println("");
	}
    }

    public static void imprimirEstatisticas(double[][] matriz) {
	double acumulador = 0;
	double acumulador_Medias = 0;
	double materias = matriz[0].length;
	double alunos = matriz.length;
	for (int linha = 0; linha < alunos; linha++) {
	    acumulador = 0;
	    double maior_Nota = 0;
	    double menor_Nota = 10;
	    for (int coluna = 0; coluna < materias; coluna++) {
		System.out.println("Notas do aluno " + linha + ": " + matriz[linha][coluna]);
		acumulador += matriz[linha][coluna];
		if (matriz[linha][coluna] > maior_Nota) {
		    maior_Nota = matriz[linha][coluna];
		}
		if (matriz[linha][coluna] < menor_Nota) {
		    menor_Nota = matriz[linha][coluna];
		}
	    }
	    System.out.println("Média do aluno " + linha + ": " + (acumulador / materias));
	    System.out.println("Maior nota do aluno " + linha + ": " + maior_Nota);
	    System.out.println("Menor nota do aluno " + linha + ": " + menor_Nota);
	    acumulador_Medias += (acumulador / materias);
	}
	System.out.println("Média da Turma: " + (acumulador_Medias / alunos));
    }

    public static void mapaOpcoes() {
	System.out.println("DIGITE 1: IMPRIMIR MATRIZ");
	System.out.println("DIGITE 2: IMPRIMIR MATRIZ ORDENADA");
	System.out.println("DIGITE 3: IMPRIMIR ESTATISTICAS GERAIS");
	System.out.println("DIGITE 4: CALCULA MÉDIA ALUNO");
	System.out.println("DIGITE 5: CALCULA MÉDIA TURMA");
	System.out.println("DIGITE 6: BUSCA DE NOTA");
	System.out.println("DIGITE 7: FECHAR O SISTEMA");
    }
}

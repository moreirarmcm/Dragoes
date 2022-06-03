package Brincadeira;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * C�digo hobbie "CRIA DRAG�ES"
 * 
 *  
 * H� 5 ra�as de drag�es: verdes, azuis, amarelos, vermelhos e pretos. Verde � a ra�a mais comum (inicial), preto � a mais rara.
 * Cada ra�a possui uma probabilidade de gerar filhotes de outras ra�as, seguindo a seguinte tabela (valores-padr�o de ra�a):
 *
 * 					Ra�a1	Ra�a2	Ra�a3	Ra�a4	Ra�a5
 * 	Prob. verde: 	80%		30%		10%		5%		1%
 * 	Prob. azul: 	15%		55%		25%		20%		9%
 * 	Prob. amarelo:	5%		15%		60%		45%		20%
 * 	Prob. vermelho:	0%		0%		10%		25%		40%
 * 	Prob. preto:	0%		5%		0%		0%		30%
 * 
 *   
 *  Para cada novo drag�o criado t�m-se a seguinte regra:
 *  	- caso a ra�a do drag�o "filhote" seja superior �s ra�as dos pais, o filhote recebe os valores-padr�o de probabilidade.
 *  	- caso a ra�a do filhote seja igual ou menor que as ra�as dos pais, o filhote receber� os valores dados pela m�dia dos 
 *  	valores dos pais, convertido para taxa percentual (em double).
 *  		ex: o drag�o Azul, filho dos drag�es Amarela e Vermelho, receber� os valores: Verde-7,32%	Azul-21,95%		Amarelo-51,22%		Vermelho-17,07%		Preto-2,44%
 *  			(a soma das taxas percentuais deve ser sempre = 100%).
 *  
 * @author Renan
 *
 */

public class Dragoes {
	public static void main(String[] args) {
		DecimalFormat df = new DecimalFormat("00.00"); // arredonda os doubles.
		df.setRoundingMode(RoundingMode.UP);
		Scanner sc = new Scanner(System.in); //Ap�s o print de uma gera��o, insira 0 (zero) para prosseguir para a pr�xima - valores diferentes de 0 encerram a execu��o.
		DragoesMethod dg = new DragoesMethod();
		List <DragoesMethod> dragao = new ArrayList<>();
		//variaveis para auxiliar o print
		int populacaoDragoes = dg.TamanhoAtualList(); // recebe 0 aqui
		int posicaoDragaoAtual = 0;
		int geracao = 1;
		dg.AdaoEva(); // cria os dois drag�es iniciais - um macho e uma f�mea.
		dg.NovoDragao(); // cria um drag�o filhote.
		populacaoDragoes = dg.TamanhoAtualList(); //DEVERIA receber 3 (macho, femea e filhote).
		System.out.println(geracao + "ra Gera��o -----------------------------------");
		
		for (posicaoDragaoAtual = 0; posicaoDragaoAtual < populacaoDragoes; posicaoDragaoAtual++) {
			dragao.clear();
			dragao.addAll(dg.dragao);
			System.out.println("Drag�o n� " + (posicaoDragaoAtual+1) + " | Tipo: " + dragao.get(posicaoDragaoAtual).raca + " | Sexo: " + dragao.get(posicaoDragaoAtual).sexo + " | probVerde: " + df.format(dragao.get(posicaoDragaoAtual).probVerde) + " | probAzul: " + df.format( dragao.get(posicaoDragaoAtual).probAzul ) + " | probAmarelo: " + df.format( dragao.get(posicaoDragaoAtual).probAmarelo) + 
					" | probVermelho: " + df.format( dragao.get(posicaoDragaoAtual).probVermelho) +" | probPreto " + df.format( dragao.get(posicaoDragaoAtual).probPreto) + " | Pai " + df.format( dragao.get(posicaoDragaoAtual).dragaoPai ) + " | M�e " + df.format( dragao.get(posicaoDragaoAtual).dragaoMae) );
			if (posicaoDragaoAtual == populacaoDragoes - 1) {
				int escolha = sc.nextInt(); 
				if (escolha == 0) {
					dg.NovoDragao();
					populacaoDragoes = dg.TamanhoAtualList();
					geracao++;
					System.out.println(geracao + "ra Gera��o -----------------------------------");
				}
			}
		}
	}
}
		
		
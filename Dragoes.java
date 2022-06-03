package Brincadeira;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * Código hobbie "CRIA DRAGÕES"
 * 
 *  
 * Há 5 raças de dragões: verdes, azuis, amarelos, vermelhos e pretos. Verde é a raça mais comum (inicial), preto é a mais rara.
 * Cada raça possui uma probabilidade de gerar filhotes de outras raças, seguindo a seguinte tabela (valores-padrão de raça):
 *
 * 					Raça1	Raça2	Raça3	Raça4	Raça5
 * 	Prob. verde: 	80%		30%		10%		5%		1%
 * 	Prob. azul: 	15%		55%		25%		20%		9%
 * 	Prob. amarelo:	5%		15%		60%		45%		20%
 * 	Prob. vermelho:	0%		0%		10%		25%		40%
 * 	Prob. preto:	0%		5%		0%		0%		30%
 * 
 *   
 *  Para cada novo dragão criado têm-se a seguinte regra:
 *  	- caso a raça do dragão "filhote" seja superior às raças dos pais, o filhote recebe os valores-padrão de probabilidade.
 *  	- caso a raça do filhote seja igual ou menor que as raças dos pais, o filhote receberá os valores dados pela média dos 
 *  	valores dos pais, convertido para taxa percentual (em double).
 *  		ex: o dragão Azul, filho dos dragões Amarela e Vermelho, receberá os valores: Verde-7,32%	Azul-21,95%		Amarelo-51,22%		Vermelho-17,07%		Preto-2,44%
 *  			(a soma das taxas percentuais deve ser sempre = 100%).
 *  
 * @author Renan
 *
 */

public class Dragoes {
	public static void main(String[] args) {
		DecimalFormat df = new DecimalFormat("00.00"); // arredonda os doubles.
		df.setRoundingMode(RoundingMode.UP);
		Scanner sc = new Scanner(System.in); //Após o print de uma geração, insira 0 (zero) para prosseguir para a próxima - valores diferentes de 0 encerram a execução.
		DragoesMethod dg = new DragoesMethod();
		List <DragoesMethod> dragao = new ArrayList<>();
		//variaveis para auxiliar o print
		int populacaoDragoes = dg.TamanhoAtualList(); // recebe 0 aqui
		int posicaoDragaoAtual = 0;
		int geracao = 1;
		dg.AdaoEva(); // cria os dois dragões iniciais - um macho e uma fêmea.
		dg.NovoDragao(); // cria um dragão filhote.
		populacaoDragoes = dg.TamanhoAtualList(); //DEVERIA receber 3 (macho, femea e filhote).
		System.out.println(geracao + "ra Geração -----------------------------------");
		
		for (posicaoDragaoAtual = 0; posicaoDragaoAtual < populacaoDragoes; posicaoDragaoAtual++) {
			dragao.clear();
			dragao.addAll(dg.dragao);
			System.out.println("Dragão n° " + (posicaoDragaoAtual+1) + " | Tipo: " + dragao.get(posicaoDragaoAtual).raca + " | Sexo: " + dragao.get(posicaoDragaoAtual).sexo + " | probVerde: " + df.format(dragao.get(posicaoDragaoAtual).probVerde) + " | probAzul: " + df.format( dragao.get(posicaoDragaoAtual).probAzul ) + " | probAmarelo: " + df.format( dragao.get(posicaoDragaoAtual).probAmarelo) + 
					" | probVermelho: " + df.format( dragao.get(posicaoDragaoAtual).probVermelho) +" | probPreto " + df.format( dragao.get(posicaoDragaoAtual).probPreto) + " | Pai " + df.format( dragao.get(posicaoDragaoAtual).dragaoPai ) + " | Mãe " + df.format( dragao.get(posicaoDragaoAtual).dragaoMae) );
			if (posicaoDragaoAtual == populacaoDragoes - 1) {
				int escolha = sc.nextInt(); 
				if (escolha == 0) {
					dg.NovoDragao();
					populacaoDragoes = dg.TamanhoAtualList();
					geracao++;
					System.out.println(geracao + "ra Geração -----------------------------------");
				}
			}
		}
	}
}
		
		
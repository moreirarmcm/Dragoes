package Brincadeira;

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
	int raca; 
	int sexo; 
	double probVerde;
	double probAzul;
	double probAmarelo;
	double probVermelho;
	double probPreto;
	double probBranco;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		DragoesMethod dg = new DragoesMethod();
		List <Dragoes> dragao = new ArrayList<>();
		dg.AdaoEva();
		//dragao.add((Dragoes) dg.dragao);
		int x = 1;
		for (int escolha = 0; escolha < 1; escolha=escolha) {
			dg.NovoDragao();
			dragao.clear();
			dragao.addAll(dg.dragao);
			escolha= sc.nextInt();
			if (escolha == 0) {
				System.out.println(x + "ra GERAÇÃO" );
				x++;
				for (int i = 0; i < dragao.size(); i++) {
					System.out.println ((i + 1) + "° dragão | " + "Tipo: " + dragao.get(i).raca +	" | Sexo: " + dragao.get(i).sexo + 
							" | probVerde: " + dragao.get(i).probVerde + " | probAzul: " + dragao.get(i).probAzul + " | probAmarelo: " + dragao.get(i).probAmarelo + 
							" | probVermelho: " + dragao.get(i).probVermelho +" | probPreto " + dragao.get(i).probPreto);
				}
			}
		}
	}
}
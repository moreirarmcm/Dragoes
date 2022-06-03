package Brincadeira;

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
				System.out.println(x + "ra GERA��O" );
				x++;
				for (int i = 0; i < dragao.size(); i++) {
					System.out.println ((i + 1) + "� drag�o | " + "Tipo: " + dragao.get(i).raca +	" | Sexo: " + dragao.get(i).sexo + 
							" | probVerde: " + dragao.get(i).probVerde + " | probAzul: " + dragao.get(i).probAzul + " | probAmarelo: " + dragao.get(i).probAmarelo + 
							" | probVermelho: " + dragao.get(i).probVermelho +" | probPreto " + dragao.get(i).probPreto);
				}
			}
		}
	}
}
package Brincadeira;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
/**
 * Descri��o do projeto na classe main "Dragoes"
 * Nessa classe estar�o alocados os m�todos para cria�ao e classifica��o dos drag�es.
 * 
 * @author Renan
 *
 */

public class DragoesMethod extends Dragoes {
	DragoesMethod [] criandoDragao = new DragoesMethod[3]; // Array para alocar os drag�es. Ser�o adicionados no List 'dragao' ap�s a cria�ao (2 espa�os para os iniciais, e um terceiro para todos os filhotes).
	List <DragoesMethod> dragao = new ArrayList<>();  
	Random r = new Random(); //Random para definir a ra�a dos drag�es criados (pode ser usado para definir o sexo tamb�m).
	
	int raca, sexo, dragaoPai = 0, dragaoMae = 0;
	double forca, probVerde, probAzul, probAmarelo, probVermelho, probPreto, probBranco;
	
	/**
	 * Metodo que retorna o List dragao
	 * 
	 * @return List <Dragoes> dragao;
	 */
	public List <DragoesMethod> ListaDragoes(int i){
		return dragao;
	}
	/**
	 * Retorna o tamanho atual do array dragao.
	 * @return dragao.size() - int.
	 */
	public int TamanhoAtualList() {
		return dragao.size();
	}
	
	/**
	 * M�todo que cria os drag�es iniciais: 'Ad�o e Eva'.
	 * Ambos s�o verdes, com as propriedades-padr�o da ra�a.
	 */
	public void AdaoEva() {
		criandoDragao[0] = new DragoesMethod();
		criandoDragao[1] = new DragoesMethod();
		criandoDragao[0].sexo = 0;
		criandoDragao[0].raca = 1;
		criandoDragao[1].sexo = 1;
		criandoDragao[1].raca = 1;
		RetornaProbabilidades(1, 0);
		dragao.add(criandoDragao[0]); // adiciona o primeiro objeto drag�o no List.
		RetornaProbabilidades(1, 1);
		dragao.add(criandoDragao[1]);
	}
	
	/**
	 * M�todo respons�vel por criar um novo drag�o.
	 * O la�o 'for' percorre todos os campos do List. Ao encontrar um drag�o f�mea, � selecionado um segundo drag�o usando uma vari�vel 
	 * rand�mica. Caso o drag�o selecionado seja macho, as posi��es de ambos ser�o passadas para o m�todo de defini��o gen�tica.
	 * 
	 * 
	 * P.S: Caso dragao.size() seja usado como par�metro no la�o, gera erro no resultado. Por essa raz�o foi usado um int tamanhoDaList
	 */
	public void NovoDragao() {
		int auxiliar; // recebe um int rand�mico, entre 0 e o tamanho do List (usado para refer�ncia de posi��o).
		int assassino;
		int auxiliar2;
		//	Double [] probGenetica = new Double[5];
		int tamanhoDaList = dragao.size(); 
		for (int i = 0; i < tamanhoDaList; i++) {
			auxiliar = r.nextInt(tamanhoDaList);
			if(dragao.get(i).sexo == 0) { // encontra f�mea
				while (dragao.get(auxiliar).sexo == 0) { // randomiza a vari�vel auxiliar at� encontrar um drag�o macho.
					auxiliar = r.nextInt(tamanhoDaList);
				}
				if (tamanhoDaList > 4) {
					auxiliar2 = r.nextInt(tamanhoDaList);
					while (dragao.get(auxiliar2).sexo == 0 || auxiliar2 == auxiliar) { // randomiza a vari�vel auxiliar at� encontrar um drag�o macho.
						auxiliar2 = r.nextInt(tamanhoDaList);
					}
					auxiliar = DisputandoForca(auxiliar, auxiliar2, 1);
				}
				DefinindoGenetica(i, auxiliar); // passa a posi��o dos dois drag�es selecionados e recebe um novo drag�o.
			}		
		}
		if (tamanhoDaList > 50) {
			double x = 0.35;
			if (tamanhoDaList > 1000) {
				x = 0.45;
			}
			if (tamanhoDaList >100000) {
				x = 0.5;
			}if (tamanhoDaList >200000) {
				x = 0.7;
			}	
			assassino = (int) ((int) tamanhoDaList*x);
			for (int y = 0; y < assassino; y++) {
				auxiliar = r.nextInt(tamanhoDaList);
				auxiliar2 = r.nextInt(tamanhoDaList);
				while (auxiliar2 == auxiliar) { // randomiza a vari�vel auxiliar at� encontrar um drag�o macho.
					auxiliar2 = r.nextInt(tamanhoDaList);
				}
				dragao.remove(DisputandoForca(auxiliar, auxiliar2, 0));
			}
			
		}	
	}
	/**
	 * M�todo que define ra�a e gen�tica do novo drag�o
	 * Primeiramente � feito o calculo da m�dia de par�metros dos pais,
	 * depois disso a ra�a � randomizada e, por fim, o array criandoDragao[3] 
	 * recebe os valores do novo drag�o.
	 * 
	 * @param mae - posi��o do drag�o f�mea no List 'dragao'.
	 * @param pai - posi��o do drag�o macho no List 'dragao'.
	 */
	public void DefinindoGenetica(int mae, int pai) {
		Double [][] probGenetica = new Double [6][2]; //recebe as probabilidades calculadas

		double verde = (dragao.get(mae).probVerde + dragao.get(pai).probVerde) / 2 ; //M�dia da taxa de probabilidade dos pais para ra�a verde.
		double azul = (dragao.get(mae).probAzul + dragao.get(pai).probAzul) / 2 ; //M�dia da taxa de probabilidade dos pais para ra�a azul.
		double amarelo = (dragao.get(mae).probAmarelo + dragao.get(pai).probAmarelo) / 2 ; //M�dia da taxa de probabilidade dos pais para ra�a amarela.
		double vermelho = (dragao.get(mae).probVermelho + dragao.get(pai).probVermelho) / 2 ; //M�dia da taxa de probabilidade dos pais para ra�a vermelha.
		double preto = (dragao.get(mae).probPreto + dragao.get(pai).probPreto) / 2 ; //M�dia da taxa de probabilidade dos pais para ra�a preta.
		double branco = (dragao.get(mae).probBranco + dragao.get(pai).probBranco) / 2 ; //M�dia da taxa de probabilidade dos pais para ra�a preta.
		double refForca = ((dragao.get(mae).forca + dragao.get(pai).forca) / 2) + (r.nextDouble()- 0.5) ; //M�dia da taxa de probabilidade dos pais para ra�a preta.
		double total = verde + azul + amarelo + vermelho + preto + branco; // Define a "base percentual" das probabilidades: para criar um novo drag�o � preciso equiparar cada taxa de prob. com as dos drag�es existentes. Por isso � necess�rio realizar uma convers�o simples.
			//double verdeNovo, azulNovo, amareloNovo, vermelhoNovo, pretoNovo;
		total = 100/total; //facilitando a convers�o.
			//valores das novas taxas de prob. j� convertidas para a base percentual.
		verde = verde * total; 
		azul = azul * total;
		amarelo = amarelo * total;
		vermelho = vermelho * total;
		preto = preto * total;
		branco = branco * total;
		probGenetica[0][0] = verde;
		probGenetica[0][1] = (double) 1;
		probGenetica[1][0] = azul;
		probGenetica[1][1] = (double) 2;
		probGenetica[2][0] = amarelo;
		probGenetica[2][1] = (double)3;
		probGenetica[3][0] = vermelho;
		probGenetica[3][1] = (double)4;
		probGenetica[4][0] = preto;
		probGenetica[4][1] = (double)5;
		probGenetica[5][0] = branco;
		probGenetica[5][1] =(double) 6;
		int racaEscolhida = OrganizandoDefinindoRaca(probGenetica);
		criandoDragao[2] = new DragoesMethod();
		criandoDragao[2].sexo = r.nextInt(2);
		criandoDragao[2].raca = racaEscolhida;
		if ( (racaEscolhida > dragao.get(mae).raca) && (racaEscolhida > dragao.get(pai).raca) ) {
			RetornaProbabilidades(racaEscolhida, 2);
		}else {
			criandoDragao[2].probVerde = verde;
			criandoDragao[2].probAzul = azul;
			criandoDragao[2].probAmarelo = amarelo;
			criandoDragao[2].probVermelho = vermelho;
			criandoDragao[2].probPreto = preto;	
			criandoDragao[2].probBranco = branco;	
			criandoDragao[2].forca = refForca;
		}
		criandoDragao[2].dragaoMae = mae;
		criandoDragao[2].dragaoPai = pai;	
		dragao.add(criandoDragao[2]);
	}
	
	/**
	 * /**
	 * M�todo que organiza as probabilidades (ordem decrescente) e define a ra�a do drag�o.
	 * 
	 * T�cnica de organiza��o - Bubble-short.
	 * 
	 * @param probGenetica[][]
	 * @return racaEscolhida - int
	 */
	public int OrganizandoDefinindoRaca(Double[][] probGenetica) {
		boolean reiniciar = false;
		for (int i = 5; i > 0; i--) {
			if (probGenetica[i][0] > probGenetica[i - 1][0]){
				double trocaProbGenetica = probGenetica[ i - 1][0]; // vari�vel auxiliar para realizar ordena��o do array double;
				double trocaReferenciaRaca = probGenetica[ i - 1][1]; // vari�vel auxiliar para realizar ordena��o do array string;
				probGenetica[i - 1][0] = probGenetica[i][0];
				probGenetica[i - 1][1] = probGenetica[i][1];
				probGenetica[i][0] = trocaProbGenetica;
				probGenetica[i][1] = trocaReferenciaRaca;
				reiniciar = true; // reinicia o la�o.
			}
			if ( (i <= 1) && (reiniciar == true) ) {
				i = 6; // 'reiniciar' � true sempre que houver altera��o de posi��o n array probReferencia. Se reiniciar = true, o loop reinicia. 
			    reiniciar = false;
			}
		}
		/*
		 * Definindo a Ra�a: com o array probGenetica ordenado EM ORDEM DECRESCENTE.
		 * Explica��o: a probabilidade � a quantidades de eventos (em 100) onde uma determinada
		 * condi��o � satisfeita. Considerando um drag�o verde, a probabilidade ser�: 80% para verde,
		 * 15% para azul e 5% para amarelo. Logo, o numero randomico (randomizandoPropriedade, inicio do m�todo)
		 * ser� 'verde' para valores de 0 a 79, azul para valores de 80-94, e amarelo para 95-99;
		 */
		double prob1 = probGenetica[0][0]; // prob1 recebe a maior taxa de probabilidade (0 at� a maior prob)
		double prob2 = prob1 + probGenetica[1][0]; //prob2 recebe a segunda maior taxa (acrescido de 0 para manter a sequ�ncia)
		double prob3 = prob2 + probGenetica[2][0];
		double prob4 = prob3 + probGenetica[3][0];
		double prob5 = prob4 + probGenetica[4][0];
		//double prob6 = prob5 + probGenetica2[5][0];
		int racaPalavra = 0;
		int random = r.nextInt(100); // recebe um int entre 0 e 99, que ser� usado para definir a ra�a.
		if ( (random >= 0) && (random < prob1) ){
			racaPalavra = (int) Math.round(probGenetica[0][1]);
		}else if ( (random >= prob1) && (random < prob2) ){
			racaPalavra = (int) Math.round(probGenetica[1][1]);
		}else if ( (random >= prob2) && (random < prob3) ){
			racaPalavra = (int) Math.round(probGenetica[2][1]);
		}else if ( (random >= prob3) && (random < prob4) ){
			racaPalavra = (int) Math.round(probGenetica[3][1]);
		}else if ( (random >=prob4) && (random < prob5) ){
			racaPalavra = (int) Math.round(probGenetica[4][1]);//� a quinta ra�a
		}else if ( (random >=prob5)){
			racaPalavra = (int) Math.round(probGenetica[5][1]);;//� a quinta ra�a
		}
		return racaPalavra;
	}

	public int DisputandoForca(int dragaoUm, int dragaoDois, int MelhouOuPior) {
		int dragaoVencedor = 0;
		int dragaoPerdedor = 0;
		if ( (dragao.get(dragaoUm).forca > dragao.get(dragaoDois).forca) || ((dragao.get(dragaoUm).forca == dragao.get(dragaoDois).forca) && (r.nextInt(2)==0)) ) {
			dragaoVencedor = dragaoUm;
			dragaoPerdedor = dragaoDois;
		} else if ( (dragao.get(dragaoUm).forca < dragao.get(dragaoDois).forca) || ((dragao.get(dragaoUm).forca == dragao.get(dragaoDois).forca) && (r.nextInt(2)== 1 )) ){
			dragaoVencedor = dragaoDois;
			dragaoPerdedor = dragaoUm;
		}
		if (MelhouOuPior == 1) {
			return dragaoVencedor;
		}else {
			return dragaoPerdedor;
		}
	}
	
	public void RetornaProbabilidades(int raca, int refPosicao) {
		if (raca == 1) {
			criandoDragao[refPosicao].probVerde = 80;
			criandoDragao[refPosicao].probAzul = 15;
			criandoDragao[refPosicao].probAmarelo = 5;
			criandoDragao[refPosicao].probVermelho = 0;
			criandoDragao[refPosicao].probPreto = 0;
			criandoDragao[refPosicao].probBranco = 0;
			criandoDragao[refPosicao].forca = 1;
		}else if (raca == 2) {
			criandoDragao[refPosicao].probVerde = 30;
			criandoDragao[refPosicao].probAzul = 50;
			criandoDragao[refPosicao].probAmarelo = 15;
			criandoDragao[refPosicao].probVermelho = 5;
			criandoDragao[refPosicao].probPreto = 0;
			criandoDragao[refPosicao].probBranco = 0;
			criandoDragao[refPosicao].forca = 1.25;
		}else if (raca == 3) {
			criandoDragao[refPosicao].probVerde = 10;
			criandoDragao[refPosicao].probAzul = 25;
			criandoDragao[refPosicao].probAmarelo = 50;
			criandoDragao[refPosicao].probVermelho = 15;
			criandoDragao[refPosicao].probPreto = 5;
			criandoDragao[refPosicao].probBranco = 0;
			criandoDragao[refPosicao].forca = 1.50;
		}else if (raca == 4) {
			criandoDragao[refPosicao].probVerde = 0;
			criandoDragao[refPosicao].probAzul = 19;
			criandoDragao[refPosicao].probAmarelo = 30;
			criandoDragao[refPosicao].probVermelho = 45;
			criandoDragao[refPosicao].probPreto = 5;
			criandoDragao[refPosicao].probBranco = 1;
			criandoDragao[refPosicao].forca = 1.75;
		}else if (raca == 5) {
			criandoDragao[refPosicao].probVerde = 0;
			criandoDragao[refPosicao].probAzul = 5;
			criandoDragao[refPosicao].probAmarelo = 20;
			criandoDragao[refPosicao].probVermelho = 40;
			criandoDragao[refPosicao].probPreto = 30;
			criandoDragao[refPosicao].probBranco = 5;
			criandoDragao[refPosicao].forca = 2;
		}else if (raca == 6) {
			criandoDragao[refPosicao].probVerde = 1;
			criandoDragao[refPosicao].probAzul = 2;
			criandoDragao[refPosicao].probAmarelo = 3;
			criandoDragao[refPosicao].probVermelho = 4;
			criandoDragao[refPosicao].probPreto = 15;
			criandoDragao[refPosicao].probBranco = 75;
			criandoDragao[refPosicao].forca = 3;
		}
	}
}
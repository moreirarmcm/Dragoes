package Brincadeira;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
/**
 * Descrição do projeto na classe main "Dragões"
 * Nessa classe estarão alocados os métodos para criaçao e classificação dos dragões.
 * 
 * 
 * @author Renan
 *
 */

public class DragoesMethod extends Dragoes {
	
	Dragoes [] criandoDragao = new Dragoes[3]; // Array para alocar os dragões. Serão adicionados no List 'dragao' após a criaçao (2 espaços para os iniciais, e um terceiro para todos os filhotes).
	List <Dragoes> dragao = new ArrayList<>();  
	Random r = new Random(); //Random para definir a raça dos dragões criados (pode ser usado para definir o sexo também).
	
	/**
	 * Metodo que retorna o List dragao
	 * 
	 * @return List <Dragoes> dragao;
	 */
	public List <Dragoes> ListaDragoes(){
		return this.dragao;
	}
	
	
	/**
	 * Método que cria os dragões iniciais: 'Adão e Eva'.
	 * Ambos são verdes, com as propriedades-padrão da raça.
	 */
	public void AdaoEva() {
		criandoDragao[0] = new Dragoes();
		criandoDragao[1] = new Dragoes();
		//O objeto recebe os valores iniciais.
		criandoDragao[0].sexo = 0;
		criandoDragao[0].raca = 1;
		criandoDragao[0].probVerde = ProbabilidadeVerde(1);
		criandoDragao[0].probAzul = ProbabilidadeAzul(1);
		criandoDragao[0].probAmarelo = ProbabilidadeAmarelo(1);
		criandoDragao[0].probVermelho = ProbabilidadeVermelho(1);
		criandoDragao[0].probPreto = ProbabilidadePreto(1);
		dragao.add(criandoDragao[0]); // adiciona o primeiro objeto dragão no List.
		criandoDragao[1].sexo = 1;
		criandoDragao[1].raca = 1;
		criandoDragao[1].probVerde = ProbabilidadeVerde(1);
		criandoDragao[1].probAzul = ProbabilidadeAzul(1);
		criandoDragao[1].probAmarelo = ProbabilidadeAmarelo(1);
		criandoDragao[1].probVermelho = ProbabilidadeVermelho(1);
		criandoDragao[1].probPreto = ProbabilidadePreto(1);
		dragao.add(criandoDragao[1]);
	}
	
	/**
	 * Método responsável por criar um novo dragão.
	 * O laço 'for' percorre todos os campos do List. Ao encontrar um dragão fêmea, é selecionado um segundo dragão usando uma variável 
	 * randômica. Caso o dragão selecionado seja macho, as posições de ambos serão passadas para o método de definição genética.
	 */
	public void NovoDragao() {
		int auxiliar = r.nextInt(dragao.size()); // recebe um int randômico, entre 0 e o tamanho do List (usado para referência de posição).
		Double [] probGenetica = new Double[5];
		for (int i = 0; i < dragao.size(); i++) {
			if(dragao.get(i).sexo %2 == 0) { // encontra fêmea
				while (dragao.get(auxiliar).sexo %2 ==0) { // randomiza a variável auxiliar até encontrar um dragão macho.
					auxiliar = r.nextInt(dragao.size());
				}
				dragao.add(DefinindoGenetica(i, auxiliar)); // passa a posição dos dois dragões selecionados e recebe um novo dragão.
			}
		}
	}
	
	/**
	 * Método que define raça e genética do novo dragão
	 * Primeiramente é feito o calculo da média de parâmetros dos pais,
	 * depois disso a raça é randomizada e, por fim, o array criandoDragao[3] 
	 * recebe os valores do novo dragão.
	 * 
	 * @param mae - posição do dragão fêmea no List 'dragao'.
	 * @param pai - posição do dragão macho no List 'dragao'.
	 */
	public Dragoes DefinindoGenetica(int mae, int pai) {
		Double [] probGenetica = new Double[5]; //recebe as probabilidades calculadas
		double verde = (dragao.get(mae).probVerde + dragao.get(pai).probVerde) / 2 ; //Média da taxa de probabilidade dos pais para raça verde.
		double azul = (dragao.get(mae).probAzul + dragao.get(pai).probAzul) / 2 ; //Média da taxa de probabilidade dos pais para raça azul.
		double amarelo = (dragao.get(mae).probAmarelo + dragao.get(pai).probAmarelo) / 2 ; //Média da taxa de probabilidade dos pais para raça amarela.
		double vermelho = (dragao.get(mae).probVermelho + dragao.get(pai).probVermelho) / 2 ; //Média da taxa de probabilidade dos pais para raça vermelha.
		double preto = (dragao.get(mae).probPreto + dragao.get(pai).probPreto) / 2 ; //Média da taxa de probabilidade dos pais para raça preta.
		double total = verde + azul + amarelo + vermelho + preto; // Define a "base percentual" das probabilidades: para criar um novo dragão é preciso equiparar cada taxa de prob. com as dos dragões existentes. Por isso é necessário realizar uma conversão simples.
			//double verdeNovo, azulNovo, amareloNovo, vermelhoNovo, pretoNovo;
		total = 100/total; //facilitando a conversão.
			//valores das novas taxas de prob. já convertidas para a base percentual.
		verde = verde * total; 
		azul = azul * total;
		amarelo = amarelo * total;
		vermelho = vermelho * total;
		preto = preto * total;
		probGenetica[0] = verde;
		probGenetica[1] = azul;
		probGenetica[2] = amarelo;
		probGenetica[3] = vermelho;
		probGenetica[4] = preto;
		int racaEscolhida = OrganizandoDefinindoRaca(probGenetica);

		criandoDragao[2] = new Dragoes();
		criandoDragao[2].sexo = r.nextInt(2);
		criandoDragao[2].raca = racaEscolhida;
		
		if ( (racaEscolhida > dragao.get(mae).raca) && (racaEscolhida > dragao.get(pai).raca) ) {
			criandoDragao[2].probVerde = ProbabilidadeVerde(racaEscolhida);
			criandoDragao[2].probAzul = ProbabilidadeAzul(racaEscolhida);
			criandoDragao[2].probAmarelo = ProbabilidadeAmarelo(racaEscolhida);
			criandoDragao[2].probVermelho = ProbabilidadeVermelho(racaEscolhida);
			criandoDragao[2].probPreto = ProbabilidadePreto(racaEscolhida);
		}else {
			criandoDragao[2].probVerde = verde;
			criandoDragao[2].probAzul = azul;
			criandoDragao[2].probAmarelo = amarelo;
			criandoDragao[2].probVermelho = vermelho;
			criandoDragao[2].probPreto = preto;	
		}
		return criandoDragao[2];
	}
	
	/**
	 * Método que organiza as probabilidades (ordem decrescente) e define a raça do dragão.
	 * 
	 * Técnica de organização - Bubble-short.
	 * 
	 * Após a organização não é possível saber quais probabilidades ocupam cada espaço e, por esse motivo,
	 * um novo array é usado para referência.
	 * 
	 * @param probGenetica - array com todas as probabilidades genéticas.
	 * @return
	 */
	public int OrganizandoDefinindoRaca(Double[] probGenetica) {
		int randomizandoProbabilidade = r.nextInt(100); // recebe um int entre 0 e 99, que será usado para definir a raça.
		String [] referenciaRaca = new String[5];
		String racaPalavra = null;
		int racaNumero = 0;
		referenciaRaca[0] = "verde";
		referenciaRaca[1] = "azul";
		referenciaRaca[2] = "amarelo";
		referenciaRaca[3] = "vermelho";
		referenciaRaca[4] = "preto";

		/*
		 * trecho copiado do codigo Filmes - alterado para ordenação em ordem decrescente (não testado).
		 */
		boolean reiniciar = false;
		for (int i = 4; i > 0; i--) {
			if (probGenetica[i] > probGenetica[i - 1] ){
				double trocaProbGenetica = probGenetica[ i - 1]; // variável auxiliar para realizar ordenação do array double;
				String trocaReferenciaRaca = referenciaRaca[i - 1]; // variável auxiliar para realizar ordenação do array string;
				probGenetica[i - 1] = probGenetica[i];
				referenciaRaca[i - 1] = referenciaRaca[i];
				probGenetica[i] = trocaProbGenetica;
				referenciaRaca[i] = trocaReferenciaRaca;
				reiniciar = true; // reinicia o laço.
			}
			if ( (i <= 1) && (reiniciar == true) ) {
				i = 5; // 'reiniciar' é true sempre que houver alteração de posição n array probReferencia. Se reiniciar = true, o loop reinicia. 
			    reiniciar = false;
			}
		}
		
		/**
		 * Definindo a Raça: com o array probGenetica ordenado EM ORDEM DECRESCENTE.
		 * Explicação: a probabilidade é a quantidades de eventos (em 100) onde uma determinada
		 * condição é satisfeita. Considerando um dragão verde, a probabilidade será: 80% para verde,
		 * 15% para azul e 5% para amarelo. Logo, o numero randomico (randomizandoPropriedade, inicio do método)
		 * será 'verde' para valores de 0 a 79, azul para valores de 80-94, e amarelo para 95-99;
		 */
		double prob1 = probGenetica[0]; // prob1 recebe a maior taxa de probabilidade (0 até a maior prob)
		double prob2 = prob1 + probGenetica[1]; //prob2 recebe a segunda maior taxa (acrescido de 0 para manter a sequência)
		double prob3 = prob2 +probGenetica[2];
		double prob4 = prob3 + probGenetica[3];
		double prob5 = prob4 + probGenetica[4];
				
				//Veja comentário acima
		if ( (randomizandoProbabilidade >= 0) && (randomizandoProbabilidade < prob1) ){
			racaPalavra = referenciaRaca[0];//é a primeira raça 
		}else if ( (randomizandoProbabilidade >= prob1) && (randomizandoProbabilidade < prob2) ){
			racaPalavra = referenciaRaca[1];//é a segunda raça
		}else if ( (randomizandoProbabilidade >= prob2) && (randomizandoProbabilidade < prob3) ){
			racaPalavra = referenciaRaca[2];//é a terceira raça
		}else if ( (randomizandoProbabilidade >= prob3) && (randomizandoProbabilidade < prob4) ){
			racaPalavra = referenciaRaca[3];//é a quarta raça
		}else if ( (randomizandoProbabilidade >=prob4) && (randomizandoProbabilidade < prob5) ){
			racaPalavra = referenciaRaca[4];//é a quinta raça
		}
		
		/*Definida a raça, na string racaPalavra, agora é feita uma verificação e mudança de referência ('raça', em string, é 
		 * alterada para int.
		*/
		switch (racaPalavra) {
			case "verde": {
				racaNumero = 1;
				break;
			}case "azul": {
				racaNumero = 2;
				break;
			}case "amarelo": {
				racaNumero = 3;
				break;
			}case "vermelho": {
				racaNumero = 4;
				break;
			}case "preto": {
				racaNumero = 5;
				break;
			}
		}
		
		return racaNumero;
	}
	
	
	/**
	 * Daqui pra baixo os métodos são todos referentes à probabilidade da raça (Está ruim, melhore)
	 * 
	 * Raça 1 - V-80%	A-15%	A-5%	V-0%	P-0%
	 * Raça 2 - V-30%	A-55%	A-15%	V-0%	P-0%
	 * Raça 3 - V-10%	A-25%	A-60%	V-10%	P-0%
	 * Raça 4 - V-5%	A-20%	A-45%	V-25%	P-5%
	 * Raça 5 - V-%0	A-9%	A-40%	V-30%	P-20%	 B - 1%
	 * 
	 * @param raca
	 * @return
	 */
	public double ProbabilidadeVerde(int raca) {
		double verde = 0;
		switch (raca) {
			case 1: {
				verde = 80;
				break;
			}
			case 2:{
				verde = 30;	
				break;
			}
			case 3 : { 				
				verde = 10;	
				break;
			}
			case 4: {
				verde = 5;
				break;
			}
			case 5: {
				verde = 1;
				break;
			}
			default:
				verde = 0;
				break;
		}
		return verde;
	}
	
	public double ProbabilidadeAzul(int raca) {
		double azul = 0;
		switch (raca) {
			case 1: {
				azul = 15;
				break;
			}
			case 2:{
				azul = 55;	
				break;
			}
			case 3 : { 				
				azul = 25;	
				break;
			}
			case 4: {
				azul = 20;
				break;
			}
			case 5: {
				azul = 9;
				break;
			}
			default:
				azul = 0;
				break;
		}
		return azul;
	}
	
	public double ProbabilidadeAmarelo(int raca) {
		double amarelo = 0;
		switch (raca) {
			case 1: {
				amarelo = 5;
				break;
			}
			case 2:{
				amarelo = 15;	
				break;
			}
			case 3 : { 				
				amarelo = 60;	
				break;
			}
			case 4: {
				amarelo = 45;
				break;
			}
			case 5: {
				amarelo = 20;
				break;
			}
			default:
				amarelo = 0;
				break;
		}
		return amarelo;
	}
	
	public double ProbabilidadeVermelho(int raca) {
		double vermelho = 0;
		switch (raca) {
			case 1: {
				vermelho = 0;
				break;
			}
			case 2:{
				vermelho = 0;	
				break;
			}
			case 3 : { 				
				vermelho = 10;	
				break;
			}
			case 4: {
				vermelho = 25;
				break;
			}
			case 5: {
				vermelho = 40;
				break;
			}
			default:
				vermelho = 0;
				break;
		}
		return vermelho;
	}
	
	public double ProbabilidadePreto(int raca) {
		double preto = 0;
		switch (raca) {
			case 1: {
				preto = 0;
				break;
			}
			case 2:{
				preto = 0;	
				break;
			}
			case 3 : { 				
				preto = 0;	
				break;
			}
			case 4: {
				preto = 5;
				break;
			}
			case 5: {
				preto = 30;
				break;
			}
			default:
				preto = 0;
				break;
		}
		return preto;
	}
	
}
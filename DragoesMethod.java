package Brincadeira;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DragoesMethod extends Dragoes {
	Dragoes [] dragao;
	List <Dragoes> dragao2; 
	Random r = new Random();
	
	public Dragoes [] DragaoTodo() {
		return dragao;
	}
	public List <Dragoes> Dragao2Todo(){
		return dragao2;
	}
	/**
	 * Inicializa o array dragao, com o parâmetro dado pelo usuário
	 * 
	 * @param tamanho
	 */
	public void População(int tamanho) {
		dragao = new Dragoes[tamanho];
		dragao2 = new ArrayList<>();
	}
	
	/**
	 * Como fazer com que os metodos de probabilidade tragam todas as características de uma raça? (de uma só vez...)
	 */
	public void AdaoEva() {
		dragao[0] = new Dragoes();
		dragao[1] = new Dragoes();
		
		dragao[0].sexo = 0;
		dragao[0].raca = 1;
		dragao[0].probVerde = ProbabilidadeVerde(1);
		dragao[0].probAzul = ProbabilidadeAzul(1);
		dragao[0].probAmarelo = ProbabilidadeAmarelo(1);
		dragao[0].probVermelho = ProbabilidadeVermelho(1);
		dragao[0].probPreto = ProbabilidadePreto(1);
		
		dragao2.add(dragao[0]);

		dragao[1].sexo = 1;
		dragao[1].raca = 1;
		dragao[1].probVerde = ProbabilidadeVerde(1);
		dragao[1].probAzul = ProbabilidadeAzul(1);
		dragao[1].probAmarelo = ProbabilidadeAmarelo(1);
		dragao[1].probVermelho = ProbabilidadeVermelho(1);
		dragao[1].probPreto = ProbabilidadePreto(1);
		
		dragao2.add(dragao[1]);
	}
	public void CriaDragao() {
		
		int y = r.nextInt(dragao2.size());
		for (int i = 0; i < dragao2.size(); i++) {
			if(dragao2.get(i).sexo %2 == 0) {
				while (dragao2.get(y).sexo %2 ==0) {
					y = r.nextInt(dragao2.size());
				}
			}
			DefineGenetica(i, y);
		}
	}
	public String BubbleShortERodaRaca(double verdeNovo, double azulNovo, double amareloNovo, double vermelhoNovo, double pretoNovo) {
				
		Double [] d = new Double[5];
		String [] s = new String[5];
		d[0] = new Double(verdeNovo);
		s[0] = new String("verde");
		
		d[1] = new Double(azulNovo);
		s[1] = new String("azul");
		
		d[2] = new Double(amareloNovo);
		s[2] = new String("amarelo");
		
		d[3] = new Double(vermelhoNovo);
		s[3] = new String("vermelho");
		
		d[4] = new Double(pretoNovo);
		s[4] = new String("preto");

		/**
		 * trecho copiado do codigo Filmes
		 */
		boolean reiniciar = false;
		for (int i = 0; i < 4; i++) {
			if (d[i] > d[i+1] ){
				double trocarPosicao = d[i+1]; // variável auxiliar para realizar ordenação.
				String trocaPosicao = s[i+1];
				
				d[i+1] = d[i];
				s[i+1] = s[i];
				
				d[i] = trocarPosicao;
				s[i] = trocaPosicao;

				reiniciar = true;
			}
			if ( (i >= 3) && (reiniciar == true) ) {
				i = -1; // reincia o loop for (a variável "reiniciar" define se o houve alteração de posição na list. Se reiniciar = true, o loop reinicia 
			    reiniciar = false;
			}
		}
		/**
		 * G A M B I A R R A
		 */
		int y = r.nextInt(100);
		double p1 = d[0], p2 = p1 + d[1], p3 = p2 + d[2], p4 = p3 + d[3], p5 = p4 + d[4];
		String raca = null;
		int resultadoRaca = 0;
		if ( (y >= 0) && (y < p1) ){
			raca = s[0];//é a primeira raça
		}else if ( (y > p1) && (y < p2) ){
			raca = s[1];//é a segunda raça
		}else if ( (y > p2) && (y < p3) ){
			raca = s[2];//é a terceira raça
		}else if ( (y > p3) && (y < p4) ){
			raca = s[3];//é a quarta raça
		}else if ( (y > p4) && (y < p5) ){
			raca = s[4];//é a quinta raça
		}
		return raca;
	}
	
	public void DefineGenetica(int refMae, int refPai) {
		double verde, azul, amarelo, vermelho, preto, total;
		double verdeNovo, azulNovo, amareloNovo, vermelhoNovo, pretoNovo;
		verde = (dragao2.get(refMae).probVerde + dragao2.get(refPai).probVerde) / 2 ;
		azul = (dragao2.get(refMae).probAzul + dragao2.get(refPai).probAzul) / 2 ;
		amarelo = (dragao2.get(refMae).probAmarelo + dragao2.get(refPai).probAmarelo) / 2 ;
		vermelho = (dragao2.get(refMae).probVermelho + dragao2.get(refPai).probVermelho) / 2 ;
		preto = (dragao2.get(refMae).probPreto + dragao2.get(refPai).probPreto) / 2 ;
		
		total = verde+azul+amarelo+vermelho+preto;
		
		verdeNovo = (verde*100)/total;
		azulNovo = (azul*100)/total;
		amareloNovo = (amarelo*100)/total;
		vermelhoNovo = (vermelho*100)/total;
		pretoNovo = (preto*100)/total;
		
		
		String raca = BubbleShortERodaRaca(verdeNovo, azulNovo, amareloNovo, vermelhoNovo, pretoNovo);
		int racaNum = 0;
		switch (raca) {
			case "verde": {
				racaNum = 1;
			}case "azul": {
				racaNum = 2;
			}case "amarelo": {
				racaNum = 3;
			}case "vermelho": {
				racaNum = 4;
			}case "preto": {
				racaNum = 5;
			}
		}
		dragao[0] = null;
		dragao[0] = new Dragoes();
		dragao[0].sexo = r.nextInt(2);
		dragao[0].raca = racaNum;
		
		if ( (racaNum > dragao2.get(refMae).raca) || (racaNum > dragao2.get(refPai).raca) ) {
			dragao[0].probVerde = ProbabilidadeVerde(racaNum);
			dragao[0].probAzul = ProbabilidadeAzul(racaNum);
			dragao[0].probAmarelo = ProbabilidadeAmarelo(racaNum);
			dragao[0].probVermelho = ProbabilidadeVermelho(racaNum);
			dragao[0].probPreto = ProbabilidadePreto(racaNum);
		}else {
			dragao[0].probVerde = verdeNovo;
			dragao[0].probAzul = azulNovo;
			dragao[0].probAmarelo = amareloNovo;
			dragao[0].probVermelho = vermelhoNovo;
			dragao[0].probPreto = pretoNovo;	
		}
		dragao2.add(dragao[0]);	
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
				amarelo = 40;
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
				vermelho = 30;
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
				preto = 20;
				break;
			}
			default:
				preto = 0;
				break;
		}
		return preto;
	}
}
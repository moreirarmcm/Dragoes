package Brincadeira;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * Codigo "hobbie" 
 * Cria "dragoes", com caracteristicas especificas, e os reproduz.
 * 
 * Verde - V-80%	A-15%	A-5%	V-0%	P-0%
 * Azul - V-30%	A-55%	A-15%	V-0%	P-0%
 * Amarelo - V-10%	A-25%	A-60%	V-10%	P-0%
 * Vermelho - V-5%	A-20%	A-45%	V-25%	P-5%
 * Preto - V-%	A-9%	A-40%	V-30%	P-20% B - 1%
 * 
 * @author Renan
 *
 */

public class Dragoes {
	
	int raca; // raça = verde, azul, amarelo, vermelho e preto. raca recebe 1-5; 
	int sexo; // 0 para fêmea, 1 para macho.
	double probVerde;
	double probAzul;
	double probAmarelo;
	double probVermelho;
	double probPreto;
	double probBranco;
	
	public static void main(String[] args) {
		//Scanner sc = new Scanner(System.in);
		DragoesMethod dg = new DragoesMethod();
		List <Dragoes> dragao2;
		dg.População(10000);
		dg.AdaoEva();
		dragao2 = dg.Dragao2Todo();
		for (int i = 0; i< dragao2.size(); i++) {
			System.out.println((i+1) + "° ----" + dragao2.get(i).raca + "----" + dragao2.get(i).sexo);

		}

		dg.CriaDragao();
		//Dragoes [] dragao = dg.DragaoTodo();
		 dragao2 = dg.Dragao2Todo();
		
	//	System.out.println(dragao2.get(0).sexo);
		
	}
}
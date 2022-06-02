package Brincadeira;

import java.util.ArrayList;
import java.util.List;

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
public class Dragoes extends DragoesMetodos {
	public static void main(String[] args) {
		Dragoes dg = new Dragoes();
		List <Dragoes> dragao = new ArrayList<>();
		
		dg.setRaca(1);
		dg.setSexo(0);
		dragao.add(dg);
		dg.setRaca(1);
		dg.setSexo(1);
		
		
	}	
}

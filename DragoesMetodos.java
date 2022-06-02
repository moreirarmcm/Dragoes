package Brincadeira;

public class DragoesMetodos {
	private int raca; // raça = verde, azul, amarelo, vermelho e preto. raca recebe 1-5; 
	private int sexo; // 0 para fêmea, 1 para macho.
	private double probVerde;
	private double probAzul;
	private double probAmarelo;
	private double probVermelho;
	private double probPreto;
	private double probBranco;
	
	public int getRaca() {
		return raca;
	}
	public void setRaca(int raca) {
		this.raca = raca;
		ProbabilidadeRaca(raca);
	}
	public int getSexo() {
		return sexo;
	}
	public void setSexo(int sexo) {
		this.sexo = sexo;
	}
	
	public void criaDragao() {
		
	}
	
	
	public double ProbabilidadeRaca(int raca) {
		switch (raca) {
			case 1 : {
				this.probVerde = 0.80;	
				this.probAzul = 0.15;	
				this.probAmarelo = 0.05;	
				this.probVermelho = 0.00;	
				this.probPreto = 0.00;	
				this.probBranco = 0.00;
				break;
			}case 2 : {
				this.probVerde = 0.30;	
				this.probAzul = 0.55;	
				this.probAmarelo = 0.15;	
				this.probVermelho = 0.00;	
				this.probPreto = 0.00;	
				this.probBranco = 0.00;
				break;
			}
			case 3 : {				
				this.probVerde = 0.10;	
				this.probAzul = 0.25;	
				this.probAmarelo = 0.60;	
				this.probVermelho = 0.10;	
				this.probPreto = 0.00;	
				this.probBranco = 0.00;
				break;
			}case 4 : {
				this.probVerde = 0.05;	
				this.probAzul = 0.20;	
				this.probAmarelo = 0.45;	
				this.probVermelho = 0.25;	
				this.probPreto = 0.05;	
				this.probBranco = 0.00;
				break;
			}case 5 : {
				this.probVerde = 0.00;	
				this.probAzul = 0.09;	
				this.probAmarelo = 0.40;	
				this.probVermelho = 0.30;	
				this.probPreto = 0.20;
				this.probBranco = 0.01;
				break;
			}
		}
		return 0;
	}
}

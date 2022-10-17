package src;

public abstract class Usina {

	private String nome;

	private double producaoMWh;

	private double custoMWh;


	public Usina(String n, double producaoMWh, double custoMWh){
		this.custoMWh = custoMWh;
		this.producaoMWh = producaoMWh;
		nome = n;
	}

	public String getNome() {
		return nome;
	}

	public double getProducaoMWh() {
		return producaoMWh;
	}

	public double getCustoMWh() {
		return custoMWh;
	}

	//setters

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setProducaoMWh(double producaoMWh) {
		this.producaoMWh = producaoMWh;
	}

	public void setCustoMWh(double custoMWh) {
		this.custoMWh = custoMWh;
	}


	public abstract double calculaPrecoMWh();

	public abstract String geraResumo();

	public abstract String toString();

}

package src;

public class UsinaNaoRenovavel extends Usina{

    String combustivel;

    int durabilidade;

    public UsinaNaoRenovavel(String n,double producaoMWH, double custoMWH,String combustivel){
        super(n,producaoMWH,custoMWH);

        if(combustivel.equalsIgnoreCase("petróleo")){
            this.combustivel = combustivel;
            durabilidade = 43;
        }
        else if (combustivel.equalsIgnoreCase("carvão")){
            this.combustivel = combustivel;
            durabilidade = 54;
        }
        else if(combustivel.equalsIgnoreCase("nuclear")){
            this.combustivel = combustivel;
            durabilidade = 48;
        }
        else{
            this.combustivel = "petróleo";
            durabilidade = 45;
        }
    }


    public String getCombustivel() {
        return combustivel;
    }

    public void setCombustivel(String combustivel) {
        this.combustivel = combustivel;
    }

    public int getDurabilidade() {
        return durabilidade;
    }

    public void setDurabilidade(int durabilidade) {
        this.durabilidade = durabilidade;
    }



    public String toString(){
        return "Tipo de usina: não renovável\n"+ "Nome: "+ getNome() + "\n" + "Produção de MWh: " + getProducaoMWh() + "\n"+ "Custo de MWh desta usina: " + getCustoMWh() +
                " R$ \n" + "Preço do MWh: "+ calculaPrecoMWh()+ " R$ \n"+"Tipo de combustível da usina: " + getCombustivel() + "\n" + "Durabilidade do combustível fóssil: " + getDurabilidade()+"\n";
    }





    @Override
    public double calculaPrecoMWh() {
        double acrecscimo =0;
        double valor = getCustoMWh();

        if(combustivel.equalsIgnoreCase("petróleo")){
            acrecscimo = (getCustoMWh() /100.00) * 30;
            valor = valor + acrecscimo;
        }
        else if(combustivel.equalsIgnoreCase("carvão")) {
            acrecscimo = (getCustoMWh() / 100.00) * 20;
            valor = valor + acrecscimo;
        }
        else if (combustivel.equalsIgnoreCase("nuclear")) {
            acrecscimo = (getCustoMWh() / 100.00) * 10;
            valor = valor + acrecscimo;
        }
        return valor;
    }

    @Override
    public String geraResumo() {
        String s = "2;"+getNome()+";"+getProducaoMWh()+";"+getCustoMWh()+";"+getCombustivel()+";"+getDurabilidade();
        return s;
    }










}


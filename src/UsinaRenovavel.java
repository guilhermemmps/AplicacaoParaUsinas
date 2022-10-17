package src;

public class UsinaRenovavel extends Usina{

    String fonte;

    public UsinaRenovavel(String nome, double producaoMWH, double custoMWH, String fonte){
        super(nome,producaoMWH,custoMWH);
        if(fonte.equalsIgnoreCase("solar") || fonte.equalsIgnoreCase("eólica") || fonte.equalsIgnoreCase("hídrica")){
            this.fonte = fonte;
        }
        else this.fonte = "solar";
    }

    public String getFonte() {
        return fonte;
    }

    public void setFonte(String fonte) {
        this.fonte = fonte;
    }

    public String toString(){
        return "Tipo de usina: renovável\n"+ "Nome: "+ getNome() + "\n" + "Produção de MWh: " + getProducaoMWh() + "\n"+"Custo de MWh desta usina: " + getCustoMWh() +
                " R$ \n" + "Preço do Mwh desta usina: "+ calculaPrecoMWh()+ " R$ \n"+ "Tipo de fonte da usina: " + getFonte() +"\n";
    }





    @Override
    public double calculaPrecoMWh() {
        double acrecscimo =0;
        double valor = getCustoMWh();

        if(fonte.equalsIgnoreCase("solar")){
            acrecscimo = (getCustoMWh() /100.00) * 25;
            valor = valor + acrecscimo;
        }
        else if(fonte.equalsIgnoreCase("eólica")) {
            acrecscimo = (getCustoMWh() / 100.00) * 15;
            valor = valor + acrecscimo;
        }
        else if (fonte.equalsIgnoreCase("hídrica")) {
            acrecscimo = (getCustoMWh() / 100.00) * 5;
            valor = valor + acrecscimo;
        }
        return valor;
    }


    @Override
    public String geraResumo() {
        return "1;"+getNome()+";"+getProducaoMWh()+";"+getCustoMWh()+";"+getFonte();
    }


}

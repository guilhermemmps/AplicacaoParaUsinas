package src;
import java.io.BufferedWriter;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Conglomerado {

	private ArrayList<Usina> lista;

	public Conglomerado(){
		lista = new ArrayList<Usina>(100);
	}




	public boolean cadastraUsina(Usina usina) {
		for(int i=0;i<lista.size();i++){
			if(lista.get(i).getNome().equalsIgnoreCase(usina.getNome())){
				return false;
			}
		}
		return lista.add(usina);
	}



	public Usina pesquisaUsina(String nome) {
		for(int i=0;i< lista.size();i++){
			Usina usina = lista.get(i);
			if(usina.getNome().equalsIgnoreCase(nome)){
				return usina;
			}
		}
		return null;
	}

	public ArrayList<Usina> listaTodasUsinas() {
		if(lista.isEmpty()) return null;
		return lista;
	}


	public double consultaPreco(String nome) {
		Usina usina = pesquisaUsina(nome);
		if(usina==null) return -1;
		return usina.calculaPrecoMWh();
		}


	public boolean salvaDadosArquivo(String nomeArquivo) throws java.io.IOException{
			if(listaTodasUsinas()==null) return false;
		Path path = Paths.get(nomeArquivo + ".CSV");
		BufferedWriter bw = Files.newBufferedWriter(path, Charset.defaultCharset());
		PrintWriter writer = new PrintWriter(bw);

		for(int i=0;i< lista.size();i++){
			Usina usina = lista.get(i);
			writer.println(usina.geraResumo());
		}
		bw.close();
		return true;
	}

		public String mostraLista(){
			if(listaTodasUsinas()==null) return "Nenhuma usina cadastrada";

			String s = "Segue abaixo a lista das usinas cadastrada com as suas respectivas descrições: ";
			s = s + "\n";
			for(int i =0;i< lista.size();i++){
				Usina usina = lista.get(i);
				s = s +"\n" + usina.toString();

		}
			return s;
 	}




}
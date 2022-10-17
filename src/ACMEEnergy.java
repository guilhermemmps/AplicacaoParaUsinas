package src;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ACMEEnergy {

	private Conglomerado conglomerado;

	Scanner input = new Scanner(System.in);

	public ACMEEnergy(){
		conglomerado = new Conglomerado();
	}


	public void executa(){
		String opcao = "1";
		do{
			menu();
			opcao = input.nextLine();

			switch (opcao) {
				case "0":
					System.out.print("Fim do programa");
					break;

				case "1":
					System.out.println("Você selecionou para cadastrar uma nova usina.");
					int opcao2 = 3;
					do {
						System.out.println("Aperte 1 para criar uma nova usina renovável.");
						System.out.println("Aperte 2 para criar uma usina não renovável.");
						try {
							opcao2 = input.nextInt();
						} catch (InputMismatchException e){
							System.err.println(e);
							System.out.println("Exceção. O valor deve ser numérico.");
						}
						input.nextLine();
					} while (opcao2 != 1 && opcao2 != 2);

					if (opcao2 == 1) {
						double producao=0;
						double custo=0;
						System.out.println("Informe o nome da usina: ");

						String nome = input.nextLine();

						System.out.println("Informe a produção MWh: ");
						try{
							producao = input.nextDouble();
						} catch (InputMismatchException e){
							 System.out.println("Exceção. O valor deve ser numérico.");
							input.nextLine();
							 break;
						}
						input.nextLine();

						System.out.println("Informe o custo do MWh: ");
						try {
							custo = input.nextDouble();
						} catch (InputMismatchException e){
							System.out.println("Exceção. O valor deve ser numérico.");
							input.nextLine();
							break;
						}
						input.nextLine();

						System.out.println("Informe a fonte da usina renovável, ela pode ser solar, eólica ou hídrica.");
						String fonte = input.nextLine();

						UsinaRenovavel usinaRenovavel = new UsinaRenovavel(nome, producao, custo, fonte);
						boolean result = conglomerado.cadastraUsina(usinaRenovavel);
						if (result == false) {
							System.out.println("Usina repetida.");
							break;
						}
						System.out.println("Usina cadatrada com sucesso.");
						break;
					}
					if (opcao2 == 2) {
						double producao = 0;
						double custo = 0;
						System.out.println("Informe o nome da usina: ");
						String nome = input.nextLine();
						System.out.println("Informe a produção MWh: ");
						try {
							producao = input.nextDouble();
						}catch (InputMismatchException e){
							 System.out.println("Exceção. O valor deve ser numérico.");
							input.nextLine();
							 break;
						}
						input.nextLine();

						System.out.println("Informe o custo do MWh");
						try{
							custo = input.nextDouble();
						} catch (InputMismatchException e){
							System.out.println("Exceção. O valor deve ser numérico.");
							input.nextLine();
							break;
						}
						input.nextLine();

						System.out.println("Informe o combustível da usina não renovável, ela pode ser petróleo, carvão ou nuclear.");
						String combustivel = input.nextLine();

						UsinaNaoRenovavel usinaNaoRenovavel = new UsinaNaoRenovavel(nome, producao, custo, combustivel);
						boolean result = conglomerado.cadastraUsina(usinaNaoRenovavel);
						if (result == false) {
							System.out.println("Usina repetida.");
							break;
						}
						System.out.println("Usina cadatrada com sucesso.");
						break;
					}

				case "2":
					System.out.println("informe o nome da usina que deseja buscar.");
					String nome1 = input.nextLine();
					Usina usina = conglomerado.pesquisaUsina(nome1);
					if (usina == null) {
						System.out.println("Nenhuma usina localizada com este nome");
						break;
					}
					System.out.println(usina.toString());
					break;

				case "3":
					System.out.print(conglomerado.mostraLista());
					break;

				case "4":
					System.out.println("Você selecionou para consultar o preço do MWh de uma usina.");
					System.out.println("Informe o nome da usina que deseja verificar: ");
					String nome = input.nextLine();
					double valor = conglomerado.consultaPreco(nome);
					if (valor == -1) {
						System.out.println("Nenhuma usina foi localizada com este nome");
						break;
					}
					System.out.println("Nome da usina: " + nome + "\n" + "Preço do MWh: " + valor);
					break;

				case "5":
					System.out.println("Informe o nome do arquivo (sem extensão) para salvar os dados da usina.");
					String nome54 = input.nextLine();
					boolean r = false;
					try {
						r = conglomerado.salvaDadosArquivo(nome54);
					} catch (IOException e) {
						System.err.println(e);
					}
					if (r) System.out.println("Objetos salvos em arquivo.");

			}
		}while(!opcao.equals("0"));
	}
		public void menu(){
			System.out.println("----MENU----");
			System.out.println("Opção 0 - Encerrar a execução do programa");
			System.out.println("Opção 1 - Cadastrar nova usina");
			System.out.println("Opção 2 - Pesquisar uma usina pelo nome");
			System.out.println("Opção 3 - Lista de todas as usinas cadastradas");
			System.out.println("Opção 4 - Consultar o preço do MWh");
			System.out.println("Opção 5 - Salvar usinas em arquivo");

		}

		public void inicializa(){
		UsinaRenovavel usinaRenovavel1 = new UsinaRenovavel("Usina da praia",200.4,2.2,"solar");
		conglomerado.cadastraUsina(usinaRenovavel1);

		UsinaNaoRenovavel usinaNaoRenovavel1 = new UsinaNaoRenovavel("Usina do centro",140.3,1.5,"nuclear");
		conglomerado.cadastraUsina(usinaNaoRenovavel1);

		UsinaRenovavel usinaRenovavel2 = new UsinaRenovavel("Usina do bairro",200.4,2.2,"eólica");
		conglomerado.cadastraUsina(usinaRenovavel2);
	}










}

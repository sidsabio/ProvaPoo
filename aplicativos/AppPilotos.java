package aplicativos;

import java.io.IOException;
import java.util.Scanner;

import classes.Aeronave;
import classes.Pessoa;

public class AppPilotos {
    public static void main(String[] args) throws InterruptedException, IOException {
        int maxElementos = 1;
        int opcao, qtdCadastrados = 0;
        Pessoa[] pilotos = new Pessoa[maxElementos];
        Scanner in = new Scanner(System.in);

        do {
            System.out.println("\n****\nMENU\n****\n");
            System.out.println("1 - Cadastrar piloto");
            System.out.println("2 - Listar pilotos cadastrados");
            System.out.println("3 - Localizar piloto pelo CPF");
            System.out.println("4 - Aumentar espaço de armazenamento");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");

            opcao = in.nextInt();
            in.nextLine(); // Tira o ENTER que ficou na entrada na instrução anterior

            if (opcao == 1) {
                // Se não tem mais espaço no vetor, caio fora
                if (qtdCadastrados == maxElementos) {
                    System.out.println("\nNão há espaço para cadastrar novos pilotos.");
                    voltarMenu(in);
                    continue;
                }

                // Cadastre seu piloto aqui
                Pessoa novoPiloto = new Pessoa();
                System.out.println("Digite o nome do piloto: ");
                novoPiloto.setNome(in.nextLine());

                System.out.println("Digite o CPF do piloto: ");
                novoPiloto.setCpf(in.nextLine());

                System.out.println("Digite a quantidade de aeronaves que o piloto tem: ");
                int qtdAeronave = in.nextInt();
                Aeronave[] aeronaves = new Aeronave[qtdAeronave];
                in.nextLine();
                for (int i = 0; i < qtdAeronave; i++) {
                    Aeronave novaAeronave = new Aeronave();
                    System.out.println("Digite o modelo da aeronave: ");
                    novaAeronave.setModelo(in.nextLine());

                    aeronaves[i] = novaAeronave;
                }

                novoPiloto.setAeronaves(aeronaves);
                pilotos[qtdCadastrados] = novoPiloto;
                qtdCadastrados++;

                System.out.println("\nPiloto cadastrado com sucesso.");
                voltarMenu(in);

            } else if (opcao == 2) {
                // Se não tem ninguém cadastrado no vetor, caio fora
                if (qtdCadastrados == 0) {
                    System.out.println("\nNão há motoristas cadastrados para exibir.");
                    voltarMenu(in);
                    continue;
                }

                // Exiba os pilotos aqui

                for (int i = 0; i < qtdCadastrados; i++) {
                    System.out.println("Piloto: " + pilotos[i].getNome());
                    System.out.println("CPF: " + pilotos[i].getCpf());
                    Aeronave[] aeronavesPilotoAtual = pilotos[i].getAeronaves();
                    for (int j = 0; j < aeronavesPilotoAtual.length; j++) {

                        System.out.println("Aeronave: " + aeronavesPilotoAtual[j].getModelo());

                    }
                }

                voltarMenu(in);
            } else if (opcao == 3) {
                System.out.println("Insira o número do CPF do piloto: ");
                String cpf = in.nextLine();
                boolean achou = false;

                for (int i = 0; i < qtdCadastrados && !achou; i++) {

                    if (cpf.equals(pilotos[i].getCpf())) {
                        achou = true;
                        System.out.println("Piloto: " + pilotos[i].getNome());
                        System.out.println("CPF: " + pilotos[i].getCpf());

                        Aeronave[] aeronavesPilotoAtual = pilotos[i].getAeronaves();

                        for (int j = 0; j < aeronavesPilotoAtual.length; j++) {

                            System.out.println("Aeronave: " + aeronavesPilotoAtual[j].getModelo());

                        }
                    }
                }
                if (!achou) {
                    System.out.println("CPF não encontrado!");
                }
                voltarMenu(in);

            } else if (opcao == 4) {
                System.out.println("Digite o tamanho do espaço: ");
                int tamanhoVt = in.nextInt();
                Pessoa[] aux = pilotos;
                pilotos = new Pessoa[tamanhoVt];
                maxElementos = tamanhoVt;

                for (int i = 0; i < qtdCadastrados; i++) {
                    pilotos[i] = aux[i];
                }
                System.out.println("Espaço de armazenamento alterado com sucesso!");
                voltarMenu(in);

            } else if (opcao != 0) {
                System.out.println("\nOpção inválida!");
            }
        } while (opcao != 0);

        System.out.println("Fim do programa!");

        in.close();
    }

    private static void voltarMenu(Scanner in) throws InterruptedException, IOException {
        System.out.println("\nPressione ENTER para voltar ao menu.");
        in.nextLine();

        // Limpa toda a tela, deixando novamente apenas o menu
        if (System.getProperty("os.name").contains("Windows"))
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        else
            System.out.print("\033[H\033[2J");

        System.out.flush();
    }
}
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
            Scanner inserir = new Scanner(System.in);
            int op;
            float quantia;
            int quantNotas;

            Caixa caixa = new Caixa();

            do {
                System.out.println("-----------------------------------------------------------");
                System.out.println("             CAIXA ELETRONICO - Menu Principal");
                System.out.println("-----------------------------------------------------------\n");
                System.out.println("Escolha a operacao que deseja efetuar:\n");
                System.out.println("1 - Sacar");
                System.out.println("2 - Repor");
                System.out.println("3 - Consultar Saldo");
                System.out.println("4 - Fim\n");
                System.out.println("Opcao: ");
                op = inserir.nextInt();

                switch(op) {
                    case 1:
                        System.out.println("-----------------------------------------------------------");
                        System.out.println("             CAIXA ELETRONICO - Saque");
                        System.out.println("-----------------------------------------------------------\n");

                        System.out.println("Digite o valor a sacar: ");
                        quantia = inserir.nextFloat();
                        boolean flag = caixa.sacar(quantia);

                        if (flag == false) {
                            System.out.println("Nao existem notas suficientes no Caixa para esta quantia!\n");
                        }
                        else {
                            System.out.printf("Saque de R$ %.2f efetuado com sucesso!\n", quantia);

                            System.out.printf("Notas de R$ 5        : %d\n", caixa.mostrarQtdtipoNotas(5));
                            System.out.printf("Notas de R$ 10       : %d\n", caixa.mostrarQtdtipoNotas(10));
                            System.out.printf("Notas de R$ 20       : %d\n", caixa.mostrarQtdtipoNotas(20));
                            System.out.printf("Notas de R$ 50       : %d\n", caixa.mostrarQtdtipoNotas(50));
                            System.out.printf("Notas de R$ 100      : %d\n", caixa.mostrarQtdtipoNotas(100));
                        }
                        break;
                    case 2:
                        System.out.println("-----------------------------------------------------------");
                        System.out.println("             CAIXA ELETRONICO - Reposicao");
                        System.out.println("-----------------------------------------------------------\n");

                        System.out.println("Notas de R$ 5: ");
                        quantNotas = inserir.nextInt();
                        caixa.repor(5, quantNotas);

                        System.out.println("Notas de R$ 10: ");
                        quantNotas = inserir.nextInt();
                        caixa.repor(10, quantNotas);

                        System.out.println("Notas de R$ 20: ");
                        quantNotas = inserir.nextInt();
                        caixa.repor(20, quantNotas);

                        System.out.println("Notas de R$ 50: ");
                        quantNotas = inserir.nextInt();
                        caixa.repor(50, quantNotas);

                        System.out.println("Notas de R$ 100: ");
                        quantNotas = inserir.nextInt();
                        caixa.repor(100, quantNotas);

                        System.out.println("Reposicao efetuada com sucesso!");
                        break;
                    case 3:
                        System.out.println("-----------------------------------------------------------");
                        System.out.println("             CAIXA ELETRONICO - Saldo");
                        System.out.println("-----------------------------------------------------------\n");

                        System.out.printf("Saldo atual          : R$ %.2f\n", caixa.consultaSaldo());
                        System.out.printf("Qtd. de saques       : %d\n", caixa.getQuantSaque());
                        System.out.printf("Total de saques      : R$ %.2f\n", caixa.getValorSaque());
                        System.out.printf("Notas de R$ 5        : %d\n", caixa.mostrarQtdtipoNotas(5));
                        System.out.printf("Notas de R$ 10       : %d\n", caixa.mostrarQtdtipoNotas(10));
                        System.out.printf("Notas de R$ 20       : %d\n", caixa.mostrarQtdtipoNotas(20));
                        System.out.printf("Notas de R$ 50       : %d\n", caixa.mostrarQtdtipoNotas(50));
                        System.out.printf("Notas de R$ 100      : %d\n", caixa.mostrarQtdtipoNotas(100));
                        break;
                    case 4: System.out.println("Volte sempre. Obrigado!\n");
                        break;
                    default: System.out.println("\nOperação inválida!");
                }
            } while (op != 4);

    }
}
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        menu();
    }

    private static void menu() {
        Cliente italo = new Cliente();
        italo.setNome("Italo");
        Conta cc = new ContaCorrente(italo);
        Conta cp = new ContaPoupanca(italo);

        boolean continuarLooping = true;
        while (continuarLooping){
            Scanner scan = new Scanner(System.in);

            System.out.println("××× Escolha ×××");
            System.out.println("\n1 - Depositar\n2 - Sacar\n3 - Transferir\n4 - Mostrar Extrato\n");
            System.out.println("××××××××××××××××××");
            System.out.print("\nDigite o número de sua escolha: ");

            int opcao = scan.nextInt();

            switch(opcao){
                case 1:
                    System.out.println("××××××××××××××××××");
                    System.out.print("\nDeposite: ");

                    double dinheiroDepositado = scan.nextDouble();

                    cc.depositar(dinheiroDepositado);
                    cc.imprimirExtrato();

                    System.out.print("\nDeseja sair do App? s/n: ");

                    char simOuNao = scan.next().charAt(0);

                    if (simOuNao == 's' || simOuNao == 'S') continuarLooping = false;
                    break;
                case 2:
                    System.out.println("××××××××××××××××××");
                    System.out.print("\nSaque: ");

                    double dinheiroSacado = scan.nextDouble();

                    cc.sacar(dinheiroSacado);
                    cc.imprimirExtrato();

                    System.out.print("\nDeseja sair do App? s/n: ");
                    simOuNao = scan.next().charAt(0);

                    if (simOuNao == 's' || simOuNao == 'S') continuarLooping = false;
                    break;
                case 3:
                    System.out.println("××××××××××××××××××");
                    System.out.println("\nTransferir para: \n1 - Minha poupança\n2 - Outra Conta");
                    System.out.print("\nEscolha: ");

                    int opcaoTransferencia = scan.nextInt();

                    if(opcaoTransferencia == 1){
                        System.out.print("\nTransfira: ");

                        double dinheiroTansferido = scan.nextDouble();

                        cc.transferir(dinheiroTansferido, cp);
                        cc.imprimirExtrato();
                        cp.imprimirExtrato();
                    } else {
                        System.out.print("Enviar para: ");

                        String nomeCliente = scan.next();
                        Cliente novoCliente = new Cliente();
                        Conta novaConta = new ContaCorrente(novoCliente);
                        novoCliente.setNome(nomeCliente);

                        System.out.print("Deseja enviar para " + nomeCliente + "? s/n:");
                        simOuNao = scan.next().charAt(0);

                        if (simOuNao == 's' || simOuNao == 'S'){
                            System.out.print("\nTransfira: ");

                            double dinheiroTansferido = scan.nextDouble();

                            cc.transferir(dinheiroTansferido, novaConta);

                            System.out.println("\nTransferido com sucesso!");
                            cc.imprimirExtrato();
                        }
                    }
                    System.out.print("\nDeseja sair do App? s/n: ");
                    simOuNao = scan.next().charAt(0);

                    if (simOuNao == 's' || simOuNao == 'S') continuarLooping = false;
                    break;
                case 4:
                    System.out.println("××××××××××××××××××");

                    cc.imprimirExtrato();
                    cp.imprimirExtrato();

                    System.out.print("\nDeseja sair do App? s/n: ");
                    simOuNao = scan.next().charAt(0);

                    if (simOuNao == 's' || simOuNao == 'S') continuarLooping = false;
                    break;
                default:
                    break;
            }
        }
    }
}
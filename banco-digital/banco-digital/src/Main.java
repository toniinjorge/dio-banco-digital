import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Cliente venilton = new Cliente();

        System.out.println("Digite seu nome: ");
        String nome = scanner.nextLine();
        venilton.setNome(nome);
        Conta cc = new ContaCorrente(venilton);
        Conta poupanca = new ContaPoupanca(venilton);

        cc.setGerente("Antonio");
        poupanca.setGerente("Adalberto");

        System.out.println("Digite o valor do depósito: ");
        double dinheiro = scanner.nextDouble();
        cc.depositar(dinheiro);

        System.out.println("Digite o valor para poupança: ");
        double transferencia = scanner.nextDouble();


        if (transferencia > cc.getSaldo()){
            System.out.println("Saldo insuficiente");
        }
        else {
            cc.transferir(transferencia, poupanca);
        }

        scanner.close();

        cc.imprimirExtrato();
        poupanca.imprimirExtrato();
    }
}
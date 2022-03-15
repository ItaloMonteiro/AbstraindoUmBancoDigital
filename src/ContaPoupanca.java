public class ContaPoupanca extends Conta{

    public ContaPoupanca(Cliente cliente){
        super(cliente);
    }

    @Override
    public void imprimirExtrato(){
        System.out.println("\n××× Extrato da Poupança ×××\n");
/* para não repetir informações criei
um método para chamar as informações comuns
que existem nas duas contas.
*/
        super.informacoesComuns();
    }

}
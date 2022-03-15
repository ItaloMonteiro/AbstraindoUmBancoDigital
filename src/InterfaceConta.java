public interface InterfaceConta{

  /*não faz sentido declarar os métodos como
  public, seria uma redundancia, pois os métodos
  da interface são publicas*/

    void sacar(double valor);

    void depositar(double valor);

    void transferir(double valor, Conta contaDestino);

    void imprimirExtrato();
}
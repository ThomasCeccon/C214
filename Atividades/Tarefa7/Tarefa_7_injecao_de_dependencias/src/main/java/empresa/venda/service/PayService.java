package empresa.venda.service;

//interface que define o serviço de pagamento.
public interface PayService {
    void processPayment(String nomeCliente, float qunatidade);
}

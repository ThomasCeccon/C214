package empresa.venda.service;

//implementa o serviço de pagamento
public class PayServiceImpl implements PayService {

    @Override
    public void processPayment(String nomeCliente, float quantidade) {
        System.out.println("Processando pagamento de " + quantidade + " para o cliente " + nomeCliente);
    }
}



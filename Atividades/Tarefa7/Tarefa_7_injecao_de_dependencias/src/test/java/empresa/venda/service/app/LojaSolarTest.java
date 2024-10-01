package empresa.venda.service.app;

import empresa.venda.service.PayService;
import empresa.venda.service.SolarServiceContract;
import empresa.venda.service.SolarServiceImpl;

//classe que usa um mock para testar a classe de vendas sem realmente processar um pagamento
public class LojaSolarTest {

    public static void main(String[] args) {
        // Mock de serviço de pagamento (simulação)
        PayService payServiceMock = new PayService() {

            @Override
            public void processPayment(String nomeCliente, float quantidade) {
                System.out.println("Simulando pagamento de " + quantidade + " para o cliente " + nomeCliente);
            }
        };

        // Injeção do mock no serviço de vendas
        SolarServiceContract solarServiceContract = new SolarServiceImpl(payServiceMock);

        // Teste com o mock
        solarServiceContract.vendaPlacaSolar("Carlos Oliveira", 5);

    }
}

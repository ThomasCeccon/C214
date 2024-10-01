package empresa.venda.service.app;

import empresa.venda.service.PayService;
import empresa.venda.service.PayServiceImpl;
import empresa.venda.service.SolarServiceContract;
import empresa.venda.service.SolarServiceImpl;
//classe onde a injeção de dependência é feita manualmente e o serviço de vendas é utilizado
public class LojaSolar {

    public static void main(String[] args) {
        // Injeção de dependência manual
        PayService pagamentoServico = new PayServiceImpl();
        SolarServiceContract solarServiceContract = new SolarServiceImpl(pagamentoServico);

        // Usando o serviço de vendas
        solarServiceContract.vendaPlacaSolar("Ana Laura", 2);
    }
}
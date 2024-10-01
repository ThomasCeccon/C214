package empresa.venda.service;

// classe que implementa a lógica de vendas de placas solares e utiliza a injeção de dependência para o serviço de pagamento.

public class SolarServiceImpl implements SolarServiceContract {

        private final PayService pagamantoServico;

        // Construtor com injeção de dependência
        public SolarServiceImpl(PayService pagamantoServico ) {
            this.pagamantoServico = pagamantoServico;
        }

    @Override
    public void vendaPlacaSolar(String nomeCliente, float quantidade) {
        System.out.println("Vendendo " + quantidade + " placas solares para o cliente " + nomeCliente);
        pagamantoServico.processPayment(nomeCliente, quantidade * 400); // Exemplo: cada placa custa 400 reais
    }
}


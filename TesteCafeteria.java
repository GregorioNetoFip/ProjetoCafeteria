package ProjetoCafeteria;
import java.util.ArrayList;
import java.util.List;
public class TesteCafeteria {
	public static void main(String[] args) {
        Cafeteria cafeteria = new Cafeteria();

        // Adicionar produtos
        cafeteria.adicionarProduto("Café", 2.5);
        cafeteria.adicionarProduto("Bolo", 3.0);
        cafeteria.adicionarProduto("Sanduíche", 5.5);

        // Remover produto
        cafeteria.removerProduto("Bolo");

        // Atualizar produto
        cafeteria.atualizarProduto("Café", 2.8);

        // Adicionar clientes
        cafeteria.adicionarCliente("João", "Rua A, 123", "9999-0000");
        cafeteria.adicionarCliente("Maria", "Rua B, 456", "8888-1111");

        // Remover cliente
        cafeteria.removerCliente("Maria");

        // Atualizar cliente
        cafeteria.atualizarCliente("João", "Rua C, 789", "7777-2222");

        // Registrar pedido
        List<String> produtosPedido = new ArrayList<>();
        produtosPedido.add("Café");
        produtosPedido.add("Sanduíche");
        cafeteria.registrarPedido("2023-05-29", produtosPedido, "João");

        // Cancelar pedido
        cafeteria.cancelarPedido("2023-05-29");

        // Gerar relatório de vendas
        cafeteria.gerarRelatorioVendas();

        // Gerar relatório de estoque
        cafeteria.gerarRelatorioEstoque();

        // Calcular salário do funcionário
        cafeteria.calcularSalarioFuncionario("Funcionário 1");

        // Adicionar funcionário
        cafeteria.adicionarFuncionario("Funcionário 1", "Atendente", 2000.0, "08:00 - 16:00");

        // Remover funcionário
        cafeteria.removerFuncionario("Funcionário 1");

        // Atualizar funcionário
        cafeteria.atualizarFuncionario("Funcionário 2", "Gerente", 3000.0, "09:00 - 18:00");

        // Adicionar combo
        List<String> nomesProdutos = new ArrayList<>();
        nomesProdutos.add("Café");
        nomesProdutos.add("Sanduíche");
        cafeteria.adicionarCombo("Combo 1", nomesProdutos, 1.5);

        // Remover combo
        cafeteria.removerCombo("Combo 1");

        // Adicionar cliente VIP
        cafeteria.adicionarClienteVIP("Cliente VIP", "Rua D, 789", "6666-3333");

        // Adicionar mesa
        Mesa mesa1 = new Mesa(1);
        cafeteria.adicionarMesa(mesa1);

        // Ocupar mesa
        cafeteria.ocuparMesa(1);

        // Atender mesa
        cafeteria.atenderMesa(1);

        // Verificar status das mesas
        cafeteria.verificarStatusMesas();

        // Exibir mesas
        cafeteria.exibirMesas();
    }
}








}

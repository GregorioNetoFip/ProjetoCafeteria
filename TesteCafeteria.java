import static org.junit.Assert.*;
import org.junit.jupiter.api.BeforeEach;


import org.junit.Test;

public class TesteCafeteria {
	    private Cafeteria cafeteria;

	    @BeforeEach
	    public void setUp() {
	        cafeteria = new Cafeteria();
	    }

	    @Test
	    public void adicionarProdutoTest() {
	        cafeteria.adicionarProduto("Café", 2.5);
	        cafeteria.adicionarProduto("Bolo", 3.0);

	        assertEquals(2, cafeteria.getProdutos().size());
	    }

	    @Test
	    public void removerProdutoTest() {
	        cafeteria.adicionarProduto("Café", 2.5);
	        cafeteria.adicionarProduto("Bolo", 3.0);

	        cafeteria.removerProduto("Café");

	        assertEquals(1, cafeteria.getProdutos().size());
	    }

	    @Test
	    public void atualizarProdutoTest() {
	        cafeteria.adicionarProduto("Café", 2.5);

	        cafeteria.atualizarProduto("Café", 2.8);

	        Produto produto = cafeteria.getProdutos().get(0);
	        assertEquals(2.8, produto.getPreco());
	    }

	    @Test
	    public void adicionarClienteTest() {
	        cafeteria.adicionarCliente("João", "Rua A, 123", "9999-0000");
	        cafeteria.adicionarCliente("Maria", "Rua B, 456", "8888-1111");

	        assertEquals(2, cafeteria.getClientes().size());
	    }

	    @Test
	    public void removerClienteTest() {
	        cafeteria.adicionarCliente("João", "Rua A, 123", "9999-0000");
	        cafeteria.adicionarCliente("Maria", "Rua B, 456", "8888-1111");

	        cafeteria.removerCliente("João");

	        assertEquals(1, cafeteria.getClientes().size());
	    }

	    @Test
	    public void atualizarClienteTest() {
	        cafeteria.adicionarCliente("João", "Rua A, 123", "9999-0000");

	        cafeteria.atualizarCliente("João", "Rua C, 789", "7777-2222");

	        Cliente cliente = cafeteria.getClientes().get(0);
	        assertEquals("Rua C, 789", cliente.getEndereco());
	        assertEquals("7777-2222", cliente.getTelefone());
	    }

	    @Test
	    public void registrarPedidoTest() {
	        cafeteria.adicionarProduto("Café", 2.5);
	        cafeteria.adicionarProduto("Bolo", 3.0);
	        cafeteria.adicionarCliente("João", "Rua A, 123", "9999-0000");

	        List<String> produtosPedido = new ArrayList<>();
	        produtosPedido.add("Café");
	        produtosPedido.add("Bolo");

	        cafeteria.registrarPedido("2023-05-29", produtosPedido, "João");

	        assertEquals(1, cafeteria.getPedidos().size());
	        assertEquals(1, cafeteria.getClientes().get(0).getHistoricoCompras().size());
	    }

	    @Test
	    public void cancelarPedidoTest() {
	        cafeteria.adicionarProduto("Café", 2.5);
	        cafeteria.adicionarProduto("Bolo", 3.0);
	        cafeteria.adicionarCliente("João", "Rua A, 123", "9999-0000");

	        List<String> produtosPedido = new ArrayList<>();
	        produtosPedido.add("Café");
	        produtosPedido.add("Bolo");

	        cafeteria.registrarPedido("2023-05-29", produtosPedido, "João");

	        cafeteria.cancelarPedido("2023-05-29");

	        assertEquals(0, cafeteria.getPedidos().size());
	        assertEquals(0, cafeteria.getClientes().get(0).getHistoricoCompras().size());
	    }

	    @Test
	    public void adicionarFuncionarioTest() {
	        cafeteria.adicionarFuncionario("Carlos", "Atendente", 1500.0, "8:00 - 16:00");
	        cafeteria.adicionarFuncionario("Ana", "Caixa", 1800.0, "12:00 - 20:00");

	        assertEquals(2, cafeteria.getFuncionarios().size());
	    }

	    @Test
	    public void removerFuncionarioTest() {
	        cafeteria.adicionarFuncionario("Carlos", "Atendente", 1500.0, "8:00 - 16:00");
	        cafeteria.adicionarFuncionario("Ana", "Caixa", 1800.0, "12:00 - 20:00");

	        cafeteria.removerFuncionario("Carlos");

	        assertEquals(1, cafeteria.getFuncionarios().size());
	    }

	    @Test
	    public void atualizarFuncionarioTest() {
	        cafeteria.adicionarFuncionario("Carlos", "Atendente", 1500.0, "8:00 - 16:00");

	        cafeteria.atualizarFuncionario("Carlos", "Supervisor", 2000.0, "9:00 - 17:00");

	        Funcionario funcionario = cafeteria.getFuncionarios().get(0);
	        assertEquals("Supervisor", funcionario.getCargo());
	        assertEquals(2000.0, funcionario.getSalario());
	        assertEquals("9:00 - 17:00", funcionario.getHorarioTrabalho());
	    }

	    @Test
	    public void adicionarComboTest() {
	        cafeteria.adicionarProduto("Café", 2.5);
	        cafeteria.adicionarProduto("Bolo", 3.0);
	        cafeteria.adicionarProduto("Suco", 4.5);

	        List<String> produtosCombo = new ArrayList<>();
	        produtosCombo.add("Café");
	        produtosCombo.add("Bolo");

	        cafeteria.adicionarCombo("Combo Café da Manhã", produtosCombo, 1.0);

	        assertEquals(1, cafeteria.getCombos().size());
	    }

	    @Test
	    public void removerComboTest() {
	        cafeteria.adicionarProduto("Café", 2.5);
	        cafeteria.adicionarProduto("Bolo", 3.0);
	        cafeteria.adicionarProduto("Suco", 4.5);

	        List<String> produtosCombo = new ArrayList<>();
	        produtosCombo.add("Café");
	        produtosCombo.add("Bolo");

	        cafeteria.adicionarCombo("Combo Café da Manhã", produtosCombo, 1.0);

	        cafeteria.removerCombo("Combo Café da Manhã");

	        assertEquals(0, cafeteria.getCombos().size());
	    }

	    @Test
	    public void adicionarClienteVIPTest() {
	        cafeteria.adicionarClienteVIP("João", "Rua A, 123", "9999-0000");
	        cafeteria.adicionarClienteVIP("Maria", "Rua B, 456", "8888-1111");

	        assertEquals(2, cafeteria.getClientes().size());
	        assertTrue(cafeteria.getClientes().get(0).isVip());
	        assertTrue(cafeteria.getClientes().get(1).isVip());
	    }

	    @Test
	    public void adicionarMesaTest() {
	        Mesa mesa1 = new Mesa(1);
	        Mesa mesa2 = new Mesa(2);

	        cafeteria.adicionarMesa(mesa1);
	        cafeteria.adicionarMesa(mesa2);

	        assertEquals(2, cafeteria.getMesas().size());
	    }

	    @Test
	    public void ocuparMesaTest() {
	        Mesa mesa1 = new Mesa(1);
	        cafeteria.adicionarMesa(mesa1);

	        cafeteria.ocuparMesa(1);
	        assertTrue(cafeteria.getMesas().get(0).isOcupada());
	    }

	    @Test
	    public void atenderMesaTest() {
	        Mesa mesa1 = new Mesa(1);
	        cafeteria.adicionarMesa(mesa1);

	        cafeteria.ocuparMesa(1);
	        cafeteria.atenderMesa(1);
	        assertFalse(cafeteria.getMesas().get(0).isOcupada());
	    }
	    }
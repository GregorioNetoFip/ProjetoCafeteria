package ProjetoCafeteria;
import java.util.ArrayList;
import java.util.List;
public class Cafeteria {
    private List<Produto> produtos;
    private List<Cliente> clientes;
    private List<Pedido> pedidos;
    private List<Funcionario> funcionarios;
    private List<Mesa> mesas;
    private List<Combo> combos;
   


    public Cafeteria() {
        produtos = new ArrayList<>();
        clientes = new ArrayList<>();
        pedidos = new ArrayList<>();
        funcionarios = new ArrayList<>();
        mesas = new ArrayList<>();
        combos = new ArrayList<>();
    }

    public void adicionarProduto(String nome, double preco) {
        Produto produto = new Produto(nome, preco);
        produtos.add(produto);
        System.out.println("Produto adicionado com sucesso.");
    }

    public void removerProduto(String nome) {
        Produto produtoRemover = null;
        for (Produto produto : produtos) {
            if (produto.getNome().equalsIgnoreCase(nome)) {
                produtoRemover = produto;
                break;
            }
        }
        if (produtoRemover != null) {
            produtos.remove(produtoRemover);
            System.out.println("Produto removido com sucesso.");
        } else {
            System.out.println("Produto não encontrado.");
        }
    }

    public void atualizarProduto(String nome, double novoPreco) {
        Produto produtoAtualizar = null;
        for (Produto produto : produtos) {
            if (produto.getNome().equalsIgnoreCase(nome)) {
                produtoAtualizar = produto;
                break;
            }
        }
        if (produtoAtualizar != null) {
            produtoAtualizar.setPreco(novoPreco);
            System.out.println("Produto atualizado com sucesso.");
        } else {
            System.out.println("Produto não encontrado.");
        }
    }

    public void adicionarCliente(String nome, String endereco, String telefone) {
        Cliente cliente = new Cliente(nome, endereco, telefone);
        clientes.add(cliente);
        System.out.println("Cliente adicionado com sucesso.");
    }

    public void removerCliente(String nome) {
        Cliente clienteRemover = null;
        for (Cliente cliente : clientes) {
            if (cliente.getNome().equalsIgnoreCase(nome)) {
                clienteRemover = cliente;
                break;
            }
        }
        if (clienteRemover != null) {
            clientes.remove(clienteRemover);
            System.out.println("Cliente removido com sucesso.");
        } else {
            System.out.println("Cliente não encontrado.");
        }
    }

    public void atualizarCliente(String nome, String novoEndereco, String novoTelefone) {
        Cliente clienteAtualizar = null;
        for (Cliente cliente : clientes) {
            if (cliente.getNome().equalsIgnoreCase(nome)) {
                clienteAtualizar = cliente;
                break;
            }
        }
        if (clienteAtualizar != null) {
            clienteAtualizar.setEndereco(novoEndereco);
            clienteAtualizar.setTelefone(novoTelefone);
            System.out.println("Cliente atualizado com sucesso.");
        } else {
            System.out.println("Cliente não encontrado.");
        }
    }

    public void registrarPedido(String data, List<String> produtosPedido, String nomeCliente) {
        Cliente cliente = null;
        for (Cliente c : clientes) {
            if (c.getNome().equalsIgnoreCase(nomeCliente)) {
                cliente = c;
                break;
            }
        }
        if (cliente != null) {
            List<Produto> produtos = new ArrayList<>();
            for (String nomeProduto : produtosPedido) {
                Produto produto = null;
                for (Produto p : this.produtos) {
                    if (p.getNome().equalsIgnoreCase(nomeProduto)) {
                        produto = p;
                        break;
                    }
                }
                if (produto != null) {
                    produtos.add(produto);
                } else {
                    System.out.println("Produto " + nomeProduto + " não encontrado.");
                }
            }
            if (!produtos.isEmpty()) {
                Pedido pedido = new Pedido(data, produtos, cliente);
                pedidos.add(pedido);
                cliente.adicionarCompra(produtos);
                System.out.println("Pedido registrado com sucesso.");
            }
        } else {
            System.out.println("Cliente não encontrado.");
        }
    }

    public void cancelarPedido(String data) {
        Pedido pedidoCancelar = null;
        for (Pedido pedido : pedidos) {
            if (pedido.getData().equalsIgnoreCase(data)) {
                pedidoCancelar = pedido;
                break;
            }
        }
        if (pedidoCancelar != null) {
            pedidos.remove(pedidoCancelar);
            Cliente cliente = pedidoCancelar.getCliente();
            if (cliente != null) {
                cliente.exibirHistoricoCompras();
            }
            System.out.println("Pedido cancelado com sucesso.");
        } else {
            System.out.println("Pedido não encontrado.");
        }
    }

    public void gerarRelatorioVendas() {
        System.out.println("== Relatório de Vendas ==");
        for (Pedido pedido : pedidos) {
            System.out.println("Data: " + pedido.getData());
            System.out.println("Cliente: " + pedido.getCliente().getNome());
            System.out.println("Produtos:");
            for (Produto produto : pedido.getProdutos()) {
                System.out.println("- " + produto.getNome() + " | Preço: R$" + produto.getPreco());
            }
            System.out.println("Valor Total: R$" + pedido.getValorTotal());
            System.out.println("-----------------------------");
        }
    }

    public void gerarRelatorioEstoque() {
        System.out.println("== Relatório de Estoque ==");
        for (Produto produto : produtos) {
            System.out.println("Produto: " + produto.getNome() + " | Preço: R$" + produto.getPreco());
        }
    }

    public void calcularSalarioFuncionario(String nomeFuncionario) {
        Funcionario funcionario = null;
        for (Funcionario f : funcionarios) {
            if (f.getNome().equalsIgnoreCase(nomeFuncionario)) {
                funcionario = f;
                break;
            }
        }
        if (funcionario != null) {
            System.out.println("Salário do funcionário " + funcionario.getNome() + ": R$" + funcionario.getSalario());
        } else {
            System.out.println("Funcionário não encontrado.");
        }
    }

    public void adicionarFuncionario(String nome, String cargo, double salario, String horarioTrabalho) {
        Funcionario funcionario = new Funcionario(nome, cargo, salario, horarioTrabalho);
        funcionarios.add(funcionario);
        System.out.println("Funcionário adicionado com sucesso.");
    }

    public void removerFuncionario(String nome) {
        Funcionario funcionarioRemover = null;
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getNome().equalsIgnoreCase(nome)) {
                funcionarioRemover = funcionario;
                break;
            }
        }
        if (funcionarioRemover != null) {
            funcionarios.remove(funcionarioRemover);
            System.out.println("Funcionário removido com sucesso.");
        } else {
            System.out.println("Funcionário não encontrado.");
        }
    }

    public void atualizarFuncionario(String nome, String novoCargo, double novoSalario, String novoHorarioTrabalho) {
        Funcionario funcionarioAtualizar = null;
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getNome().equalsIgnoreCase(nome)) {
                funcionarioAtualizar = funcionario;
                break;
            }
        }
        if (funcionarioAtualizar != null) {
            funcionarioAtualizar.setCargo(novoCargo);
            funcionarioAtualizar.setSalario(novoSalario);
            funcionarioAtualizar.setHorarioTrabalho(novoHorarioTrabalho);
            System.out.println("Funcionário atualizado com sucesso.");
        } else {
            System.out.println("Funcionário não encontrado.");
        }
    }

public void adicionarCombo(String nome, List<String> nomesProdutos, double desconto) {
    List<Produto> produtosCombo = new ArrayList<>();
    for (String nomeProduto : nomesProdutos) {
        Produto produto = buscarProduto(nomeProduto);
        if (produto != null) {
            produtosCombo.add(produto);
        } else {
            System.out.println("Produto " + nomeProduto + " não encontrado. Combo não adicionado.");
            return;
        }
    }
    Combo combo = new Combo(nome, produtosCombo, desconto);
    combos.add(combo);
    System.out.println("Combo adicionado: " + combo);
}

private Produto buscarProduto(String nomeProduto) {
	// TODO Auto-generated method stub
	return null;
}

public void removerCombo(String nome) {
    Combo combo = buscarCombo(nome);
    if (combo != null) {
        combos.remove(combo);
        System.out.println("Combo removido: " + combo);
    } else {
        System.out.println("Combo não encontrado.");
    }
}


private Combo buscarCombo(String nome) {
	// TODO Auto-generated method stub
	return null;
}


public void adicionarClienteVIP(String nome, String endereco, String telefone) {
    Cliente cliente = new Cliente(nome, endereco, telefone);
    cliente.setVip(true);
    clientes.add(cliente);
    System.out.println("Cliente VIP adicionado com sucesso.");
}
public void adicionarMesa(Mesa mesa) {
    mesas.add(mesa);
}

public void ocuparMesa(int numero) {
    Mesa mesa = encontrarMesa(numero);
    if (mesa != null) {
        if (mesa.isOcupada()) {
            System.out.println("A mesa " + numero + " já está ocupada.");
        } else {
            mesa.setOcupada(true);
            System.out.println("A mesa " + numero + " foi marcada como ocupada.");
        }
    } else {
        System.out.println("Mesa não encontrada.");
    }
}

public void atenderMesa(int numero) {
    Mesa mesa = encontrarMesa(numero);
    if (mesa != null) {
        if (mesa.isOcupada()) {
            mesa.setOcupada(false);
            System.out.println("A mesa " + numero + " foi marcada como atendida.");
        } else {
            System.out.println("A mesa " + numero + " já está livre.");
        }
    } else {
        System.out.println("Mesa não encontrada.");
    }
}

public void verificarStatusMesas() {
    for (Mesa mesa : mesas) {
        System.out.println("Mesa " + mesa.getNumero() + ": " + (mesa.isOcupada() ? "Ocupada" : "Livre"));
    }
}

Mesa encontrarMesa(int numero) {
    for (Mesa mesa : mesas) {
        if (mesa.getNumero() == numero) {
            return mesa;
        }
    }
    return null;
}

public void exibirMesas() {
    System.out.println("Mesas:");
    for (Mesa mesa : mesas) {
        System.out.println("Mesa " + mesa.getNumero() + ": " + (mesa.isOcupada() ? "Ocupada" : "Livre"));
    }
}
}

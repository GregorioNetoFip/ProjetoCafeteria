package ProjetoCafeteria;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
public class Main {
	public static void main(String[] args) {
        Cafeteria cafe = new Cafeteria();
        Scanner scanner = new Scanner(System.in);
        int opcao;
        do {
            System.out.println("=== Menu Principal ===");
            System.out.println("1. Gerenciar Produtos");
            System.out.println("2. Gerenciar Clientes");
            System.out.println("3. Registrar Pedido");
            System.out.println("4. Cancelar Pedido");
            System.out.println("5. Gerar Relatório de Vendas");
            System.out.println("6. Gerar Relatório de Estoque");
            System.out.println("7. Calcular Salário do Funcionário");
            System.out.println("8. Gerenciar Funcionários");
            System.out.println("9. Gerenciar Mesas");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do scanner

            switch (opcao) {
                case 1:
                    gerenciarProdutos(scanner, cafe);
                    break;
                case 2:
                    gerenciarClientes(scanner, cafe);
                    break;
                case 3:
                    registrarPedido(scanner, cafe);
                    break;
                case 4:
                    cancelarPedido(scanner, cafe);
                    break;
                case 5:
                    cafe.gerarRelatorioVendas();
                    break;
                case 6:
                    cafe.gerarRelatorioEstoque();
                    break;
                case 7:
                    calcularSalarioFuncionario(scanner, cafe);
                    break;
                case 8:
                    gerenciarFuncionarios(scanner, cafe);
                    break;
                case 9:
                	gerenciarMesas(scanner, cafe);
                	break;
                case 0:
                    System.out.println("Encerrando o programa...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
            System.out.println();
        } while (opcao != 0);
        scanner.close();
    }

    private static void gerenciarProdutos(Scanner scanner, Cafeteria cafe) {
        int opcao;
        do {
            System.out.println("=== Gerenciar Produtos ===");
            System.out.println("1. Adicionar Produto");
            System.out.println("2. Remover Produto");
            System.out.println("3. Atualizar Produto");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do scanner

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome do produto: ");
                    String nomeProduto = scanner.nextLine();
                    System.out.print("Digite o preço do produto: ");
                    double precoProduto = scanner.nextDouble();
                    cafe.adicionarProduto(nomeProduto, precoProduto);
                    break;
                case 2:
                    System.out.print("Digite o nome do produto: ");
                    String produtoRemover = scanner.nextLine();
                    cafe.removerProduto(produtoRemover);
                    break;
                case 3:
                    System.out.print("Digite o nome do produto: ");
                    String produtoAtualizar = scanner.nextLine();
                    System.out.print("Digite o novo preço do produto: ");
                    double novoPrecoProduto = scanner.nextDouble();
                    cafe.atualizarProduto(produtoAtualizar, novoPrecoProduto);
                    break;
                case 0:
                    System.out.println("Voltando ao Menu Principal...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
            System.out.println();
        } while (opcao != 0);
    }

    private static void gerenciarClientes(Scanner scanner, Cafeteria cafe) {
        int opcao;
        do {
            System.out.println("=== Gerenciar Clientes ===");
            System.out.println("1. Adicionar Cliente");
            System.out.println("2. Remover Cliente");
            System.out.println("3. Atualizar Cliente");
            System.out.println("4. Cliente Vip");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do scanner

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome do cliente: ");
                    String nomeCliente = scanner.nextLine();
                    System.out.print("Digite o endereço do cliente: ");
                    String enderecoCliente = scanner.nextLine();
                    System.out.print("Digite o telefone do cliente: ");
                    String telefoneCliente = scanner.nextLine();
                    cafe.adicionarCliente(nomeCliente, enderecoCliente, telefoneCliente);
                    break;
                case 2:
                    System.out.print("Digite o nome do cliente: ");
                    String clienteRemover = scanner.nextLine();
                    cafe.removerCliente(clienteRemover);
                    break;
                case 3:
                    System.out.print("Digite o nome do cliente: ");
                    String clienteAtualizar = scanner.nextLine();
                    System.out.print("Digite o novo endereço do cliente: ");
                    String novoEnderecoCliente = scanner.nextLine();
                    System.out.print("Digite o novo telefone do cliente: ");
                    String novoTelefoneCliente = scanner.nextLine();
                    cafe.atualizarCliente(clienteAtualizar, novoEnderecoCliente, novoTelefoneCliente);
                case 4:
                    System.out.print("Digite o nome do cliente: ");
                    String nomeClienteVIP = scanner.nextLine();
                    System.out.print("Digite o endereço do cliente: ");
                    String enderecoClienteVIP = scanner.nextLine();
                    System.out.print("Digite o telefone do cliente: ");
                    String telefoneClienteVIP = scanner.nextLine();
                    cafe.adicionarClienteVIP(nomeClienteVIP, enderecoClienteVIP, telefoneClienteVIP);
                    break;
                case 0:
                    System.out.println("Voltando ao Menu Principal...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
            System.out.println();
        } while (opcao != 0);
    }

    private static void registrarPedido(Scanner scanner, Cafeteria cafe) {
        System.out.print("Digite a data do pedido: ");
        String dataPedido = scanner.nextLine();
        List<String> produtosPedido = new ArrayList<>();
        String nomeProduto;
        do {
            System.out.print("Digite o nome do produto (ou 0 para encerrar): ");
            nomeProduto = scanner.nextLine();
            if (!nomeProduto.equals("0")) {
                produtosPedido.add(nomeProduto);
            }
        } while (!nomeProduto.equals("0"));
        System.out.print("Digite o nome do cliente: ");
        String nomeCliente = scanner.nextLine();
        cafe.registrarPedido(dataPedido, produtosPedido, nomeCliente);
    }

    private static void cancelarPedido(Scanner scanner, Cafeteria cafe) {
        System.out.print("Digite a data do pedido a ser cancelado: ");
        String dataCancelar = scanner.nextLine();
        cafe.cancelarPedido(dataCancelar);
    }

    private static void calcularSalarioFuncionario(Scanner scanner, Cafeteria cafe) {
        System.out.print("Digite o nome do funcionário: ");
        String nomeFuncionario = scanner.nextLine();
        cafe.calcularSalarioFuncionario(nomeFuncionario);
    }

    private static void gerenciarFuncionarios(Scanner scanner, Cafeteria cafe) {
        int opcao;
        do {
            System.out.println("=== Gerenciar Funcionários ===");
            System.out.println("1. Adicionar Funcionário");
            System.out.println("2. Remover Funcionário");
            System.out.println("3. Atualizar Funcionário");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do scanner

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome do funcionário: ");
                    String nomeFuncionario = scanner.nextLine();
                    System.out.print("Digite o cargo do funcionário: ");
                    String cargoFuncionario = scanner.nextLine();
                    System.out.print("Digite o salário do funcionário: ");
                    double salarioFuncionario = scanner.nextDouble();
                    scanner.nextLine(); // Limpar o buffer do scanner
                    System.out.print("Digite o horário de trabalho do funcionário: ");
                    String horarioTrabalhoFuncionario = scanner.nextLine();
                    cafe.adicionarFuncionario(nomeFuncionario, cargoFuncionario, salarioFuncionario, horarioTrabalhoFuncionario);
                    break;
                case 2:
                    System.out.print("Digite o nome do funcionário: ");
                    String funcionarioRemover = scanner.nextLine();
                    cafe.removerFuncionario(funcionarioRemover);
                    break;
                case 3:
                    System.out.print("Digite o nome do funcionário: ");
                    String funcionarioAtualizar = scanner.nextLine();
                    System.out.print("Digite o novo cargo do funcionário: ");
                    String novoCargoFuncionario = scanner.nextLine();
                    System.out.print("Digite o novo salário do funcionário: ");
                    double novoSalarioFuncionario = scanner.nextDouble();
                    scanner.nextLine(); // Limpar o buffer do scanner
                    System.out.print("Digite o novo horário de trabalho do funcionário: ");
                    String novoHorarioTrabalhoFuncionario = scanner.nextLine();
                    cafe.atualizarFuncionario(funcionarioAtualizar, novoCargoFuncionario, novoSalarioFuncionario, novoHorarioTrabalhoFuncionario);
                    break;
                case 0:
                    System.out.println("Voltando ao Menu Principal...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
            System.out.println();
        } while (opcao != 0);
    }

            private static void gerarRelatorioVendas(Cafeteria cafe) {
                System.out.println("=== Relatório de Vendas ===");
                cafe.gerarRelatorioVendas();
                System.out.println();
            }

            private static void gerarRelatorioEstoque(Cafeteria cafe) {
                System.out.println("=== Relatório de Estoque ===");
                cafe.gerarRelatorioEstoque();
                System.out.println();
            }
        
    private static void gerenciarMesas(Scanner scanner, Cafeteria cafe) {
    int opcao;
    do {
        System.out.println("=== Gerenciar Mesas ===");
        System.out.println("1. Adicionar Mesa");
        System.out.println("2. Ocupar Mesa");
        System.out.println("3. Exibir Mesa");
        System.out.println("0. Voltar");
        System.out.print("Escolha uma opção: ");
        opcao = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer do scanner

        switch (opcao) {
            case 1:
                System.out.print("Digite o número da mesa: ");
                int numeroMesa = scanner.nextInt();
                scanner.nextLine(); // Limpa o buffer do scanner

                Mesa mesa = new Mesa(numeroMesa);
                cafe.adicionarMesa(mesa);
                System.out.println("Mesa " + numeroMesa + " adicionada.");
                break;
            case 2:
            	System.out.print("Digite o número da mesa a ser ocupada: ");
                int mesaOcupada = scanner.nextInt();
                cafe.ocuparMesa(mesaOcupada);
                break;
            case 3:
            	cafe.exibirMesas();
                break;
            case 0:
                System.out.println("Voltando ao Menu Principal...");
                break;
            default:
                System.out.println("Opção inválida. Tente novamente.");
                break;
        }
        System.out.println();
    } while (opcao != 0);
}}

package ProjetoCafeteria;

import java.util.List;
import java.util.ArrayList;
 

class Cliente {
    private String nome;
    private String endereco;
    private String telefone;
    private List<Produto> historicoCompras;
    private boolean vip;

    public Cliente(String nome, String endereco, String telefone) {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.historicoCompras = new ArrayList<>();
        this.vip = false;
        
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void adicionarCompra(Produto produto) {
        historicoCompras.add(produto);
    }

    public void exibirHistoricoCompras() {
        if (historicoCompras.isEmpty()) {
            System.out.println("O cliente não possui histórico de compras.");
        } else {
            System.out.println("Histórico de Compras do Cliente " + nome + ":");
            for (Produto produto : historicoCompras) {
                System.out.println("Produto: " + produto.getNome() + " | Preço: R$" + produto.getPreco());
            }
        }
    }

	public void adicionarCompra(List<Produto> produtos) {
		// TODO Auto-generated method stub
		
	}

	public void setVip(boolean b) {
		// TODO Auto-generated method stub
		
	}
}

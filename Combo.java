package ProjetoCafeteria;

import java.util.List;

class Combo {
    private String nome;
    private List<Produto> produtos;
    private double desconto;

    public Combo(String nome, List<Produto> produtos, double desconto) {
        this.nome = nome;
        this.produtos = produtos;
        this.desconto = desconto;
    }

    public String getNome() {
        return nome;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public double getDesconto() {
        return desconto;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Nome: ").append(nome).append("\n");
        sb.append("Produtos: \n");
        for (Produto produto : produtos) {
            sb.append("- ").append(produto.getNome()).append(" - R$").append(produto.getPreco()).append("\n");
        }
        sb.append("Desconto: ").append(desconto).append("%\n");
        return sb.toString();
    }
}

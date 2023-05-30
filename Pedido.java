package ProjetoCafeteria;
import java.util.ArrayList;
import java.util.List;

class Pedido {
    private String data;
    private List<Produto> produtos;
    private double valorTotal;
    private Cliente cliente;

    public Pedido(String data, List<Produto> produtos, Cliente cliente) {
        this.data = data;
        this.produtos = produtos;
        this.cliente = cliente;
        calcularValorTotal();
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
        calcularValorTotal();
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public Cliente getCliente() {
        return cliente;
    }

    private void calcularValorTotal() {
        valorTotal = 0;
        for (Produto produto : produtos) {
            valorTotal += produto.getPreco();
        }
    }
}

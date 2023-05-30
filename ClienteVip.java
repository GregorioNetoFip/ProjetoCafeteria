package ProjetoCafeteria;

class ClienteVIP extends Cliente {
    private String codigoVIP;

    public ClienteVIP(String nome, String endereco, String telefone, String codigoVIP) {
        super(nome, endereco, telefone);
        this.codigoVIP = codigoVIP;
    }

    public String getCodigoVIP() {
        return codigoVIP;
    }

    public void setCodigoVIP(String codigoVIP) {
        this.codigoVIP = codigoVIP;
    }

    @Override
    public String toString() {
        return super.toString() + ", Código VIP: " + codigoVIP;
    }
}

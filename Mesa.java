package ProjetoCafeteria;

class Mesa {
    private int numero;
    private boolean ocupada;
    
    public Mesa(int numero, String status) {
        this.numero = numero;
        this.ocupada = false;
    }


	public Mesa(int numeroMesa) {
		// TODO Auto-generated constructor stub
	}


	public int getNumero() {
        return numero;
    }

	public boolean isOcupada() {
		// TODO Auto-generated method stub
		return false;
	}

	public void setOcupada(boolean b) {
		// TODO Auto-generated method stub
		
	}

public void ocupar() {
    if (ocupada) {
        System.out.println("A mesa já está ocupada.");
    } else {
        ocupada = true;
        System.out.println("A mesa " + numero + " foi ocupada.");
    }
}

public void desocupar() {
    if (ocupada) {
        ocupada = false;
        System.out.println("A mesa " + numero + " foi desocupada.");
    } else {
        System.out.println("A mesa já está desocupada.");
    }
}


	
}
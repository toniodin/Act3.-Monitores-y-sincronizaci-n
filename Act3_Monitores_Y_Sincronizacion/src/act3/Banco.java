package act3;

public class Banco {

    private int clientesEnBanco = 0;

    public static void main(String[] args) {
        Banco banco = new Banco();

        for (int i = 1; i <= 10; i++) {
            Cliente cliente = new Cliente(banco, "Cliente " + i);
            cliente.start();
        }
    }

    public synchronized void ingresarBanco(String cliente) {
        while (clientesEnBanco >= 2) {
            try {
                System.out.println(cliente + " está esperando para ingresar al banco.");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        clientesEnBanco++;
        System.out.println(cliente + " ha ingresado al banco.\nEn el banco hay: " + clientesEnBanco + " clientes.");
    }

    public synchronized void salirBanco(String cliente) {
        clientesEnBanco--;
        System.out.println(cliente + " ha ingresado al banco.\nEn el banco hay: " + clientesEnBanco + " clientes.");
        notify();
    }
}



    


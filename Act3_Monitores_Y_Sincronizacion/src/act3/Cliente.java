package act3;

public class Cliente extends Thread {
	
    private Banco banco;
    private String nombre;

    public Cliente(Banco banco, String nombre) {
        this.banco = banco;
        this.nombre = nombre;
    }

    @Override public void run() {
        banco.ingresarBanco(nombre);
        try {
            sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        banco.salirBanco(nombre);
    }
}

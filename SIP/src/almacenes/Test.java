package almacenes;

public class Test {

  
    public static void main(String[] args) throws InterruptedException {

      
        final int NCLIENTES = 300;
        final int NPRODUCTOS = 100;

        // Array de clientes los cuales se meterán en el Thread
        Cliente[] cliente = new Cliente[NCLIENTES];
        Thread[] clientes = new Thread[NCLIENTES];

        // se crea 
        Almacen almacen = new Almacen(NPRODUCTOS);

        
        Puerta puerta = new Puerta();


        
        for (int i = 0; i < NCLIENTES; i++) {
        	
            int id = i;
            //se asigna al cliente la info actual de cuando es su turno 
            cliente[i] = new Cliente(puerta, almacen, id);
            clientes[i] = new Thread(cliente[i]);
            clientes[i].start();
        }

        for (int i = 0; i < NCLIENTES; i++) {
            clientes[i].join();
        }
    }
}
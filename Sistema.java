package a.test;

/*La clase Sistema es la aplicación que configura y ejecuta el
sistema. Contendrá el método main() donde serán declarados los elementos que
constituyen el sistema: un contenedor de 50 piezas y dos brazos robots que
tendrán como propósito vaciarlo. Inicialmente, cada brazo puede estar configurado
para tomar 25 piezas del contenedor, aunque este parámetro puede ser
posteriormente modificado.
*/
public class Sistema {
    public static void main(String[] args) {
        Contenedor cont = new Contenedor(50);
        Thread brazo1 = new Thread(new Brazo(0,25,cont));
        Thread brazo2 = new Thread(new Brazo(1,25,cont));
        
        brazo1.start();
        brazo2.start();
        System.out.println("Contenedor vacío");
    }
}

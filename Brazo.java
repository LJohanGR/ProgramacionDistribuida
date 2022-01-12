package a.test;

/*
    La clase brazo tiene que implementar la interfaz Runnable
    El constructor de la clase tendrá tres parámetros de entrada:
    un identificador único asignado al brazo, el número de piezas que deben ser
    tomadas por el brazo durante su actividad y, finalmente, el contenedor sobre el
    que debe trabajar. Esta clase únicamente deberá implementar el método run(),
    responsable de tomar del contenedor compartido el número de piezas indicado.
*/
public class Brazo extends Thread{
    private int iD,numPiezas;
    private Contenedor contenedor;
    
    public Brazo(int iD,int numPiezas, Contenedor cont){
        this.iD = iD;
        this.numPiezas = numPiezas;
        this.contenedor=cont;
    }
    /*Aquí intenté usar el método synchronized para ver su funcionamiento, sin embargo no vi un 
    cambio en su funcionamiento, llama en un loop al método extraer para crear la condición
    de competencia.*/
    public void run(){
         while(this.numPiezas>0){
            this.contenedor.descargarUnaPieza();
            //Thread.;
            System.out.print("Brazo "+this.iD+": extrajo una pieza, restan "+contenedor.getCantPiezas()+" Piezas\n");
            this.numPiezas -= 1;
            try{
                Thread.sleep(500);
            }catch(InterruptedException e){
                System.out.println("Proceso interrumpido");
            }
        } 
    }
    public void extraer(){
        if(this.contenedor.getCantPiezas()>0){
            this.contenedor.descargarUnaPieza();
            System.out.print("Brazo "+this.iD+": extrajo una pieza, restan "+contenedor.getCantPiezas()+" Piezas\n");
            try{
                Thread.sleep(3000);
            }catch(InterruptedException e){
                System.out.println("Brazo "+this.iD+" interrumpido");
            }
       }else{
           System.out.println("Brazo "+this.iD+": No hay piezas por extraer");
       }
        
    }
       
}
public class conjunto {
    public static void main(String[]args){
        int[] elementos;
        int[] elementosc;
        int i, y, cardinalidad, sc, scp, escac;

        System.out.print("Numero de elementos del conjunto: ");
        cardinalidad = Integer.parseInt(System.console().readLine());

        elementos = new int [cardinalidad];

        for(i = 0 ; i < cardinalidad  ; i++){
        
            System.out.print("Elemento " + (i+1) + ": ");
            elementos[i] = Integer.parseInt(System.console().readLine());
        }

        System.out.print("Numero de elementos del subconjunto a comprobar: ");
        escac = Integer.parseInt(System.console().readLine());
        
        elementosc = new int [escac];

        for (i = 0; i < escac ; i++ ){

            System.out.print("Elemento " + (i+1) + " del subconjunto: ");
            elementosc[i] = Integer.parseInt(System.console().readLine());

        }

        for (i = 0 ; i < escac  ; i++){
            for(y = 0 ; y < cardinalidad ; y++ ){
                do {

                } while();
            }
        }

        if (escac==cardinalidad){
            System.out.print("Los elementos introducidos son un subconjunto del conjunto principal");
        }else if (escac<cardinalidad){
            System.out.print("Los elementos introducidos son un subconjunto propio del conjunto principal");
        }else{
            System.out.print("Los elementos introducidos no son un subconjunto del conjunto principal");
        }
        


        //sc = Math.pow(2.0, cardinalidad);
        //scp = sc - 1;
        //System.out.println("Subconjuntos: " + sc );
        //System.out.println("Subconjuntos propios: " + sc );

    }
}
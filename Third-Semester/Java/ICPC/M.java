import java.util.Scanner;

	public class M {
		public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int c = sc.nextInt();
            int t = sc.nextInt(); sc.nextLine();
            double[] bolsas = new double[n];
            double max = 0;
            for(int i = 0; i < n; i++){
                bolsas[i] = sc.nextDouble() / t;
                if(bolsas[i] > max) max = bolsas[i];
            }
            sc.nextLine();
            max = Math.ceil(max);
            int contador = 0;
            double suma = 0;
            while(contador != n || suma > max){
                contador = 0;
                for(int jugador = 0; jugador < c; jugador++){
                    suma = 0;
                    while(suma + bolsas[contador]<= max){
                        suma += bolsas[contador];
                        contador++;
                        if(contador == n) break;
                    }
                }
                max++;
            }
            max--;
            System.out.println((int)max);
		}
	}

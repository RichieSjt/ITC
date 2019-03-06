public class Restaurant {
	public static void main (String[] args) {

		//Declarar Arreglos
		int [] dishes;
		int [][] orders;

		//Contadores
		int customersCount, dishesCount;

		//Preguntas
		System.out.print("How many customers?: ");
		customersCount = Integer.parseInt(System.console().readLine());
		System.out.print("How many dishes?: ");
		dishesCount = Integer.parseInt(System.console().readLine());


		//Inicializar arreglos, aquí ya sabes el número de personas y platillos
		orders = new int[customersCount][dishesCount];
		dishes = new int[dishesCount];

		//Preguntar por el precio de platillos
		for(int i=0; i<dishesCount;i++){
			System.out.print("How much does the dish" +(i+1)+ "costs?: " );
			//Guardar valor en el arreglo en la posición i
			dishes[i] = Integer.parseInt(System.console().readLine());
		}



		//Preguntar por los platillos que cada persona pidió
		for(int i=0; i<customersCount;i++){
			for(int j=0; j<dishesCount;j++){
				System.out.print("How many dishes " +(j+1) + " customer " + (i+1) +": ");
				//Guardar valor en el arreglo en la posición i
				orders[i][j] = Integer.parseInt(System.console().readLine());
			}
		}


		//Imprimir cuenta de cada persona
		for(int i=0; i<customersCount;i++){

			int count=0;

			for(int j=0; j<dishesCount;j++){
				
				count = count + (orders[i][j]*dishes[j]);
				
				//Guardar valor en el arreglo en la posición i
				

			}
			System.out.println("Count for customer "+(i+1)+": "+count);
		}

		//Imprimir cuenta de cada persona
		for(int i=0; i<customersCount;i++){


			for(int j=0; j<dishesCount;j++){
				
				System.out.print(orders[i][j]+"  ");

			}
			System.out.println("");
			
		}





	}
}

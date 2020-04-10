package fi.unju.edu.ar.punto7;

public class sudoku {
	public static void main(String[] args) {
		 int[][] matriz = {
				{3,0,1,2},
				{0,1,0,3},
				{0,0,0,0},
				{1,0,3,4}
		};
		/*
		int fila, col;
		Scanner scn = new Scanner(System.in);
		System.out.println("Ingrese una posicion (fila,columna): ");
		fila = scn.nextInt();
		col = scn.nextInt();
		solucion(matriz, --fila, --col);*/
		solucion(matriz, 0, 1);
		solucion(matriz, 2, 3);
	}

	static void solucion(int[][] matriz, int fila, int col) {
		if( matriz[fila][col] == 0 ) {
			int[] soluciones = {1,1,1,1}; // si {1,1,1,1}, las soluciones son {1,2,3,4}
			int aux;
			
			// Verificacion a lo Alto y ancho
			for (int i = 0; i < 4 ; i++) {
				aux = matriz[fila][i]; //a lo ancho
				if (aux > 0) soluciones[aux-1] = 0; // numero usado, entonces 0
				aux = matriz[i][col]; //a lo alto
				if(aux > 0) soluciones[aux-1] = 0; // numero usado, entonces 0
			}
			
			// Verificacion cuadrante, 4 celdas
			int c_fila, c_col; 			
			if ( fila < 2 ) c_fila = 0; else c_fila = 2; // cuadrantes superior o inferior
			if ( col < 2 ) c_col = 0; else c_col = 2; // cuadrante izquierdo o derecho
			if ( matriz[c_fila][c_col] > 0 )  soluciones[matriz[c_fila][c_col]-1] = 0; // celda 1
			if ( matriz[c_fila][c_col+1] > 0 ) soluciones[matriz[c_fila][c_col+1]-1] = 0; // celda 2
			if ( matriz[c_fila+1][c_col] > 0 ) soluciones[matriz[c_fila+1][c_col]-1] = 0; // celda 3
			if ( matriz[c_fila+1][c_col+1] > 0 ) soluciones[matriz[c_fila+1][c_col+1]-1] = 0; // celda 4
			
			// Escribir solucion
			System.out.print("\nSolucion en " + (fila+1) + "," + (col+1) + ": ");
			for(int i = 0; i < 4; i++) 
				if (soluciones[i] > 0) System.out.print(i+1);
		} 
		else System.out.println("La celda ya tiene solucion");
	}
	
}

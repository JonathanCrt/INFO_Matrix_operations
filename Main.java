package maths;

/**
 * Devoir maison de Mathématiques
 * @authors jonathan CRETE & Emilie Marti
 */

public class Main {

	public static void main(String[] args) {
		
		/*
		Matrice A = new Matrice(new long[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 13 } });
		Matrice B = A.times(A.transpose());
		Matrice C = B.inverse();
		System.out.println(C);
		Matrice D = A.transpose().times(A);
		
		
	
		try {
			Matrice E = D.inverse();
			System.out.println(E);
		} catch (ArithmeticException e) {
			System.out.println("D n'a pas d'inverse");
		}
		*/
		
		// test  Matrices
		Matrice A = new Matrice(new long[][] { { 1, 2 }, { 0, 0 }, { 0, 0  } });
		Matrice B = new Matrice(new long[][] { { 1, 0 }, { 1, 1 }, { 2, -3  } });
		Matrice C = new Matrice(new long[][] { { 1, 0, 9 }, { 1, 1, 6 } });
		
		// Résultat attendu : { 2, 2 }, { 1, 1 }, { 2, -3  }
		System.out.println(A.plus(B)); //[[2, 2], [1, 1], [2, -3]]
		
		// Résultata attendu : { 1, 2 }, { 1, 2 }
		System.out.println(C.times(A)); // [[1, 2], [1, 2]]
		
	}

}

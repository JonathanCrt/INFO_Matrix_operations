package maths;

/**
 * Devoir maison de Math�matiques
 * @authors jonathan CRETE & Emilie Marti
 */

public class Main {

	public static void main(String[] args)
	{
		System.out.println("\nLa somme des chiffres d'un nombre a trois chiffres est 21.\nSi le numero est inverse (abc -> cba), le nouveau nombre depasse de 198 le nombre original.\nLa somme du premier et du dernier chiffre depasse de 1 le deuxieme chiffre multiplie par 3.\nQuel est ce nombre ?");

		System.out.println("\nOn modelise :\n\t- a + b + c = 21\n\t- abc + 198 = cba\n\t- a + c = (3*b) + 1\n\nOn obtient la matrice suivante :");

		Matrice linearSystem = new Matrice(new long[][] {{1, 1, 1, 21}, {-99, 0, 99, 198}, {1, -3, 1, 1}});

		System.out.println("\n" + linearSystem);
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

/*
		// test  Matrices
		Matrice A = new Matrice(new long[][] { { 1, 2 }, { 0, 0 }, { 0, 0  } });
		//Matrice B = new Matrice(new long[][] { { 1, 0 }, { 1, 1 }, { 2, -3  } });
		Matrice C = new Matrice(new long[][] { { 1, 0, 9 }, { 1, 1, 6 } });
		
		// R�sultat attendu : { 2, 2 }, { 1, 1 }, { 2, -3  }
		//System.out.println(A.plus(B)); //[[2, 2], [1, 1], [2, -3]]
		
		// R�sultat attendu : { 1, 2 }, { 1, 2 }

		Matrice matrix = new Matrice(new long[][] {{1, 2}, {-1, 0}});
		//Matrice matrix = C.times(A);
		System.out.println("Matrix = \n" + matrix); // [[1, 2], [1, 2]]

		System.out.println("identity =\n" + matrix.identity());

		System.out.println("inverse =\n" + matrix.inverse());*/


	}

}

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

		System.out.println("\t" + linearSystem);

		Matrice linearSystemReduced = new Matrice(new long[][] {{1, 1, 1}, {-99, 0, 99}, {1, -3, 1}});

		Matrice inverse = linearSystemReduced.inverse();

		System.out.println("\nOn calcule la matrice inverse de notre systeme reduit (sans la derniere colonne) :\n\t" + inverse);

		System.out.println("\nAfin de resoudre le systeme, on multiplie l'inverse calculee ci-dessus par la derniere colonne de notre systeme :\n");

		Matrice results = new Matrice(new long[][] {{21}, {198}, {1}});

		System.out.println("\t" + inverse + " x " + results + " = " + inverse.times(results));

		System.out.println("\nLe nombre recherche est 759.");
	}

}

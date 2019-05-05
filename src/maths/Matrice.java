package maths;

import java.util.Arrays;

/**
 * Devoir maison de Math�matiques
 * @authors jonathan CRETE & Emilie Marti
 */

public class Matrice {

	private final int n; /* nombre de lignes */
	private final int m; /* nombre de colonnes */
	private final Rational[][] coeff; /* liste des coefficients */

	/**
	 * Cr�ation d'une matrice
	 * 
	 * @param coeff coefficients de la matrice
	 */
	public Matrice(Rational[][] coeff) {
		n = coeff.length;
		m = coeff[0].length;
		this.coeff = coeff;
	}

	/**
	 * Cr�ation d'une matrice
	 * 
	 * @param coeff coefficients de la matrice, donn�s comme long
	 */
	public Matrice(long[][] coeff) {
		n = coeff.length;
		m = coeff[0].length;
		this.coeff = new Rational[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				this.coeff[i][j] = new Rational(coeff[i][j]);
			}
		}
	}

	/**
	 * Calcul de la somme matricielle this + M (si les dimensions de this et M
	 * l'autorisent)
	 * 
	 * @param M matrice � ajouter : tableau n x m
	 * @return somme this + M : tableau n x m
	 */
	public Matrice plus(Matrice M) {
		if (n != M.n || m != M.m) {
			throw new IllegalArgumentException("Dimensions incorrectes");
		}

		Rational[][] sum = new Rational[n][m];
		
		int i,j;
		for(i = 0; i < M.n; i++) {
			for(j = 0; j< M.m;  j++) {
				sum[i][j] = this.coeff[i][j].plus(M.coeff[i][j]);			
			}
		}
		return new Matrice(sum);
	}

	/**
	 * Calcul du produit matriciel this M (si les dimensions de this et M
	 * l'autorisent)
	 * 
	 * @param M matrice � multiplier : tableau m x p
	 * @return produit this M : tableau n x p
	 */
	public Matrice times(Matrice M) {
		if (m != M.n) {
			throw new IllegalArgumentException("Dimensions incorrectes");
		}
		int p = M.m;

		Rational[][] prod = new Rational[n][p];
		int i, j, k;
		for(i = 0; i < n; i++) {
			for(j = 0; j < p; j++) {
				Rational calc = new Rational(0);
 				for(k = 0; k < m; k++) {
					
					calc =  calc.plus(this.coeff[i][k].times(M.coeff[k][j]));

				}
 				prod[i][j] = calc;
			}
		}
		return new Matrice(prod);
	}

	/**
	 * Calcul de la transpos�e de this
	 * 
	 * @return transpos�e de this : tableau m x n
	 */
	public Matrice transpose() {
		Rational[][] trans = new Rational[m][n];
		
		int i,j;
		for(i = 0; i <m; i++) {
			for(j = 0; j < n; j++) {
				trans[j][i] = coeff[i][j];
			}
		}
		return new Matrice(trans);
	}

	/**
	 * �change les lignes i et j de la matrice
	 * 
	 * @param i premi�re ligne � �changer
	 * @param j deuxi�me ligne � �changer
	 */
	private void swapRows(int i, int j) {
		Rational[] swap = coeff[i];
		coeff[i] = coeff[j];
		coeff[i] = swap;
	}

	/**
	 * Ajoute a fois la ligne i de this a sa ligne j
	 * 
	 * @param i ligne à ajouter (multipliée par a)
	 * @param j ligne à laquelle on ajoute a fois la ligne i
	 * @param a scalaire par lequel on multiplie la ligne i quand on l'ajoute
	 */
	private void transvection(int i, int j, Rational a)
	{
		for(int index = 0; index < this.m; ++index)
		{
			coeff[j][index] = coeff[j][index].plus(coeff[i][index].times(a));
		}
	}

	/**
	 * Mutiplie par a la ligne i de this
	 * 
	 * @param i ligne � multiplier par a
	 * @param a scalaire par lequel on multiplie la ligne i
	 */
	private void multiplyRow(int i, Rational a)
	{
		for(int index = 0; index < m; ++index)
		{
			coeff[i][index] = coeff[i][index].times(a);
		}
	}

	/**
	 * Calcul de la matrice identit� de m�mes dimensions que this (si les dimensions
	 * de this l'autorisent)
	 * 
	 * @return matrice identit� : tableau n x n
	 */
	public Matrice identity()
	{
		if (m != n)
		{
			throw new IllegalArgumentException("Dimensions incorrectes");
		}

		Rational[][] id = new Rational[n][n];

		for(int i = 0; i < n; ++i)
		{
			for(int j = 0; j < n; ++j)
			{
				if(j == i)
					id[i][j] = Rational.ONE;
				else
					id[i][j] = Rational.ZERO;
			}
		}

		return new Matrice(id);
	}

	/**
	 * Calcul d'une copie de this
	 * 
	 * @return copie de this : tableau n x m
	 */
	public Matrice clone() {
		Rational[][] clone = new Rational[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				clone[i][j] = coeff[i][j];
			}
		}
		return new Matrice(clone);
	}

	private Matrice augmentedMatrix()
	{
		Matrice clone = clone();
		Matrice id = identity();

		int size = n;

		Rational[][] augmentedMatrixRational = new Rational[size][size*2];

		/**
		 * create augmented matrix
		 */
		for(int i = 0; i < size; ++i)
		{
			/**
			 * going through each column of the row
			 */
			for(int j = 0; j < size; j++)
			{
				/**
				 * Create new augmented matrix (matrix + identity joined)
				 */
				augmentedMatrixRational[j][i] = clone.coeff[j][i];
				augmentedMatrixRational[j][i+size] = id.coeff[j][i];
			}
		}

		Matrice augmentedMatrix = new Matrice(augmentedMatrixRational);

		return augmentedMatrix;
	}

	/**
	 * Calcul de l'inverse de this
	 * 
	 * @return inverse de this : tableau n x n
	 */
	public Matrice inverse()
	{
		if (m != n)
		{
			throw new IllegalArgumentException("Dimensions incorrectes");
		}

		int size = n;

		Matrice augmentedMatrix = augmentedMatrix();

		Rational rationalOne = Rational.ONE;
		Rational rationalZero = Rational.ZERO;

		int i, j;

		/**
		 * Gaussian elimination algorithm
		 * Going through rows
		 */
		for(i = 0; i < size; ++i)
		{
			if(augmentedMatrix.coeff[i][i] == rationalZero)
			{
				throw new IllegalStateException("Inverse cannot be found");
			}

			/**
			 * Divide each value by the diagonal value
			 * We need diagonal to be only ones
			 */
			if(augmentedMatrix.coeff[i][i] != rationalOne)
			{
				augmentedMatrix.multiplyRow(i, augmentedMatrix.coeff[i][i].inverse());
			}

			Rational constant;

			/**
			 * All zeros below diagonal
			 */
			if(i < (size - 1))
			{
				for(j = 0; j < size; ++j)
				{
					/**
					 * Make transvection to all lines below
					 */
					if(j != i)
					{
						constant = augmentedMatrix.coeff[j][i];

						if(augmentedMatrix.coeff[j][i].isSameSign(constant))
						{
							constant = constant.minus();
						}
						augmentedMatrix.transvection(i, j, constant);
					}
				}
			}

			/**
			 * All zeros above diagonal
			 */
			if(i > 0)
			{
				for(j = (size - 1); j >= 0; --j)
				{
					/**
					 * Make transvection to all lines above
					 */
					if(j != i)
					{
						constant = augmentedMatrix.coeff[j][i];

						if(augmentedMatrix.coeff[j][i].isSameSign(constant))
						{
							constant = constant.minus();
						}
						augmentedMatrix.transvection(i, j, constant);
					}
				}
			}
		}

		/**
		 * Extract inverse Matrix from augmented matrix
		 */
		Rational[][] inverseCoeff = new Rational[size][size];

		for(i = 0; i < size; ++i)
		{
			for(j = 0; j < size; ++j)
			{
				inverseCoeff[i][j] = augmentedMatrix.coeff[i][size+j];
			}
		}

		Matrice inverse = new Matrice(inverseCoeff);

		return inverse;
	}

	@Override
	public String toString()
	{
		return Arrays.deepToString(coeff);
	}
}

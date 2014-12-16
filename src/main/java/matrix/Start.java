package matrix;

public class Start {


	public static void main(String[] args) {

		final int[][] matrix1 = makeMatrix(1);
		printMatrix(matrix1);

		final int[][] matrix2 = makeMatrix(2);
		printMatrix(matrix2);

		final int[][] matrix3 = makeMatrix(3);
		printMatrix(matrix3);

		final int[][] matrix4 = makeMatrix(4);
		printMatrix(matrix4);

		final int[][] matrix5 = makeMatrix(5);
		printMatrix(matrix5);

	}

	private static void printMatrix(final int[][] matrix) {
		for (int i = 0; i<matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {

				System.out.print(matrix[i][j]);
			}
			System.out.println();

		}
	}

	protected static int[][] makeMatrix(final int size) {
		int[][] matrix = makeMatrix2way(size);

		return matrix;
	}

	private static int[][] makeMatrix2way(final int size) {
		int[][] matrix = new int[size][size];

		for (int i = 0; i<size; i++) {
			for (int j = 0; j < size; j++) {
				int val = findVal(i+1, j+1, size);
				matrix[i][j] = val;
			}
		}
		return matrix;
	}

	protected static int findVal(int i, int j, int size) {

		if (i == j) {
			return getValDepOnSize(i, size);

		} else if ( i < j ) {
			return getValDepOnSize(i, size);

		} else  {
			return getValDepOnSize(j, size);

		}
	}

	private static int getValDepOnSize(int val, int size) {
		int mid = size/2;
		int rem = size%2;

		if ( val < mid + rem + 1) {
			return val;
		} else {
			return size - val + 1;
		}
	}

	private static int[][] makeMatrix1way(final int size) {
		int[][] matrix = new int[size][size];


		for (int i = 0; i<size; i++) {
			for (int j = 0; j < size; j++) {

				int val = 0;
				int middle = size/2;
				int remndr = size%2;

				if ( i < middle + remndr) {
					val = i + 1;
				} else {
					val = size - i;
				}

				matrix[i][j] = val;

			}

		}

		return matrix;
	}

	private static void show(int val) {
		System.out.print(val + " ");
	}

	private static void newLine() {
		System.out.println();
	}

}

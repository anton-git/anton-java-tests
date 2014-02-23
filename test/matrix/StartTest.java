package matrix;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

public class StartTest extends Start{


	@Test
	public void makeMatrixSize1() throws Exception {
		final int size = 1;
		final int[][] matrix = makeMatrix(size);

		assertBasic(size, matrix);

		assertEquals(1, matrix[0][0]);

	}

	@Test
	public void makeMatrixSize2() throws Exception {
		final int size = 2;
		final int[][] matrix = makeMatrix(size);

		assertBasic(size, matrix);

		assertEquals(1, matrix[0][0]);
		assertEquals(1, matrix[0][1]);
		assertEquals(1, matrix[1][0]);
		assertEquals(1, matrix[1][1]);

	}

	@Ignore
	@Test
	public void makeMatrixSize3() throws Exception {
		final int size = 3;
		final int[][] matrix = makeMatrix(size);

		assertBasic(size, matrix);

		assertEquals(1, matrix[0][0]);
		assertEquals(1, matrix[0][1]);
		assertEquals(1, matrix[0][2]);

		assertEquals(1, matrix[1][0]);
		assertEquals(2, matrix[1][1]);
		assertEquals(1, matrix[1][2]);

		assertEquals(1, matrix[2][0]);
		assertEquals(1, matrix[2][1]);
		assertEquals(1, matrix[2][2]);

	}

	private void assertBasic(final int size, final int[][] matrix) {
		assertNotNull(matrix);
		assertEquals(size, matrix.length);
	}

	@Test
	public void testFindVal() throws Exception {
		assertEquals(1, findVal(1,1,1));

		assertEquals(1, findVal(1,1,2));
		assertEquals(1, findVal(1,2,2));
		assertEquals(1, findVal(2,1,2));
		assertEquals(1, findVal(2,2,2));

		assertEquals(1, findVal(1,1,3));
		assertEquals(1, findVal(1,2,3));
		assertEquals(1, findVal(1,3,3));

		assertEquals(1, findVal(2,1,3));
		assertEquals(2, findVal(2,2,3));
//		assertEquals(1, findVal(2,3,3));

	}
}

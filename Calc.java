
import java.util.ArrayList;

/**
 *
 * @author Zofia Sobocinska
 */
public class Calc {

	/**
	 * Permutation to be indexed
	 */
	Permutation permutation = null;

	/**
	 * Class constructor
	 * 
	 * @param permutation Permutation to be indexed 
	 */
	public Calc(Permutation permutation) {
		this.permutation = permutation;
	}

	/**
	 * Lexical index of the given permutation.
	 * 
	 * @return 
	 */
	public int index() {
		int index = 1;
		for (int i = 1; i < permutation.size(); i++) {
			int order = 0;
			for (int j = 0; j < i; j++) {
				if (permutation.getFromEnd(i) > permutation.getFromEnd(j)) {
					order++;
				}
			}
			index += order * factorial(i);
		}
		return index;
	}

	/**
	 * Factorial method to calculate number of permutations
	 * available for set with given size.
	 * 
	 * @param n Factorial function's parameter == size of the set.
	 * @return 
	 */
	private static int factorial(int n) {
		int factorial = 1;
		for (int i = 1; i <= n; i++) {
			factorial *= i;
		}
		return factorial;
	}

	/**
	 * Class to keep permutation.
	 */
	public static class Permutation extends ArrayList<Integer> {

		/**
		 * Version UID for serialization.
		 */
		static final long serialVersionUID = 1;

		/**
		 * Method to get number with specific index, counting from the end.
		 * 
		 * @param n Index to get, counting from the end.
		 * @return 
		 */
		Integer getFromEnd(int n) {
			return get(size() - 1 - n);
		}
	}
}

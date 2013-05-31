
import java.util.ArrayList;

/**
 *
 * @author Zofia Sobocinska
 */
public class Calc {

	Numbers numbers = null;

	public Calc(Numbers numbers) {
		this.numbers = numbers;
	}

	public int index() {
		int index = 1;
		for (int i = 1; i < numbers.N(); i++) {
			int order = 0;
			for (int j = 0; j < i; j++) {
				if (numbers.get(i) > numbers.get(j)) {
					order++;
				}
			}
			index += order * permutationsCount(i);
		}
		return index;
	}

	private static int permutationsCount(int N) {
		int factorial = 1;
		for (int i = 1; i <= N; i++) {
			factorial *= i;
		}
		return factorial;
	}

	public static class Numbers extends ArrayList<Integer> {

		static final long serialVersionUID = 1;

		public int N() {
			return size();
		}

		@Override
		public Integer get(int n) {
			return super.get(size() - 1 - n);
		}
	}
}

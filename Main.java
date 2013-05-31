
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Zofia Sobocinska
 */
public class Main {

	/**
	 * Main program mechanism
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		String file = args[0];
		try {
			Calc.Permutation permutation = readData(file);
			Calc calc = new Calc(permutation);
			System.out.println(calc.index());
		} catch (FileNotFoundException ex) {
			Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	/**
	 * Reading permuted numbers from file.
	 *
	 * @param filename Name of the file from which numbers have to be read.
	 * @return
	 * @throws FileNotFoundException
	 */
	private static Calc.Permutation readData(String filename)
					throws FileNotFoundException {

		String regexp = "\\D+";
		Calc.Permutation permutation = new Calc.Permutation();
		File file = new File(filename);
		Scanner sc = new Scanner(file).useDelimiter(regexp);
		while (sc.hasNext()) {
			int number = sc.nextInt();
			permutation.add(number);
		}
		return permutation;
	}
}

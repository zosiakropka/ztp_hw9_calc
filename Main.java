
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

	public static void main(String[] args) {
		String file = args[0];
		try {
			Calc.Numbers numbers = readData(file);
			Calc calc = new Calc(numbers);
			System.out.println(calc.index());
		} catch (FileNotFoundException ex) {
			Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	private static Calc.Numbers readData(String filename) throws FileNotFoundException {

		String regexp = "\\D+";
		Calc.Numbers elements = new Calc.Numbers();
		File file = new File(filename);
		Scanner sc = new Scanner(file).useDelimiter(regexp);
		while (sc.hasNext()) {
			int number = sc.nextInt();
			elements.add(number);
		}
		return elements;
	}
}

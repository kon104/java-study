import java.util.Scanner;

public class ExpSimpleClock extends ExpBase {
	public static void main(String[] args) {
		String path = "./java-study/input-SimpleClock.txt";
		Scanner sc = fetchFileToScanner(path);
		long startTimeNs = System.nanoTime();		

		for (int test_case = 1; sc.hasNext(); test_case++) {
			int degrees = sc.nextInt();
			int minites = degrees * 2;
			int hh = minites / 60;
			int mm = minites - hh * 60;
			System.out.println("#" + test_case + " " + hh + " " + mm);
		}
		sc.close();

		long endTimeNs = System.nanoTime();
		printProcessingTime(startTimeNs, endTimeNs);
	}
}

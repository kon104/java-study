import java.util.Scanner;

public class ExpDistributeCookie extends ExpBase {
	public static void main(String[] args) {
		String path = "./java-study/input-ExpDistributeCookie.txt";
		Scanner sc = fetchFileToScanner(path);
		long startTimeNs = System.nanoTime();		

		for (int test_case = 1; sc.hasNext(); test_case++) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			int m = n % k;
			System.out.println("#" + test_case + " " + ((m > 0) ? 1 : 0));
		}
		sc.close();

		long endTimeNs = System.nanoTime();
		printProcessingTime(startTimeNs, endTimeNs);
	}

}

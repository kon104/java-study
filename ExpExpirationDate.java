import java.util.Scanner;

public class ExpExpirationDate extends ExpBase {
	public static void main(String[] args) {
		String path = "./java-study/input-ExpirationDate.txt";
		Scanner sc = fetchFileToScanner(path);
		long startTimeNs = System.nanoTime();		

		for (int test_case = 1; sc.hasNext(); test_case++) {
			String line = sc.nextLine();
			String str1 = line.substring(0, 2);
			String str2 = line.substring(2);
			int i1 = Integer.parseInt(str1);
			int i2 = Integer.parseInt(str2);
			String ans = null;
			if (i1 <= 12) {
				if (i2 <= 12) {
					ans = "AMBIGUOUS";
				} else {
					ans = "MMYY";
				}
			} else {
				if (i2 <= 12) {
					ans = "YYMM";
				} else {
					ans = "NA";
				}
			}
			System.out.println(ans);
		}
		sc.close();

		long endTimeNs = System.nanoTime();
		printProcessingTime(startTimeNs, endTimeNs);
	}

}

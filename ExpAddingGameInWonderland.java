import java.util.Scanner;

public class ExpAddingGameInWonderland extends ExpBase {
	public static void main(String[] args) {
		String path = "./java-study/input-ExpAddingGameInWonderland.txt";
		Scanner sc = fetchFileToScanner(path);
		long startTimeNs = System.nanoTime();		

		for (int test_case = 1; sc.hasNext(); test_case++) {
			int num = sc.nextInt();
			int count = 0;
			while(num >= 10) {
				count++;
//				System.out.println("\t" + num);
				int d1 = num % 10;
				int d2 = ((int)(num / 10)) % 10;
				if (num >= 1000) {
					int d3 = ((int)(num / 100)) % 10;
					int d4 = (int)(num / 1000);
					int x1 = (d4 + d3) * 100 + d2 * 10 + d1;
					int x2 = d4 * ((d3 + d2) < 10 ? 100 : 1000) + (d3 + d2) * 10 + d1;
					int x3 = d4 * ((d2 + d1) < 10 ? 100 : 1000) + d3 * ((d2 + d1) < 10 ? 10 : 100) + (d2 + d1);
					if ((x1 > x2) && (x1 > x3)) {
						num = x1;
					} else if (x2 > x3) {
						num = x2;
					} else {
						num = x3;
					}
				} else if (num >= 100) {
					int d3 = ((int)(num / 100)) % 10;
					int x1 = (d3 + d2) * 10 + d1;
					int x2 = d3 * ((d2 + d1) < 10 ? 10 : 100) + (d2 + d1);
					if (x1 > x2) {
						num = x1;
					} else {
						num = x2;
					}
				} else {
					num = d2 + d1;
				}
			}
//			System.out.println("\t" + num);
			System.out.println("#" + test_case + " " + ((count % 2) == 0 ? "B" : "A" ));
		}
		sc.close();

		long endTimeNs = System.nanoTime();
		printProcessingTime(startTimeNs, endTimeNs);
	}
}

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
				if (num > 999) {
					int d1 = (int)(Math.floor(num / 1000));
					int d2 = (int)(Math.floor(num / 100) % 10);
					int d3 = (int)(Math.floor(num / 10) % 10);
					int d4 = num % 10;
					int x1 = Integer.parseInt(String.format("%d%d%d", d1 + d2, d3, d4));
					int x2 = Integer.parseInt(String.format("%d%d%d", d1, d2 + d3, d4));
					int x3 = Integer.parseInt(String.format("%d%d%d", d1, d2, d3 + d4));
					if ((x1 > x2) && (x1 > x3)) {
						num = x1;
					} else if (x2 > x3) {
						num = x2;
					} else {
						num = x3;
					}
				} else if (num > 99) {
					int d1 = (int)(Math.floor(num / 100) % 10);
					int d2 = (int)(Math.floor(num / 10) % 10);
					int d3 = num % 10;
					int x1 = Integer.parseInt(String.format("%d%d", d1 + d2, d3));
					int x2 = Integer.parseInt(String.format("%d%d", d1, d2 + d3));
					if (x1 > x2) {
						num = x1;
					} else {
						num = x2;
					}
				} else if (num > 9) {
					int d1 = (int)(Math.floor(num / 10) % 10);
					int d2 = num % 10;
					num = Integer.parseInt(String.format("%d", d1 + d2));
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

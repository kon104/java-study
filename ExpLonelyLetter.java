import java.util.Arrays;
import java.util.Scanner;

public class ExpLonelyLetter extends ExpBase {
	public static void main(String[] args) {
		String path = "./java-study/input-ExpLonelyLetter.txt";
		Scanner sc = fetchFileToScanner(path);
		long startTimeNs = System.nanoTime();		

		for (int test_case = 1; sc.hasNext(); test_case++) {
			String line = sc.nextLine();
			char[] src = line.toCharArray();
			char[] dst = new char[src.length];
			Arrays.sort(src);
			int j = 0;
			for (int i = 0; i < src.length; i++) {
				if ((i < (src.length - 1)) && (src[i] == src[i + 1])) {
					i++;
				} else {
					dst[j++] = src[i];
				}
			}
			char tmp[] = Arrays.copyOf(dst, j);
			String ans = new String(tmp);
			if (ans.equals("")) {
				ans = "Good";
			}
			String str = new String(src);
//			System.out.println(line + "\t" + str + "\t" + "[" + ans + "]" + "\t" + j);
			System.out.println("#" + test_case + " " + ans);
		}
		sc.close();

		long endTimeNs = System.nanoTime();
		printProcessingTime(startTimeNs, endTimeNs);
	}

}

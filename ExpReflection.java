import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class ExpReflection extends ExpBase {

	public static void main(String[] args) {
		String path = "./java-study/input-reflection.txt";
		Scanner sc = fetchFileToScanner(path);
//		sc.nextLine();

		long startTimeNs = System.nanoTime();
		
		for (int test_case = 1; sc.hasNext(); test_case++) {
			String line = sc.nextLine();
			char[] charSrc = line.toCharArray();
			char[] charDst = new char[charSrc.length];
			for (int i = 0; i < charSrc.length; i++) {
				char c = '-';
				switch (charSrc[charSrc.length - 1 - i]) {
					case 'b':
						c = 'd';
						break;
					case 'd':
						c = 'b';
						break;
					case 'p':
						c = 'q';
						break;
					case 'q':
						c = 'p';
						break;
					default:
						break;
				}
				charDst[i] = c;
			}
			String strAns = new String(charDst);
			System.out.println("#" + test_case + " " + strAns);
		}
		sc.close();

		long endTimeNs = System.nanoTime();
		printProcessingTime(startTimeNs, endTimeNs);
	}

}

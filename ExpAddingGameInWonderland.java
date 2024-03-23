import java.util.Arrays;
import java.util.Scanner;

public class ExpAddingGameInWonderland extends ExpBase {
	public static void main(String[] args) {
		String path = "./java-study/input-ExpAddingGameInWonderland.txt";
		Scanner sc = fetchFileToScanner(path);
		long startTimeNs = System.nanoTime();		

		for (int test_case = 1; sc.hasNext(); test_case++) {
			String line = sc.nextLine();
			char[] src = line.toCharArray();
			int count = 0;

//			System.out.println("\t(" + ((count % 2) == 0 ? 'A' : 'B') + ")curr=" + line);
			while (src.length > 1) {
				count++;

				char[] dst = makeNextValMax(src);
//				char[] dst = makeNextValMin(src);

//				System.out.println("\t(" + ((count % 2) == 0 ? 'A' : 'B') + ")next=" + String.valueOf(dst));
				src = Arrays.copyOf(dst, dst.length);
			}

			System.out.println("#" + test_case + " " + ((count % 2) == 0 ? "B" : "A" ));
		}
		sc.close();

		long endTimeNs = System.nanoTime();
		printProcessingTime(startTimeNs, endTimeNs);
	}

	private static char[] makeNextValMax(char[] src) {
		int[] pair = new int[src.length - 1];
		for (int i = 0; i < src.length - 1; i++) {
			pair[i] = (src[i] - 48) + (src[i + 1] - 48);
		}
		int maxVal = 0;
		int maxPos = 0;
		boolean isOver10 = false;
		for (int i = 0; i < pair.length; i++) {
			if (pair[i] > maxVal) {
				maxVal = pair[i];
				maxPos = i;
				if (maxVal >= 10) {
					isOver10 = true;
				}
			}
		}
		char[] dst = new char[(isOver10 ? src.length : (src.length - 1))];
		for (int i = 0, j = 0; i < dst.length; i++, j++) {
			if (i == maxPos) {
				if (isOver10) {
					dst[i] = (char)(((int)(maxVal / 10)) + 48);
					i++;
					dst[i] = (char)((maxVal % 10) + 48);
				} else {
					dst[i] = (char)(maxVal + 48);
				}
				j++;
			} else {
				dst[i] = src[j];
			}
		}
		return dst;
	}

	private static char[] makeNextValMin(char[] src) {
		int[] pair = new int[src.length - 1];
		for (int i = 0; i < src.length - 1; i++) {
			pair[i] = (src[i] - 48) + (src[i + 1] - 48);
		}
		int minVal = 0;
		int minPos = 0;
		boolean isOver10 = false;
		for (int i = 0; i < pair.length; i++) {
			if ((i == 0) || (pair[i] < minVal)) {
				minVal = pair[i];
				minPos = i;
				if (minVal >= 10) {
					isOver10 = true;
				}
			}
		}
		char[] dst = new char[(isOver10 ? src.length : (src.length - 1))];
		for (int i = 0, j = 0; i < dst.length; i++, j++) {
			if (i == minPos) {
				if (isOver10) {
					dst[i] = (char)(((int)(minVal / 10)) + 48);
					i++;
					dst[i] = (char)((minVal % 10) + 48);
				} else {
					dst[i] = (char)(minVal + 48);
				}
				j++;
			} else {
				dst[i] = src[j];
			}
		}
		return dst;
	}

}

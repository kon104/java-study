import java.util.LinkedList;
import java.util.StringJoiner;

public class ExpReflection extends ExpBase {

	public static void main(String[] args) {
		String path = "./java-study/input-reflection.txt";
		LinkedList<String> lines = readFileToList(path);

		long startTimeNs = System.nanoTime();
		
		int test_case = 0;
		for(String l: lines){
			test_case++;
			char[] charSrc = l.toCharArray();
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

		long endTimeNs = System.nanoTime();
		double diffNs = (endTimeNs - startTimeNs) / 1000000000.0;
		System.out.printf("処理時間: %.10f sec", diffNs);


	}

}

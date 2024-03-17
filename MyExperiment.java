import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

class MyExperiment {
	public static void main(String[] args) {
		if (true) readFile();
		if (true) resizeArray1();
		if (true) resizeArray2();
	}

	private static void printProcessingTime(long startTime, long endTime) {
		double diff = (endTime - startTime) / 1000000000.0;
		System.out.printf("処理時間: %.10f nano second in %s()", diff, Thread.currentThread().getStackTrace()[2].getMethodName());
		System.err.println();
		System.out.println(String.join("", Collections.nCopies(60, "-")));
	}

	private static void readFile() {
		long startTime = System.nanoTime();

		String path = "./java-study/input001.txt";
		LinkedList<String> lines = new LinkedList<>();
		try {
			FileInputStream fis = new FileInputStream(path);
			InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
			BufferedReader bf = new BufferedReader(isr);
			String line;
		    while((line = bf.readLine()) != null) {
				lines.add(line);
			}
		    bf.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}

		for(String l: lines){
			System.out.println(l);
		}

		long entTime = System.nanoTime();
		printProcessingTime(startTime, entTime);
	}

	private static void resizeArray1() {
		long startTime = System.nanoTime();

		int src[] = new int[15];
		for (int i = 0; i < src.length; i++) {
			src[i] = (i + 1);
		}

		int tmp[] = new int[src.length];
		int j = 0;
		for (int i: src) {
			if ((i % 3) != 0) {
				tmp[j++] = i;
			}
		}

		int dst[] = new int[j];
		System.arraycopy(tmp, 0, dst, 0, dst.length);

		System.out.printf("There are %s values from %s to %s.", dst.length, dst[0], dst[dst.length - 1]);
		System.out.println("");

		long endTime = System.nanoTime();
		printProcessingTime(startTime, endTime);


	}

	private static void resizeArray2() {
		long startTime = System.nanoTime();

		int src[] = new int[15];
		for (int i = 0; i < src.length; i++) {
			src[i] = (i + 1);
		}

		int tmp[] = new int[src.length];
		int j = 0;
		for (int i: src) {
			if ((i % 3) != 0) {
				tmp[j++] = i;
			}
		}

		int dst[] = Arrays.copyOf(tmp, j);

		System.out.printf("There are %s values from %s to %s.", dst.length, dst[0], dst[dst.length - 1]);
		System.out.println("");

		long endTime = System.nanoTime();
		printProcessingTime(startTime, endTime);
	}


}


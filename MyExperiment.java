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

		Runnable readFile = () -> {
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
		};

		Runnable resizeArrayBySystem = () -> {
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
		};

		Runnable resizeArrayByArrays = () -> {
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
		};

		if (true) calcProcessingTime(readFile, "readFile");
		if (true) calcProcessingTime(resizeArrayBySystem, "resizeArrayBySystem");
		if (true) calcProcessingTime(resizeArrayByArrays, "resizeArrayByArrays");
	}

	private static void calcProcessingTime(Runnable runnable, String name) {
		long startTimeMs = System.currentTimeMillis();
		long startTimeNs = System.nanoTime();
		runnable.run();
		long endTimeMs = System.currentTimeMillis();
		long endTimeNs = System.nanoTime();
		long diffMs = endTimeMs - startTimeMs;
		double diffNs = (endTimeNs - startTimeNs) / 1000000000.0;
		System.out.printf("処理時間: %d msec (%.10f sec) in %s()", diffMs, diffNs, name);
		System.out.println();
	}
}


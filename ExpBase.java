import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.LinkedList;
import java.util.Scanner;

public class ExpBase {
	public static void main(String[] args) {

		String path = "./java-study/input001.txt";
		LinkedList<String> lines = readFileToList(path);

		for(String l: lines){
			System.out.println(l);
		}				

	}

	protected static Scanner fetchFileToScanner(String path) {
		Scanner sc = null;
		try {
			File file = new File(path);
			sc = new Scanner(file);
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		}
		return sc;
	}

	protected static LinkedList<String> readFileToList(String path) {
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
		return lines;
	}

	protected static void printProcessingTime(long startTimeNs, long endTimeNs) {
		double diffNs = (endTimeNs - startTimeNs) / 1000000000.0;
		System.out.printf("処理時間: %.10f sec\n", diffNs);
	}
}

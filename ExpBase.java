import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.LinkedList;

public class ExpBase {
	public static void main(String[] args) {

		String path = "./java-study/input001.txt";
		LinkedList<String> lines = readFileToList(path);

		for(String l: lines){
			System.out.println(l);
		}				

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
}

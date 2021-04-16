package ui;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;


public class Main {
	
	//Towers
	private static int t1 = 1;
	private static int t2 = 2;
	private static int t3 = 3;
	
	//Number of discs in every tower
	private static int discs_t1;
	private static int discs_t2;
	private static int discs_t3;
	
	private static PrintWriter pWriter;
	private static BufferedReader bReader;
	
	
	public static void main(String[] args) throws IOException {
		File file = new File("output.txt");
		FileReader fileReader = new FileReader("input.txt");
		pWriter = new PrintWriter(file);
		bReader = new BufferedReader(fileReader);
		String line;
		int discs;
		ArrayList<String> input = new ArrayList<String>();
		
		try {
			
			while ((line = bReader.readLine()) != null) {
				input.add(line);
			}
			bReader.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		for (int i = 1; i <= Integer.parseInt(input.get(0)); i++) {
			discs_t1 = Integer.parseInt(input.get(i));
			discs = Integer.parseInt(input.get(i));
			pWriter.println(discs_t1 + " " + discs_t2 + " " + discs_t3);
			hanoi(discs, t1, t3, t2);
			
			pWriter.close();
			
		}
		
			
	}
	
	public static void hanoi(int discs, int t1, int t3, int t2) {

		if (discs == 1) {
			showAnswers(t1, t3);
			return;
		}
		hanoi(discs - 1, t1, t2, t3);
		showAnswers(t1, t3);
		hanoi(discs - 1, t2, t3, t1);
	}
	
	
	public static void showAnswers(int t1, int t3) {
		if (t1 == 1) {
			discs_t1--;
		}
		if (t1 == 2) {
			discs_t2--;
		}
		if (t1 == 3) {
			discs_t3--;
		}
		
		if (t3 == 1) {
			discs_t1++;
		}
		if (t3 == 2) {
			discs_t2++;
		}
		if (t3 == 3) {
			discs_t3++;
		}
		pWriter.println(discs_t1 + " " + discs_t2 + " " + discs_t3);
	}
	
}
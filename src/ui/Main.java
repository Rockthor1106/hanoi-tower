package ui;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Main {

	// Towers
	private static int t1 = 1;
	private static int t2 = 2;
	private static int t3 = 3;

	// Number of discs in every tower
	private static int discs_t1;
	private static int discs_t2;
	private static int discs_t3;

	private static PrintWriter pWriter;
	private static BufferedReader bReader;

	public static void main(String[] args) throws IOException {

		File file = new File("output.txt"); // make a file where will be print the outputs of Hanoi Towers
		FileReader fileReader = new FileReader("input.txt"); // search a file called "input.txt" where is the amount of
																// cases and the discs for every case
		pWriter = new PrintWriter(file);
		bReader = new BufferedReader(fileReader);

		// variables

		String line;
		int discs;
		ArrayList<String> input = new ArrayList<String>(); // in this ArrayList the program save the lines from file.txt

		// read input.txt
		try {

			while ((line = bReader.readLine()) != null) {
				input.add(line);
			}
			bReader.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		int amount_cases = Integer.parseInt(input.get(0));
		input.remove(0);// it is removed from the ArrayList to work only with the amount of discs for every case

		for (int i = 0; i < amount_cases; i++) {
			
			discs_t1 = Integer.parseInt(input.get(i)); // At first line the discs are in the tower one that's the reason for this assignment
			
			discs = Integer.parseInt(input.get(i)); // here the program gets the amount of discs for the current case
			
			pWriter.println(discs_t1 + " " + discs_t2 + " " + discs_t3); // this line print at the output.txt the first case where the discs are in the tower one
			
			hanoi(discs, t1, t3, t2);
			
			pWriter.println(" ");
			
			//Now, the variables are reestablished and they are ready for the next case
			discs = 0;
			discs_t1 = 0;
			discs_t2 = 0;
			discs_t3 = 0;
		}
		pWriter.close();

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
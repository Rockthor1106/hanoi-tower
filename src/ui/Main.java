package ui;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


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
	
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		File file = new File("output.txt");
		pWriter = new PrintWriter(file);

		int discs = sc.nextInt();
		discs_t1 = discs;

		pWriter.println(discs_t1 + " " + discs_t2 + " " + discs_t3);
		hanoi(discs, t1, t3, t2);	
	
		if (pWriter != null) {
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
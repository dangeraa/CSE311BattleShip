import java.awt.Frame;
import java.util.Scanner;

import javax.swing.JFrame;

public class Controller {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		
		
		int choice = 0;
		while(choice <1 || choice >2) {
			System.out.println("(1) for GUI. (2) for Text based");
			choice = input.nextInt();
		}
		
		if(choice == 1) {
			ConnectFourFrame cff = new ConnectFourFrame();
			
			JFrame jf = new JFrame();
			
			jf.setTitle("ConnectFour");
			jf.setSize(700,700);
			jf.setVisible(true);
			jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			jf.getContentPane().add(cff);	
		}
		
		
		if(choice == 2) {
			Board testBoard = new Board();
			
			Scanner input1 = new Scanner(System.in);
			int choice1 = 0;
			char playerTurn = 'r';
			//While the user has not chosen a vaild choice, it will ask them to make a move.
			while(testBoard.isWinningBoard() == false) {
				System.out.println(testBoard);	
				choice = 0;
				System.out.println("Make a move: choose a column between 1 and 7");
				choice = input.nextInt();
				while(choice >= 1 && choice <= 7) {
					
					if(testBoard.getMovesMade()%2==0) {
						playerTurn = 'R';
					}else {
						playerTurn = 'Y';
					}
					
					testBoard.makeMove(playerTurn, choice - 1);
					choice = 0;
				}
		}
			System.out.println(testBoard);
			if(testBoard.getMovesMade() % 2 == 0) {
				System.out.println("Player " + 2 + " Wins!");
			} else {
				System.out.println("Player " + 1 + " Wins!");
			}
			
		}
			
	}
}

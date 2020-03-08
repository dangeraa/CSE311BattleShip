/**
 * 
 * @author Cogan
 * A game board that consists of six rows and seven columns
 */
public class Board {
	private final int ROWS = 6;
	private final int COLUMNS = 7;
	private final int FOUR_IN_A_ROW = 4;
	private int movesMade = 0;
	private char[][] board = new char[ROWS][COLUMNS];
	/**
	 * Just gives the board
	 * Note the board should only
	 * return a copy of the this board
	 * @return the board
	 */
	public Board() {
		for (int i = 0; i < ROWS; i++) {
			for (int j = 0; j < COLUMNS; j++) {
				board[i][j] = ' ';
			}
		}
	}
	
	public Board(char[][] board) {
		if (board.length != ROWS || board[0].length != COLUMNS) {
			throw new IllegalArgumentException("Invalid Board! Must be six rows by seven columns!");
		} else {
			for (int i = 0; i < board.length; i++) {
				for (int j = 0; j < board[i].length; j++) {
					this.board[i][j] = board[i][j];
				}
			}
		}
	}
	
	public char[][] getBoard() {
		char[][] returnedBoard = new char[ROWS][COLUMNS];
		for (int i = 0; i < ROWS; i++) {
			for (int j = 0; j < COLUMNS; j++) {
				returnedBoard[i][j] = board[i][j];
			}
		}
		return returnedBoard;
	}
	
	/**
	 * 
	 * @param playerChar
	 * @param row
	 * @param column
	 */
	public boolean makeMove(char playerChar, int column) {
		for (int i = ROWS - 1; i >= 0; i--) {
			if (board[i][column] != ' ') {
				board[i][column] = playerChar;
				movesMade++;
				return true;
			}
		}
		return false;
		
	}
	
	public int getMoves() {
		return movesMade;
	}
	
	private String highestRightDiagonalStreak() {
		String result = "";
		// Diagonals going up
		for (int row = ROWS - 1; row >= 0; row--) {
			int currRow = row;
			for (int column = 0; currRow < ROWS && column < COLUMNS; column++)
			{
				result = result + board[currRow][column];
				currRow++;
			}
			result = result + " ";
		}
		// Diagonals going right
		for (int column = 1; column < COLUMNS; ++ column) {
			int currColumn = column;
			for (int row = 0; row < ROWS && currColumn < COLUMNS; row++) {
				result = result + board[row][currColumn];
				currColumn++;
			}
			result = result + " ";
		}
		
		return result;
	}
	
	private int highestLeftDiagonalStreak() {
		return 0;
	}
	
	private int highestVerticalStreak() {
		return 0;
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean isWinningBoard() {
		if (highestVerticalStreak() >= FOUR_IN_A_ROW 
				|| highestLeftDiagonalStreak() >= FOUR_IN_A_ROW
				|| highestRightDiagonalStreak().length() >= FOUR_IN_A_ROW)
			return true;
		return false;
	}
	
	/**
	 * @Override
	 * @return
	 */
	public String toString() {
		String returnedString = "";
		for (int i = 0; i < ROWS; i++) {
			returnedString = returnedString + "[ " + board[i][0];
			for (int j = 1; j < COLUMNS; j++) {
				returnedString = returnedString + " | " + board[i][j];
			}
			returnedString = returnedString + "]";
			if (i < ROWS - 1)
				returnedString = returnedString + "\n\n";
		}
		return returnedString;
	}
	
	public static void main(String[] args) {
		Board testBoard = new Board();
		System.out.println(testBoard);
	}
	
	
}

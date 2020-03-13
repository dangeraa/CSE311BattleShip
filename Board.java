/**
 * Logic of Connect Four game is here, also creates text-based view
 * @author Abby Danger, Scott Cogen, Andrew Grimes
 *
 */
public class Board {
	
	/*Sets board demensions*/
	private final int ROWS = 6;
	private final int COLUMNS = 7;
	private final int FOUR_IN_A_ROW = 4;
	private int movesMade = 0;
	private char[][] board = new char[ROWS][COLUMNS];
	
	/**
	 * Creates the board
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
	
	/**
	 * Gets the current board
	 * @return the board
	 */
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
	 * Allows the player to make a move, stores their move in the array
	 * @param playerChar
	 * @param row
	 * @param column
	 * @return true if they made a move, false if not
	 */
	public boolean makeMove(char playerChar, int column) {
		for (int i = ROWS - 1; i >= 0; i--) {
			if (board[i][column] == ' ') {
				board[i][column] = playerChar;
				movesMade++;
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Gets the amount of moves that were just made
	 * @return number of moves
	 */
	public int getMoves() {
		return movesMade;
	}
	
	/**
	 * Creates the combination for right diagonal streaks
	 * @return string of the streak
	 */
	private String highestRightDiagonalStreak() {
		String result = "";
		
		// Diagonals going up
		for (int row = ROWS - 1; row >= 0; row--) {
			int currRow = row; // The row of the diagonal
			for (int column = 0; currRow < ROWS && column < COLUMNS; column++)
			{
				result = result + board[currRow][column];
				currRow++;
			}
			result = result + " ";
		}
		
		// Diagonals going right
		for (int column = 1; column < COLUMNS; column++) {
			int currColumn = column; // The column of the diagonal
			for (int row = 0; row < ROWS && currColumn < COLUMNS; row++) {
				result = result + board[row][currColumn];
				currColumn++;
			}
			result = result + " ";
		}
		return result;
	}
	
	/**
	 * Creates the combination for left diagonal streaks
	 * @return string of the streak
	 */
	private String highestLeftDiagonalStreak() {
		String result = "";
		
		// Diagonals going up
		for (int row = ROWS - 1; row >= 0; row--) {
			int currRow = row;
			for (int column = COLUMNS - 1; currRow < ROWS && column >= 0; column--)
			{
				result = result + board[currRow][column];
				currRow++;
			}
			result = result + " ";
		}
		
		// Diagonals going right
		for (int column = COLUMNS - 2; column >= 0;  --column) {
			int currColumn = column;
			for (int row = 0; row < ROWS && currColumn < COLUMNS; row++) {
				result = result + board[row][currColumn];
				currColumn++;
			}
			result = result + " ";
		}
		return result;
	}
	
	/**
	 * Creates the combination for horizontal streaks
	 * @return string of the streak
	 */
	private String highestHorizontalStreak() {
		String result = "";
		for (int i = 0; i < ROWS; i++) {
			for (int j = 0; j < COLUMNS; j++) {
				result = result + board[i][j];
			}
			result = result + " ";
		}
		return result;
	}
	
	/**
	 * Creates the combination for vertical streaks
	 * @return string of the streak
	 */
	private String highestVerticalStreak() {
		String result = "";
		for (int i = 0; i < COLUMNS; i++) {
			for (int j = 0; j < ROWS; j++) {
				result = result + board[j][i];
			}
			result = result + " ";
		}
		return result;
	}
	
	
	/**
	 * Determines if the order of the board is a streak or not
	 * @param boardOrder
	 * @return the length of the streak
	 */
	private int streak(String boardOrder) {
		int maxStreak = 0;
		String streak = "";
		for (int i = 0; i < boardOrder.length(); i++) {
			char currentChar = boardOrder.charAt(i);
			if (currentChar != ' ' && (streak.length() == 0 || currentChar == streak.charAt(0))) {
				streak = streak + currentChar;
			} else {
				maxStreak = Math.max(streak.length(), maxStreak);
				if(currentChar == ' ')
					streak = "";
				else
					streak = "" + currentChar;
			}
			
		}
		return Math.max(streak.length(), maxStreak);
	}
	
	/**
	 * Determines if the board contains a winning combination
	 * @return true if the board contains a winning combination, false if not
	 */
	public boolean isWinningBoard() {
		if 		  (streak(highestHorizontalStreak()) >= 4
				|| streak(highestVerticalStreak()) >= 4
				|| streak(highestRightDiagonalStreak()) >= 4
				|| streak(highestLeftDiagonalStreak()) >= 4) {
			return true;
		}
		return false;
	}
	
	/**
	 * Simple method that represents the board as a string
	 * @Override
	 * @return board as a string
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

	
	/*Helper Methods*/
	
	public int getMovesMade() {
		return movesMade;
	}

	public void setMovesMade(int movesMade) {
		this.movesMade = movesMade;
	}

	public int getROWS() {
		return ROWS;
	}

	public int getCOLUMNS() {
		return COLUMNS;
	}

	public int getFOUR_IN_A_ROW() {
		return FOUR_IN_A_ROW;
	}

	public void setBoard(char[][] board) {
		this.board = board;
	}
	
}

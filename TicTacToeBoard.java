package TicTacToe;

public class TicTacToeBoard {

	// Konstruktor
	
	public TicTacToeBoard() {
		this.initializeBoard();
	}
	
	
	// Attribute
	
	private String[][] board = new String[3][3];

	
	// Methoden
	
	public void initializeBoard() {
		// Board erstmalig befuellen
		for (int i = 0; i < this.board.length; i++) {
							
					for (int j = 0; j < this.board.length; j ++) {
								
						this.board[i][j] = "| |";
								
					} // Ende innere for-Schleife
							
				} // Ende aeussere for-Schleife
				
		// und erstmalig ausgeben...
		this.drawBoard();
	}
	
	public void drawBoard() {
		
		// erstmal wieder Platz auf der Konsole schaffen...
		this.clearConsole();
		
		// und jetzt zeichnen
		for (int i = 0; i < this.board.length; i++) {
			
			for (int j = 0; j < this.board.length; j ++) {
				
				System.out.print(this.board[i][j] + "\t");
				
			} // Ende innere for-Schleife
			
			System.out.println(); // neue Zeile
			System.out.println(); // neue Zeile
			
		} // Ende aeussere for-Schleife
		
	}
	
	public void clearConsole() {
		for (int i = 0; i < 15; i ++) {
			System.out.println();
		}
	}
	
	public boolean setSign(String sign, int column, int row, int playerNo) {

		if (column > 3 || row > 3 || column < 1 || row < 1) {
			System.out.println("Bzzz... Bzzz... FEHLER! Feld ausserhalb des Spielfelds!\nBitte nochmal...\n");
			return false;
		}
		else if ((playerNo == 1 && this.board[row-1][column-1].equals("|X|")) || (playerNo == 2 && this.board[row-1][column-1].equals("|O|"))){
			System.out.println("Brrr... Bzzz.... Feld bereits von dir belegt!\nBitte nochmal...\n");
			return false;
		}
		else if((playerNo == 1 && this.board[row-1][column-1].equals("|O|")) || (playerNo == 2 && this.board[row-1][column-1].equals("|X|"))) {
			System.out.println("Krrrch... krrch... Feld bereits von deinem Gegenspieler belegt!\nBitte nochmal...\n");
			return false;
		}
		else if(this.board[row-1][column-1].equals("| |")) {
			this.board[row-1][column-1] = sign;
			return true;
		} else {return false;}
		
	}
	
	public boolean checkWinner(TicTacToeGamer player) {
		
		// Reihe 1
		if (this.board[0][0].equals(player.getSign()) && this.board[0][1].equals(player.getSign()) && this.board[0][2].equals(player.getSign())) {
			player.setScore(player.getScore()+1);
			return true;
		}
		// Reihe 2
		else if (this.board[1][0].equals(player.getSign()) && this.board[1][1].equals(player.getSign()) && this.board[1][2].equals(player.getSign())) {
			player.setScore(player.getScore()+1);
			return true;
		}
		// Reihe 3
		else if (this.board[2][0].equals(player.getSign()) && this.board[2][1].equals(player.getSign()) && this.board[2][2].equals(player.getSign())) {
			player.setScore(player.getScore()+1);
			return true;
		}
		// Spalte 1
		else if (this.board[0][0].equals(player.getSign()) && this.board[1][0].equals(player.getSign()) && this.board[2][0].equals(player.getSign())) {
			player.setScore(player.getScore()+1);
			return true;
		}
		// Spalte 2
		else if (this.board[0][1].equals(player.getSign()) && this.board[1][1].equals(player.getSign()) && this.board[2][1].equals(player.getSign())) {
			player.setScore(player.getScore()+1);
			return true;
		}
		// Spalte 3
		else if (this.board[0][2].equals(player.getSign()) && this.board[1][2].equals(player.getSign()) && this.board[2][2].equals(player.getSign())) {
			player.setScore(player.getScore()+1);
			return true;
		}
		// Diagnonale 1
		else if (this.board[0][0].equals(player.getSign()) && this.board[1][1].equals(player.getSign()) && this.board[2][2].equals(player.getSign())) {
			player.setScore(player.getScore()+1);
			return true;
		}
		// Diagnonale 2
		else if (this.board[0][2].equals(player.getSign()) && this.board[1][1].equals(player.getSign()) && this.board[2][0].equals(player.getSign())) {
			player.setScore(player.getScore()+1);
			return true;
		} else {return false;}
	}
	
	public boolean checkDraw() {
		
		int unusedFields = 0;
		
		for (int i = 0; i < this.board.length; i++) {
									
					for (int j = 0; j < this.board.length; j ++) {
										
						if (this.board[i][j].equals("| |")) {
							unusedFields++;
						}
										
					} // Ende innere for-Schleife
									
				} // Ende aeussere for-Schleife
		
		if (unusedFields > 0) {
			return false;
		} else {return true;}
		
	}
	
	// getter setter
	
	public String[][] getBoard() {
		return board;
	}

	public void setBoard(String[][] board) {
		this.board = board;
	}
}

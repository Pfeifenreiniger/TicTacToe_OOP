package TicTacToe;

import java.util.Scanner;

public class TicTacToeGame {

	public static void main(String[] args) {
		
		// Das Spielbrett und die beiden Spieler-Objekte instanziieren...
		TicTacToeBoard board = new TicTacToeBoard();
		TicTacToeGamer player1 = new TicTacToeGamer(1);
		TicTacToeGamer player2 = new TicTacToeGamer(2);
		
		
		Scanner sc = new Scanner(System.in);
		int round = 1;

		boolean gameloop = true;
		// Gameloop
		System.out.println("+++RUNDE " + round + "+++");
		gameloop : while(gameloop) {
			
			// Spielzug Spieler1
			if (player1.isTurn()) {
				if (playerTurn(board, player1)) {
					board.drawBoard();
					if (board.checkWinner(player1)) {
						System.out.println("SPIELER 1 HAT GEWONNEN!!!! ^,^");
						System.out.println("Score Spieler 1: " + player1.getScore());
						System.out.println("Score Spieler 2: " + player2.getScore());
						if (nextRound()) {
							System.out.println("Es beginnt der Verlierer... :)");
							round++;
							board.initializeBoard();
							System.out.println("+++RUNDE " + round + "+++");
						} else {
							break gameloop;
						}
						
					}
					
					if (board.checkDraw()) {
						System.out.println("Tja... keiner gewonnnen");
						if (nextRound()) {
							System.out.println("Es beginnt - wie zu Anfang - Spieler 1.");
							round++;
							board.initializeBoard();
							continue;
						}
					}
					
					player1.setTurn(false);
					player2.setTurn(true);
				}
			} 
			// Spielzug Spieler2
			else {
				if (playerTurn(board, player2)) {
					board.drawBoard();
					if (board.checkWinner(player2)) {
						System.out.println("SPIELER 2 HAT GEWONNEN!!!! ^,^");
						System.out.println("Score Spieler 1: " + player1.getScore());
						System.out.println("Score Spieler 2: " + player2.getScore());
						if (nextRound()) {
							System.out.println("Es beginnt der Verlierer... :)");
							round++;
							board.initializeBoard();
							System.out.println("+++RUNDE " + round + "+++");
						} else {
							break gameloop;
						}
						
					}
					
					if (board.checkDraw()) {
						System.out.println("Tja... keiner gewonnnen");
						if (nextRound()) {
							System.out.println("Es beginnt - wie zu Anfang - Spieler 1.");
							round++;
							board.initializeBoard();
						}
					}
					
					player2.setTurn(false);
					player1.setTurn(true);
				}
			}
			
			
			
		} // Ende gameloop
		
		String roundString;
		if (round == 1) {
			roundString = " Runde! ";
		} else {
			roundString = " Runden! ";
		}
		System.out.println("\nDanke fuer's Spielen von " + round + roundString + "See you next time n_n");

	} // Ende main-Methode

	
	public static boolean playerTurn(TicTacToeBoard board, TicTacToeGamer player) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Dein Zug, Spieler " + player.getNumber() + ".");
		System.out.print("Spalte: ");
		int column = sc.nextInt();
		System.out.print("Reihe: ");
		int row = sc.nextInt();
		return board.setSign(player.getSign(), column, row, player.getNumber());
	}
	
	public static boolean nextRound() {
		Scanner sc = new Scanner(System.in);
		String wannaContinue;
		System.out.print("Noch eine Runde? (y / n):  ");
		wannaContinue = sc.nextLine().toLowerCase();
		if (wannaContinue.startsWith("y")) {
			return true;
		} else {
			return false;
		}
	}
	
} // Ende Klasse

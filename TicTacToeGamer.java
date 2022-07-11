package TicTacToe;

public class TicTacToeGamer {

	// Konstruktor
	
	public TicTacToeGamer(int number) {
		this.setNumber(number);
		if (this.number == 1) {
			this.sign = "|X|";
			// zu Beginn ist Spieler 1 dran.
			this.setTurn(true);
		} else {
			this.sign = "|O|";
			this.setTurn(false);
		}
		this.setScore(0);
	}
	
	// Attribute
	
	private int number;
	private String sign;
	private int score;
	private boolean turn;

	
	// getter setter
	
	public int getNumber() {
		return number;
	}
	
	public void setNumber(int number) {
		if (number <= 1) {
			this.number = 1;
		} else {
			this.number = 2;
		}
	}
	
	public String getSign() {
		return sign;
	}
	
	public void setSign(String sign) {
		this.sign = sign;
	}
	
	public int getScore() {
		return score;
	}
	
	public void setScore(int score) {
		this.score = score;
	}
	
	public void setTurn(boolean turn) {
		this.turn = turn;
	}
	
	public boolean isTurn() {
		return this.turn;
	}
	
}

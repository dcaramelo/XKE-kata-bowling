package bowling;

public class Shoot {

	private Type type;
	private int score;
	private int bonus = 0;
	
	public Shoot(int score, Type type) {
		this.score = score;
		this.type = type;
	}

	public int getScore() {
		return score;
	}
	
	public Type getType() {
		return type;
	}
	
	public void setScore(int score) {
		this.score = score;
	}
	
	public void setType(Type type) {
		this.type = type;
	}

	public void addBonus(int score) {
		this.bonus += score;
	}
	
	public int getFinalScore() {
		return score + bonus;
	}
}

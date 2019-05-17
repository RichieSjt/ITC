public abstract class CaesarCode implements ICode {
	private int offset;
	
	public int getOffset() {
		return offset;
	}
	public void setOffset(int offset) {
		this.offset = offset;
	}
	protected int toNumber(char letter) {
		return letter;
	}
	protected int toNumber(String letter) {
		return letter.toCharArray()[0];
	}
	protected String toLetter(int number) {
		if (number < 'a')
			number = number + ('z' - 'a' + 1);
		else if (number > 'z')
			number = number - ('z' - 'a' + 1);
		return Character.toString((char)number);
	}
}


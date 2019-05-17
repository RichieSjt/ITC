public abstract class ReplacementCode implements ICode {
	private char[][] replacements;
	
	public void setReplacements(char[][] replacements) {
		this.replacements = replacements;
	}
	
	public char[][] getReplacements() {
		return this.replacements;
	}
}
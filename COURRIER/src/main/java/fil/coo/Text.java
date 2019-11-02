package fil.coo;

public class Text implements Content {

	private String text;

	/**
	 * @param text
	 */
	public Text(String text) {
		this.text = text;
	}

	public String getText() {
		return this.text;
	}

	@Override
	public String getDescription() {
		return this.getText();
	}

	@Override
	public Content copyContent() {
		return new Text(this.getText());
	}

}

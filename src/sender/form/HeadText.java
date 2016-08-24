package sender.form;

public class HeadText extends HttpRequestEntryText {

	public HeadText(String key, String value) {
		super(key, value);
	}

	public String toString() {
		return this.key + ": " + this.value + "\r\n";
	}
}

package sender.form;

public class ContentText extends HttpRequestEntryText {
	public ContentText(String key, String value) {
		super(key, value);
	}

	public String toString() {
		return this.key + "=" + this.value;
	}
}

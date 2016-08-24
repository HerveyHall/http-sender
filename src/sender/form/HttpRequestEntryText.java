package sender.form;

public class HttpRequestEntryText {
	protected String key;
	protected String value;

	public HttpRequestEntryText(String key, String value) {
		this.key = key;
		this.value = value;
	}

	public String getKey() {
		return this.key;
	}

	public String getValue() {
		return this.value;
	}

	public boolean keyEquals(HttpRequestEntryText entry) {
		if (this.key.equals(entry.getKey()))
			return true;
		return false;
	}

	public boolean valueEquals(HttpRequestEntryText entry) {
		if (this.value.equals(entry.getValue()))
			return true;
		return false;
	}

	public boolean equals(HttpRequestEntryText entry) {
		if (this.keyEquals(entry) && this.valueEquals(entry))
			return true;
		return false;
	}
}

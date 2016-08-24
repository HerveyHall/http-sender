package sender.form;

public enum HttpRequestMethod {
	GET("GET"), POST("POST");
	private String method;

	private HttpRequestMethod(String method) {
		this.method = method;
	}

	public String getMethod() {
		return method;
	}
}

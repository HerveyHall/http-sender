package sender.form;

/**
 * The content of HTTP packet which format is form. 表单格式的HTTP报文内容
 * 
 * @author Hervey Hall
 *
 */
public class FormHttpContent extends HttpRequestEntryText implements HttpContent {

	/**
	 * Construct a content of HTTP packet which format is form. <br>
	 * Format: <br>
	 * 
	 * <pre>
	 * key = value
	 * </pre>
	 * 
	 * <br>
	 * <br>
	 * 构造一个表单格式的HTTP报文内容<br>
	 * 格式如下：<br>
	 * 
	 * <pre>
	 * 键 = 值
	 * </pre>
	 * 
	 * @param key
	 *            The key of the parameter. 参数的键
	 * @param value
	 *            The value of the parameter. 参数的值
	 */
	public FormHttpContent(String key, String value) {
		super(key, value);
	}

	public String toString() {
		return this.key + "=" + this.value;
	}
}

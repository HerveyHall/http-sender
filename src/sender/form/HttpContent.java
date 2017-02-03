package sender.form;

/**
 * The content of HTTP packet. HTTP报文的内容
 * 
 * @author Hervey Hall
 *
 */
public interface HttpContent {

	/**
	 * Get the length of the content. 获取报文内容的长度
	 * 
	 * @return length 报文的长度
	 */
	public default long getLength() {
		return this.toString().length();
	}

	/**
	 * Get the content as a string. 获取报文内容字符串
	 * 
	 * @return
	 */
	@Override
	public String toString();
}

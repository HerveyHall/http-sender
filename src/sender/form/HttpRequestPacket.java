package sender.form;

import java.util.*;

public abstract class HttpRequestPacket {
	private String method = "GET";
	private String url = new String();
	private String protocol = "HTTP/1.1";
	private Vector<HeadText> head = new Vector<HeadText>();

	/**
	 * Get the method of the request. 获取请求的方法
	 * 
	 * @return The method 请求的方法
	 */
	public String getMethod() {
		return method.toUpperCase();
	}

	/**
	 * Set the method of the request. 设置请求的方法
	 * 
	 * @param method
	 *            The method 请求的方法
	 */
	public void setMethod(HttpRequestMethod method) {
		this.method = method.getMethod();
	}

	/**
	 * Get the URL of the request. 获取请求的URL信息
	 * 
	 * @return The URL 请求的URL
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * Set the URL of the request. 设置请求的URL信息
	 * 
	 * @param url
	 *            The URL 请求的URL
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * Get the protocol of the request. 获取请求使用的协议
	 * 
	 * @return The protocol 请求的协议
	 */
	public String getProtocol() {
		return protocol;
	}

	/**
	 * Set the protocol of the request. 设置请求使用的协议
	 * 
	 * @param protocol
	 *            The protocol 请求的协议
	 */
	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}

	public String getRequestHead() {
		int size = this.head.size();
		String head = new String();
		for (int i = 0; i < size; ++i)
			head += this.head.get(i).toString();
		return head;
	}

	public boolean addHeadText(HeadText head) {

		int size = this.head.size();
		this.head.addElement(head);
		if (this.head.size() == 1 + size)
			return true;
		return false;
	}

	public boolean deleteHeadText(HeadText head) {
		int size = this.head.size();
		Iterator<HeadText> i = this.head.iterator();
		HeadText elem = null;
		while (i.hasNext()) {
			elem = i.next();
			if (elem.keyEquals(head))
				i.remove();
		}
		return this.head.size() < size ? true : false;
	}

	public abstract String getRequestContent();

	public abstract <T extends HttpContent> boolean addContentText(T content);

	public abstract <T extends HttpContent> boolean deleteContentText(T content);

	public String toString() {
		return this.method + " " + this.url + " " + this.protocol + "\r\n" + this.getRequestHead() + "\r\n"
				+ this.getRequestContent();
	}
}

package sender.form;

import java.util.*;

public class HttpRequestPacket {
	private String method = "GET";
	private String url = new String();
	private String protocol = "HTTP/1.1";
	private Vector<HeadText> head = new Vector<HeadText>();
	private Vector<ContentText> content = new Vector<ContentText>();

	public String getMethod() {
		return method.toUpperCase();
	}

	public void setMethod(HttpRequestMethod method) {
		this.method = method.getMethod();
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getProtocol() {
		return protocol;
	}

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

	public String getRequestContent() {
		int size = this.content.size();
		String content = new String();
		for (int i = 0; i < size; ++i)
			content += this.content.get(i).toString() + (i == size - 1 ? "" : "&");
		return content;
	}

	public boolean addContentText(ContentText content) {
		int size = this.content.size();
		this.content.addElement(content);
		if (this.content.size() == 1 + size)
			return true;
		return false;
	}

	public boolean deleteContentText(ContentText content) {
		int size = this.content.size();
		Iterator<ContentText> i = this.content.iterator();
		ContentText elem = null;
		while (i.hasNext()) {
			elem = i.next();
			if (elem.keyEquals(content))
				i.remove();
		}
		return this.content.size() > size ? true : false;
	}

	public String toString() {
		return this.method + " " + this.url + " " + this.protocol + "\r\n" + this.getRequestHead() + "\r\n"
				+ this.getRequestContent();
	}
}

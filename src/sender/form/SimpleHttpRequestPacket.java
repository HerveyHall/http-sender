package sender.form;

import java.util.Iterator;
import java.util.Vector;

public class SimpleHttpRequestPacket extends HttpRequestPacket {

	private Vector<FormHttpContent> content = new Vector<>();

	@Override
	public String getRequestContent() {
		int size = this.content.size();
		String content = new String();
		for (int i = 0; i < size; ++i) {
			content += this.content.get(i).toString() + (i == size - 1 ? "" : "&");
		}
		return content;
	}

	public boolean addContentText(HttpContent httpContent) {
		FormHttpContent content = null;
		try {
			content = (FormHttpContent) httpContent;
		} catch (ClassCastException e) {
			return false;
		}
		int size = this.content.size();
		this.content.addElement(content);
		if (this.content.size() != 1 + size) {
			return false;
		}
		return true;
	}

	@Override
	public boolean deleteContentText(HttpContent httpContent) {
		FormHttpContent content = null;
		try {
			content = (FormHttpContent) httpContent;
		} catch (ClassCastException e) {
			return false;
		}
		int size = this.content.size();
		Iterator<FormHttpContent> i = this.content.iterator();
		FormHttpContent elem = null;
		while (i.hasNext()) {
			elem = i.next();
			if (elem.keyEquals(content))
				i.remove();
		}
		return this.content.size() > size ? true : false;
	}

}

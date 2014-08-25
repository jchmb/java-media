package nl.jchmb.media.content;

import java.util.ArrayList;
import java.util.Collection;

public class SimpleContentContainer implements ContentContainer {
	private Collection<Content> contentObjects;
	
	public SimpleContentContainer() {
		contentObjects = new ArrayList<Content>();
	}
	
	@Override
	public String getContentString() {
		StringBuilder stringBuilder = new StringBuilder();
		for (Content content : contentObjects) {
			stringBuilder.append(content.getContentString());
		}
		return stringBuilder.toString();
	}

	@Override
	public void addContent(Content content) {
		contentObjects.add(content);
	}

}

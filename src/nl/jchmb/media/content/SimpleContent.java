package nl.jchmb.media.content;

public class SimpleContent implements Content {
	private String contentString;
	
	public SimpleContent(String contentString) {
		this.contentString = contentString;
	}
	
	public String getContentString() {
		return contentString;
	}
}

package nl.jchmb.media.post;

public class SimplePoster implements Poster {
	private String name;
	
	public SimplePoster(String name) {
		this.name = name;
	}
	
	@Override
	public String getName() {
		return name;
	}
}

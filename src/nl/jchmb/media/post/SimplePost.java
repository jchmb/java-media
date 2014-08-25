package nl.jchmb.media.post;

import nl.jchmb.media.content.Content;

public class SimplePost implements Post {
	private Content content;
	private Poster poster;
	
	public SimplePost(Poster poster, Content content) {
		this.poster = poster;
		this.content = content;
	}
	
	@Override
	public Content getContent() {
		return content;
	}

	@Override
	public Poster getPoster() {
		return poster;
	}
}

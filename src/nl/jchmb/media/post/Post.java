package nl.jchmb.media.post;

import nl.jchmb.media.content.Content;
import nl.jchmb.media.entity.Entity;

public interface Post extends Entity {
	public Content getContent();
	public Poster getPoster();
}

package nl.jchmb.media.article;

import java.net.URL;

import nl.jchmb.media.entity.Entity;

public interface Article extends Entity {
	public String getTitle();
	public URL getURL();
}

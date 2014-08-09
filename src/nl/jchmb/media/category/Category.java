package nl.jchmb.media.category;

import java.net.URL;

import nl.jchmb.media.entity.Entity;

public interface Category extends Entity {
	public String getName();
	public URL getURL();
}

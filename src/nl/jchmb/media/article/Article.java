package nl.jchmb.media.article;

import java.net.URL;

import nl.jchmb.media.entity.Entity;
import nl.jchmb.media.hydrator.Hydratable;

public interface Article extends Entity, Hydratable {
	public String getTitle();
	public URL getURL();
}

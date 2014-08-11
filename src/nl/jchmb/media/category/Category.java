package nl.jchmb.media.category;

import nl.jchmb.media.adapter.MediumAdapter;
import nl.jchmb.media.entity.Entity;

public interface Category<T extends Entity> extends Entity {
	public String getName();
	public MediumAdapter<T> getAdapter();
}
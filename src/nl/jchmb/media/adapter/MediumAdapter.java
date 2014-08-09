package nl.jchmb.media.adapter;

import java.util.Collection;

import nl.jchmb.media.adapter.exception.MediumAdapterException;
import nl.jchmb.media.entity.Entity;

public interface MediumAdapter<T extends Entity> {
	public Collection<T> fetch() throws MediumAdapterException;
}

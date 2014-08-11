package nl.jchmb.media.adapter;

import nl.jchmb.media.entity.Entity;

public interface AggregateMediumAdapter<T extends Entity> extends MediumAdapter<T> {
	public AggregateMediumAdapter<T> addMediumAdapter(MediumAdapter<T> adapter);
}

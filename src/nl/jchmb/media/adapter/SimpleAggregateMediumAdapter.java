package nl.jchmb.media.adapter;

import java.util.ArrayList;
import java.util.Collection;

import nl.jchmb.media.adapter.exception.MediumAdapterException;
import nl.jchmb.media.entity.Entity;

public class SimpleAggregateMediumAdapter<T extends Entity> implements AggregateMediumAdapter<T> {
	private Collection<MediumAdapter<T>> adapters;
	
	public SimpleAggregateMediumAdapter() {
		adapters = new ArrayList<MediumAdapter<T>>();
	}
	
	@Override
	public Collection<T> fetch() throws MediumAdapterException {
		Collection<T> collection = new ArrayList<T>();
		for (MediumAdapter<T> adapter : adapters) {
			collection.addAll(adapter.fetch());
		}
		return collection;
	}

	@Override
	public AggregateMediumAdapter<T> addMediumAdapter(MediumAdapter<T> adapter) {
		adapters.add(adapter);
		return this;
	}
	
	public void clear() {
		adapters.clear();
	}
}

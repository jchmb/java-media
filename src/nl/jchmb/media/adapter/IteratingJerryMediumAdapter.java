package nl.jchmb.media.adapter;

import java.util.ArrayList;
import java.util.Collection;

import jodd.jerry.Jerry;
import nl.jchmb.media.adapter.exception.MediumAdapterException;
import nl.jchmb.media.data.Data;
import nl.jchmb.media.entity.Entity;

public abstract class IteratingJerryMediumAdapter<T extends Entity> extends JerryMediumAdapter<T> {
	protected abstract Data getData(Jerry element) throws MediumAdapterException;
	
	protected abstract String getSelector();
	
	protected Collection<Data> getDataCollection(Jerry doc) throws MediumAdapterException {
		Collection<Data> dataCollection = new ArrayList<Data>();
		for (Jerry element : doc.$(getSelector())) {
			dataCollection.add(getData(element));
		}
		return dataCollection;
	}
}

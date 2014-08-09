package nl.jchmb.media.adapter;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Collection;

import nl.jchmb.media.adapter.exception.MediumAdapterException;
import nl.jchmb.media.data.Data;
import nl.jchmb.media.entity.Entity;

public abstract class InternetMediumAdapter<T extends Entity> implements MediumAdapter<T> {
	protected abstract String getURLString();
	
	public Collection<T> fetch() throws MediumAdapterException {
		Collection<Data> dataCollection = getDataCollection();
		Collection<T> collection = entitizeCollection(dataCollection);
		return collection;
	}
	
	private InputStream getInputStream() throws MediumAdapterException {
		URL url = getURL();
		try {
			URLConnection connection = url.openConnection();
			return connection.getInputStream();
		} catch (IOException e) {
			throw new MediumAdapterException();
		}
	}
	
	private URL getURL() throws MediumAdapterException {
		try {
			URL url = new URL(getURLString());
			return url;
		} catch (MalformedURLException e) {
			MediumAdapterException fetcherException = new MediumAdapterException();
			throw fetcherException;
		}		
	}
	
	private Collection<T> entitizeCollection(Collection<Data> dataCollection) throws MediumAdapterException {
		Collection<T> collection = new ArrayList<T>();
		for (Data data : dataCollection) {
			collection.add(entitize(data));
		}
		return collection;
	}
	
	protected abstract T entitize(Data data) throws MediumAdapterException;
	
	protected Collection<Data> getDataCollection() throws MediumAdapterException {
		InputStream inputStream = getInputStream();
		Collection<Data> dataCollection = getDataCollection(inputStream);
		try {
			inputStream.close();
		} catch (IOException e) {
			throw new MediumAdapterException();
		}
		return dataCollection;
	}
	
	protected abstract Collection<Data> getDataCollection(InputStream inputStream) throws MediumAdapterException;
}

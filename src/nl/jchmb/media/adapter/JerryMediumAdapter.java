package nl.jchmb.media.adapter;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collection;

import jodd.jerry.Jerry;
import nl.jchmb.media.adapter.exception.MediumAdapterException;
import nl.jchmb.media.data.Data;
import nl.jchmb.media.entity.Entity;

public abstract class JerryMediumAdapter<T extends Entity> extends InternetMediumAdapter<T> {
	protected abstract Collection<Data> getDataCollection(Jerry doc) throws MediumAdapterException;
	
	protected Collection<Data> getDataCollection(InputStream inputStream) throws MediumAdapterException {
		InputStreamReader reader = new InputStreamReader(inputStream);
		int character;
		StringBuilder stringBuilder = new StringBuilder();
		try {
			while ((character = reader.read()) != -1) {
				stringBuilder.append((char) character);
			}
		} catch (IOException e) {
			throw new MediumAdapterException();
		}
		String content = stringBuilder.toString();
		Jerry doc = Jerry.jerry(content);
		return getDataCollection(doc);
	}
}

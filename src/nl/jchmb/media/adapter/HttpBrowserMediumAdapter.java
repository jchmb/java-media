package nl.jchmb.media.adapter;

import java.util.Collection;

import jodd.http.HttpBrowser;
import jodd.http.HttpRequest;
import jodd.jerry.Jerry;
import nl.jchmb.media.adapter.exception.MediumAdapterException;
import nl.jchmb.media.entity.Entity;

public abstract class HttpBrowserMediumAdapter<T extends Entity> implements MediumAdapter<T> {
	private HttpBrowser browser;
	
	protected HttpBrowserMediumAdapter(HttpBrowser browser) {
		this.browser = browser;
	}
	
	protected HttpBrowser getBrowser() {
		return browser;
	}

	@Override
	public Collection<T> fetch() throws MediumAdapterException {
		Jerry doc = getJerry();
		if (doc == null) {
			throw new MediumAdapterException();
		}
		return fetchFromJerry(doc);
	}
	
	protected abstract Collection<T> fetchFromJerry(Jerry doc);
	
	protected abstract String getURLString();
	
	protected Jerry getJerry() {
		if (browser != null) {
			String urlString = getURLString();
			HttpRequest request = HttpRequest.get(urlString);
			return Jerry.jerry(browser.sendRequest(request).bodyText());
		}
		return null;
	}
}

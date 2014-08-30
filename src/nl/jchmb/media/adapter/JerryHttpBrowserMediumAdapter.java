package nl.jchmb.media.adapter;

import jodd.http.HttpBrowser;
import nl.jchmb.media.entity.Entity;

public abstract class JerryHttpBrowserMediumAdapter<T extends Entity> extends HttpBrowserMediumAdapter<T> {
	protected JerryHttpBrowserMediumAdapter(HttpBrowser browser) {
		super(browser);
	}
}

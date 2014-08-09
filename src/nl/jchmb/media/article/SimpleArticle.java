package nl.jchmb.media.article;

import java.net.MalformedURLException;
import java.net.URL;

import nl.jchmb.media.data.Data;
import nl.jchmb.media.data.DefaultData;

public class SimpleArticle implements Article {
	private String title;
	private URL url;

	@Override
	public String getTitle() {
		return title;
	}

	@Override
	public URL getURL() {
		return url;
	}

	@Override
	public Data getData() {
		Data data = new DefaultData();
		data.put("title", title);
		data.put("url", url.getFile());
		return data;
	}

	@Override
	public void setData(Data data) {
		if (data.containsKey("title")) {
			title = (String) data.get("title");
		}
		if (data.containsKey("url")) {
			try {
				url = new URL((String) data.get("url"));
			} catch (MalformedURLException e) {
				e.printStackTrace();
				System.exit(-1);
			}
		}
	}
}

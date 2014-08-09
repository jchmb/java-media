package nl.jchmb.media.category;

import java.net.MalformedURLException;
import java.net.URL;

import nl.jchmb.media.data.Data;
import nl.jchmb.media.data.DefaultData;

public class SimpleCategory implements Category {
	private String name;
	private URL url;
	
	public SimpleCategory(String name, URL url) {
		this.name = name;
		this.url = url;
	}
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public URL getURL() {
		return url;
	}

	@Override
	public Data getData() {
		Data data = new DefaultData();
		data.put("name", name);
		data.put("url", url.getFile());
		return data;
	}

	@Override
	public void setData(Data data) {
		if (data.containsKey("name")) {
			name = (String) data.get("name");
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

package nl.jchmb.media.adapter;

import jodd.jerry.Jerry;
import nl.jchmb.media.adapter.exception.MediumAdapterException;
import nl.jchmb.media.article.Article;
import nl.jchmb.media.article.SimpleArticle;
import nl.jchmb.media.data.Data;
import nl.jchmb.media.data.DefaultData;

public abstract class DefaultArticleMediumAdapter extends IteratingJerryMediumAdapter<Article> {
	@Override
	protected Data getData(Jerry element) throws MediumAdapterException {
		Data data = new DefaultData();
		data.put("title", element.html());
		data.put("url", parseURL(element.attr("href")));
		return data;
	}
	
	protected String parseURL(String url) {
		return url;
	}
	
	@Override
	protected Article entitize(Data data) throws MediumAdapterException {
		Article article = new SimpleArticle();
		article.setData(data);
		return article;
	}
}

package nl.jchmb.media.category;

import nl.jchmb.media.adapter.MediumAdapter;
import nl.jchmb.media.article.Article;

public class SimpleArticleCategory implements ArticleCategory {
	private String name;
	private MediumAdapter<Article> adapter;
	
	public SimpleArticleCategory(String name, MediumAdapter<Article> adapter) {
		this.name = name;
		this.adapter = adapter;
	}
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public MediumAdapter<Article> getAdapter() {
		return adapter;
	}
}

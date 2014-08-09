package nl.jchmb.media.article;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class ArticleContainer implements ArticleCollection {
	private Collection<Article> articles;
	
	public ArticleContainer() {
		articles = new ArrayList<Article>();
	}
	
	public ArticleCollection addArticle(Article article) {
		articles.add(article);
		return this;
	}
	
	@Override
	public Iterator<Article> iterator() {
		return articles.iterator();
	}

}

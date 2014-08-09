package nl.jchmb.media.category;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class CategoryContainer implements CategoryCollection {
	private Collection<Category> categories;
	
	public CategoryContainer() {
		categories = new ArrayList<Category>();
	}
	
	public CategoryContainer addCategory(Category category) {
		categories.add(category);
		return this;
	}
	
	@Override
	public Iterator<Category> iterator() {
		return categories.iterator();
	}

}

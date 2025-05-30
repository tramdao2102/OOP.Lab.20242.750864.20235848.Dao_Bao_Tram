package hust.soict.hedspi.aims.media;

import java.util.Comparator;

public abstract class Media implements Comparable<Media> {

	public Media() {
		
	}		
		private static int nbMedia = 0;
	    private int id;
	    private String title;
	    private String category;
	    private float cost;

	    public Media(String title) {
	        this.title = title;
			this.id = ++nbMedia;
	    }
	    public Media(String title, String category) {
	        this.title = title;
	        this.category = category;
	        this.id = ++nbMedia;
	    }
	    public Media(String title, String category, float cost) {
	        this.title = title;
	        this.category = category;
	        this.cost = cost;
	        this.id = ++nbMedia;
	    }
	    
	    public int getId() {
	        return id;
	    }
	    public String getTitle() {
	        return title;
	    }
	    public String getCategory() {
	        return category;
	    }
	    public float getCost() {
	        return cost;
	    }

	    public void setTitle(String title) {
	        this.title = title;
	    }
	    
	    public String toString() {
	        return "Media: " + this.getTitle() +
	                " - Category: " + this.getCategory() +
	                " - Cost: " + this.getCost() + "$";
	    }
	    
	    public boolean isMatch(String title) {
	        return this.getTitle().toLowerCase().contains(title.toLowerCase());
	    }
	    
	    @Override
	    public boolean equals(Object obj) {
	        if (this == obj) return true;
	        if (obj == null) return false;
	        if (!(obj instanceof Media)) return false;

	        Media other = (Media) obj;
	        // So sánh title và cost
	        return this.title != null && this.title.equals(other.title)
	               && Float.compare(this.cost, other.cost) == 0;
	    }
	    
	    public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
	    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();
	    
	    @Override
	    public int compareTo(Media other) {
	        if (other == null) throw new NullPointerException("Media to compare is null");

	        int titleCompare = this.title.compareTo(other.title);
	        if (titleCompare != 0) return titleCompare;

	        return Float.compare(this.cost, other.cost);
	    }


}

package Model;

public class Category {
	
	private int categoryId;
	private String category;
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public Category(int categoryId, String category) {
		this.categoryId = categoryId;
		this.category = category;
	}
	public Category() {}
	
	

}

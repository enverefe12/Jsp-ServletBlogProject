package Model;

public class Text {
	
	private String textPath;
	private String name;
	private int categoryId;
	private int textId;

	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getTextPath() {
		return textPath;
	}
	public void setTextPath(String textPath) {
		this.textPath = textPath;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getTextId() {
		return textId;
	}
	public void setTextId(int textId) {
		this.textId = textId;
	}
	public Text(String name, String textPath, int categoryId, int textId) {
		super();
		this.name = name;
		this.textPath = textPath;
		this.categoryId=categoryId;
		this.textId=textId;
	}
	
	
	public Text() {}
	
	

}

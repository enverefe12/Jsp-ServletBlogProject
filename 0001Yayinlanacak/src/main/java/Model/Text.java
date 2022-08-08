package Model;

public class Text {
	
	private String textPath;
	private String name;
	private int kategoriId;
	private int textId;

	public int getKategoriId() {
		return kategoriId;
	}
	public void setKategoriId(int kategoriId) {
		this.kategoriId = kategoriId;
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
	public Text(String name, String textPath, int kategoriId, int textId) {
		super();
		this.name = name;
		this.textPath = textPath;
		this.kategoriId=kategoriId;
		this.textId=textId;
	}
	
	
	public Text() {}
	
	

}

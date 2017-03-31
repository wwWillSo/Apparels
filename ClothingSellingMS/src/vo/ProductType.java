package vo;

public class ProductType {
	private int id ;
	
	private int menuId ;
	
	private String typeName ;
	
	private String typeResource ;
	
	private int typeShowOrder ;
	
	private int enable ;
	

	public int getEnable() {
		return enable;
	}

	public void setEnable(int enable) {
		this.enable = enable;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMenuId() {
		return menuId;
	}

	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getTypeResource() {
		return typeResource;
	}

	public void setTypeResource(String typeResource) {
		this.typeResource = typeResource;
	}

	public int getTypeShowOrder() {
		return typeShowOrder;
	}

	public void setTypeShowOrder(int typeShowOrder) {
		this.typeShowOrder = typeShowOrder;
	}
	
}

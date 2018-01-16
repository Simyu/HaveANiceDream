package product;

import java.sql.Date;

public class ProductDTO {

    private Integer productNo;

    private String userId;

    private Integer categoryNo;

    private String productName;

    private Integer productPrice;

    private String productContent;

    private Integer productCount;

    private String productTitle;

    private Date productDate;

    private String productState;

    private Integer productExfDate;

    private String tradeType;
    
    public ProductDTO() {
		// TODO Auto-generated constructor stub
	}

	public ProductDTO(Integer productNo, String userId, Integer categoryNo, String productName, Integer productPrice,
			String productContent, Integer productCount, String productTitle, Date productDate, String productState,
			Integer productExfDate, String tradeType) {
		super();
		this.productNo = productNo;
		this.userId = userId;
		this.categoryNo = categoryNo;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productContent = productContent;
		this.productCount = productCount;
		this.productTitle = productTitle;
		this.productDate = productDate;
		this.productState = productState;
		this.productExfDate = productExfDate;
		this.tradeType = tradeType;
	}

	public Integer getProductNo() {
		return productNo;
	}

	public void setProductNo(Integer productNo) {
		this.productNo = productNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Integer getCategoryNo() {
		return categoryNo;
	}

	public void setCategoryNo(Integer categoryNo) {
		this.categoryNo = categoryNo;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Integer getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(Integer productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductContent() {
		return productContent;
	}

	public void setProductContent(String productContent) {
		this.productContent = productContent;
	}

	public Integer getProductCount() {
		return productCount;
	}

	public void setProductCount(Integer productCount) {
		this.productCount = productCount;
	}

	public String getProductTitle() {
		return productTitle;
	}

	public void setProductTitle(String productTitle) {
		this.productTitle = productTitle;
	}

	public Date getProductDate() {
		return productDate;
	}

	public void setProductDate(Date productDate) {
		this.productDate = productDate;
	}

	public String getProductState() {
		return productState;
	}

	public void setProductState(String productState) {
		this.productState = productState;
	}

	public Integer getProductExfDate() {
		return productExfDate;
	}

	public void setProductExfDate(Integer productExfDate) {
		this.productExfDate = productExfDate;
	}

	public String getTradeType() {
		return tradeType;
	}

	public void setTradeType(String tradeType) {
		this.tradeType = tradeType;
	}

	@Override
	public String toString() {
		return "ProductDTO [productNo=" + productNo + ", userId=" + userId + ", categoryNo=" + categoryNo
				+ ", productName=" + productName + ", productPrice=" + productPrice + ", productContent="
				+ productContent + ", productCount=" + productCount + ", productTitle=" + productTitle
				+ ", productDate=" + productDate + ", productState=" + productState + ", productExfDate="
				+ productExfDate + ", tradeType=" + tradeType + "]";
	}
    
    
}
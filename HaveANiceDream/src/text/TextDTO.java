package text;

import java.sql.Date;

public class TextDTO {

    private Integer textNo;

    private Integer tradeNo;

    private String userId;

    private Date textDate;

    private String textContent;
    
    public TextDTO() {
		// TODO Auto-generated constructor stub
	}

	public TextDTO(Integer textNo, Integer tradeNo, String userId, Date textDate, String textContent) {
		super();
		this.textNo = textNo;
		this.tradeNo = tradeNo;
		this.userId = userId;
		this.textDate = textDate;
		this.textContent = textContent;
	}

	public Integer getTextNo() {
		return textNo;
	}

	public void setTextNo(Integer textNo) {
		this.textNo = textNo;
	}

	public Integer getTradeNo() {
		return tradeNo;
	}

	public void setTradeNo(Integer tradeNo) {
		this.tradeNo = tradeNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Date getTextDate() {
		return textDate;
	}

	public void setTextDate(Date textDate) {
		this.textDate = textDate;
	}

	public String getTextContent() {
		return textContent;
	}

	public void setTextContent(String textContent) {
		this.textContent = textContent;
	}

	@Override
	public String toString() {
		return "TextDTO [textNo=" + textNo + ", tradeNo=" + tradeNo + ", userId=" + userId + ", textDate=" + textDate
				+ ", textContent=" + textContent + "]";
	}
    
    
}
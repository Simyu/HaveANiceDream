package blame;

import java.sql.Date;

public class BlameDTO {

    private Integer blameNo;

    private Date blameDate;

    private String userIdBlamere;

    private String userIdBlamee;

    private String blameType;

    private Integer productNo;

    private String attachedFile;

    private String blameTitle;

    private String blameContent;
    
    public BlameDTO() {
		// TODO Auto-generated constructor stub
	}

	public BlameDTO(Integer blameNo, Date blameDate, String userIdBlamere, String userIdBlamee, String blameType,
			Integer productNo, String attachedFile, String blameTitle, String blameContent) {
		super();
		this.blameNo = blameNo;
		this.blameDate = blameDate;
		this.userIdBlamere = userIdBlamere;
		this.userIdBlamee = userIdBlamee;
		this.blameType = blameType;
		this.productNo = productNo;
		this.attachedFile = attachedFile;
		this.blameTitle = blameTitle;
		this.blameContent = blameContent;
	}

	public Integer getBlameNo() {
		return blameNo;
	}

	public void setBlameNo(Integer blameNo) {
		this.blameNo = blameNo;
	}

	public Date getBlameDate() {
		return blameDate;
	}

	public void setBlameDate(Date blameDate) {
		this.blameDate = blameDate;
	}

	public String getUserIdBlamere() {
		return userIdBlamere;
	}

	public void setUserIdBlamere(String userIdBlamere) {
		this.userIdBlamere = userIdBlamere;
	}

	public String getUserIdBlamee() {
		return userIdBlamee;
	}

	public void setUserIdBlamee(String userIdBlamee) {
		this.userIdBlamee = userIdBlamee;
	}

	public String getBlameType() {
		return blameType;
	}

	public void setBlameType(String blameType) {
		this.blameType = blameType;
	}

	public Integer getProductNo() {
		return productNo;
	}

	public void setProductNo(Integer productNo) {
		this.productNo = productNo;
	}

	public String getAttachedFile() {
		return attachedFile;
	}

	public void setAttachedFile(String attachedFile) {
		this.attachedFile = attachedFile;
	}

	public String getBlameTitle() {
		return blameTitle;
	}

	public void setBlameTitle(String blameTitle) {
		this.blameTitle = blameTitle;
	}

	public String getBlameContent() {
		return blameContent;
	}

	public void setBlameContent(String blameContent) {
		this.blameContent = blameContent;
	}

	@Override
	public String toString() {
		return "BlameDTO [blameNo=" + blameNo + ", blameDate=" + blameDate + ", userIdBlamere=" + userIdBlamere
				+ ", userIdBlamee=" + userIdBlamee + ", blameType=" + blameType + ", productNo=" + productNo
				+ ", attachedFile=" + attachedFile + ", blameTitle=" + blameTitle + ", blameContent=" + blameContent
				+ "]";
	}
    
}
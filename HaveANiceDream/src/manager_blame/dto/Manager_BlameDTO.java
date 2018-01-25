package manager_blame.dto;

import java.sql.Date;

public class Manager_BlameDTO {

	private Integer answerNo;

    private String answerTitle;

    private String answerContent;

    private Date answerDate;

	public Integer getAnswerNo() {
		return answerNo;
	}

	public void setAnswerNo(Integer answerNo) {
		this.answerNo = answerNo;
	}

	public String getAnswerTitle() {
		return answerTitle;
	}

	public void setAnswerTitle(String answerTitle) {
		this.answerTitle = answerTitle;
	}

	public String getAnswerContent() {
		return answerContent;
	}

	public void setAnswerContent(String answerContent) {
		this.answerContent = answerContent;
	}

	public Date getAnswerDate() {
		return answerDate;
	}

	public void setAnswerDate(Date answerDate) {
		this.answerDate = answerDate;
	}

	@Override
	public String toString() {
		return "Blame_ReplyDTO [answerNo=" + answerNo + ", answerTitle=" + answerTitle + ", answerContent="
				+ answerContent + ", answerDate=" + answerDate + "]";
	}

	public Manager_BlameDTO(Integer answerNo, String answerTitle, String answerContent, Date answerDate) {
		super();
		this.answerNo = answerNo;
		this.answerTitle = answerTitle;
		this.answerContent = answerContent;
		this.answerDate = answerDate;
	}
	public Manager_BlameDTO(String answerTitle, String answerContent) {
		super();
		
		this.answerTitle = answerTitle;
		this.answerContent = answerContent;
		
	}

 
}
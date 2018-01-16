package grade;
public class GradeDTO {

    private Integer gradeNo;

    private String userId;

    private Integer tradeNo;

    private Integer grade;

    private String gradeType;
    
    public GradeDTO() {
		// TODO Auto-generated constructor stub
	}

	public GradeDTO(Integer gradeNo, String userId, Integer tradeNo, Integer grade, String gradeType) {
		super();
		this.gradeNo = gradeNo;
		this.userId = userId;
		this.tradeNo = tradeNo;
		this.grade = grade;
		this.gradeType = gradeType;
	}

	public Integer getGradeNo() {
		return gradeNo;
	}

	public void setGradeNo(Integer gradeNo) {
		this.gradeNo = gradeNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Integer getTradeNo() {
		return tradeNo;
	}

	public void setTradeNo(Integer tradeNo) {
		this.tradeNo = tradeNo;
	}

	public Integer getGrade() {
		return grade;
	}

	public void setGrade(Integer grade) {
		this.grade = grade;
	}

	public String getGradeType() {
		return gradeType;
	}

	public void setGradeType(String gradeType) {
		this.gradeType = gradeType;
	}

	@Override
	public String toString() {
		return "GradeDTO [gradeNo=" + gradeNo + ", userId=" + userId + ", tradeNo=" + tradeNo + ", grade=" + grade
				+ ", gradeType=" + gradeType + "]";
	}
    
    
}
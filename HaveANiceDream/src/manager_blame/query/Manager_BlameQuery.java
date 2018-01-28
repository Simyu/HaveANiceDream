package manager_blame.query;


/*Name                                      Null?    Type
----------------------------------------- -------- ----------------------------
ANSWER_NO                                 NOT NULL NUMBER
BLAME_NO                                           NUMBER
USER_ID                                            VARCHAR2(20)
ANSWER_TITLE                                       VARCHAR2(20)
ANSWER_CONTENT                                     VARCHAR2(20)
ANSWER_DATE                                        DATE*/

public class Manager_BlameQuery {
	public static final String ANSWER_INSERT = "insert into blame values(ANSWER_SEQ.nextval,?,?,sysdate)";
	public static final String ANSWER_SELECT = "select * from blame where ANSWER_NO = ?";
}

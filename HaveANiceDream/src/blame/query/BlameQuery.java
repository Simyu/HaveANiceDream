package blame.query;


/*Name                                      Null?    Type
----------------------------------------- -------- ----------------------------
BLAME_NO                                  NOT NULL NUMBER
BLAME_DATE                                         DATE
USER_ID_BLAMERE                                    VARCHAR2(20)
USER_ID_BLAMEE                                     VARCHAR2(20)
BLAME_TYPE                                         VARCHAR2(20)
PRODUCT_NO                                         NUMBER
ATTACHED_FILE                                      VARCHAR2(20)
BLAME_TITLE                                        VARCHAR2(20)
BLAME_CONTENT                                      VARCHAR2(20)*/

public class BlameQuery {
	public static final String BLAME_INSERT = "insert into blame values(BLAME_SEQ.nextval,sysdate,?,?,?,?,?,?,?)";
	public static final String BLAME_LIST = "select * from blame";
	public static final String BLAME_SELECT = "select * from blame where BLAME_NO = ?";
	public static final String BLAME_UPDATE = "update into blame values(?,?,?,?,?,?,?,?,?)";
}

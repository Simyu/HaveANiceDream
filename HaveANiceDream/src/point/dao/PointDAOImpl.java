package point.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import fw.DBUtil;
import point.PointDTO;
import point.query.PointQuery;
/*Name                                      Null?    Type
----------------------------------------- -------- ----------------------------
POINT_NO                                  NOT NULL NUMBER
USER_ID                                            VARCHAR2(20)
POINT_DATE                                         DATE
POINT_TYPE                                         VARCHAR2(20)
POINT                                              NUMBER*/


public class PointDAOImpl implements PointDAO {

	@Override
	public int pointInsert(PointDTO point, Connection connection) throws SQLException {
		int rowNum = 0;
		PreparedStatement preparedStatement = connection.prepareStatement(PointQuery.POINT_INSERT);
		
		preparedStatement.setString(1, point.getUserId());
		preparedStatement.setString(2, point.getPointType());
		preparedStatement.setInt(3, point.getPoint());
		
		rowNum = preparedStatement.executeUpdate();
		
		DBUtil.close(preparedStatement);
		
		return rowNum;
	}

}

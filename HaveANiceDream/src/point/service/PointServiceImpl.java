package point.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import fw.DBUtil;
import point.dao.PointDAO;
import point.dao.PointDAOImpl;
import point.dto.PointDTO;

public class PointServiceImpl implements PointService {

	@Override
	public ArrayList<PointDTO> pointList(String userId) {
		ArrayList<PointDTO> list = null;
		
		Connection connection = null;
		PointDAO dao = new PointDAOImpl();
		
		try {
			connection = DBUtil.getConnect();
			list = dao.pointList(userId, connection);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(connection);
		}
		
		return list;
	}

}

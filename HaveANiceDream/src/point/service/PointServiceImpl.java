package point.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import fw.DBUtil;
import point.dao.PointDAO;
import point.dao.PointDAOImpl;
import point.dto.PointDTO;
import user.dao.UserDAO;
import user.dao.UserDAOImpl;

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

	@Override
	public int pointInsert(PointDTO point) {
		int rowNum = 0;

		Connection connection = null;
		PointDAO pointDAO = new PointDAOImpl();
		UserDAO userDAO = new UserDAOImpl();

		try {
			connection = DBUtil.getConnect();
			rowNum = pointDAO.pointInsert(point, connection);

			if (rowNum > 0) {
				int totalPoint = userDAO.userGetPoint(point.getUserId(), connection);
				rowNum += userDAO.userUpdatePoint((totalPoint + point.getPoint()), point.getUserId(), connection);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(connection);
		}

		return rowNum;
	}

}

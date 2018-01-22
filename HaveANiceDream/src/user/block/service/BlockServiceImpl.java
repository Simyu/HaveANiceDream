package user.block.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import fw.DBUtil;
import user.block.dao.BlockDAO;
import user.block.dao.BlockDAOImpl;
import user.block.dto.BlockDTO;
import user.dao.UserDAO;
import user.dao.UserDAOImpl;

public class BlockServiceImpl implements BlockService {

	@Override
	public int blockInsert(BlockDTO block) {
		int rowNum = 0;

		Connection connection = null;
		BlockDAO blockDAO = new BlockDAOImpl();

		try {
			connection = DBUtil.getConnect();
			rowNum = blockDAO.blockInsert(block, connection);

			if (rowNum > 0) {
				UserDAO userDAO = new UserDAOImpl();
				rowNum += userDAO.userUpdateType(block.getUserId(), "차단회원", connection);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(connection);
		}

		return rowNum;
	}

	@Override
	public int blockDelete(String userId) {
		int rowNum = 0;

		Connection connection = null;
		BlockDAO blockDAO = new BlockDAOImpl();

		try {
			connection = DBUtil.getConnect();
			rowNum = blockDAO.blockDelete(userId, connection);

			if (rowNum > 0) {
				UserDAO userDAO = new UserDAOImpl();
				rowNum += userDAO.userUpdateType(userId, "일반회원", connection);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(connection);
		}

		return rowNum;
	}

	@Override
	public ArrayList<BlockDTO> blockList() {
		ArrayList<BlockDTO> list = null;
		Connection connection = null;
		
		BlockDAO blockDAO = new BlockDAOImpl();
		
		try {
			connection = DBUtil.getConnect();
			list = blockDAO.blockList(connection);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(connection);
		}
		
		return list;
	}

}

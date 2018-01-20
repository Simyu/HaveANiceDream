package blame;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import blame.dto.BlameDTO;

public class BlameDAOimpl implements BlameDAO {


	public int insert(BlameDTO dto, Connection con) throws SQLException {
		int result = 0;
		PreparedStatement ptmt = null;
		PreparedStatement = con.prepareStatement(sql);
		return 0;
	}


	public ArrayList<BlameDTO> list(Connection con) throws SQLException {

		return null;
	}


	public int update(BlameDTO dto, Connection con) throws SQLException {

		return 0;
	}

	public BlameDTO select(int blameNo, Connection con) throws SQLException {

		return null;
	}

}

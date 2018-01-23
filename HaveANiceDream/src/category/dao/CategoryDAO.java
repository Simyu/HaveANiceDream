package category.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import category.CategoryDTO;


public interface CategoryDAO {
     
       ArrayList<CategoryDTO>  category_list(Connection connection) throws SQLException;
}

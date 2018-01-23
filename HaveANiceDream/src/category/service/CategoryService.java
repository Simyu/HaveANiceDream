package category.service;


import java.sql.Connection;
import java.util.ArrayList;

import category.CategoryDTO;
import category.CategoryDetailDTO;

public interface CategoryService {
	ArrayList<CategoryDTO>  categoryList();
	ArrayList<CategoryDetailDTO>  categoryDetailList(String categoryName);
	ArrayList<CategoryDetailDTO>  categoryDetailListAjax(String categoryName);
}

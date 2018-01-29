package category.query;

public class CategoryQuery {
      public static String  CATEGORYDETAILSEARCHNO ="select * from category_detail where category_no = ?";
      public static String  CATEGORYDETAILSEARCHNAME = "select * from category_detail where category_detail_name like ? ";
      public static String  CATEGORYSEARCHALL="select * from category";
      public static String  CATEGORYSEARCHNAME="select * from category where category_Name like  ?";
}

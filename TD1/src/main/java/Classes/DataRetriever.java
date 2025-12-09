package Classes;

import java.sql.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class DataRetriever {
    DBConnection  dbConnection;

    public DataRetriever(DBConnection dbConnection) {
        this.dbConnection = dbConnection;
    }

    public List<Category> getAllCategories() throws  SQLException {
        List<Category> categories = new ArrayList<>();
        String sql = "SELECT * FROM product_category";
        Connection conn = null;
        Statement statement = null;
        ResultSet result = null;

        try {
             conn = dbConnection.getDBConnection();
             statement = conn.createStatement();
             result = statement.executeQuery(sql);

            while (result.next()) {
                int id = result.getInt("id");
                String name = result.getString("name");
                int product_id = result.getInt("product_id");

                Category  category = new Category(id, name, product_id);
                categories.add(category);
            }
        } finally {
            if (conn != null) {conn.close();}
            if (statement != null) {statement.close();}
            if (result != null) {result.close();}
        }
        return categories;
    }

    public List<Product> getProductList(int page, int size) throws  SQLException {
        List<Product> products = new ArrayList<>();
        int offset = (page - 1) * size;
        String sql = "SELECT p.*, pc.name AS category_name, pc.product_id AS category_id FROM product p " +
                     "LEFT JOIN product_category pc ON p.id = pc.product_id " +
                     "LIMIT " + size +
                     " OFFSET " + offset;
        Connection conn = null;
        Statement statement = null;
        ResultSet result = null;

        try {
            conn = dbConnection.getDBConnection();
            statement = conn.createStatement();
            result = statement.executeQuery(sql);

            while (result.next()) {
                int id = result.getInt("id");
                String name = result.getString("name");
                double price = result.getDouble("price");
                Instant creationDatetime = result.getTimestamp("creation_datetime").toInstant();
                String categoryName = result.getString("category_name");
                int categoryId = result.getInt("category_id");

                Category category = new Category(0, categoryName , categoryId );
                Product product = new Product(id, name, price, creationDatetime,category);
                products.add(product);
            }
        } finally {
            if (conn != null) {conn.close();}
            if (statement != null) {statement.close();}
            if (result != null) {result.close();}
        }

        return  products;
    }

    public List<Product> getProductsByCriteria(String productName, String categoryName, Instant creationMin, Instant creationMax) throws SQLException {
        List<Product> products = new ArrayList<>();

        String sql =
                "SELECT p.id, p.name, p.price, p.creation_datetime, " +
                        "       pc.id AS category_id, pc.name AS category_name " +
                        "FROM product p " +
                        "LEFT JOIN product_category pc ON p.id = pc.product_id " +
                        "WHERE 1=1 ";

        if (productName != null) {
            sql += " AND p.name ILIKE '%" + productName + "%' ";
        }

        if (categoryName != null) {
            sql += " AND pc.name ILIKE '%" + categoryName + "%' ";
        }

        if (creationMin != null) {
            sql += " AND p.creation_datetime > '" + Timestamp.from(creationMin) + "' ";
        }

        if (creationMax != null) {
            sql += " AND p.creation_datetime < '" + Timestamp.from(creationMax) + "' ";
        }

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = dbConnection.getDBConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                double price = rs.getDouble("price");
                Instant creationDatetime = rs.getTimestamp("creation_datetime").toInstant();

                int catId = rs.getInt("category_id");
                String catName = rs.getString("category_name");

                Category category = new Category(catId, catName, id);
                Product product = new Product(id, name, price, creationDatetime, category);

                products.add(product);
            }

        } finally {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        }

        return products;
    }

    public List<Product> getProductsByCriteria(
            String productName,
            String categoryName,
            Instant creationMin,
            Instant creationMax,
            int page,
            int size
    ) throws SQLException {

        List<Product> products = new ArrayList<>();
        int offset = (page - 1) * size;
        String sql =
                "SELECT p.id, p.name, p.price, p.creation_datetime, " +
                        "       pc.id AS category_id, pc.name AS category_name " +
                        "FROM product p " +
                        "LEFT JOIN product_category pc ON p.id = pc.product_id " +
                        "WHERE 1=1 ";


        if (productName != null) {
            sql += " AND p.name ILIKE '%" + productName + "%' ";
        }

        if (categoryName != null) {
            sql += " AND pc.name ILIKE '%" + categoryName + "%' ";
        }

        if (creationMin != null) {
            sql += " AND p.creation_datetime > '" + Timestamp.from(creationMin) + "' ";
        }

        if (creationMax != null) {
            sql += " AND p.creation_datetime < '" + Timestamp.from(creationMax) + "' ";
        }

        sql += " LIMIT " + size + " OFFSET " + offset;


        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = dbConnection.getDBConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);

            while (rs.next()) {

                int id = rs.getInt("id");
                String name = rs.getString("name");
                double price = rs.getDouble("price");
                Instant creationDatetime = rs.getTimestamp("creation_datetime").toInstant();

                int categoryId = rs.getInt("category_id");
                String categoryNameResult = rs.getString("category_name");

                Category category = new Category(categoryId, categoryNameResult, id);
                Product product = new Product(id, name, price, creationDatetime, category);

                products.add(product);
            }

        } finally {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        }

        return products;
    }


}

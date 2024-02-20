package co.com.hyunseda.market.domain.access;

import co.com.hyunseda.market.service.ProductService;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ACER
 */
public class SQLiteDataBaseInitializer implements IDataBaseInitializer{
    
    private final Connection conn;

    public SQLiteDataBaseInitializer(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void initDatabase() {
    // SQL statement for creating a new table
        String sql1 = "CREATE TABLE IF NOT EXISTS products (\n"
                + "	productId integer PRIMARY KEY AUTOINCREMENT,\n"
                + "	name text NOT NULL,\n"
                + "	description text NULL\n"
                + ");";
        String sql2 ="CREATE TABLE IF NOT EXISTS categories (\n"
                + "	categoryId integer PRIMARY KEY AUTOINCREMENT,\n"
                + "	name text NOT NULL,\n"
                + ");";
        try {
            //this.connect();
            Statement stmt = conn.createStatement();
            stmt.execute(sql1);
            stmt.execute(sql2);
            //this.disconnect();

        } catch (SQLException ex) {
            Logger.getLogger(ProductService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
 
}

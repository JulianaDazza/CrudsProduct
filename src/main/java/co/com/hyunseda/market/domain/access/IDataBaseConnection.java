package co.com.hyunseda.market.domain.access;

import java.sql.Connection;

/**
 *
 * @author ACER
 */
public interface IDataBaseConnection {
    void connect();
    void disconnect();
    Connection getConnection();
}

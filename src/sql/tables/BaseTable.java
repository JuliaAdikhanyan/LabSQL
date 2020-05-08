package sql.tables;

import sql.StockExchangeDB;
import java.io.Closeable;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

// класс базоыой таблицы SQL
public class BaseTable implements Closeable {

    protected Connection connection;  // JDBC-соединение
    protected String name;       // имя таблицы

    // конструктор
    BaseTable(String tempName) throws SQLException { // передаём в конструктор имя таблицы
        this.name = tempName;
        this.connection = StockExchangeDB.getConnection(); // установка соединения
    }

    // метод close для закрытия базы данных
    @Override
    public void close() {

        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            System.out.println("Closing error!");
        }
    }

    // описание состояния базы данных
    void executeSQLStatement(String sql, String description) throws SQLException {

        reopen();
        // Statement создаётся для выполнения команд базы данных
        Statement statement = connection.createStatement();
        statement.execute(sql); // выполнение Statement
        statement.close();      // закрытие Statement

        if (description != null) {
            System.out.println(description);
        }
    }

    void executeSQLStatement(String sql) throws SQLException {
        executeSQLStatement(sql, null);
    }

    // если соединение неактивно, откроем его
    void reopen() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = StockExchangeDB.getConnection();
        }
    }
}

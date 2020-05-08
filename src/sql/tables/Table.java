package sql.tables;

import java.sql.SQLException;

public interface Table {
    // создание таблицы
    void create() throws SQLException;
}

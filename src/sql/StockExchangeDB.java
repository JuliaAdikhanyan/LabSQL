package sql;

import org.h2.tools.DeleteDbFiles;
import sql.model.MusicModel;
import sql.tables.MusicTable;
import java.sql.*;

public class StockExchangeDB {

    public static final String DB_DIR = "c:/JavaPrj/SQLDemo/db";
    public static final String DB_FILE = "stockExchange";
    public static final String DB_URL = "jdbc:h2:/" + DB_DIR + "/" + DB_FILE;
    public static final String DB_DRIVER = "org.h2.Driver";

    // таблицы
    MusicTable musicTable;

    // конструктор
    public StockExchangeDB() throws SQLException, ClassNotFoundException {
        this(false);
    }

    // инициализация
    public StockExchangeDB(boolean renew) throws SQLException, ClassNotFoundException {
        if (renew) {
            DeleteDbFiles.execute(DB_DIR, DB_FILE, false);
        }

        Class.forName(DB_DRIVER);
        musicTable = new MusicTable();
    }

    // соединение с базой данных
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL);
    }

    // создание таблиц
    public void createTablesAndForeignKeys() throws SQLException {
        musicTable.create();
    }

    public static void main(String[] args) {

        try {
            // создание новой таблицы
            StockExchangeDB stockExchangeDB = new StockExchangeDB(true);
            stockExchangeDB.createTablesAndForeignKeys();

            // создание экземпляров MusicModel
            MusicModel firstMusic = new MusicModel("POP", "Artist1", "2000-11-01", 3000, 300, 1);
            MusicModel secondMusic = new MusicModel("POP", "Artist2", "1970-07-10", 5000, 500, 2);

            // добавление экземпляров в таблицу
            stockExchangeDB.musicTable.insert(firstMusic);
            stockExchangeDB.musicTable.insert(secondMusic);

            // вывод информации
            stockExchangeDB.musicTable.printAll();

            // поиск музыки по ID
            MusicModel searchMusic = stockExchangeDB.musicTable.search(1);
            searchMusic.printAll();

            // удаление по ID
            stockExchangeDB.musicTable.delete(1);
            stockExchangeDB.musicTable.printAll();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
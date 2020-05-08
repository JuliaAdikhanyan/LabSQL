package sql.tables;

import sql.model.MusicModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

// класс таблицы музыки
public class MusicTable extends BaseTable implements Table {

    // конструктор
    public MusicTable() throws SQLException {
        super("Musics");
    }

    // создание таблицы
    @Override
    public void create() throws SQLException {
        super.executeSQLStatement("CREATE TABLE IF NOT EXISTS Musics(" +
                "id BIGINT AUTO_INCREMENT PRIMARY KEY," +
                "title NVARCHAR(30) NOT NULL," +
                "artist NVARCHAR(30) NOT NULL," +
                "date NVARCHAR(30) NOT NULL," +
                "listPrice integer NOT NULL," +
                "price integer NOT NULL," +
                "version integer NOT NULL)", "Создана таблица " + name);
    }

    // вставка в таблицу
    public void insert(MusicModel music) throws SQLException {
        super.executeSQLStatement("INSERT INTO Musics VALUES " +
                "(DEFAULT, '" + music.getName() + "', '" + music.getArtist() +
                "', date '" + music.getDate() + "'," + music.getListPrice() + ","
                + music.getPrice() + ", " + music.getVersion() + ");\n");
    }

    // вывод информации
    public void printAll() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM Musics");
        while (resultSet.next()) {

            int id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            String artist = resultSet.getString(3);
            Date date = resultSet.getDate(4);
            int listPrice = resultSet.getInt(5);
            int price = resultSet.getInt(6);
            int version = resultSet.getInt(7);
            System.out.println("ID: " + id + " Name: " + name + " Artist: " + artist + " Date: " + date +
                    " ListPrice: " + listPrice + " Price: " + price + " Version: " + version);
        }
    }

    // поиск музыки по ID
    public MusicModel search(int inputID) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM Musics WHERE ID =" + inputID);
        MusicModel model = new MusicModel();
        while (resultSet.next()) {

            int id = resultSet.getInt(1);
            String title = resultSet.getString(2);
            String artist = resultSet.getString(3);
            Date date = resultSet.getDate(4);
            int listPrice = resultSet.getInt(5);
            int price = resultSet.getInt(6);
            int version = resultSet.getInt(7);

            model.setName(title);
            model.setArtist(artist);
            model.setDate(date.toString());
            model.setListPrice(listPrice);
            model.setPrice(price);
            model.setVersion(version);
        }
        return model;
    }

    // удаление по ID
    public void delete(int inputID) throws SQLException {
        Statement statement = connection.createStatement();
        int temp = statement.executeUpdate("DELETE FROM Musics WHERE Id = " + inputID);

        System.out.println("Delete: " + temp);
    }
}

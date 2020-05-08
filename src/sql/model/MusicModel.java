package sql.model;

// класс MusicModel
public class MusicModel extends BaseModel {

    private String name; // название песни
    private String artist; // имя артиста
    private String date; // дата песни
    private int listPrice;
    private int price; // цена
    private int version; // версия

    // конструктор
    public MusicModel() {
    }

    // конструктор
    public MusicModel(String tempName, String tempArtist, String tempDate, int tempListPrice, int tempPrice, int tempVersion) {

        name = tempName;
        artist = tempArtist;
        date = tempDate;
        listPrice = tempListPrice;
        price = tempPrice;
        version = tempVersion;
    }

    // вывод на экран
    public void printAll() {
        System.out.println("Name: " + name + " Artist: " + artist + " Date: " + date
                + " ListPrice: " + listPrice + " Price: " + price + " Version: " + version);
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getListPrice() {
        return listPrice;
    }

    public void setListPrice(int listPrice) {
        this.listPrice = listPrice;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

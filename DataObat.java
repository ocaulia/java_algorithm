public class DataObat {
    int id;
    String nama;
    double harga;
    String type;
    int stock;
    String tanggalKadaluarsa;

    public DataObat(int id, String nama, double harga, String type, int stock, String tanggalKadaluarsa) {
        this.id = id;
        this.nama = nama;
        this.harga = harga;
        this.type = type;
        this.stock = stock;
        this.tanggalKadaluarsa = tanggalKadaluarsa;
    }
}
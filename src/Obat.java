public class Obat {
    private int id;
    private String nama;
    private String type;
    private double harga;

    Obat(int id, String nama, String type, double harga ){
        this.id = id;
        this.nama = nama;
        this.type = type;
        this.harga = harga;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }

    @Override
    public String toString(){
        return String.format("ID : %d  |  Nama : %s  |  Tipe : %s  |  Harga : Rp.%.2f",id, nama, type, harga);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

   

    



}

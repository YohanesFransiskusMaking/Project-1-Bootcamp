import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class App {

    static List<Obat> daftarObat = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        boolean running = true;
        int pilihan;
        Scanner scan = new Scanner(System.in);
        Obat obat1 = new Obat(3, "Paracetamol", "Sakit kepala", 2000);
        Obat obat2 = new Obat(2, "Dexa", "Batuk", 4000);
        Obat obat3 = new Obat(7, "Amoxilin", "Sakit erut", 8000);
        Obat obat4 = new Obat(6, "VIT C", "Vitamin", 2500);
        Obat obat5 = new Obat(5, "VIT A", "Kesehatan mata", 2000);
        daftarObat.add(obat1);
        daftarObat.add(obat2);
        daftarObat.add(obat3);
        daftarObat.add(obat4);
        daftarObat.add(obat5);

        while (running) {
            try {
                System.out.println("**************");
                System.out.println("Program Apotik");
                System.out.println("**************");
                System.out.println("1. Daftar semua obat");
                System.out.println("2. Lihat detail obat");
                System.out.println("3. Tambah obat");
                System.out.println("4. Perbaharui obat");
                System.out.println("5. Hapus obat");
                System.out.println("6. Keluar");
                System.out.print("\nMasukan pilihan: ");
                pilihan = scan.nextInt();
                scan.nextLine();

                switch (pilihan) {
                    case 1 -> dataObat();
                    case 2 -> detailObat(scan);
                    case 3 -> tambahObat(scan);
                    case 4 -> updateObat(scan);
                    case 5 -> hapusObat(scan);
                    case 6 -> {
                        running = false;
                        System.out.println("Sampai Jumpa");
                    }
                    default -> System.out.println("Inputan tidak sesuai");

                }
            } catch (InputMismatchException e) {
                System.out.println("\nFormat inputan tidak valid");
                scan.nextLine();
            }

        }

        scan.close();

    }

    public static void dataObat() {
        if (daftarObat.isEmpty()) {
            System.out.println("Belum ada stok obat yang ditambahkan");
        } else {

            Collections.sort(daftarObat, (obat1, obat2) -> Integer.compare(obat2.getId(), obat1.getId()));
            System.out.println("***********");
            System.out.println("DAFTAR OBAT");
            System.out.println("***********");
            for (Obat obat : daftarObat) {
                System.out.println(obat.getId() + " : " + obat.getNama());
            }

        }

    }

    public static void detailObat(Scanner scanner) {
        if (daftarObat.isEmpty()) {
            System.out.println("Belum ada daftar obat");
        } else {
            try {
                System.out.print("Input Id Obat: ");
                int cari = scanner.nextInt();
                Optional<Obat> dapatObat = daftarObat.stream().filter(a -> a.getId() == cari).findFirst();
                if (dapatObat.isPresent()) {
                    System.out.printf("Detail obat dengan Id %d\n", cari);
                    System.out.println(dapatObat.get());
                } else {
                    System.out.println("Data tidak ditemukan");
                }

            } catch (Exception e) {
                System.out.println("Terjadi kesalahan inputan");
            }

        }

    }

    public static void tambahObat(Scanner scanner) {

        System.out.print("ID: ");
        int id = scanner.nextInt();
        boolean adaId = daftarObat.stream().anyMatch(c -> c.getId() == id);
        if (adaId) {
            System.out.println("Id sudah terdaftar");

        } else if (id <= 0) {
            System.out.println("Id tidak boleh <= 0 ");
        } else {
            scanner.nextLine();
            System.out.print("Masukan Nama Obat: ");
            String nama = scanner.nextLine();
            System.out.print("Masukan Type Obat : ");
            String type = scanner.nextLine();
            System.out.print("Masukan Harga : Rp.");
            double harga = scanner.nextDouble();

            Obat obatBaru = new Obat(id, nama, type, harga);
            daftarObat.add(obatBaru);
            System.out.println("Obat berhasil ditambahkan");
        }

    }

    public static void updateObat(Scanner scanner){
        System.out.print("Masukan Id obat yang akan di perbaharui:");
        int input = scanner.nextInt();
        scanner.nextLine();

        Optional<Obat> updateObat = daftarObat.stream().filter(o ->o.getId()==input).findFirst();
        System.out.println("Perbaharui data obat: ");
        if(updateObat.isPresent()) {
            Obat obat = updateObat.get();
            System.out.println("Data lama obat:");
            System.out.println(obat);
            System.out.println("Masukan data baru (kosongkan jika tidak ingin di ubah)");
            System.out.print("Nama ["+ obat.getNama()+"] : ");
            String namaBaru = scanner.nextLine();
            if (!namaBaru.isEmpty()) {
                obat.setNama(namaBaru);
            }
            System.out.print("Tipe ["+obat.getType()+"] : ");
            String typeBaru = scanner.nextLine();
            if(!typeBaru.isEmpty()){
                obat.setType(typeBaru);
            }
            System.out.print("Harga ["+obat.getHarga()+"] : ");
            String hargaInput = scanner.nextLine();
           if (!hargaInput.isEmpty()) {
            try{
                double hargaBaru = Double.parseDouble(hargaInput);
                obat.setHarga(hargaBaru);

            }catch(NumberFormatException e){
                System.out.println("Format harga tidak valid. Harga tidak di ubah.");
            }
           }

           System.out.println("Data berhasil di perbaharui");
           System.out.println(obat);

        }else{
            System.out.println("Input tidak ditemukan");
        }

    }

    public static void hapusObat(Scanner scanner) {
        try {
            System.out.print("Masukan Id obat: ");
            int hapus = scanner.nextInt();

            boolean hapusObat = daftarObat.removeIf(c -> c.getId() == hapus);

            if (hapusObat) {
                System.out.printf("Obat dengan Id %d berhsil di hapus\n", hapus);
            } else {
                System.out.println("Id tidak ditemukan");
            }

        } catch (InputMismatchException e) {
            System.out.println("Inputan tidak valid");
        }

    }

}

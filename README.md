
## Project ini mengambil tema Apotik dengan aktivitas antara lain:
### - Menampilkan obat (defaul telah terdapat 5 obat)
### - Menemukan obat by Id
### - Menambahkan obat
### - Memperbaharui obat
### - Menghapus obat

## 1. Menu
- ![Tampilan Menu](/asset/menu-tdkvalid.PNG)
- Menu, menampilkan 6 pilihan yang dapat di input user.
- Perulangan pada menu menggunakan WHILE, sehingga baru akan berhenti jika telah memenuhi kondisi untuk FALSE. Selain itu, di deklarasikan juga penanganan error yang apabila terdapat kesalahan input maka sistem tidak langsung error. ![penanganan error](/asset/while.PNG)

## 2. Menampilkan daftar obat
- Pilihan 1 dalam opsi menu akan menampilkan daftar obat.
- Daftar obat diurutkan berdasarkan Id dari nilai kecil ke besar.
- ![Menampilkan daftar obat](/asset/tampil.PNG)
- Apabila daftar obat kosong maka program menampilkan:
    ![stock kosong](/asset/no%20stock.PNG)

## 3. Menemukan obat berdasarkan Id
- Opsi 2 ini akan menampilkan detail data obat berdasarkan Id yang diinput user.
- Pada gambar dibawah ini akan dilihat hasil program dengan inputan benar serta hasil program dari inputan yang kurang sesuai dalam menu opsi 2:
    ![opsi 2](/asset/menu2-valid-tdkvalid.PNG)

## 4. Menambahkan obat
- Opsi 3 memungkinkan user untuk menambahkan obat pada daftar obat. 
- Beberapa kondisi telah di atur dalam kodingan program seperti tidak bisa menggunakan Id yang terdaftar, Id tidak bisa 0 atau lebih kecil dari 0.
- ![Menambahkan obat](/asset/tambahobat.PNG)

## 5. Perbaharui obat
- Untuk proses pembaharuan data obat pada opsi 4, user hanya dapat memperbaharui data obat yang valid tersedia. 
- User terlebih dahulu memasukan Id obat yang ingin di perbaharui dan dapat melanjutkan proses update ketika Id valid.
- ![Memperbaharui obat](/asset/update.PNG).

## 6. Hapus obat
- Opsi 5 digunakan user untuk menghapus obat tertentu berdasarkan Id
- ![Hapus obat](/asset/hapus.PNG)


## 7. Keluar
- Opsi 6 dipilih user untuk keluar dari program dan program menampilkan ucapan "Sampai Jumpa"
- ![Keluar](/asset/keluar.PNG)



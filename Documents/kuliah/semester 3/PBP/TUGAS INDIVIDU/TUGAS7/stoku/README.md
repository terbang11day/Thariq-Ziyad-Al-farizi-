# **STOKU**

**Daftar isi :**<br/>
[Tugas 7](#tugas-7)<br/>
[Tugas 8](#tugas-8)<br/>


**Thariq Ziyad Al Farizi**<br/>
**2206082865**<br/>
**PBP B**<br/>

# **Tugas 7**

1. Apa perbedaan utama antara stateless dan stateful widget dalam konteks pengembangan aplikasi Flutter?

*Stateless Widget: Widget ini bersifat statis dan tidak dapat mengubah tampilan atau properti selama masa hidupnya. Mereka cocok untuk elemen UI yang tidak berubah, seperti teks atau ikon.

*Stateful Widget: Widget ini memiliki keadaan yang dapat berubah selama masa hidupnya. Mereka digunakan untuk elemen UI yang dapat diperbarui, seperti daftar item, formulir, dan komponen yang memerlukan respons interaktif dari pengguna.


2. Sebutkan seluruh widget yang kamu gunakan untuk menyelesaikan tugas ini dan jelaskan fungsinya masing-masing.

*ShopItem: Merupakan objek yang mewakili item dalam daftar toko dengan properti seperti nama, ikon, dan warna latar belakang.
*ShopCard: Merupakan widget yang digunakan untuk menampilkan item toko sebagai kartu dengan latar belakang warna yang dapat disesuaikan.
*MyHomePage: Merupakan widget yang menampilkan daftar item toko dalam tata letak grid dan menangani interaksi pengguna.


3. Jelaskan bagaimana cara kamu mengimplementasikan checklist di atas secara step-by-step (bukan hanya sekadar mengikuti tutorial)

*Generate proyek Flutter baru 
*Membuat file baru bernama menu.dart
*Struktur Proyek
*Menggunakan Widget

# **Tugas 8**

1. Jelaskan perbedaan antara Navigator.push() dan Navigator.pushReplacement(), disertai dengan contoh mengenai penggunaan kedua metode tersebut yang tepat!

*Navigator.push():

Fungsi ini digunakan untuk menambahkan halaman baru ke dalam tumpukan navigasi.
Halaman sebelumnya tetap ada di dalam tumpukan navigasi dan dapat diakses dengan menekan tombol kembali.
Cocok digunakan ketika Anda ingin menambahkan halaman baru di atas halaman saat ini.

```dart
Navigator.push(
  context,
  MaterialPageRoute(builder: (context) => NewPage()),
);
```
*Navigator.pushReplacement():

Fungsi ini juga menambahkan halaman baru ke dalam tumpukan navigasi, tetapi juga menggantikan halaman saat ini dalam tumpukan dengan yang baru.
Halaman sebelumnya dihapus dari tumpukan navigasi, sehingga tidak dapat diakses lagi dengan menekan tombol kembali.
Berguna ketika Anda ingin menggantikan halaman saat ini dengan halaman baru, seperti ketika menavigasi dari halaman login ke halaman utama setelah login berhasil.

```dart
Navigator.pushReplacement(
  context,
  MaterialPageRoute(builder: (context) => HomePage()),
);

```

2. Jelaskan masing-masing layout widget pada Flutter dan konteks penggunaannya masing-masing!

*Container:

Digunakan untuk mengatur dan mendekorasi widget-child di dalamnya.
Konteks penggunaan: Membungkus widget-child dengan properti seperti margin, padding, dan dekorasi.
Column dan Row:

*Column digunakan untuk mengatur widget-child secara vertikal, sedangkan Row digunakan untuk mengatur secara horizontal.
Konteks penggunaan: Menata widget-child secara berurutan sesuai dengan arah kolom atau baris.
Stack:

*Digunakan untuk menumpuk widget-child di atas satu sama lain.
Konteks penggunaan: Membuat tata letak yang kompleks di mana beberapa widget dapat tumpang tindih.

*ListView:

Menampilkan daftar widget-child dalam daftar gulir vertikal atau horizontal.
Konteks penggunaan: Menampilkan daftar item yang dapat digulir.

3. Sebutkan apa saja elemen input pada form yang kamu pakai pada tugas kali ini dan jelaskan mengapa kamu menggunakan elemen input tersebut!

*TextFormField untuk Nama Produk: Digunakan untuk memasukkan nama produk. Alasan Penggunaan: Untuk mendapatkan informasi tentang nama produk yang akan ditambahkan, dan sebagai validasi, tidak boleh kosong.

*TextFormField untuk Harga: Digunakan untuk memasukkan harga produk. Alasan Penggunaan: Untuk mendapatkan informasi tentang harga produk yang akan ditambahkan. Menerapkan validasi agar tidak boleh kosong dan harus berupa angka.

*TextFormField untuk Deskripsi: Digunakan untuk memasukkan deskripsi produk. Alasan Penggunaan: Untuk mendapatkan deskripsi produk yang akan ditambahkan, dan sebagai validasi, tidak boleh kosong.

4. agaimana penerapan clean architecture pada aplikasi Flutter?

Clean Architecture adalah konsep pengembangan perangkat lunak yang memisahkan kode ke dalam lapisan-lapisan terisolasi, seperti Entities, Use Cases, dan Frameworks. Penerapan Clean Architecture pada aplikasi Flutter dapat melibatkan:

*Entities:

Representasi objek bisnis atau data dalam aplikasi.

*Use Cases:

Merepresentasikan aturan bisnis dan logika aplikasi.

*Frameworks:

Mewakili detail implementasi seperti Flutter framework, database, atau eksternal libraries.

5. elaskan bagaimana cara kamu mengimplementasikan checklist di atas secara step-by-step! (bukan hanya sekadar mengikuti tutorial)

*Buat berkas left_drawer.dart: Buat berkas baru di dalam direktori widgets dengan nama left_drawer.dart.
*Kemudian, tambahkan routing untuk MyHomePage dan StokuFormPage pada bagian routing
*Hias Drawer dengan Drawer Header
*Buat Halaman stoku_form.dart

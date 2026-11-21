# PBO-LatihanGUI
# 🏆 Ranking Siswa (Java Swing)

> **Aplikasi Desktop Sederhana untuk Menampilkan Ringkasan Nilai & Ranking Siswa** berbasis **Java Swing**. Pengguna mengisi nama, nilai akhir, dan memilih ranking (1–10), lalu program menampilkan predikat nilai beserta keterangan ranking.

[![Java](https://img.shields.io/badge/Language-Java-ED8B00?style=flat-square&logo=openjdk&logoColor=white)](https://www.java.com)
[![GUI](https://img.shields.io/badge/GUI-Java%20Swing-007396?style=flat-square)](https://docs.oracle.com/javase/tutorial/uiswing/)

---

## 👤 Identitas Penyusun

| Keterangan | Detail |
| ---------- | ------ |
| **Nama**   | *Putri Riyona Ibtisaamah* |
| **NIM**    | *F1D02510131* |
| **Kelas**  | *B* |

---

## ✨ Fitur Utama

- **Input Data Siswa**: isi `Nama Siswa` dan `Nilai Akhir` (0–100).
- **Pilihan Ranking 1–10**: ranking dipilih lewat *dropdown* (`JComboBox`).
- **Predikat Nilai Otomatis**: dihitung dari nilai akhir yang diinput.

| Nilai Akhir | Predikat |
| ----------- | -------- |
| ≥ 85        | **A**    |
| ≥ 70        | **B**    |
| ≥ 60        | **C**    |
| < 60        | **D**    |

- **Keterangan Ranking Otomatis**: ditampilkan sesuai ranking yang dipilih.

| Ranking | Keterangan |
| ------- | ---------- |
| 1       | Juara 1, pertahankan! |
| 2 – 3   | Masuk 3 besar |
| 4 – 5   | Masuk 5 besar |
| 6 – 10  | Masuk 10 besar |

- **Validasi Input**: nama wajib diisi, nilai harus berupa angka, dan nilai dibatasi pada rentang `0`–`100`. Kesalahan ditampilkan lewat dialog *pop-up*.

---

## 🖼️ Tampilan Aplikasi

![Tampilan GUI Ranking Siswa](screenshot-gui.png)

---

## 🖥️ Komponen GUI yang Digunakan

Antarmuka disusun menggunakan **Java Swing** dengan *layout* manual (`setLayout(null)` + `setBounds`) dan latar berwarna tosca. Komponen yang digunakan:

1. **`JFrame` (`RankingSiswaGo`)**: jendela utama berukuran `360x460`, diposisikan di tengah layar (`setLocationRelativeTo(null)`), ukuran dikunci (`setResizable(false)`), dan ditutup dengan `EXIT_ON_CLOSE`.
2. **`JLabel`**: label kolom input (`Nama Siswa`, `Nilai Akhir (0-100)`, `Ranking`) dan tiga baris teks hasil (nama, nilai + predikat, ranking + keterangan).
3. **`JTextField`**: kolom input teks untuk `Nama Siswa` dan `Nilai Akhir`.
4. **`JComboBox<Integer>`**: menu *dropdown* pilihan ranking `1` sampai `10`, diisi dengan perulangan `for`.
5. **`JButton`**: tombol `Go` yang menjalankan proses lewat *lambda* `ActionListener`.
6. **`JOptionPane`**: dialog *pop-up* untuk menampilkan pesan peringatan ketika input tidak valid.

---

## 🔄 Alur Program

1. Pengguna mengisi **Nama Siswa** dan **Nilai Akhir**, lalu memilih **Ranking**.
2. Pengguna menekan tombol **Go**.
3. Program memvalidasi input (nama tidak kosong, nilai berupa angka 0–100).
4. Jika valid, program menghitung **predikat** dan menentukan **keterangan ranking**.
5. Hasil ditampilkan pada tiga label di bagian bawah jendela.

Contoh keluaran:

```
Nama : Budi
Nilai Akhir : 88.0 (Predikat A)
Ranking 1 : Juara 1, pertahankan!
```

---

## 🚀 Cara Menjalankan

> **Prasyarat:** Pastikan **JDK** sudah terinstal dan perintah `javac` serta `java` dapat diakses melalui terminal/CMD.
> Cek dengan `javac -version`.

1. *Clone* repositori ini (atau unduh sebagai ZIP):

   ```bash
   git clone https://github.com/<username>/<nama-repo>.git
   cd <nama-repo>
   ```

2. Kompilasi program:

   ```bash
   javac RankingSiswaGo.java
   ```

3. Jalankan program:

   ```bash
   java RankingSiswaGo
   ```

---

## 📁 Struktur Repositori

```
.
├── RankingSiswaGo.java   # Kode sumber utama (GUI + logika)
├── screenshot-gui.png    # Tangkapan layar aplikasi
└── README.md             # Dokumentasi
```

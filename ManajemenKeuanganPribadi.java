import java.util.ArrayList;
import java.util.Scanner;

//Class utama untuk manajemen keuangan pribadi
public class ManajemenKeuanganPribadi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); //Membuat objek scanner untuk input pengguna
        ArrayList<Transaksi> daftarTransaksi = new ArrayList<>(); //Membuat arraylist untuk menyimpan transaksi keuangan
        boolean running = true; // Variabel untuk mengontrol loop menu

        // Loop utama untuk menampilkan menu dan memproses pilihan 
        while (running) {
            System.out.println("\nMENU MANAJEMEN KEUANGAN");
            System.out.println("1. Tambah Catatan Keuangan"); // Menu untuk menambahkan catatan keuangan
            System.out.println("2. Lihat Semua Catatan Keuangan"); // Menu untuk melihat semua catatan keuangan
            System.out.println("3. Perbarui Catatan Keuangan"); // Menu untuk memperbarui catatan keuangan
            System.out.println("4. Hapus Catatan Keuangan"); // Menu untuk menghapus catatan keuangan
            System.out.println("5. Lihat Laporan Keuangan"); // Menu untuk melihat laporan transaksi keuangan
            System.out.println("6. Keluar"); // Menu untuk keluar dari program
            System.out.print("Pilih Menu: ");
            int pilihan = scanner.nextInt(); // Menerima input pilihan menu 
            scanner.nextLine(); // Membersihkan buffer newline setelah nextInt()

            switch (pilihan) {
                case 1: // Tambah Catatan Keuangan
                    System.out.print("Masukkan Tanggal Transaksi(dd/mm/yyyy): ");
                    String tanggal = scanner.nextLine(); // Menerima input tanggal transaksi
                    System.out.print("Masukkan Keterangan Transaksi: ");
                    String deskripsi = scanner.nextLine(); // Menerima input keterangan transaksi
                    System.out.print("Masukkan Jumlah Transaksi: ");
                    double jumlah = scanner.nextDouble(); // Menerima input jumlah transaksi
                    scanner.nextLine(); // Membersihkan buffer newline setelah nextDouble()
                    System.out.print("Masukkan jenis transaksi(Pemasukan/Pengeluaran): ");
                    String jenisTransaksi = scanner.nextLine(); // Menerima input jenis transaksi keuangan

                    // Validasi jenis transaksi
                    if (!jenisTransaksi.equalsIgnoreCase("Pemasukan") && !jenisTransaksi.equalsIgnoreCase("Pengeluaran")) {
                        System.out.println("Jenis transaksi tidak valid, gunakan Pemasukan atau Pengeluaran");
                    } else {
                        daftarTransaksi.add(new Transaksi(tanggal, deskripsi, jumlah, jenisTransaksi)); // Menambahkan catatan keuangan baru ke daftartransaksi
                        System.out.println("Catatan keuangan berhasil ditambahkan!");
                    }
                    break;

                case 2: // Lihat Semua Catatan Keuangan
                    if (daftarTransaksi.isEmpty()) {
                        System.out.println("Tidak ada catatan keuangan"); // Jika daftar kosong,maka akan ditampilkan Tidak ada catatan keuangan
                    } else {
                        for (int i = 0; i < daftarTransaksi.size(); i++) {
                            System.out.println((i + 1) + ". " + daftarTransaksi.get(i)); // Menampilkan semua catatan keuangan
                        }
                    }
                    break;

                case 3: // Perbarui Catatan Keuangan
                    System.out.print("Masukkan nomor transaksi yang ingin diperbarui: ");
                    int updateIndex = scanner.nextInt(); // Menerima input nomor transkasi yang akan diperbarui
                    scanner.nextLine(); // Membersihkan buffer newline setelah nextInt()
                    if (updateIndex > 0 && updateIndex <= daftarTransaksi.size()) {
                        Transaksi transaksiToUpdate = daftarTransaksi.get(updateIndex - 1); // Mengambil transaksi yang akan diperbarui
                        System.out.print("Masukkan Tanggal Transaksi Baru(dd/mm/yyyy): ");
                        String newTanggal = scanner.nextLine(); // Menerima tanggal transaksi baru
                        System.out.print("Masukkan Keterangan Transaksi Baru: ");
                        String newDeskripsi = scanner.nextLine(); // Menerima Keterangan transaksi baru
                        System.out.print("Masukkan Jumlah Transaksi Baru: ");
                        double newJumlah = scanner.nextDouble(); // Menerima jumlah transaksi baru
                        scanner.nextLine(); // Membersihkan buffer newline setelah nextDouble()
                        System.out.print("Masukkan Jenis Transaksi Baru(Pemasukan/Pengeluaran): ");
                        String newJenisTransaksi = scanner.nextLine(); // Menerima input jenis transaksi baru

                        // Validasi jenis transaksi
                        if (!newJenisTransaksi.equalsIgnoreCase("Pemasukan") && !newJenisTransaksi.equalsIgnoreCase("Pengeluaran")) {
                            System.out.println("Jenis transaksi tidak valid, gunakan Pemasukan atau Pengeluaran");
                        } else {
                            transaksiToUpdate.setTanggal(newTanggal); // Memeperbarui tanggal transaksi
                            transaksiToUpdate.setDeskripsi(newDeskripsi); // Memeperbarui deskripsi transaksi
                            transaksiToUpdate.setJumlah(newJumlah); // Memeperbarui jumlah transaksi
                            transaksiToUpdate.setJenisTransaksi(newJenisTransaksi); // Memeperbarui jenis transaksi transaksi
                            System.out.println("Catatan keuangan berhasil diperbarui!");
                        }
                    } else {
                        System.out.println("Nomor transaksi tidak valid"); // Jika nomor tidak valid,maka akan ditampilkan Nomor transaksu tidak valid.
                    }
                    break;

                case 4: // Hapus Catatan Keuangan
                    System.out.print("Masukkan nomor transaksi yang ingin dihapus: ");
                    int deleteIndex = scanner.nextInt(); // Menerima input nomor transaksi yang akan dihapus
                    scanner.nextLine(); // Membersihkan buffer newline setelah nextInt()
                    if (deleteIndex > 0 && deleteIndex <= daftarTransaksi.size()) {
                        daftarTransaksi.remove(deleteIndex - 1); // Menghapus transaksi dari daftar
                        System.out.println("Catatan keuangan berhasil dihapus!");
                    } else {
                        System.out.println("Nomor transkasi tidak valid"); // Jika nomor tidak valid, maka akan ditampilkan Nomor catatan tidak valid
                    }
                    break;

                case 5: // Lihat Laporan Keuangan
                    double totalPemasukan = 0; // Variabel untuk menyimpan total pemasukan
                    double totalPengeluaran = 0; // Variabel untuk menyimpan total pengeluaran

                    // Menghitung total pemasukan dan pengeluaran
                    for (Transaksi transaksi : daftarTransaksi) {
                        if (transaksi.getJenisTransaksi().equalsIgnoreCase("Pemasukan")) {
                            totalPemasukan += transaksi.getJumlah(); // Menambahkan ke total pemasukan
                        } else if (transaksi.getJenisTransaksi().equalsIgnoreCase("Pengeluaran")) {
                            totalPengeluaran += transaksi.getJumlah(); // Menambahkan ke total pengeluaran
                        }
                    }

                    double saldo = totalPemasukan - totalPengeluaran; // Menghitung saldo akhir

                    // Menampilkan laporan keuangan
                    System.out.println("\nLAPORAN KEUANGAN");
                    System.out.println("Total Pemasukan: " + totalPemasukan);
                    System.out.println("Total Pengeluaran: " + totalPengeluaran);
                    System.out.println("Saldo Akhir: " + saldo);
                    break;

                case 6: // Keluar dari program
                    running = false; // Menghentikan loop menu
                    System.out.println("Program Telah Berhenti!");
                    break;

                default:
                    System.out.println("Pilihan tidak valid"); // Jika pilihan tidak valid,maka akan ditampilkan Pilihan tidak valid
            }
        }
        scanner.close(); // Menutup objek Scanner
    }
}

// Kelas transaksi untuk merepresentasikan setiap catatan keuangan
class Transaksi {
    private String tanggal;       // Menyimpan tanggal transaksi
    private String deskripsi;     // Menyimpan deskripsi transaksi
    private double jumlah;        // Menyimpan jumlah uang transaksi
    private String jenisTransaksi; // Menyimpan jenis transaksi ("Pemasukan" atau "Pengeluaran")

    // Konstruktor untuk inisialisasi objek transaksi
    public Transaksi(String tanggal, String deskripsi, double jumlah, String jenisTransaksi) {
        this.tanggal = tanggal;
        this.deskripsi = deskripsi;
        this.jumlah = jumlah;
        this.jenisTransaksi = jenisTransaksi;
    }

    // Getter dan Setter untuk mengakses dan mengubah nilai atribut
    public String getTanggal() { return tanggal; } // Mengembalikan nilai tanggal transaksi
    public void setTanggal(String tanggal) { this.tanggal = tanggal; } // Mengubah nilai tanggal transaksi
    public String getDeskripsi() { return deskripsi; } // Mengembalikan nilai keterangan transaksi
    public void setDeskripsi(String deskripsi) { this.deskripsi = deskripsi; } // Mengubah nilai keterangan transaksi
    public double getJumlah() { return jumlah; } // Mengembalikan nilai jumlah transaksi
    public void setJumlah(double jumlah) { this.jumlah = jumlah; } // Mengubah nilai jumlah transaksi
    public String getJenisTransaksi() { return jenisTransaksi; } // Mengembalikan jenis transaksi
    public void setJenisTransaksi(String jenisTransaksi) { this.jenisTransaksi = jenisTransaksi; } // Mengubah jenis transaksi

    // Override metode toString untuk menampilkan informasi transaksi dalam bentuk string
    @Override
    public String toString() {
        return "Tanggal: " + tanggal + ", Deskripsi: " + deskripsi + ", Jumlah: " + jumlah + ", Jenis: " + jenisTransaksi;
    }
}
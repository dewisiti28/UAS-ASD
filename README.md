#TUGAS ASD

Creator  :
|Nama|NIM|
|-------|-------|
|Abdul Rafi|2300062|
|Alfarizi Khoerul Rizal|2309650|
|Danish Zaidan Ahmad |2308270|
|Dewi Siti Jamilah|2300707|


Dibuat untuk memenuhi proyek akhir mata kuliah Algoritma dan Struktur Data :

Soal Tugas:

Pada zaman dahulu, ada negara damai dan makmur bernama Utopia. Legolas, seorang tukang berlian, bisa bebas bepergian dari kota ke kota untuk menjual berlian yang ia desain ke semua orang. Semua kota dapat dengan mudah dikunjungi oleh Legolas melalui jalan-jalan yang menghubungkan setiap kota di Utopia. Dia biasa menyusuri setiap kota di Utopia setidaknya satu kali untuk menawarkan berlian buatannya. Namun, semuanya berubah setelah perang melanda Utopia. Terbentuk persekutuan di Utopia. Penduduk tidak lagi bebas untuk bepergian mengunjungi kota-kota yang ada di sana. Utopia menjadi negara yang terbagi ke dalam persekutuan/aliansi berwarna. Setiap kota tergabung dalam minimal satu dan maksimal dua aliansi (warna). Untuk masuk ke dalam sebuah kota. penduduk perlu menunjukkan tiket yang sesuai dengan salah satu warna aliansi kota tersebut pada petugas penjaga perbatasak. Saat keluar, dia akan menerima tiket lain (warna yang berbeda-jika masuk ke aliansi ganda, tiket dengan warna yang sama jika kota tersebut hanya tergabung ke dalam satu aliansi saja). Sebagai penduduk senior dan disegani di Utopia. Legolas diperbolehkan memilih tiket dan kota yang ingin dia masuki sebagai kota pertama saat ia hendak akan berjualan keliling Utopia. Namun setelah itu dia harus mematuhi aturan aliansi. la ingin melakukan rutinitas yang sama seperti dulu, mengunjungi setiap kota tepat satu kali di Utopia. Kini tidak mudah baginya untuk melakukan hal tersebut, meski ia bisa memilih dari mana akan memulai perjalanan bisnisnya.

Contoh :
- Misal, ada 4 kota (0-3).
- Kota 0: aliansi merah & hijau.
- Kota 1: aliansi merah.
- Kota 2: aliansi hijau & kuning.
- Kota 3: aliansi biru & merah.

jika :
- Legolas mulai di kota 0 dengan tiket merah, dia keluar kota 0 dengan membawa tiket
- Sekarang hanya kota 2 yang bisa dikunjungi (dan keluar dari kota 2 dengan tiker kuning)
- Keluar kota 2, dan terima tiket kuning dan tidak biss ke mana-mana lagi
- Jika Legolas mulai di kota dengan tiket hijnu, dia keluar kota 0 dengan tiket merah.
- Sekarang dia bisa ke kota 1 atau 3 menggunakan tiket merah tersebut
- Jika dia memilih ke kota 3, dia akan keluar dengan tiket biru dan tidak bisa kemana-mana lagi. (kota 1 dan 2 tidak berhasil dikunjungi).
- Jika dia memilih ke kota 1 setelah dari 0. dia mendapat tiket merah untuk ke kota 3. Keluar dari kota 3 dengan tiket biru, dia tidak bisa berkunjung ke kota 2 
- Jadi, tidak mungkin mengunjungi semua kota jika Legolas mulai dari kota 0.

Tapi, ternyata, memungkinkan untuk mengunjungi semua kota jika Legolas mulai dari kota 2 dengan tiket kuning 
- Masuk kota 2 dengan tiket kuning, keluar dengan membawa tiket hijau.
- Lalu ke kota 0 dan keluar dengan tiket merah.
- Menuju kota 1 dengan tiket merah dan pulang dari kota tersebut dengan tiket merah lagi(karena kota 1 hanya tergabung ke dalam 1 aliansi, sehingga tiket yang dibawa pulang
  bisa sama dengan tiket yang digunakan untuk masuk).
- Masuk kota 3 menggunakan tiket merah.

Seperti yang Anda lihat, sangat sulit bagi Legolas si tukang berlian untuk menyelesaikan tugasnya. Oleh sebab itu, dia meminta Anda membantunya. Dia ingin tahu kota mana yangharus dia pilih untuk memulai perjalanan, sehingga dia dapat melakukan perjalanan ke semuakota di Utopia tepat satu kali.
Bisakah kamu membantu Legolas?

  INPUT :
  - Input terdiri dari beragam kasus. Setiap kasus terdiri dari data masukan sebagai berikut:
     1. Baris pertama: jumlah kota (N. 1≤N≤ 500) dan aliansi (C. 1≤ C≤ 100).
     2. Baris selanjutnya (sebanyak C): jumlah kota (K) dalam aliansi dan daftar kotayang tergabung (dipisahkan spasi, bernomor 0 sampai N-1). Setiap kota muncul minimal sekali, maksimal dua kali, dan tidak ada yang terulang dalam aliansi yang sama.
   - Input diakhiri dua angka nol (0 0).

  OUTPUT :
- Bilangan -1 jika tidak mungkin. atau nomor kota awal yang bisa dipilih legolas(pilih yng terkecil jika ada bbeberapa jawaban).

  |Contoh input|Contoh output|
  |---------|---------|
  |4 4| 2|
  |1 3|-1|
  |3 0 1 3|1|
  |2 0 2| |
  |1 2| |
  |3 4| |
  |1 0| |
  |3 0 1 2| |
  |1 1| |
  |1 2| |
  |3 4| |
  |1 1| |
  |2 1 0| |
  |2 0 2| |
  |1 2| |
  |0 0| |
  
  
  
  



**Mekatronika dan Kecerdasan Buatan**

**Universitas Pendidikan Indonesia**

import java.util.*;

public class UAS {

    static class Graf {
        int jumlahKota;
        List<Set<Integer>> daftarTetangga;
        Map<Integer, Set<Integer>> aliansiKota;

        Graf(int jumlahKota) {
            this.jumlahKota = jumlahKota;
            daftarTetangga = new ArrayList<>(jumlahKota);
            for (int i = 0; i < jumlahKota; i++) {
                daftarTetangga.add(new HashSet<>());
            }
            aliansiKota = new HashMap<>();
        }

        void tambahAliansi(int warna, List<Integer> kotaKota) {
            for (int kota : kotaKota) {
                aliansiKota.putIfAbsent(kota, new HashSet<>());
                aliansiKota.get(kota).add(warna);
            }
            for (int kota : kotaKota) {
                for (int kotaLain : kotaKota) {
                    if (kota != kotaLain) {
                        daftarTetangga.get(kota).add(kotaLain);
                    }
                }
            }
        }

        boolean bisaKunjungiSemuaKotaDari(int kotaMulai) {
            Set<Integer> tiketAwal = aliansiKota.get(kotaMulai);
            for (int tiket : tiketAwal) {
                Set<Integer> dikunjungi = new HashSet<>();
                if (dfs(kotaMulai, dikunjungi, tiket) == jumlahKota) {
                    return true;
                }
            }
            return false;
        }

        private int dfs(int kota, Set<Integer> dikunjungi, int tiketSaatIni) {
            dikunjungi.add(kota);
            int hitungan = 1;

            for (int tetangga : daftarTetangga.get(kota)) {
                if (!dikunjungi.contains(tetangga)) {
                    Set<Integer> tiketTetangga = aliansiKota.get(tetangga);
                    for (int tiket : tiketTetangga) {
                        if (tiket != tiketSaatIni) {
                            hitungan += dfs(tetangga, dikunjungi, tiket);
                        }
                    }
                }
            }
            return hitungan;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder output = new StringBuilder();

        while (true) {
            int jumlahKota = scanner.nextInt();
            int jumlahAliansi = scanner.nextInt();
            if (jumlahKota == 0 && jumlahAliansi == 0) break;

            Graf graf = new Graf(jumlahKota);

            for (int i = 0; i < jumlahAliansi; i++) {
                int kotaDalamAliansi = scanner.nextInt();
                List<Integer> kotaKota = new ArrayList<>();
                for (int j = 0; j < kotaDalamAliansi; j++) {
                    kotaKota.add(scanner.nextInt());
                }
                graf.tambahAliansi(i, kotaKota);
            }

            int kotaMulai = -1;
            for (int i = 0; i < jumlahKota; i++) {
                if (graf.bisaKunjungiSemuaKotaDari(i)) {
                    kotaMulai = i;
                    break;
                }
            }

            output.append(kotaMulai).append("\n");
        }

        System.out.print(output);
        scanner.close();
    }
}

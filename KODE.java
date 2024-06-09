import java.util.*;
import java.util.LinkedList;
public class uasSem2 {

    static class Graf {
        int jumlahKota;
        Map<Integer, Set<Integer>> aliansiKota;
        Map<String, List<String>> graf;

        Graf(int jumlahKota) {
            this.jumlahKota = jumlahKota;
            aliansiKota = new HashMap<>();
            graf = new HashMap<>();
        }

        void tambahAliansi(int warna, List<Integer> kota) {
            for (int k : kota) {
                aliansiKota.putIfAbsent(k, new HashSet<>());
                aliansiKota.get(k).add(warna);
            }
            for (int i = 0; i < kota.size(); i++) {
                for (int j = i + 1; j < kota.size(); j++) {
                    String kunci1 = kota.get(i) + "-" + warna;
                    String kunci2 = kota.get(j) + "-" + warna;
                    graf.putIfAbsent(kunci1, new ArrayList<>());
                    graf.putIfAbsent(kunci2, new ArrayList<>());
                    graf.get(kunci1).add(kunci2);
                    graf.get(kunci2).add(kunci1);
                }
            }
        }

        boolean dapatMengunjungiSemuaKotaDari(int kotaMulai) {
            Set<Integer> tiketAwal = aliansiKota.get(kotaMulai);
            if (tiketAwal == null) return false;

            for (int tiket : tiketAwal) {
                Set<Integer> dikunjungi = new HashSet<>();
                if (bfs(kotaMulai, tiket, dikunjungi) == jumlahKota) {
                    return true;
                }
            }
            return false;
        }

        private int bfs(int kotaMulai, int aliansiMulai, Set<Integer> dikunjungi) {
            Queue<Node> antrian = new LinkedList<>();
            antrian.offer(new Node(kotaMulai, aliansiMulai, new HashSet<>(Collections.singleton(kotaMulai))));

            while (!antrian.isEmpty()) {
                Node node = antrian.poll();
                int kotaSaatIni = node.kota;
                int aliansiSaatIni = node.aliansi;
                Set<Integer> dikunjungiSaatIni = node.dikunjungi;

                if (dikunjungiSaatIni.size() == jumlahKota) {
                    return dikunjungiSaatIni.size();
                }

                List<Integer> aliansiBerikutnyaList = new ArrayList<>(aliansiKota.getOrDefault(kotaSaatIni, new HashSet<>()));
                for (int aliansiBerikutnya : aliansiBerikutnyaList) {
                    if (aliansiBerikutnya != aliansiSaatIni || aliansiBerikutnyaList.size() == 1) {
                        String kunci = kotaSaatIni + "-" + aliansiBerikutnya;
                        List<String> tetangga = graf.getOrDefault(kunci, new ArrayList<>());
                        for (String tetanggaStr : tetangga) {
                            int kotaTetangga = Integer.parseInt(tetanggaStr.split("-")[0]);
                            int aliansiTetangga = Integer.parseInt(tetanggaStr.split("-")[1]);
                            if (!dikunjungiSaatIni.contains(kotaTetangga)) {
                                Set<Integer> baruDikunjungi = new HashSet<>(dikunjungiSaatIni);
                                baruDikunjungi.add(kotaTetangga);
                                antrian.offer(new Node(kotaTetangga, aliansiTetangga, baruDikunjungi));
                            }
                        }
                    }
                }
            }
            return dikunjungi.size();
        }

        static class Node {
            int kota;
            int aliansi;
            Set<Integer> dikunjungi;

            Node(int kota, int aliansi, Set<Integer> dikunjungi) {
                this.kota = kota;
                this.aliansi = aliansi;
                this.dikunjungi = dikunjungi;
            }
        }
    }

    public static void main(String[] args) {
        Scanner pemindai = new Scanner(System.in);
        List<Integer> hasil = new ArrayList<>();

        while (true) {
            int jumlahKota = pemindai.nextInt();
            int jumlahAliansi = pemindai.nextInt();
            if (jumlahKota == 0 && jumlahAliansi == 0) break;

            Graf graf = new Graf(jumlahKota);

            for (int i = 0; i < jumlahAliansi; i++) {
                int jumlahKotaDalamAliansi = pemindai.nextInt();
                List<Integer> kota = new ArrayList<>();
                for (int j = 0; j < jumlahKotaDalamAliansi; j++) {
                    kota.add(pemindai.nextInt());
                }
                graf.tambahAliansi(i, kota);
            }

            int kotaMulai = -1;
            for (int i = 0; i < jumlahKota; i++) {
                if (graf.dapatMengunjungiSemuaKotaDari(i)) {
                    kotaMulai = i;
                    break;
                }
            }

            hasil.add(kotaMulai);
        }

        for (int result : hasil) {
            System.out.println(result);
        }
        pemindai.close();
    }
}

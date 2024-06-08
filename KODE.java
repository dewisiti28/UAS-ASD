import java.util.*;
import java.util.LinkedList;

public class UAS {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> hasil = new ArrayList<>();

        while (true) {
            int jumlahKota = scanner.nextInt();
            int jumlahAliansi = scanner.nextInt();
            if (jumlahKota == 0 && jumlahAliansi == 0) {
                break;
            }

            List<List<Integer>> daftarAliansi = new ArrayList<>();
            for (int i = 0; i < jumlahAliansi; i++) {
                int kotaDalamAliansi = scanner.nextInt();
                List<Integer> aliansi = new ArrayList<>();
                for (int j = 0; j < kotaDalamAliansi; j++) {
                    aliansi.add(scanner.nextInt());
                }
                daftarAliansi.add(aliansi);
            }

            int kotaAwal = cariKotaAwal(jumlahKota, jumlahAliansi, daftarAliansi);
            hasil.add(kotaAwal);
        }

        for (int kota : hasil) {
            System.out.println(kota);
        }
        scanner.close();
    }
private static int cariKotaAwal(int n, int c, List<List<Integer>> daftarAliansi) {
        Map<Integer, List<Integer>> petaAliansiKota = new HashMap<>();
        Map<String, List<String>> graf = new HashMap<>();
        
        for (int indeksAliansi = 0; indeksAliansi < daftarAliansi.size(); indeksAliansi++) {
            List<Integer> aliansi = daftarAliansi.get(indeksAliansi);
            for (int i = 0; i < aliansi.size(); i++) {
                for (int j = i + 1; j < aliansi.size(); j++) {
                    String kunci1 = aliansi.get(i) + "-" + indeksAliansi;
                    String kunci2 = aliansi.get(j) + "-" + indeksAliansi;
                    graf.putIfAbsent(kunci1, new ArrayList<>());
                    graf.putIfAbsent(kunci2, new ArrayList<>());
                    graf.get(kunci1).add(kunci2);
                    graf.get(kunci2).add(kunci1);
                }
            }
        }
        
        for (int indeksAliansi = 0; indeksAliansi < daftarAliansi.size(); indeksAliansi++) {
            List<Integer> aliansi = daftarAliansi.get(indeksAliansi);
            for (int kota : aliansi) {
                petaAliansiKota.putIfAbsent(kota, new ArrayList<>());
                petaAliansiKota.get(kota).add(indeksAliansi);
            }
        }
        for (int kota = 0; kota < n; kota++) {
                    for (int aliansi : petaAliansiKota.getOrDefault(kota, new ArrayList<>())) {
                        if (dapatKunjungiSemuaKota(kota, aliansi, n, petaAliansiKota, graf)) {
                            return kota;
                        }
                    }
                }
        
                return -1;
            }
        
            private static boolean dapatKunjungiSemuaKota(int kotaMulai, int aliansiMulai, int n, Map<Integer, List<Integer>> petaAliansiKota, Map<String, List<String>> graf) {
                Queue<Node> antrian = new LinkedList<>();
                antrian.offer(new Node(kotaMulai, aliansiMulai, new HashSet<>(Collections.singleton(kotaMulai)), new ArrayList<>(Collections.singleton(kotaMulai))));
        
                while (!antrian.isEmpty()) {
                    Node node = antrian.poll();
                    int kotaSekarang = node.kota;
                    int aliansiSekarang = node.aliansi;
                    Set<Integer> sudahDikunjungi = node.dikunjungi;
                    List<Integer> jalur = node.jalur;
        
                    if (sudahDikunjungi.size() == n) {
                        return true;
                    }

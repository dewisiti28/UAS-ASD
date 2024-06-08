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

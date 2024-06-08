import java.util.*;

public class UAS {

   
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

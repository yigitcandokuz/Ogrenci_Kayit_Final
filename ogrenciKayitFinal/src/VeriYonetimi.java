import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class VeriYonetimi {
    public static void veriEkle(String dosyaAdi, String veri) {
        try (FileWriter fileWriter = new FileWriter(dosyaAdi, true)) {
            fileWriter.write(veri + System.lineSeparator());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static List<String> dosyadanOku(String dosyaAdi) {
        List<String> veriler = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(dosyaAdi))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                veriler.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return veriler;
    }
}

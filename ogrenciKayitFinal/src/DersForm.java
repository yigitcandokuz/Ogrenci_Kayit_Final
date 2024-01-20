import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

public class DersForm extends JFrame {
    private JTextField txtDersKodu;
    private JTextField txtDersAd;
    private JTextField txtDersDonem;
    private JTextField txtOgretimGorevlisi;
    private JButton btnKaydet;

    public DersForm() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 300);
        setTitle("Ders Formu");

        JPanel panel = new JPanel();
        getContentPane().add(panel, null);
        panel.setLayout(null);

        JLabel lblDersKodu = new JLabel("Ders Kodu:");
        lblDersKodu.setBounds(50, 30, 100, 20);
        panel.add(lblDersKodu);

        txtDersKodu = new JTextField();
        txtDersKodu.setBounds(150, 30, 200, 20);
        panel.add(txtDersKodu);

        JLabel lblDersAd = new JLabel("Ders Adı:");
        lblDersAd.setBounds(50, 60, 100, 20);
        panel.add(lblDersAd);

        txtDersAd = new JTextField();
        txtDersAd.setBounds(150, 60, 200, 20);
        panel.add(txtDersAd);

        JLabel lblDersDonem = new JLabel("Dönem:");
        lblDersDonem.setBounds(50, 90, 100, 20);
        panel.add(lblDersDonem);

        txtDersDonem = new JTextField();
        txtDersDonem.setBounds(150, 90, 200, 20);
        panel.add(txtDersDonem);

        JLabel lblOgretimGorevlisi = new JLabel("Öğretim Görevlisi:");
        lblOgretimGorevlisi.setBounds(50, 120, 100, 20);
        panel.add(lblOgretimGorevlisi);

        txtOgretimGorevlisi = new JTextField();
        txtOgretimGorevlisi.setBounds(150, 120, 200, 20);
        panel.add(txtOgretimGorevlisi);

        btnKaydet = new JButton("Kaydet");
        btnKaydet.setBounds(150, 150, 100, 30);
        panel.add(btnKaydet);

        btnKaydet.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                kaydet("kayitlar.txt");
            }
        });
    }

    private void kaydet(String dosyaAdi) {
        try (FileWriter fileWriter = new FileWriter(dosyaAdi, true)) {
            String json = String.format("{\"DersKodu\":\"%s\",\"DersAd\":\"%s\",\"DersDonem\":\"%s\",\"OgretimGorevlisi\":\"%s\"}",
                    txtDersKodu.getText(), txtDersAd.getText(), txtDersDonem.getText(), txtOgretimGorevlisi.getText());
            fileWriter.write(json + System.lineSeparator());
            JOptionPane.showMessageDialog(null, "Ders bilgileri kaydedildi: " + dosyaAdi);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}

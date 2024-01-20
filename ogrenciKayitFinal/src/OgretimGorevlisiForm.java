import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

public class OgretimGorevlisiForm extends JFrame {
    private JTextField txtOgretmenNo;
    private JTextField txtAd;
    private JTextField txtSoyad;
    private JTextField txtBolum;
    private JComboBox<String> cbVerdigiDersler;
    private JButton btnKaydet;

    public OgretimGorevlisiForm() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 300);
        setTitle("Öğretim Görevlisi Formu");

        JPanel panel = new JPanel();
        getContentPane().add(panel, null);
        panel.setLayout(null);

        JLabel lblOgretmenNo = new JLabel("Öğretmen No:");
        lblOgretmenNo.setBounds(50, 30, 100, 20);
        panel.add(lblOgretmenNo);

        txtOgretmenNo = new JTextField();
        txtOgretmenNo.setBounds(150, 30, 200, 20);
        panel.add(txtOgretmenNo);

        JLabel lblAd = new JLabel("Ad:");
        lblAd.setBounds(50, 60, 100, 20);
        panel.add(lblAd);

        txtAd = new JTextField();
        txtAd.setBounds(150, 60, 200, 20);
        panel.add(txtAd);

        JLabel lblSoyad = new JLabel("Soyad:");
        lblSoyad.setBounds(50, 90, 100, 20);
        panel.add(lblSoyad);

        txtSoyad = new JTextField();
        txtSoyad.setBounds(150, 90, 200, 20);
        panel.add(txtSoyad);

        JLabel lblBolum = new JLabel("Bölüm:");
        lblBolum.setBounds(50, 120, 100, 20);
        panel.add(lblBolum);

        txtBolum = new JTextField();
        txtBolum.setBounds(150, 120, 200, 20);
        panel.add(txtBolum);

        JLabel lblVerdigiDersler = new JLabel("Verdiği Dersler:");
        lblVerdigiDersler.setBounds(50, 150, 100, 20);
        panel.add(lblVerdigiDersler);

        cbVerdigiDersler = new JComboBox<>();
        // Buraya Ders Formundan alınan dersleri ekleyebilirsiniz
        cbVerdigiDersler.addItem("Matematik");
        cbVerdigiDersler.addItem("Türkçe");
        cbVerdigiDersler.addItem("Fizik");
        cbVerdigiDersler.setBounds(150, 150, 200, 20);
        panel.add(cbVerdigiDersler);

        btnKaydet = new JButton("Kaydet");
        btnKaydet.setBounds(150, 180, 100, 30);
        panel.add(btnKaydet);

        btnKaydet.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                kaydet("kayitlar.txt");
            }
        });
    }

    private void kaydet(String dosyaAdi) {
        try (FileWriter fileWriter = new FileWriter(dosyaAdi, true)) {
            String json = String.format("{\"OgretmenNo\":\"%s\",\"Ad\":\"%s\",\"Soyad\":\"%s\",\"Bolum\":\"%s\",\"VerdigiDers\":\"%s\"}",
                    txtOgretmenNo.getText(), txtAd.getText(), txtSoyad.getText(),
                    txtBolum.getText(), cbVerdigiDersler.getSelectedItem());
            fileWriter.write(json + System.lineSeparator());
            JOptionPane.showMessageDialog(null, "Öğretim görevlisi bilgileri kaydedildi: " + dosyaAdi);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}

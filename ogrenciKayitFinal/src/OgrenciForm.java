import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

public class OgrenciForm extends JFrame {
    private JTextField txtOgrenciNo;
    private JTextField txtOgrenciAd;
    private JTextField txtOgrenciSoyad;
    private JTextField txtOgrenciBolum;
    private JComboBox<String> cbOgrenciDersler;
    private JButton btnKaydet;

    public OgrenciForm() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 300);
        setTitle("Öğrenci Formu");

        JPanel panel = new JPanel();
        getContentPane().add(panel, null);
        panel.setLayout(null);

        JLabel lblOgrenciNo = new JLabel("Öğrenci No:");
        lblOgrenciNo.setBounds(50, 30, 100, 20);
        panel.add(lblOgrenciNo);

        txtOgrenciNo = new JTextField();
        txtOgrenciNo.setBounds(150, 30, 200, 20);
        panel.add(txtOgrenciNo);

        JLabel lblOgrenciAd = new JLabel("Ad:");
        lblOgrenciAd.setBounds(50, 60, 100, 20);
        panel.add(lblOgrenciAd);

        txtOgrenciAd = new JTextField();
        txtOgrenciAd.setBounds(150, 60, 200, 20);
        panel.add(txtOgrenciAd);

        JLabel lblOgrenciSoyad = new JLabel("Soyad:");
        lblOgrenciSoyad.setBounds(50, 90, 100, 20);
        panel.add(lblOgrenciSoyad);

        txtOgrenciSoyad = new JTextField();
        txtOgrenciSoyad.setBounds(150, 90, 200, 20);
        panel.add(txtOgrenciSoyad);

        JLabel lblOgrenciBolum = new JLabel("Bölüm:");
        lblOgrenciBolum.setBounds(50, 120, 100, 20);
        panel.add(lblOgrenciBolum);

        txtOgrenciBolum = new JTextField();
        txtOgrenciBolum.setBounds(150, 120, 200, 20);
        panel.add(txtOgrenciBolum);

        JLabel lblOgrenciDersler = new JLabel("Dersler:");
        lblOgrenciDersler.setBounds(50, 150, 100, 20);
        panel.add(lblOgrenciDersler);

        cbOgrenciDersler = new JComboBox<>();
        // Buraya Ders Formundan alınan dersleri ekleyebilirsiniz
        cbOgrenciDersler.addItem("Matematik");
        cbOgrenciDersler.addItem("Türkçe");
        cbOgrenciDersler.addItem("Fizik");
        cbOgrenciDersler.setBounds(150, 150, 200, 20);
        panel.add(cbOgrenciDersler);

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
            String json = String.format("{\"OgrenciNo\":\"%s\",\"OgrenciAd\":\"%s\",\"OgrenciSoyad\":\"%s\",\"OgrenciBolum\":\"%s\",\"OgrenciDers\":\"%s\"}",
                    txtOgrenciNo.getText(), txtOgrenciAd.getText(), txtOgrenciSoyad.getText(),
                    txtOgrenciBolum.getText(), cbOgrenciDersler.getSelectedItem());
            fileWriter.write(json + System.lineSeparator());
            JOptionPane.showMessageDialog(null, "Öğrenci bilgileri kaydedildi: " + dosyaAdi);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}

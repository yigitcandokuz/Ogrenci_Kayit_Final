import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AnaForm extends JFrame {
    private JButton btnDersForm;
    private JButton btnOgrenciForm;
    private JButton btnOgretimGorevlisiForm;

    public AnaForm() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setTitle("Menü Formu");

        JPanel panel = new JPanel();
        getContentPane().add(panel, null);
        panel.setLayout(null);

        btnDersForm = new JButton("Ders Formu");
        btnDersForm.setBounds(50, 50, 150, 30);
        panel.add(btnDersForm);

        btnOgrenciForm = new JButton("Öğrenci Formu");
        btnOgrenciForm.setBounds(50, 100, 150, 30);
        panel.add(btnOgrenciForm);

        btnOgretimGorevlisiForm = new JButton("Öğretim Görevlisi Formu");
        btnOgretimGorevlisiForm.setBounds(50, 150, 200, 30);
        panel.add(btnOgretimGorevlisiForm);

        btnDersForm.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DersForm dersForm = new DersForm();
                dersForm.setVisible(true);
            }
        });

        btnOgrenciForm.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                OgrenciForm ogrenciForm = new OgrenciForm();
                ogrenciForm.setVisible(true);
            }
        });

        btnOgretimGorevlisiForm.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                OgretimGorevlisiForm ogretimGorevlisiForm = new OgretimGorevlisiForm();
                ogretimGorevlisiForm.setVisible(true);
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            AnaForm anaForm = new AnaForm();
            anaForm.setVisible(true);
        });
    }
}


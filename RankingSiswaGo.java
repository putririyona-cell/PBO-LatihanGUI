import javax.swing.*;
import java.awt.*;

public class RankingSiswaGo extends JFrame {

    private JTextField txtNama, txtNilai;
    private JComboBox<Integer> cbRanking;
    private JLabel lblHasil1, lblHasil2, lblHasil3;

    private static final Color WARNA_BG = new Color(20, 200, 195); // tosca

    public RankingSiswaGo() {
        setTitle("Ranking Siswa");
        setSize(360, 460);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        getContentPane().setBackground(WARNA_BG);
        setLayout(null); // posisi diatur manual pakai setBounds

        buatGUI();
    }

    // Membuat label putih biasa
    private JLabel buatLabel(String teks, int y) {
        JLabel label = new JLabel(teks);
        label.setFont(new Font("Arial", Font.PLAIN, 14));
        label.setForeground(Color.WHITE);
        label.setBounds(30, y, 280, 22);
        add(label);
        return label;
    }

    // Membuat label hasil (tebal) yang awalnya kosong
    private JLabel buatLabelHasil(int y) {
        JLabel label = new JLabel("");
        label.setFont(new Font("Arial", Font.BOLD, 13));
        label.setForeground(Color.WHITE);
        label.setBounds(30, y, 300, 22);
        add(label);
        return label;
    }

    private void buatGUI() {
        // ---------- INPUT NAMA ----------
        buatLabel("Nama Siswa", 20);
        txtNama = new JTextField();
        txtNama.setBounds(30, 45, 280, 28);
        add(txtNama);

        // ---------- INPUT NILAI AKHIR ----------
        buatLabel("Nilai Akhir (0-100)", 80);
        txtNilai = new JTextField();
        txtNilai.setBounds(30, 105, 280, 28);
        add(txtNilai);

        // ---------- PILIHAN RANKING 1-10 ----------
        buatLabel("Ranking", 140);
        cbRanking = new JComboBox<>();
        for (int i = 1; i <= 10; i++) {
            cbRanking.addItem(i);
        }
        cbRanking.setBounds(30, 165, 280, 28);
        add(cbRanking);

        // ---------- TOMBOL GO ----------
        JButton btnGo = new JButton("Go");
        btnGo.setBounds(210, 215, 100, 30);
        add(btnGo);

        // ---------- LABEL HASIL ----------
        lblHasil1 = buatLabelHasil(270);
        lblHasil2 = buatLabelHasil(300);
        lblHasil3 = buatLabelHasil(330);

        // ---------- EVENT ----------
        btnGo.addActionListener(e -> prosesData());
    }

    private void prosesData() {
        String nama = txtNama.getText().trim();

        if (nama.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nama siswa wajib diisi!");
            return;
        }

        double nilai;
        try {
            nilai = Double.parseDouble(txtNilai.getText().trim());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(
                this, "Nilai akhir harus berupa angka!"
            );
            return;
        }

        if (nilai < 0 || nilai > 100) {
            JOptionPane.showMessageDialog(
                this, "Nilai akhir harus antara 0 sampai 100!"
            );
            return;
        }

        int ranking = (Integer) cbRanking.getSelectedItem();

        lblHasil1.setText("Nama : " + nama);
        lblHasil2.setText(
            "Nilai Akhir : " + nilai + " (Predikat " + hitungPredikat(nilai) + ")"
        );
        lblHasil3.setText(
            "Ranking " + ranking + " : " + keteranganRanking(ranking)
        );
    }

    private String hitungPredikat(double nilai) {
        if (nilai >= 85) return "A";
        if (nilai >= 70) return "B";
        if (nilai >= 60) return "C";
        return "D";
    }

    private String keteranganRanking(int ranking) {
        if (ranking == 1) return "Juara 1, pertahankan!";
        if (ranking <= 3) return "Masuk 3 besar";
        if (ranking <= 5) return "Masuk 5 besar";
        return "Masuk 10 besar";
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new RankingSiswaGo().setVisible(true);
        });
    }
}

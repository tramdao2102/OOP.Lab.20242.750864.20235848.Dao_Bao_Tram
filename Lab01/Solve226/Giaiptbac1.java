import javax.swing.JOptionPane;

public class Giaiptbac1 {
    public static void main(String[] args) {
        String inputA = JOptionPane.showInputDialog("Nhap he so a (a ≠ 0)");
        double a = Double.parseDouble(inputA);

        if (a == 0) {
            JOptionPane.showMessageDialog(null, "He so a phai khac 0");
            return;
        }

        String inputB = JOptionPane.showInputDialog("Nhap he so b");
        double b = Double.parseDouble(inputB);

        double x = -b / a;

        String message = "Ket qua cua phuong trinh " + a + "x + " + b + " = 0 la x = " + x;
        JOptionPane.showMessageDialog(null, message);
    }
}


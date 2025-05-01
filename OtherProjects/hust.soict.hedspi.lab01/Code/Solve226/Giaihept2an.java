import javax.swing.JOptionPane;

public class Giaihept2an {
    public static void main(String[] args) {
        String inputA11 = JOptionPane.showInputDialog("Nhap he so a11");
        double a11 = Double.parseDouble(inputA11);

        String inputA12 = JOptionPane.showInputDialog("Nhap he so a12");
        double a12 = Double.parseDouble(inputA12);

        String inputB1 = JOptionPane.showInputDialog("Nhap he so b1");
        double b1 = Double.parseDouble(inputB1);

        String inputA21 = JOptionPane.showInputDialog("Nhap he so a21");
        double a21 = Double.parseDouble(inputA21);

        String inputA22 = JOptionPane.showInputDialog("Nhap he so a22");
        double a22 = Double.parseDouble(inputA22);

        String inputB2 = JOptionPane.showInputDialog("Nhap he so b2");
        double b2 = Double.parseDouble(inputB2);

        double determinant = a11 * a22 - a12 * a21;

        if (determinant == 0) {
            if (a11 * b2 == a21 * b1 && a12 * b2 == a22 * b1) {
                JOptionPane.showMessageDialog(null, "He phuong trinh co vo so nghiem.");
            } else {
                JOptionPane.showMessageDialog(null, "He phuong trinh vo nghiem.");
            }
        } else {
            double x1 = (b1 * a22 - b2 * a12) / determinant;
            double x2 = (a11 * b2 - a21 * b1) / determinant;

            String message = "Nghiem cua he phuong trinh la:\n" +
                             "x1 = " + x1 + "\n" +
                             "x2 = " + x2;
            JOptionPane.showMessageDialog(null, message);
        }
    }
}

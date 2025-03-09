import javax.swing.JOptionPane;

public class Giaiptbac2 {
    public static void main(String[] args) {
        String inputA = JOptionPane.showInputDialog("Nhap he so a (a ≠ 0)");
        double a = Double.parseDouble(inputA);

        if (a == 0) {
            JOptionPane.showMessageDialog(null, "He so a phai khac 0.");
            return;
        }

        String inputB = JOptionPane.showInputDialog("Nhap he so b");
        double b = Double.parseDouble(inputB);

        String inputC = JOptionPane.showInputDialog("Nhap he so c");
        double c = Double.parseDouble(inputC);

        double discriminant = b * b - 4 * a * c;

        String message;
        if (discriminant > 0) {
            double x1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            double x2 = (-b - Math.sqrt(discriminant)) / (2 * a);
            message = "Phuong trinh co hai nghiem phan biet:\n" +
                      "x1 = " + x1 + "\n" +
                      "x2 = " + x2;
        } else if (discriminant == 0) {
            double x = -b / (2 * a);
            message = "Phuong trinh co nghiem kep:\n" +
                      "x = " + x;
        } else {
            message = "Phuong trinh vo nghiem";
        }

        JOptionPane.showMessageDialog(null, message);
    }
}
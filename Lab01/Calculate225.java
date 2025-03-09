import javax.swing.JOptionPane;

public class Calculate225 {
    public static void main(String[] args) {
        String input1 = JOptionPane.showInputDialog("Nhap so thu nhat");
        double number1 = Double.parseDouble(input1);

        String input2 = JOptionPane.showInputDialog("Nhap so thu hai");
        double number2 = Double.parseDouble(input2);

        double sum = number1 + number2;
        double difference = number1 - number2;
        double product = number1 * number2;
        String quotient;

        if (number2 != 0) {
            quotient = String.valueOf(number1 / number2);
        } else {
            quotient = "khong chia duoc cho 0";
        }

        String message = "Tong hai so " + number1 + " va " + number2 + " la " + sum + "\n" +
                         "Hieu hai so " + number1 + " va " + number2 + " la " + difference + "\n" +
                         "Tich hai so " + number1 + " va " + number2 + " la " + product + "\n" +
                         "Thuong hai so " + number1 + " va " + number2 + " la " + quotient;

        JOptionPane.showMessageDialog(null, message);
    }
}
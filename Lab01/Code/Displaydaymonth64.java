import java.util.Scanner;

public class Displaydaymonth64 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String monthInput;
        int year;

        while (true) {
            System.out.print("Nhap thang ");
            monthInput = scanner.nextLine().trim();

            System.out.print("Nhap nam ");
            if (scanner.hasNextInt()) {
                year = scanner.nextInt();
                scanner.nextLine(); 
                if (year >= 0) {
                    int days = getDaysInMonth(monthInput, year);
                    if (days != -1) {
                        System.out.println("Thang " + monthInput + " trong nam " + year + " co " + days + " ngay");
                        break;
                    } else {
                        System.out.println("Nhap sai thang");
                    }
                } else {
                    System.out.println("Nhap sai nam");
                }
            } else {
                System.out.println("Nhap sai nam");
                scanner.nextLine();
            }
        }
        scanner.close();
    }

    public static int getDaysInMonth(String monthInput, int year) {
        String[] monthsFull = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        String[] monthsAbbrev = {"Jan.", "Feb.", "Mar.", "Apr.", "May", "Jun.", "Jul.", "Aug.", "Sep.", "Oct.", "Nov.", "Dec."};
        String[] monthsShort = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};

        int monthIndex = -1;

        for (int i = 0; i < monthsFull.length; i++) {
            if (monthInput.equalsIgnoreCase(monthsFull[i]) || monthInput.equalsIgnoreCase(monthsAbbrev[i]) || monthInput.equalsIgnoreCase(monthsShort[i]) || monthInput.equals(String.valueOf(i + 1))) {
                monthIndex = i;
                break;
            }
        }

        if (monthIndex == -1) {
            return -1; 
        }

        switch (monthIndex) {
            case 0: // January
            case 2: // March
            case 4: // May
            case 6: // July
            case 7: // August
            case 9: // October
            case 11: // December
                return 31;
            case 3: // April
            case 5: // June
            case 8: // September
            case 10: // November
                return 30;
            case 1: // February
                return isLeapYear(year) ? 29 : 28;
            default:
                return -1;
        }
    }

    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
}
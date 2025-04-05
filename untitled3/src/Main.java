import java.util.*;
import java.time.LocalDate;
import java.time.DayOfWeek;
import java.time.temporal.ChronoUnit;
import java.time.DateTimeException;
import java.time.format.DateTimeFormatter;

class Date implements Comparable<Date> {
    private int day, month, year;

    public Date(int day, int month, int year) {
        if (isValidDate(day, month, year)) {
            this.day = day;
            this.month = month;
            this.year = year;
        } else {
            throw new IllegalArgumentException("Invalid date");
        }
    }

    public boolean isValidDate(int day, int month, int year) {
        try {
            LocalDate.of(year, month, day);
            return true;
        } catch (DateTimeException e) {
            return false;
        }
    }

    public void updateDate(int day, int month, int year) {
        if (isValidDate(day, month, year)) {
            this.day = day;
            this.month = month;
            this.year = year;
        } else {
            throw new IllegalArgumentException("Invalid date");
        }
    }

    public String getDayOfWeek() {
        LocalDate date = LocalDate.of(year, month, day);
        return date.getDayOfWeek().toString();
    }

    public long calculateDifference(Date otherDate) {
        LocalDate date1 = LocalDate.of(this.year, this.month, this.day);
        LocalDate date2 = LocalDate.of(otherDate.year, otherDate.month, otherDate.day);
        return Math.abs(ChronoUnit.DAYS.between(date1, date2));
    }

    public void printDate() {
        LocalDate date = LocalDate.of(year, month, day);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d, yyyy", Locale.ENGLISH);
        System.out.println(date.format(formatter));
    }

    @Override
    public int compareTo(Date other) {
        return Comparator.comparingInt((Date d) -> d.year)
                .thenComparingInt(d -> d.month)
                .thenComparingInt(d -> d.day)
                .compare(this, other);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("Выберите действие:");
            System.out.println("1. Проверить день недели");
            System.out.println("2. Рассчитать разницу между датами");
            System.out.println("3. Вывести дату");
            System.out.println("4. Обновить дату");
            System.out.println("5. Выйти");
            int choice = input.nextInt();

            if (choice == 5) break;

            System.out.print("Введите дату (день, месяц, год): ");
            int day = input.nextInt();
            int month = input.nextInt();
            int year = input.nextInt();
            Date date = new Date(day, month, year);

            switch (choice) {
                case 1:
                    System.out.println("День недели: " + date.getDayOfWeek());
                    break;
                case 2:
                    System.out.print("Введите вторую дату (день, месяц, год): ");
                    int day2 = input.nextInt();
                    int month2 = input.nextInt();
                    int year2 = input.nextInt();
                    Date date2 = new Date(day2, month2, year2);
                    System.out.println("Разница между датами: " + date.calculateDifference(date2) + " дней");
                    break;
                case 3:
                    date.printDate();
                    break;
                case 4:
                    System.out.print("Введите новую дату (день, месяц, год): ");
                    int newDay = input.nextInt();
                    int newMonth = input.nextInt();
                    int newYear = input.nextInt();
                    date.updateDate(newDay, newMonth, newYear);
                    System.out.println("Дата обновлена.");
                    break;
                default:
                    System.out.println("Неверный выбор.");
            }
        }
        input.close();
    }
}

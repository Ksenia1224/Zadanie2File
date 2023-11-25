import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        File file = new File("C:\\Мои работы Java\\File11.2\\students.txt");

        int stud = 0;
        int ocenka = 0;

        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // Разбиение строки на части
                String[] parts = line.split(" ");

                if (parts.length == 3) {
                    // Получение оценки и преобразование ее в целое число
                    int grade = Integer.parseInt(parts[2]);

                    stud += grade;
                    ocenka ++;
                    if (grade < 3) {
                        System.out.println(line);
                    }
                }
            }
            if (ocenka > 0) {
                double bal = stud / ocenka;
                System.out.printf("Средний балл по классу: %.2f\n", bal);
            } else {
                System.out.println("В классе нет учеников.");
            }
        } catch (FileNotFoundException e) {
            System.err.println("Файл не найден: " + e.getMessage());
        }
    }
}

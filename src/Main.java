import java.util.Scanner;

// Интерфейс для документов
interface Document {
    void open();
}

// Класс для отчетов
class Report implements Document {
    @Override
    public void open() {
        System.out.println("Открытие отчета.");
    }
}

// Класс для резюме
class Resume implements Document {
    @Override
    public void open() {
        System.out.println("Открытие резюме.");
    }
}

// Класс для писем
class Letter implements Document {
    @Override
    public void open() {
        System.out.println("Открытие письма.");
    }
}

// Класс для счетов
class Invoice implements Document {
    @Override
    public void open() {
        System.out.println("Открытие счета.");
    }
}

// Абстрактный класс создателя документа
abstract class DocumentCreator {
    public abstract Document createDocument();
}

// Создатель для отчетов
class ReportCreator extends DocumentCreator {
    @Override
    public Document createDocument() {
        return new Report();
    }
}

// Создатель для резюме
class ResumeCreator extends DocumentCreator {
    @Override
    public Document createDocument() {
        return new Resume();
    }
}

// Создатель для писем
class LetterCreator extends DocumentCreator {
    @Override
    public Document createDocument() {
        return new Letter();
    }
}

// Создатель для счетов
class InvoiceCreator extends DocumentCreator {
    @Override
    public Document createDocument() {
        return new Invoice();
    }
}

// Главный класс
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите тип документа: 1 - Отчет, 2 - Резюме, 3 - Письмо, 4 - Счет");
        int choice = scanner.nextInt();
        DocumentCreator creator = null;

        switch (choice) {
            case 1:
                creator = new ReportCreator();
                break;
            case 2:
                creator = new ResumeCreator();
                break;
            case 3:
                creator = new LetterCreator();
                break;
            case 4:
                creator = new InvoiceCreator();
                break;
            default:
                System.out.println("Неверный выбор.");
                return; // Завершаем программу, если выбор неверный
        }

        // Создаем документ и открываем его
        Document document = creator.createDocument();
        document.open();
    }
}

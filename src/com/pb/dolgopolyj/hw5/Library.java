package com.pb.dolgopolyj.hw5;

/**
 * Класс, демонстрирующий работу классов Book и Reader
 */
public class Library {

    //Описываем метод, выводящий сообщение о попытке ввода некорректного значения
    static void printError() {
        System.out.println("Вы пытаетесь ввести некорректные данные");
    }

    public static void main(String[] args) {



        //Выводим на экран приветствие программы и выполняемые ей действия
        System.out.println("*** Добрый день! ***\nЭто класс 'Library'");
        System.out.println("Он демонстрирует работу классов Book и Reader");

        //Инициируем переменную для определения количества книг в библиотеке
        int numberOffBooks=5;
        //Инициализируем массив книг в библиотеке, то есть ссылок на объекты класса Book
        Book [] book = new Book[numberOffBooks];
        //Теперь инициализируем непосредственно сами "книги", то есть отдельные объекты класса Book
        for (int i=0;i<numberOffBooks;i++) book[i]= new Book();
        //Заполняем данные о книгах в билиотеке
        book[0].setBookName("Знакомьтесь: JAVA");
        book[0].setAuthorName("Аккуратов Е.Е.");
        book[0].setYearPublish(2009);
        book[1].setBookName("Блицкриг 1941");
        book[1].setAuthorName("Исаев А.В.");
        book[1].setYearPublish(2001);
        book[2].setBookName("Приключения");
        book[2].setAuthorName("Иванов И.И.");
        book[2].setYearPublish(2000);
        book[3].setBookName("Словарь");
        book[3].setAuthorName("Сидоров А.В.");
        book[3].setYearPublish(1980);
        book[4].setBookName("Энциклопедия");
        book[4].setAuthorName("Гусев К.В.");
        book[4].setYearPublish(2010);

        //Инициируем переменную для определения количества читателей в библиотеке
        int numberOffReaders=4;
        //Инициализируем массив читателей в библиотеке, то есть ссылок на объекты класса Reader
        Reader [] reader = new Reader [numberOffBooks];
        //Теперь инициализируем массив данных непосредственных читателей, то есть отдельных объектов класса Reader
        for (int i=0;i<numberOffReaders;i++) reader[i]= new Reader();
        //Заполняем данные о читателях, обслуживаемых в билиотеке
        reader[0].setUserName("Петров Игорь Николаевич");
        reader[0].setBirthDate("08/09/1978");
        reader[0].setFacultyName("Механический");
        reader[0].setTelephonNumber("+380508819413");
        reader[1].setUserName("Козаченко Станислав Владимирович");
        reader[1].setBirthDate("03/12/2000");
        reader[1].setFacultyName("Исторический");
        reader[1].setTelephonNumber("+380998815414");
        reader[2].setUserName("Усов Кирилл Станиславович");
        reader[2].setBirthDate("05/02/2002");
        reader[2].setFacultyName("Автоматизации");
        reader[2].setTelephonNumber("+380936415525");
        reader[3].setUserName("Назарова Елена Викторовна");
        reader[3].setBirthDate("13/06/2002");
        reader[3].setFacultyName("Экономики и финансов");
        reader[3].setTelephonNumber("+380993336217");

        //Демонстрируем возможности класса Library
        //Выводим на экран имеющиеся в библиотеке книги
        System.out.println("\nВ билиотеке для читателей доступны книги:");
        for (int i=0;i<numberOffBooks;i++) {
            System.out.println("\"" + book[i].getBookName() + "\", автор:" + book[i].getAuthorName() + ", " + book[i].getYearPublish()+"г.");
        }

        //Выводим на экран сведения о читателях
        System.out.println("\nВ нашей библиотеке обслуживаются следующие читатели:");
        for (int i=0;i<Reader.getReadersNumber();i++) {
            System.out.println(reader[i].getUserName()+", д.р."+reader[i].getBirthDate()+", факультет:"+reader[i].getFacultyName()+", ч.б.№"+reader[i].getTicketNumber()+", телефон:"+reader[i].getTelephonNumber());
        }

        //Примеры использования методов класса Reader
        Reader.takeBook(reader[0].getUserName(),3);
        Reader.takeBook(reader[2].getUserName(),5);
        String [] bookNames=new String[2];
        bookNames[0]="Огненное сияние";
        bookNames[1]="Война и мир";
        Reader.takeBook(reader[3].getUserName(), bookNames);
        Reader.takeBook(reader[1].getUserName(), book);

        //Демонстрация работы перегруженных методов returnBook
        Reader.returnBook(reader[1].getUserName(),2);
        String [] bookNames2=new String[3];
        bookNames2[0]="Мертвые души";
        bookNames2[1]="Му-Му";
        bookNames2[2]="Остров сокровищ";
        Reader.returnBook(reader[2].getUserName(), bookNames2);
        //Для проверки метода returnBook (String readerName, Book [] book)
        //создадим ещё один массив объектов класса Book
        Book [] book2 = new Book[3];
        for (int i=0;i<3;i++) book2[i]= new Book();
        book2[0].setBookName("Письма с фронта");
        book2[0].setAuthorName("Улюкаев С.В.");
        book2[0].setYearPublish(2015);
        book2[1].setBookName("Когда внезапности уже не было");
        book2[1].setAuthorName("Исаев А.В.");
        book2[1].setYearPublish(2002);
        book2[2].setBookName("Необычная история");
        book2[2].setAuthorName("Петров В.В.");
        book2[2].setYearPublish(2005);
        Reader.returnBook(reader[0].getUserName(), book2);

        //Благодарности :)
        System.out.println("\n*** Cпасибо за использование класса 'Library'! ***");
    }
}

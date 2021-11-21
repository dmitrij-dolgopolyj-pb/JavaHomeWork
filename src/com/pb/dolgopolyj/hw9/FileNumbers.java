package com.pb.dolgopolyj.hw9;

//Импортируем классы для работы с файлами
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;

/**
 * Класс FileNumbers, который демонстрирует работу с файлами.
 */
public class FileNumbers
{
    public static void main(String[] args)
    {
    //Выводим на экран приветствие программы и выполняемые ей действия
    System.out.println("*** Добрый день! ***\nВас приветствует класс 'FileNumbers'!!!");
    System.out.println("Он продемонстрирует работу с файлами.");

        //Объявляем строковую переменную, которая будет помогать нам записывать данные
        String str;
        //Объявляем переменные для работы с циклами
        int i,k;
        //Объявляем массив для работы с данными файла 1
        int [] array = new int[10];
        //Объявляем переменную, которая будет помогать генерировать случайное число
        Random random=new Random();

        //Для работы с файлами мы будем использовать класс BufferedWriter
        // Рабочие файлы программы будем хранить в папке нашего домашнего задания
        Path path = Paths.get("out\\production\\JavaHomeWork\\com\\pb\\dolgopolyj\\hw9\\numbers.txt");
        //Записываем первый файл
        try (BufferedWriter writer = Files.newBufferedWriter(path))
        {
            for (k=0;k<10;k++)
            {
                str = "";
                for (i = 0; i < 10; i++) {
                    //Генерируем случайное число от 1 до 99
                    array[i] = random.nextInt(99) + 1;
                    str = str + Integer.toString(array[i]) + " ";
                }
                //Записываем полученную строку и переходим на следующую
                writer.write(str);
                writer.newLine();
            }
        }
        catch (Exception ex)
        {
            System.out.println("Ошибка записи файла №1: " + ex);
        }
        System.out.println("Запись в файл №1 \"" + path.toAbsolutePath() + "\" прошла успешно!\n");

        //Объявляем массив для работы с данными файла 2
        int [][] array2 = new int[10][10];
        //Ещё один строковый массив будем использовать для работы с разделением полученных строк из файла
        String[] strParts;
        //Загружаем полученный файл с помощью класса BufferedReader
        System.out.println("Проводим чтение файла №1: \"" + path.toAbsolutePath() + "\":");
        try (BufferedReader reader = Files.newBufferedReader(path))
        {
            System.out.println("--------------Содержимое файла №1--------------------");
            k=0;
            while((str = reader.readLine()) != null)
            {
                //Преобразуем полученную строку в строковый массив отдельных чисел, с помощью регулярного выражения (RegEx)
                //в качестве разделителя слов принимаем пробелы
                strParts=str.split(" ");
                for (i=0;i<strParts.length;i++)
                {
                    //Преобразуем "cтроковые" числа из полученной строки в элементы массива array2, формата int
                    array2[i][k]=Integer.valueOf(strParts[i]);
                    System.out.print(array2[i][k] + " ");
                }
                k++;
                System.out.print("\n");
            }
            System.out.println("----------------------------------");

        }
        catch (Exception ex)
        {
            System.out.println("Ошибка чтения файла №1: " + ex);
        }
        System.out.println("Файл №1 прочитан успешно!\n");

        System.out.println("----------Данные для файла №2------------------------");
        //Осуществляем проверку полученного массива на четные числа и заменим их на "0"
        for (k=0;k<10;k++)
        {
            for (i = 0; i < 10; i++)
            {
                if (array2[i][k]%2==0) array2[i][k]=0;
                System.out.print(array2[i][k] + " ");
            }
            System.out.print("\n");
        }
        System.out.println("----------------------------------\n");

        //Записываем второй файл
        path = Paths.get("out\\production\\JavaHomeWork\\com\\pb\\dolgopolyj\\hw9\\odd-numbers.txt");
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            for (k=0;k<10;k++)
            {
                str = "";
                for (i = 0; i < 10; i++)
                {
                    str = str + Integer.toString(array2[i][k]) + " ";
                }
                writer.write(str);
                writer.newLine();
            }
        }
        catch (Exception ex)
        {
            System.out.println("Ошибка записи файла №2: " + ex);
        }
        System.out.println("Запись в файл №2 \"" + path.toAbsolutePath() + "\" прошла успешно!\n");

        //Благодарности :)
     System.out.println("\n*** Cпасибо за использование класса 'FileNumbers'!!! ***");
    }
}

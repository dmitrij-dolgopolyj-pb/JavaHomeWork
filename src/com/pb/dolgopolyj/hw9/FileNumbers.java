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
        //Объявляем массив для работы с данными
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
                writer.write(str);
                writer.newLine();
            }
        }
        catch (Exception ex)
        {
            System.out.println("Ошибка записи файла №1: " + ex);
        }

        System.out.println("Запись в файл №1 \"" + path.toAbsolutePath() + "\" прошла успешно!");

        System.out.println("Read text from file \"" + path.toAbsolutePath() + "\":");
        try (BufferedReader reader = Files.newBufferedReader(path)) {

            System.out.println("----------------------------------");
            String line;
            while((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            System.out.println("----------------------------------");

        } catch (Exception ex) {
            System.out.println("Error with file read: " + ex);
        }
        System.out.println("Read from file done!");





        //Записываем второй файл
        path = Paths.get("out\\production\\JavaHomeWork\\com\\pb\\dolgopolyj\\hw9\\odd-numbers.txt");
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            for (k=0;k<10;k++)
            {
                str = "";
                for (i = 0; i < 10; i++) {
                    //Генерируем случайное число от 1 до 99
                    array[i] = random.nextInt(99) + 1;
                    str = str + Integer.toString(array[i]) + "-";
                }
                writer.write(str);
                writer.newLine();
            }
        } catch (Exception ex) {
            System.out.println("Ошибка записи файла №2: " + ex);
        }

        System.out.println("Запись в файл №2 \"" + path.toAbsolutePath() + "\" прошла успешно!");


        //Благодарности :)
     System.out.println("\n*** Cпасибо за использование класса 'FileNumbers'!!! ***");
    }
}

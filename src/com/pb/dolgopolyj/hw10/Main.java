package com.pb.dolgopolyj.hw10;

/**
 * Класс Main, который демонстрирует работу с обобщенным классом NumBox.
 */
public class Main
{
    public static void main(String[] args)
    {
        //Выводим на экран приветствие программы и выполняемые ей действия
        System.out.println("*** Добрый день! ***\nВас приветствует класс 'Main'!!!");
        System.out.println("Он продемонстрирует работу с обобщенным классом NumBox.");
        System.out.println("Параметром класса может быть любой класс-наследник Number.");
        System.out.println("Мы будем тестировать его на примере примере NumBox<Float> и NumBox<Integer>.\n");

        //Инициализируем переменную, отвечающую за размерность нашего массива
        int arrayDepth=3;
        NumBox myNumBox= new NumBox (arrayDepth);
        Number myNumber=3;
        Integer myNumber2=4;
        Float myNumber3=4.358F;
        //Наполняем массив значениями
        try
        {
            myNumBox.add(myNumber);
            myNumBox.add(myNumber2);
            myNumBox.add(myNumber3);
        }
        //Если мы попытались выйти при наполнении массива за его границы, ловим соответствующее исключение
        catch (WrongNumberArrayElements e)
        {
            System.out.println("Вы не можете наполнить массив этим элементом," +
                    " общая размерность массива "+arrayDepth+" элемента(ов)!");
        }





        System.out.println("\n*** Cпасибо за использование классов 'Main' и 'NumBox'***");
    }
}

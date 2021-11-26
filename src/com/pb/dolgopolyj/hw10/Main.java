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
        System.out.println("Мы будем тестировать его на примерах классов NumBox<Float> и NumBox<Integer>.\n");

        System.out.println("Сначала тестируем произвольный класс myNumBox:");
        //Инициализируем переменную, отвечающую за размерность нашего массива
        int arrayDepth=3;
        NumBox myNumBox= new NumBox (arrayDepth);
        Long myNumber1=23474L;
        Integer myNumber2=48798;
        Float myNumber3=6874.358F;
        Integer myNumber4=5;
        //Наполняем массив значениями
        try
        {
            myNumBox.add(myNumber1);
            myNumBox.add(myNumber2);
            myNumBox.add(myNumber3);

            //Демонстрация вызова исключения переполнения массива
            myNumBox.add(myNumber4);
        }
        //Если мы попытались выйти при наполнении массива за его границы, ловим соответствующее исключение
        catch (WrongNumberArrayElements e)
        {
            System.out.println("Вы не можете наполнить массив этим элементом," +
                    " общая размерность массива "+arrayDepth+" элемента(ов)!");
        }
        //Выводим необходимую информацию о классе
        myNumBox.arrayInfo();

        //Теперь выполним задание с тестированием массива NumBox<Float>
        System.out.println("\nТеперь тестируем класс NumBox<Float>:");
        arrayDepth=5;
        NumBox floatNumBox= new NumBox (arrayDepth);
        Float number1=3474.13F;
        Float number2=45.2133F;
        Float number3=523.65F;
        Float number4=871.355566663F;
        Float number5=74.1F;

        //Наполняем массив значениями
        try
        {
            floatNumBox.add(number1);
            floatNumBox.add(number2);
            floatNumBox.add(number3);
            floatNumBox.add(number4);
            floatNumBox.add(number5);
            //Следующая строка тестирует работу исключения
            floatNumBox.add(number5);
        }
        //Если мы попытались выйти при наполнении массива за его границы, ловим соответствующее исключение
        catch (WrongNumberArrayElements e)
        {
            System.out.println("Вы не можете наполнить массив этим элементом," +
                    " общая размерность массива "+arrayDepth+" элемента(ов)!");
        }
        //Выводим необходимую информацию о классе
        floatNumBox.arrayInfo();

        //Теперь выполним задание с тестированием массива NumBox<Integer>
        System.out.println("\nТеперь тестируем класс NumBox<Integer>:");
        arrayDepth=6;
        NumBox intNumBox= new NumBox (arrayDepth);
        Integer inumber1=75;
        Integer inumber2=550;
        Integer inumber3=2;
        Integer inumber4=6780;
        Integer inumber5=8990;
        Integer inumber6=470550;

        //Наполняем массив значениями
        try
        {
            intNumBox.add(inumber1);
            intNumBox.add(inumber2);
            intNumBox.add(inumber3);
            intNumBox.add(inumber4);
            intNumBox.add(inumber5);
            intNumBox.add(inumber6);
            //Следующая строка тестирует работу исключения
            intNumBox.add(inumber6);
        }
        //Если мы попытались выйти при наполнении массива за его границы, ловим соответствующее исключение
        catch (WrongNumberArrayElements e)
        {
            System.out.println("Вы не можете наполнить массив этим элементом," +
                    " общая размерность массива "+arrayDepth+" элемента(ов)!");
        }
        //Выводим необходимую информацию о классе
        intNumBox.arrayInfo();

        System.out.println("\n*** Cпасибо за использование классов 'Main' и 'NumBox'***");
    }
}

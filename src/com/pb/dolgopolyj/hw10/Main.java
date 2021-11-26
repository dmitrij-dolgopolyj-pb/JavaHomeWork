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
        Long myNumber1=23474L;
        Integer myNumber2=48798;
        Float myNumber3=6874.358F;
        Integer myNumber4=5;
        //Наполняем массив значениями
        try
        {
            myNumBox.add(myNumber1);
            System.out.println("Теперь количество элементов в нашем массиве равно:"+myNumBox.length()+"шт.");
            myNumBox.add(myNumber2);
            System.out.println("Теперь количество элементов в нашем массиве равно:"+myNumBox.length()+"шт.");
            myNumBox.add(myNumber3);
            System.out.println("Теперь количество элементов в нашем массиве равно:"+myNumBox.length()+"шт.");

            //Демонстрация вызова исключения переполнения массива
            myNumBox.add(myNumber3);
        }
        //Если мы попытались выйти при наполнении массива за его границы, ловим соответствующее исключение
        catch (WrongNumberArrayElements e)
        {
            System.out.println("Вы не можете наполнить массив этим элементом," +
                    " общая размерность массива "+arrayDepth+" элемента(ов)!");
        }
        System.out.println("В нашем массиве находятся следующие элементы:");
        for (int i=0; i<arrayDepth;i++)
        {
           System.out.println("myNumBox["+i+"]="+myNumBox.get(i));
        }
        System.out.println("Cумма всех элементов нашего массива равна:"+myNumBox.sum());
        System.out.println("Cреднее арифметическое нашего массива равно:"+myNumBox.average());
        System.out.println("Максимальный элемент нашего массива это:"+myNumBox.max());



        System.out.println("\n*** Cпасибо за использование классов 'Main' и 'NumBox'***");
    }
}

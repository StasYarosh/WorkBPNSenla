package com.senla;

import java.io.PrintStream;
import java.util.function.Consumer;

/**
 * Пример использования фикционального интерфейса Consumer (Потребитель)
 * public interface Consumer<T>
 */
public class Example2Consumer {

    /**
     * Метод у этого интерфейса следующий :     void accept(T t);
     * т.е. он принимает объект и ничего не возвращает
     */
    public static void main(String[] args) {
        Consumer<Integer> consumer;

        //пускай наш consumer будет принимать Integer и выводить его в консоль
        //1) пример с реализацией интерфейса
        consumer = new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer);
            }
        };
        consumer.accept(1);

        //2) лямбда
        consumer = (Integer integer) -> {
            System.out.println(integer);
        };
        consumer.accept(2);

        //3) лямбда без типов параметров
        consumer = (integer) -> {
            System.out.println(integer);
        };
        consumer.accept(3);


        //4) лямбда без типов параметров и скобок вокруг единственного параметра
        consumer = integer -> {
            System.out.println(integer);
        };
        consumer.accept(4);


        //5) лямбда без тела, в одну строку
        consumer = (integer) -> System.out.println(integer);
        consumer.accept(5);

        //6) а сейчас внимание, у нас есть объект System.out - это PrintStream
        PrintStream outStream = System.out;
        //мы можем передать ссылку на метод именно этого объекта как реализацию функционального интерфейса
        consumer = outStream::println; //метод println принимает Object и возвращает void (т.е. ничего), он нам подходит, так как Integer - наследует Object
        consumer.accept(6);

        //7)  теперь без промежуточных вычислений, а сразу ссылка на метод System.out.println
        consumer = System.out::println;//это значит, что когда будет вызван метод, его выполнение перейдёт к методу println объекта System.out

        consumer.accept(7);
    }
}

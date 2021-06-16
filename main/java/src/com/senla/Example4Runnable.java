package com.senla;

/**
 * Пример использования фикционального интерфейса Consumer (Потребитель)
 * public interface Runnable
 */
public class Example4Runnable {

    /**
     * Метод интерфейса : void run()
     */
    public static void main(String[] args) {

        Runnable runnable;

        //1) реализуем интерфейс
        runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("1");
            }
        };
        runnable.run();

        //2) лямбда
        runnable = () -> {
            System.out.println("2");
        };
        runnable.run();

        //3) лямбда в 1 строку
        runnable = () -> System.out.println("3");
        runnable.run();

        //интерфейс нужен просто чтобы выполнить какое-то действие (напоминаю метод void run() , ничего не принимает и не возвращает)
    }
}

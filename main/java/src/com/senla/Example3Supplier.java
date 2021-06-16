package com.senla;

import java.util.function.Supplier;

/**
 * Пример использования фикционального интерфейса Supplier (Поставщик)
 * public interface Supplier<T>
 */
public class Example3Supplier {

    /**
     * Его не реализованный метод -     T get();
     */
    public static void main(String[] args) {
        Supplier<Integer> supplier;

        //1) реализуем интерфейс
        supplier = new Supplier<Integer>() {
            @Override
            public Integer get() {
                return 1;
            }
        };

        System.out.println(supplier.get());

        //2) лямбда без параметров, поэтому используем пустые скобки
        supplier = () -> {
            return 1;
        };

        System.out.println(supplier.get());

        //3) лямбда в 1 строку
        supplier = () -> 1;

        System.out.println(supplier.get());
    }
}

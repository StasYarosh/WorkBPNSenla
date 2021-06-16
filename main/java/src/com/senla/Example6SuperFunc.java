package com.senla;

/**
 * Пишем свой функциональный интерфейс который вернет Integer, а принимает Integer Integer boolean
 */
public class Example6SuperFunc {

    /**
     * Просто интерфейс с 1 нереализованным методом является функциональным интерфейсом
     */
    interface SuperFunc {
        Integer execute(Integer first, Integer second, boolean multiplyOn10);
    }

    public static void main(String[] args) {
        //просто складывает 1 и 2 элементы, и потом если 3 параметр true выводи их умноженными на 10, а если false
        // * умноженными на 100 и возвращает
        SuperFunc func = (first, second, multiplyOn10) -> {
            Integer result = first + second;
            if (multiplyOn10) {
                result *=10;
            } else {
                result *=100;
            }
            return result;
        };
        System.out.println(func.execute(10, 11, true)); //21 * 10 = 210
        System.out.println(func.execute(15, 10, false));// 25 * 100 = 2500

        //эквивалентная запись в 1 строку
        func = (first, second, multiplyOn10) -> multiplyOn10 ? (first + second) * 10 : (first + second) * 100;
        System.out.println(func.execute(10, 11, true)); //21 * 10 = 210
        System.out.println(func.execute(15, 10, false));// 25 * 100 = 2500
    }
}

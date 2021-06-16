package com.senla;

/**
 * Пишем свой функциональный интерфейс который ничего не возвращает, а принимает Integer Integer boolean
 */
public class Example5SuperFuncVoid {

    /**
     * Просто интерфейс с 1 нереализованным методом является функциональным интерфейсом
     */
    interface SuperFunc {
        void execute(Integer first, Integer second, boolean multiplyOn10);
    }

    public static void main(String[] args) {
        //просто складывает 1 и 2 элементы, и потом если 3 параметр true выводи их умноженными на 10, а если false
        // * умноженными на 100 и выводит в консоль
        SuperFunc func = (first, second, multiplyOn10) -> {
            Integer result = first + second;
            if (multiplyOn10) {
                result *=10;
            } else {
                result *=100;
            }
            System.out.println(result);
        };
        func.execute(10, 11, true);  //21 * 10 = 210
        func.execute(15, 10, false); // 25 * 100 = 2500

        //эквивалентная запись в 1 строку
        func = (first, second, multiplyOn10) -> System.out.println(multiplyOn10 ? (first + second) * 10 : (first + second) * 100);
        func.execute(10, 11, true);  //21 * 10 = 210
        func.execute(15, 10, false); // 25 * 100 = 2500
    }
}

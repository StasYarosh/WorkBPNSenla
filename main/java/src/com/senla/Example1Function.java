package com.senla;

import java.util.function.Function;

/**
 * Функциональные интерфейсы, которые можно описать с помощью лямбды - это интерфейсы у которых не описан 1 метод
 */
public class Example1Function {

    public static void main(String[] args) {
        /*FIXME
           Function<Integer, String> - интерфейс, откройте его исходный код и вы увидите
           что там в объявлении указаны generic-параметры
           public interface Function<T, R>
           у него есть один метод без реализации (не default) он называется apply,
           R apply(T t) - т.е. метод принимает объект типа T и возвращает объект типа R , это generic параметры которые мы определим
           */

        /*Например я хочу чтобы мой метод принимал число, и возвращал его строковое представление*/
        Function<Integer/* принимает Integer */, String /* возвращает String */> function;

        //способы задать значение
        //1) реализовать интерфейс
        function = new Function<Integer, String>() {
            @Override
            public String apply(Integer integer) {
                return integer.toString();
            }
        };

        System.out.println(function.apply(1)); //вызываем функцию apply

        //2) заменить на упрощённый вариант, лямбду, лямбда есть просто реализация метода в виде (A a, B b) -> {return X};
        //   где a и b - параметры метода функционального интерфейса - в нашем случае у нас только 1 параметр Integer integer
        //   и X - возвращаемое значение - строка, полученная путем integer.toString()
        function = (Integer integer) -> {
            return integer.toString();
        };

        System.out.println(function.apply(2));//вызываем функцию apply

        //3) упростить 2 , так как типы данных в параметрах можно не указывать вообще
        function = (integer) -> {
            return integer.toString();
        };

        System.out.println(function.apply(3));//вызываем функцию apply

        //4) упростить 3 , так как скобки для 1 параметра являются необязательным (но если их больше - то обязательно)
        function = integer -> {
            return integer.toString();
        };

        System.out.println(function.apply(4));//вызываем функцию apply

        //5) упростить 4, так как если метод пишется одной строкой будь он void либо возвращающий что-то, можно его записать в 1 строку,
        // и если методо что-то возвращает, то просто подразумевается, что правая часть будет возвращена как результат метода
        function = integer -> integer.toString();

        System.out.println(function.apply(5));//вызываем функцию apply

        //6) можно заменить на ссылку на метод, так как нам нужно вызвать метод класса на объекте, то ссылка будет иметь вид ClassName::methodName
        // т.е. Object::toString , Object - потому что метод имеет в Integer несколько перегрузок и Integer::toString не подходит, а так как он наследник класса Object то всё хорошо
        function = Object::toString;

        System.out.println(function.apply(6));//вызываем функцию apply

        //как видно мы работаем со всеми вариантами как с интерфейсом Function<Integer, String>
    }
}

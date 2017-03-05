/*
6. В методе main:
6.1 Запроси пользователя ввести полный путь архива с клавиатуры. Не забудь, что имя тоже входит в состав полного пути.
6.2 Создай объект класса ZipFileManager, передав в него имя файла архива. Разберись, как из String получить Path.

Подсказка: изучи метод get() класса Paths.

6.3 Запроси пользователя ввести путь к файлу, который будем архивировать. Не путай это с файлом архива, который мы уже ввели.
На этот раз нам нужен файл, который мы будем сжимать, а не в котором хранить сжатые данные.
6.4 Вызови метод createZip у объекта ZipFileManager, передав в него путь для архивации.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.file.Paths;

public class Archiver {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите полный путь до архива");
        String fileName = reader.readLine();
        ZipFileManager zipFileManager = new ZipFileManager(Paths.get(fileName));
        System.out.println("Введите полный путь до файла для архивации");
        zipFileManager.createZip(Paths.get(reader.readLine()));
    }
}

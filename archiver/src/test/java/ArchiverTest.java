import manager.ZipFileManager;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.file.Paths;

public class ArchiverTest {

    /*
    Files directories for testing
    absolute path of archive -- /Users/bogdanpopov/Desktop/Archivator/archive.zip
    absolute path of file for archive -- /Users/bogdanpopov/Desktop/Archivator/file_for_test.txt
    absolute path of file2 for archive -- /Users/bogdanpopov/Desktop/Archivator/second_file_for_test.txt
    absolute path of fodler for archive -- /Users/bogdanpopov/Desktop/Archivator/folder

     */

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите полный путь до архива");
        String fileName = reader.readLine();
        ZipFileManager zipFileManager = new ZipFileManager(Paths.get(fileName));
        System.out.println("Введите полный путь до файла для архивации");
        zipFileManager.createZip(Paths.get(reader.readLine()));
    }

}
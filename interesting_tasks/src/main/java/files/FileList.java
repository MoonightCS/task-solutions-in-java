package files;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;


public class FileList {
    public static List<String> getFileTree(String root) throws IOException {
        List<String> answer = new ArrayList<>();
        MyFileVisitor myFileVisitor = new MyFileVisitor(answer);
        Files.walkFileTree(Paths.get(root), myFileVisitor);
        return answer;
    }

    public static void main(String[] args) {
        try {
            List<String> answer = getFileTree("/Users/bogdanpopov/Desktop/folder_for_testing");
            for (String str : answer) {
                System.out.println(str);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private static class MyFileVisitor extends SimpleFileVisitor<Path> {

        private final List<String> fileNames;

        public MyFileVisitor(final List<String> fileNames) {
            this.fileNames = fileNames;
        }

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            if (file.toFile().isFile()) {
                fileNames.add(file.toFile().getAbsolutePath());
            }
            return FileVisitResult.CONTINUE;
        }
    }
}

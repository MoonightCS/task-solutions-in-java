package probability;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class Password {

    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 10; i++) {
            ByteArrayOutputStream password = getPassword();
            System.out.println(password.toString());
        }
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        for (int i = 0; i < 2; i++) {
            addLowerCaseLetter(byteArrayOutputStream);
            addRandomNumber(byteArrayOutputStream);
            addUpperCaseLetter(byteArrayOutputStream);
        }
        addLowerCaseLetter(byteArrayOutputStream);
        addUpperCaseLetter(byteArrayOutputStream);

        return byteArrayOutputStream;
    }


    private static void addRandomNumber(ByteArrayOutputStream stream) {
        stream.write(48 + ((int) (Math.random() * 10)));
    }

    private static void addUpperCaseLetter(ByteArrayOutputStream stream) {
        stream.write(97 + ((int) (Math.random() * 26)));
    }

    private static void addLowerCaseLetter(ByteArrayOutputStream stream) {
        stream.write(65 + ((int) (Math.random() * 26)));
    }
}

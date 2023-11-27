import java.util.Scanner;

public class VigenereCipher {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the plaintext: ");
        String plaintext = scanner.nextLine().toUpperCase();

        System.out.print("Enter the keyword: ");
        String keyword = scanner.nextLine().toUpperCase();

        String encryptedText = encrypt(plaintext, keyword);
        System.out.println("Encrypted text: " + encryptedText);

        String decryptedText = decrypt(encryptedText, keyword);
        System.out.println("Decrypted text: " + decryptedText);

        scanner.close();
    }

    public static String encrypt(String plaintext, String keyword) {
        StringBuilder encryptedText = new StringBuilder();
        int keywordLength = keyword.length();

        for (int i = 0; i < plaintext.length(); i++) {
            char plainChar = plaintext.charAt(i);
            char keywordChar = keyword.charAt(i % keywordLength);

            if (Character.isLetter(plainChar)) {
                int shift = keywordChar - 'A';
                char encryptedChar = (char) (((plainChar - 'A' + shift) % 26) + 'A');
                encryptedText.append(encryptedChar);
            } else {
                encryptedText.append(plainChar);
            }
        }

        return encryptedText.toString();
    }

    public static String decrypt(String ciphertext, String keyword) {
        StringBuilder decryptedText = new StringBuilder();
        int keywordLength = keyword.length();

        for (int i = 0; i < ciphertext.length(); i++) {
            char cipherChar = ciphertext.charAt(i);
            char keywordChar = keyword.charAt(i % keywordLength);

            if (Character.isLetter(cipherChar)) {
                int shift = keywordChar - 'A';
                char decryptedChar = (char) (((cipherChar - 'A' - shift + 26) % 26) + 'A');
                decryptedText.append(decryptedChar);
            } else {
                decryptedText.append(cipherChar);
            }
        }

        return decryptedText.toString();
    }
}

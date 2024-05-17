/*
Jack Keane
Professor Shang
CSIT460_01 Computer Security
24 April 2023
Lab 3: Vigenere Cipher
 */
import java.util.Scanner;

public class Keane_VigenereCipher {
    //function that creates the key using the length of the string entered by the user
    static String keyGenerator(int key){
        String availableChars = "abcdefghijklmnopqrstuvwxyz";

        StringBuilder makeKey = new StringBuilder(key);

        for(int i = 0; i < key; i++){
            int keySize = (int)(availableChars.length()*Math.random());

            makeKey.append(availableChars.charAt(keySize));
        }
        return makeKey.toString();
    }
    //function that will be used to encrypt the message
    static String encryptMsg(String message, String key){
        String encryptedText = "";

        for (int i = 0; i < message.length(); i++){
            int e = (message.charAt(i) + key.charAt(i) - 2 *'a') % 26;

            e += 'a';
            encryptedText += (char)(e);
        }
        return encryptedText;
    }
    // function that will be used to decrypt the message
    static String decryptMsg(String cipherText, String key){
        String decryptedText = "";

        for(int i = 0; i < cipherText.length() && i < key.length(); i++){
            int d = (cipherText.charAt(i) - key.charAt(i)+ 26) % 26;

            d += 'a';
            decryptedText += (char)(d);
        }
        return decryptedText;
    }
/*
For the input only use lower case letters with no spaces
Function below will display the output
 */

    public static void main (String args[]){
        //User will enter the message they want to encrypt
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a message to encrypt: ");
        String plaintext = scan.next();

        //A test statement to make sure the message from the keyboard prints
        //System.out.println("The text you entered is: " + plaintext + "\n");

        //key is initialized by the integer value of the length of the string that was entered
        //the result will be displayed as a string
        int key = plaintext.length();
        System.out.println("The key that has been randomly generated is: ");
        String keyString = keyGenerator(key);
        System.out.println(keyString);

        // The message will be encrypted with the encryptMsg function
        // and printed
        System.out.println("Encrypted Text: ");
        String ciphertext = encryptMsg(plaintext, keyString);
        System.out.println(ciphertext);

        // The message will be decrypted with the decryptMsg function
        // and printed in the statement below
        System.out.println("Decrypted Text: ");
        String decryptedText = decryptMsg(ciphertext, keyString);
        System.out.println(decryptedText);
    }
}

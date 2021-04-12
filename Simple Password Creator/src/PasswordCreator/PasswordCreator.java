
package PasswordCreator;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author ilias
 */
public class PasswordCreator {

    public static void main(String[] args) {
        String first_name, last_name, pet_name,  password, passwordfinal, password2, c2;
        char c;
        int lname_length, p_length = 0;
        Random random = new Random();
        int randomInt = random.nextInt(10);
        
        //name
        first_name = JOptionPane.showInputDialog("Please enter your first name");
        first_name = first_name.toLowerCase();// peza onoma
        c = first_name.charAt(0);
        c2 = "_";
        
        //last name
        
        last_name = JOptionPane.showInputDialog("Please enter your last name");
        lname_length = last_name.length();
        last_name = last_name.toLowerCase();//peza epitheto
        if (last_name.length() <= 7) {
            last_name = last_name;

        } else {
            last_name = last_name.substring(0, 8);

        }

        //pet name
        pet_name = JOptionPane.showInputDialog("Please enter your pet name");
        pet_name = pet_name.toLowerCase();

        StringBuilder sb1 = new StringBuilder();
        
        sb1.append(c);
        sb1.append(last_name);
        sb1.append(c2);

        while (sb1.length() <= 10) {
            int Random = (int) (Math.random() * 10);
            if (sb1.length() <= 10) {
                sb1.append(Random);

            } else {
                sb1.append(Random);
            }
        }

        JOptionPane.showMessageDialog(null, sb1);
        
        //1st password
        
        StringBuilder sb2 = new StringBuilder();
        sb2.append(first_name);
        sb2.append(last_name);
        sb2.append(pet_name);
        String passString = sb2.toString();

        password = shuffleString(passString);
        int passwordLength = password.length();
        String letter = password.substring(0, 1);                                                                           //1st letter
        String lastLetter = password.substring((passwordLength - 1), (passwordLength));                                     //last letter  
        passwordfinal = letter.toUpperCase() + password.substring(1, password.length() - 1) + lastLetter.toUpperCase();     //capital
        JOptionPane.showMessageDialog(null, passwordfinal);

        //2nd password
        
        StringBuilder sb3 = new StringBuilder();
        sb3.append(c);
        int Random = (int) (Math.random() * 100);
        sb3.append(Random);
        sb3.append(last_name);
        String pass2String = sb3.toString();
        //replace all letters
        String replaceString = pass2String.replaceAll("a", "@").replaceAll("s", "$").replaceAll("l", "1").replaceAll("o", "0");

        password2 = replaceString;

        JOptionPane.showMessageDialog(null, password2);

    }

    //shuffle letter for  password
    public static String shuffleString(String string) {
        List<String> letters = Arrays.asList(string.split(""));
        Collections.shuffle(letters);
        StringBuilder builder = new StringBuilder();
        for (String letter : letters) {
            builder.append(letter);
        }
        return builder.toString();
    }
}

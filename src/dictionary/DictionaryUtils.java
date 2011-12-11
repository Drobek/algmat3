/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary;

/**
 *
 * @author Drobek
 */
public class DictionaryUtils {
    
    public static int min(int a, int b, int c) {
//        System.out.println("min of a" + a + " b " + b + " c " + c + " is " + Math.min(a, Math.min(b, c))+ "\n");
        return Math.min(a, Math.min(b, c));
    }
}

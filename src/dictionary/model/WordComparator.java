/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary.model;

import java.util.Comparator;

/**
 *
 * @author Drobek
 */
public class WordComparator implements Comparator {

    public int compare(Object t, Object t1) {
        Word word1 = (Word)t;
        Word word2 = (Word)t;
        return word1.getWord().compareTo(word2.getWord());
    }
    
}

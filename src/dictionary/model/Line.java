/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary.model;

import java.util.ArrayList;
import java.util.Iterator;


/**
 *
 * @author Drobek
 */
public class Line {
    ArrayList<Word> words;

    public Line(ArrayList<Word> words) {
        this.words = words;
    }

    public Line(String line) {
        parseLine(line);
    }

    public Line() {
        words = new ArrayList<Word>();
    }

    public ArrayList<Word> getWords() {
        return words;
    }

    public void setWords(ArrayList<Word> words) {
        this.words = words;
    }
    
    public void addWord(String s) {
        words.add(new Word(s));
    }
    
    public final void parseLine(String line) {
        words = new ArrayList<Word>();
        line = line.replaceAll("\\.", "");
        String wordStrings[] = line.split("\\s+");
        for (int i = 0; i < wordStrings.length; i++) {
            String s = wordStrings[i];
            addWord(s);
        }
    }

    @Override
    public String toString() {
        String s = "";
        Iterator<Word> it = words.iterator();
        while (it.hasNext()) {
            Word w = it.next();
            s += w.getWord() + " ";
        }
        return s;
    }
    
    
    
}

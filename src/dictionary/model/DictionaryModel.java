/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

/**
 *
 * @author Drobek
 */
public class DictionaryModel {

    private ArrayList<Word> words;

    public DictionaryModel() {
        words = new ArrayList<Word>();
    }

    public void addWord(String s) {
        words.add(new Word(s));
    }

    public void sortWords() {
        Collections.sort(words, new WordComparator());
    }

    public int longestWordLength() {
        int res = 0;
        Iterator<Word> it = words.iterator();
        while (it.hasNext()) {
            Word w = it.next();
            if (w.length() > res) {
                res = w.length();
            }
        }
        return res;
    }

    public ArrayList<Word> getWords() {
        return words;
    }

    public Word find(String s) {
        Iterator<Word> it = words.iterator();
        while (it.hasNext()) {
            Word w = it.next();
            if (w.getWord().equals(s)) {
                return w;
            }
        }
        return null;
    }

    public ArrayList<Word> fiveClosest(Word word) {
        ArrayList<Integer> dists = new ArrayList<Integer>();
        ArrayList<Word> ret = new ArrayList<Word>();
        Iterator<Word> it = words.iterator();
        while (it.hasNext()) {
            Word w = it.next();
            Integer dist = w.E(word);
            if (ret.size()<5) {
                dists.add(dist);
                ret.add(w);
            } else {
                Integer maxVal = dists.get(0);
                Integer biggestIdx = 0;
                for (int i = 1; i < dists.size(); i++) {
                    if (dists.get(i) > maxVal) {
                        maxVal = dists.get(i);
                        biggestIdx = i;
                    }
                }
                dists.remove(maxVal);
                ret.remove(ret.get(biggestIdx));
                dists.add(dist);
                ret.add(w);
            }
        }
        return ret;
    }

    public void setWords(ArrayList<Word> words) {
        this.words = words;
    }

    public void loadFile(File file) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            String text = null;
            // repeat until all lines is read
            while ((text = reader.readLine()) != null) {
                addWord(text);
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found");
        } catch (IOException e) {
            System.err.println("Error in I/O");
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                System.err.println("Could not close file");
            }
        }
    }
}

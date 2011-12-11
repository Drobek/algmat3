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
import java.util.HashMap;
import java.util.Iterator;

/**
 *
 * @author Drobek
 */
public class TextModel {

    ArrayList<Line> text;

    public TextModel() {
        text = new ArrayList<Line>();
    }

    public ArrayList<Line> getText() {
        return text;
    }

    public void setText(ArrayList<Line> text) {
        this.text = text;
    }

    public void addLine(Line l) {
        text.add(l);
    }

    public void loadFile(File f) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(f));
            String line = null;
            while ((line = reader.readLine()) != null) {
                System.out.println("adding line to text");
                System.out.println(line);
                addLine(new Line(line));
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

    public String findMistakes(DictionaryModel dm) {
        String ret = "";
        Integer lineNum = 0;
        
        Iterator<Line> lineIt = getText().iterator();
        while (lineIt.hasNext()) {
            Line l = lineIt.next();
            lineNum++;
            Integer wordNum = 0;
            Iterator<Word> wordIt = l.getWords().iterator();
            while (wordIt.hasNext()) {
                Word w = wordIt.next();
                wordNum++;
                if (dm.find(w.getWord()) == null) {
                    ret += "řádek " + lineNum + " slovo " + wordNum + " (" + w.getWord() + ") Možnosti:\n";
                    ArrayList<Word> closest = dm.fiveClosest(w);
                    Iterator<Word> closestWords = closest.iterator();
                    while (closestWords.hasNext()) {
                        Word resWord = closestWords.next();
                        if (resWord != null) {
                            ret += " - " + resWord.getWord() + "\n";
                        }
                    }
                }
            }
        }
        return ret;
    }

    @Override
    public String toString() {
        String s = "";
        Iterator<Line> it = text.iterator();
        while (it.hasNext()) {
            Line l = it.next();
//            System.out.println("iterating text");
//            System.out.println(l.toString());
            s += l.toString() + "\n";
//            System.err.println("s: " + s);
        }
//        System.err.println("tm tos:" + s);
        return s;
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary.model;

import dictionary.DictionaryUtils;

/**
 *
 * @author Drobek
 */
public class Word {

    private String word;

    public Word() {
        word = "";
    }

    public Word(String word) {
        this.word = word;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    @Override
    public String toString() {
        return "Word{" + "word=" + word + '}';
    }

    public int length() {
        return word.length();
    }

    public char getFromEnd(int i) {
        return word.charAt(word.length() - i);
    }

    public int diff(Word goal, int i, int j) {
        if (getFromEnd(i) != goal.getFromEnd(j)) {
            return 1;
        }
        return 0;
    }

    public int E(Word goal) {
        int m = length() + 1;
        int n = goal.length() + 1;
        int[][] res = new int[m][n];
        for (int i = 0; i < m; i++) {
            res[i][0] = i;
        }
        for (int i = 0; i < n; i++) {
            res[0][i] = i;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                res[i][j] = DictionaryUtils.min(
                        res[i - 1][j] + 1,
                        res[i][j - 1] + 1,
                        res[i - 1][j - 1] + diff(goal, i, j));
            }
        }
//        String s = "";
//        for (int i = 0; i < res.length; i++) {
//            int[] is = res[i];
//            for (int j = 0; j < is.length; j++) {
//                int k = is[j];
//                s += " " + k;
//            }
//            s += "\n";
//        }
//        System.err.println(s);
        return res[m - 1][n - 1];
    }
}

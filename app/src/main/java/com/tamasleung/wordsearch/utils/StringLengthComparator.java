package com.tamasleung.wordsearch.utils;

import java.util.Comparator;

/**
 * Compares String Lengths and then sorts by Largest to Smallest
 */
public class StringLengthComparator implements Comparator<String> {

    public int compare(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return -1;
        } else if (s1.length() < s2.length()) {
            return 1;
        } else {
            return 0;
        }
    }

}

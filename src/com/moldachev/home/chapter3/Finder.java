package com.moldachev.home.chapter3;

/**
 * Created by sergey on 23.03.2016.
 */
public class Finder {

    public static Integer[] getIndexes(char[][] array, char searchChar) {
        Integer indexes[] = new Integer[array.length];

        for(int i = 0; i < array.length; i++) {
            for(int j = 0; j < array[i].length; j++) {
                if (array[i][j] == searchChar) {
                    indexes[i] = j;
                    break;
                }
            }
        }

        return indexes;
    }
}

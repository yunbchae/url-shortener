package com.smilegate.shortener.utils;

public class Base62Util {

    private final static int BASE = 62;

    private final static char[] base62 = {
            'G', '3', 'c', 'd', 'Z', 'r', 'b', 'I', 'g', '0', 'i', 'l', 'p',
            'm', 'W', '1', 'q', 'u', 'C', 'w', '9', 'Y', 'x', 'D', 'z', 'B',
            'a', 'E', 'F', 'o', 'K', 'H', 'L', '4', 'h', 'M', 'f', '2', 'N',
            'e', 't', 'S', 'P', 'n', '5', 'T', 'k', 'V', 'O', 'R', 'U', '6',
            'A', 'v', 'J', '7', 'y', 'j', 'X', '8', 'Q', 's'
    };

    public static String longTOString(Long index) {
        StringBuilder result = new StringBuilder();

        while(index>0) {
            result.append(base62[(int)(index%BASE)]);
            index /= BASE;
        }

        return result.toString();
    }

}

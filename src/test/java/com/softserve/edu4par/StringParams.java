package com.softserve.edu4par;

import java.util.stream.Stream;

public class StringParams {

    public static Stream<String> blankStrings() {
        return Stream.of(null, "", "  ", "\n\r\t", " ");
    }

}  
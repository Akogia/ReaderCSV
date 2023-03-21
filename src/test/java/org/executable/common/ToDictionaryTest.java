package org.executable.common;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class ToDictionaryTest {
    // Semikolon getrennt

    // = getrennt

    // empty string --> no mapping

    // Key muss vorhanden sein, value kann leer sein, wenn = vorhanden

    // key und value werden durch = gerennt und nicht mehr weiter beachtet
    @InjectMocks
    ToDictionary toDictionary;

    @Test
    void splitString_shouldSplitIntoStringArray(){
        // Arrange
        String input = "a=1;b=2;c=3";

        // Act
        String[] result = toDictionary.splitString(input);

        // Assert
        assertEquals(3, result.length);
    }

    @Test
    void splitKeyValuePair_shouldSplitStringArrayIntoKeyValueList(){
        // Arrange
        String[] input = new String[]{"a=1", "b=2", "c=3"};

        // Act
        List<String[]> result = toDictionary.splitKeyValuePair(input);

        // Assert
        assertEquals(3, result.size());
    }


    @Test
    void mapString_validInputData() {
        // Arrange
        String input = "a=1;b=2;c=3";

        // Act
        Map<String,String> result = toDictionary.mapString(input);

        // Assert
        assertAll(
            ()->assertEquals(3,result.size()),
            ()->assertEquals("1", result.get("a"))
        );
    }

    @Test
    void mapString_shouldThrowExceptionInvalidKey() {
        // Arrange
        String input = "a=1;b=2;c=3;=1";

        // Act and Assert
        assertThrows(RuntimeException.class,()->toDictionary.mapString(input));
    }

    @Test
    void mapString_shouldNotPairEmptyStringPair(){
        // Arrange
        String input = "a=1;;b=2";

        // Act
        Map<String, String> result = toDictionary.mapString(input);

        assertEquals(2, result.size());
    }

    @Test
    void mapString_shouldIsEqualToSymbolInValue(){
        String input = "a==1";

        Map<String,String> result = toDictionary.mapString(input);

        assertAll(
            ()-> assertEquals(1, result.size()),
            ()-> assertEquals("=1", result.get("a"))
        );
    }
}

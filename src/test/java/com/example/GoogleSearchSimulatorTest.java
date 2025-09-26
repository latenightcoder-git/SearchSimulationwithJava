package com.example;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class GoogleSearchSimulatorTest {
    private TreeMap<String, List<String>> testDB;

    @BeforeEach
    void setUp() {
        // Initialize before each test
        testDB = new TreeMap<>();
        testDB.put("Java", Arrays.asList("https://docs.oracle.com", "https://geeksforgeeks.org"));
        testDB.put("Python", Arrays.asList("https://python.org", "https://realpython.com"));
        testDB.put("AI", Arrays.asList("https://openai.com"));
    }

    @Test
    void testAddSearch() {
        testDB.put("C++", Arrays.asList("https://cplusplus.com"));
        assertTrue(testDB.containsKey("C++"), "C++ keyword should be added.");
    }

    @Test
    void testSearchKeywordExists() {
        assertTrue(testDB.containsKey("Java"), "Java keyword should exist.");
        assertEquals(2, testDB.get("Java").size(), "Java should have 2 results.");
    }

    @Test
    void testSearchKeywordNotExists() {
        assertFalse(testDB.containsKey("GoLang"), "GoLang keyword should not exist.");
    }

    @Test
    void testDeleteKeyword() {
        testDB.remove("AI");
        assertFalse(testDB.containsKey("AI"), "AI keyword should be deleted.");
    }

    @Test
    void testSortingByKeyword() {
        List<String> keys = new ArrayList<>(testDB.keySet());
        List<String> expected = Arrays.asList("AI", "Java", "Python");
        assertEquals(expected, keys, "Keywords should be sorted alphabetically.");
    }

    @Test
    void testSortingByNumberOfResults() {
        List<Map.Entry<String, List<String>>> list = new ArrayList<>(testDB.entrySet());
        list.sort((a, b) -> Integer.compare(b.getValue().size(), a.getValue().size()));

        assertEquals("Java", list.get(0).getKey(), "Java should be first (2 results).");
        assertEquals("AI", list.get(2).getKey(), "AI should be last (1 result).");
    }
}

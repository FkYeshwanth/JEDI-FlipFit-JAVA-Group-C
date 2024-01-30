/**
 * Utility class for generating unique IDs.
 */
package com.flipkart.utils;

import java.util.HashSet;

/**
 * Utility class for generating unique IDs.
 */
public class IdGenerator {

    // HashSet to store already allocated IDs
    static HashSet<String> alreadyAlloted = new HashSet<>();

    /**
     * Generates a unique ID based on the given prefix.
     *
     * @param part The prefix for the generated ID.
     * @return A unique ID.
     */
    public static String generateId(String part) {
        String id = part + "_";

        // Generate a unique ID
        while (true) {
            while (id.length() - part.length() < 4) {
                id += (int) Math.ceil((Math.random() + 1) * 10);
            }

            // Check if the generated ID is unique
            if (!alreadyAlloted.contains(id)) break;
        }

        // Add the generated ID to the set of allocated IDs
        alreadyAlloted.add(id);

        return id;
    }
}

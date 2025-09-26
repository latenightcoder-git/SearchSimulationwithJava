package com.example;

import java.util.*;

public class GoogleSearchSimulator {
    // TreeMap to store Search Keyword (Key) and List of URLs (Value)
    private static TreeMap<String, List<String>> searchDB = new TreeMap<>();

    /**
     * Add a new search keyword and its results.
     */
    private static void addSearch(Scanner sc) {
        try {
            System.out.print("Enter search keyword: ");
            String keyword = sc.nextLine().trim();

            if (keyword.isEmpty()) {
                throw new IllegalArgumentException("Keyword cannot be empty!");
            }

            System.out.print("Enter number of results for this keyword: ");
            int n = Integer.parseInt(sc.nextLine());

            List<String> results = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                System.out.print("Enter result URL " + (i + 1) + ": ");
                results.add(sc.nextLine().trim());
            }

            searchDB.put(keyword, results);
            System.out.println("Search results added successfully!\n");

        } catch (NumberFormatException e) {
            System.out.println("Invalid number entered! Please try again.");
        } catch (IllegalArgumentException e) {
            System.out.println("Illegal argument! " + e.getMessage());
        }
    }

    /**
     * Display search results for a given keyword.
     */
    private static void searchKeyword(Scanner sc) {
        System.out.print("Enter keyword to search: ");
        String keyword = sc.nextLine().trim();
        if (searchDB.containsKey(keyword)) {
            System.out.println("Results for '" + keyword + "':");
            searchDB.get(keyword).forEach(url -> System.out.println(" - " + url));
        } else {
            System.out.println("No results found for '" + keyword + "'");
        }
    }

    /**
     * Delete a keyword and its results.
     */
    private static void deleteKeyword(Scanner sc) {
        System.out.print("Enter keyword to delete: ");
        String keyword = sc.nextLine().trim();
        if (searchDB.remove(keyword) != null) {
            System.out.println("Keyword '" + keyword + "' removed successfully!");
        } else {
            System.out.println("Keyword not found.");
        }
    }

    /**
     * Display all keywords and results.
     */
    private static void displayAll() {
        if (searchDB.isEmpty()) {
            System.out.println("No data available.");
            return;
        }
        System.out.println("\nAll Stored Search Data:");
        searchDB.forEach((keyword, results) -> {
            System.out.println("Keyword: " + keyword);
            results.forEach(url -> System.out.println("   - " + url));
        });
    }

    /**
     * Custom sorting options.
     */
    private static void customSorting(Scanner sc) {
        if (searchDB.isEmpty()) {
            System.out.println("No data to sort.");
            return;
        }
        System.out.println("\nChoose sorting option:");
        System.out.println("1. Sort by Keyword (Alphabetical - Default in TreeMap)");
        System.out.println("2. Sort by Number of Results (Descending)");
        String choice = sc.nextLine();
        if (choice.equals("1")) {
            // Already sorted as TreeMap keeps natural order
            displayAll();
        } else if (choice.equals("2")) {
            // Sort by number of results
            List<Map.Entry<String, List<String>>> list =
                    new ArrayList<>(searchDB.entrySet());
            list.sort((a, b) -> Integer.compare(b.getValue().size(), a.getValue().size()));

            System.out.println("\nSorted by Number of Results:");
            list.forEach(entry -> {
                System.out.println("Keyword: " + entry.getKey() +
                        " (Results: " + entry.getValue().size() + ")");
                entry.getValue().forEach(url -> System.out.println("   - " + url));
            });
        } else {
            System.out.println("Invalid choice.");
        }
    }

    /**
     * Main menu-driven method.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String choice;

        do {
            System.out.println("\n===== Google Search Simulation =====");
            System.out.println("1. Add Search Data");
            System.out.println("2. Search Keyword");
            System.out.println("3. Delete Keyword");
            System.out.println("4. Display All");
            System.out.println("5. Custom Sorting");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextLine();

            switch (choice) {
                case "1":
                    addSearch(sc);
                    break;
                case "2":
                    searchKeyword(sc);
                    break;
                case "3":
                    deleteKeyword(sc);
                    break;
                case "4":
                    displayAll();
                    break;
                case "5":
                    customSorting(sc);
                    break;
                case "6":
                    System.out.println("Exiting... Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }

        } while (!choice.equals("6"));

        sc.close();
    }
}

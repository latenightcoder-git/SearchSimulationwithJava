# Google Search Simulator

A simple **Java-based console application** that simulates a Google search experience by storing keywords and their corresponding URLs. Users can **add search data, search for keywords, delete keywords, display all entries, and sort results**. This project is designed for learning **Java collections, TreeMap, lists, and basic menu-driven programs**.

---

## Technologies Used

Java 17 (or higher)
JUnit 5 for testing
TreeMap and ArrayList for data storage

---

## 🛠 Features

- **Add Search Data**: Add a new keyword and its list of URLs.
- **Search Keyword**: Retrieve URLs for a given keyword.
- **Delete Keyword**: Remove a keyword and its search results.
- **Display All**: Show all stored keywords and their results.
- **Custom Sorting**: 
  - Sort by keyword (alphabetical order)  
  - Sort by number of results (descending)

---

## 📂 Project Structure
```plaintext
GoogleSearchSimulator/
├── src/
│ └── com/example/GoogleSearchSimulator.java
├── test/
│ └── GoogleSearchSimulatorTest.java
├── README.md
```

- `GoogleSearchSimulator.java`: Main class with menu-driven search simulator.
- `GoogleSearchSimulatorTest.java`: JUnit 5 test class for unit testing add, search, delete, and sorting functionality.

---

## ⚙️ How to Run

### Using Command Line

1. **Compile the program**
```bash
javac com/example/GoogleSearchSimulator.java
```
2. **Run the Program**
```bash
java com.example.GoogleSearchSimulator
```
3. **Follow the console prompts to add/search/delete/display/sort keywords.**

JUnit 5 tests are provided to ensure correct functionality.
Using Maven
```bash
mvn test
```
__________________________________________________________________________________________________________________________________________________________________________________________________________________________

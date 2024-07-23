[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/CT_tfQiy)
# SE2012-Practical - 02 - Java Basics 


## 1. Create strings
### 1.1. Using String Literals
In Java, you can create a string using string literals. A string literal is a sequence of characters enclosed in double quotes.

```java
String str1 = "Hello, World!";
String str2 = "Java Programming";
String str3 = "Hello, World!"; // str3 points to the same memory location as str1

```
### 1.2. Using the new Keyword
You can also create a string using the new keyword. This way, a new String object is created in the heap memory.

```java
String str4 = new String("Hello, World!");
String str5 = new String("Java Programming");
String str6 = new String("Hello, World!"); // str6 is a new object, different from str1 and str3
```

### 1.3. Using StringBuilder or StringBuffer for String Concatenation

Avoid using the “+” operator repeatedly when concatenating multiple strings. This can create unnecessary string objects, leading to poor performance. Instead, use StringBuilder (or StringBuffer for thread safety) to efficiently concatenate strings.
```java
StringBuilder sb = new StringBuilder(); 
sb.append("Hello"); 
sb.append(" "); 
sb.append("World"); 
String result = sb.toString(); // "Hello World"
```

## 1.4. Prefer StringBuilder over StringBuffer



```java
public class StringBuilderExample { 
    public static void main(String[] args) { 
        StringBuilder stringBuilder = new StringBuilder(); 
          
        stringBuilder.append("Hello"); 
        stringBuilder.append(" "); 
        stringBuilder.append("World"); 
          
        String result = stringBuilder.toString(); 
          
        System.out.println("StringBuilder result: " + result); // Output: StringBuilder result: Hello World 
    } 
} 
```

Use the Enhanced for Loop or StringBuilder for String Iteration: When iterating over characters in a string, use the enhanced for loop or StringBuilder to avoid unnecessary object creation.
```java
String str = "Hello"; 
for (char c : str.toCharArray()) { 
    // Do something with each character 
} 
  
// Alternatively, using StringBuilder 
StringBuilder sb = new StringBuilder(str); 
for (int i = 0; i < sb.length(); i++) { 
    char c = sb.charAt(i); 
    // Do something with each character 
}
```
## 2. String Comparison
### 2.1 Comparing Strings using "=="

The == operator compares the reference (memory address) of the objects, not their content. This means it checks if the two references point to the same object in memory.

```java
String str1 = "Hello, World!";
String str2 = "Hello, World!";
String str3 = new String("Hello, World!");

// Comparing string literals
System.out.println(str1 == str2); // true, because both str1 and str2 refer to the same object in the string pool

// Comparing string literal with a new String object
System.out.println(str1 == str3); // false, because str3 refers to a different object in the heap memory

// Comparing two new String objects
String str4 = new String("Hello, World!");
System.out.println(str3 == str4); // false, because str3 and str4 are different objects
```
### 2.2. Use the equals() Method for String Comparison
When comparing string content, use the equals() method or its variants (equalsIgnoreCase(), startsWith(), endsWith(), etc.) instead of the “==” operator, which compares object references.
```java
String str1 = "Hello"; 
String str2 = "hello"; 
if (str1.equalsIgnoreCase(str2)) { 
    // Strings are equal 
}
```

## 3. Utilize String Formatting

Instead of concatenating values using the “+” operator, use String formatting with placeholders (%s, %d, etc.) to improve readability and maintainability.
```java
String name = "Alice"; 
int age = 30; 
String message = String.format("My name is %s and I'm %d years old.", name, age);
```


## 4. Use StringBuilder or StringBuffer for String Modification

If you need to modify a string frequently, it’s more efficient to use StringBuilder (or StringBuffer for thread safety) instead of creating new string objects each time.
```java
StringBuilder sb = new StringBuilder("Hello World"); 
sb.append("!"); 
sb.insert(5, ","); 
sb.delete(5, 7); 
String result = sb.toString(); // "Hello, World!"
```

## 5. Handle Null and Empty Strings Appropriately
Check for null or empty strings before performing any string manipulation operations. This helps prevent NullPointerExceptions and ensures your code handles such cases gracefully.
```java
String str = "Hello"; 
if (str != null && !str.isEmpty()) { 
    // Perform string manipulation 
}
```
## 6. Remove Leading and Trailing Whitespaces
Use the trim() method to eliminate leading and trailing whitespaces from a string.
```java
String str = "   Hello World   "; 
String trimmedStr = str.trim(); // "Hello World"
```
## 7. Split Strings
Use the split() method to split a string into an array of substrings based on a specified delimiter.
```java
String str = "Java is awesome"; 
String[] parts = str.split(" "); // ["Java", "is", "awesome"]
```
## 8. Convert String to Upper or Lower Case
Use the toUpperCase() or toLowerCase() methods to convert a string to uppercase or lowercase, respectively
```java
String str = "Hello World"; 
String upperCaseStr = str.toUpperCase(); // "HELLO WORLD" 
String lowerCaseStr = str.toLowerCase(); // "hello world"
```
## 9. Check for Substring Existence
Use the contains() method to check if a string contains a specific substring.
```java
String str = "Hello World"; 
if (str.contains("World")) { 
    // Substring exists in the string 
}
```
## 10. Replace Substrings
Use the replace() or replaceAll() methods to replace occurrences of a substring with another string.
```java
String str = "Hello World"; 
String replacedStr = str.replace("World", "Universe"); // "Hello Universe"
```
## 11. Compare Strings
Use the compareTo() method to compare two strings lexicographically.
```java
String str1 = "apple"; 
String str2 = "banana"; 
int result = str1.compareTo(str2); 
if (result < 0) { 
    // str1 is less than str2 
} else if (result > 0) { 
    // str1 is greater than str2 
} else { 
    // str1 is equal to str2 
}
```
## 12. Convert Other Data Types to Strings
Use the valueOf() or toString() methods to convert other data types to strings.
```java
int number = 42; 
String strNumber = String.valueOf(number); // "42" 
  
// Alternatively 
String strNumber = Integer.toString(number); // "42"
```

# Basic String Questions

## Question 1. 
Write a Java program that performs various string manipulation tasks as described below. Ensure that you include comments in your code to explain each step.

### Part 1: String Concatenation

1. Prompt the user to enter their first name, middle name, and last name separately.
2. Concatenate these strings to create a full name in the format: "Last Name, First Name Middle Name".
3. Display the concatenated full name.

### Part 2: String Comparison

4. Prompt the user to enter another full name.
5. Compare this new full name with the previously concatenated full name to check if they are the same (case-insensitive comparison).
6. Display an appropriate message indicating whether the names are the same or different.

### Part 3: String Modification

7. Modify the concatenated full name (Last Name, First Name Middle Name) to replace all occurrences of the letter 'a' with '@' and 'e' with '3'.
8. Convert the entire full name to uppercase.
9. Display the modified full name.

### Part 4: String Splitting

10. Split the concatenated full name into individual components (Last Name, First Name, Middle Name) based on the comma and space.
11. Display each component separately.

### Part 5: String Trimming

12. Prompt the user to enter a string with leading and trailing spaces.
13. Trim the spaces from the string and display the trimmed string.

### Part 6: Additional Manipulations

14. Count the number of vowels (a, e, i, o, u) in the concatenated full name.
15. Display the number of vowels found.


## Practical Questions ( Using Strings and String Manipulation Build the Menu below.)

### Question 1 :

There are ‘n’ number of students in a class. The students are taking 3 subjects each. Mathematics, Chemistry and Physics. You are tasked with creating a small program to let the teacher enter and view the marks of all these students. The program should allow the user to view the average mark a student. The program should allow the user to view the average mark each subject. The program should allow the user to view the Total Mark of a student for all 3 subjects. Create a menu driven program to facilitate the above requirement. The menu should allow the below commands.

 1.	Add student marks: add [studentID]- student ID will be an integer ranging from 1 to n
 2.	Update student mark : update [studentID] [subjectID] [mark] - subject ID will be an integer from 1 to 3
 3.	Get the average for a subject: average_s [studentID]
 4.	Get the average for a student: average [studentID]
 5.	Get the total mark of a student : total [studentID]
    
##### Steps
 - Create a public class named Marks.
 - Create the main method.
 - Create the functionality to take in the user entered commands as a single line using nextLine().
 - use String manipulation to process the user inputs.
 - Average and Totals should be displayed witht the user ID and subject ID is applicable.
     - example :
     - Average 1 shall display "Student <ID> has an Haverage of <Average>.
     - update 1 2 58 shall display "Student 1's marks for subject 2 was updated to 58.

### Question 2 :

Extend the program to display the grades of the student for each subject based on the below criteria.
-	If the score is 90 or above, print "Grade A"
-	If the score is between 80 and 89, print "Grade B"
-	If the score is between 70 and 79, print "Grade C"
-	If the score is between 60 and 69, print "Grade D"
-	If the score is below 60, print "Fail“
The “grades” command should display the grades of all the students in a tabular format as a summary.


### Notes for Students

- Use the Scanner class to read input from the user.
- For string concatenation, you can use the + operator.
- For string comparison, use the `.equalsIgnoreCase()` method.
- For string modification, use the `.replace()` method and `.toUpperCase()` method.
- For string splitting, use the `.split()` method.
- For string trimming, use the `.trim()` method.
- To count vowels, you can iterate over the string and use a conditional statement to check for vowels.

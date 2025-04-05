📄 ReadMe File for the “Date Methods” Project

# Project Description

This project is a console-based Java application that allows users to work with dates through a menu-driven interface. The program supports multiple date operations such as:

Validating dates (including leap years),

Getting the day of the week for a specific date,

Calculating the number of days between two dates,

Displaying the date in a readable format like “January 1, 2023”,

Updating a date,

Sorting support via Comparable<Date>.

The project demonstrates how to use Java's LocalDate, ChronoUnit, and DateTimeFormatter classes effectively.

# How I Came to This Solution

Initially, I thought implementing simple date operations would be easy using just a few if conditions and some manual date logic. However, the deeper I went, the more I realized the importance of using built-in Java tools to handle edge cases, especially leap years and date format parsing.

# First Steps

I started by writing methods to:

Check if a date is valid,

Update date fields,

Retrieve the day of the week.

Using LocalDate was a game-changer — it made handling dates much more reliable than trying to calculate leap years and month lengths manually.

# Building the Logic

After setting up the basic date object structure, I added:

A method to calculate the difference between two Date objects using ChronoUnit.DAYS.between(...),

A method to print the date in the required human-readable format with DateTimeFormatter,

A compareTo() method to support sorting Date objects by year, month, then day.

The real challenge came in building the menu system and maintaining the state of the Date object throughout user interaction.

# Testing and Edge Cases

I tested the program with:

Leap years (e.g., February 29, 2020),

Invalid dates (e.g., April 31),

Sorting multiple Date objects,

Different date format outputs.

Edge cases like invalid input or incorrect date values were caught using try-catch blocks around LocalDate.of(...).

# Errors and Fixes

Some problems I ran into:

Invalid date crashes: Solved by catching DateTimeException.

Incorrect date format output: Fixed using DateTimeFormatter.ofPattern("MMMM d, yyyy").

Menu behavior bugs: Initially, each operation created a new Date object. I changed this by keeping the state persistent for smoother user experience.

Missing locale: The month names printed incorrectly on some systems — fixed by explicitly setting Locale.ENGLISH.

# What I Learned

How to use LocalDate, DateTimeFormatter, and ChronoUnit.

Exception handling for user input validation.

Implementing Comparable<T> for custom sorting.

Creating a clean, interactive console menu.

# Conclusion

This project helped me realize how powerful Java’s date and time API is — and how crucial it is to use built-in libraries instead of trying to manually calculate dates. What looked like a basic task actually had lots of hidden complexity, especially when dealing with real-world calendars. Although it wasn't easy, the end result feels polished and practical.

I'm proud of the progress I made and the lessons I’ve learned from solving real programming problems with clean, reusable code.
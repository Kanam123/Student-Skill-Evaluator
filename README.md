Student Skill Evaluator – Java Console Application 

A Java console-based application to evaluate students’ performance across multiple skill areas.  
The program calculates total marks, average score, grade, and personalized feedback for each student.  
It also supports evaluating multiple students in one session and displays the top performer.  

Features  
- Input student details: Name, ID, and skill marks (Programming, Communication, Problem-Solving, Teamwork, Creativity)  
- Calculate:  
  - ✅ Total marks  
  - ✅ Average score  
  - ✅ Grade (A–F scale)  
- Display:  
  - Student info & individual skill scores  
  - Overall performance with grade  
  - Personalized feedback highlighting weakest skill  
- Support for multiple students in one run  
- Shows Top Performer(s) based on average  

---

 rading Logic  
- 90–100 → Grade A (Excellent)  
- 75–89 → Grade B (Good)  
- 60–74 → Grade C (Average)  
- 40–59 → Grade D (Needs Improvement)  
- Below 40 → Grade F (Fail)  

---

Tools & Concepts Used  
- **Language**: Java (SE 8+)  
- **IDE**: IntelliJ IDEA / Eclipse / BlueJ / VS Code / Replit  
- **Core Concepts**:  
  - Java program structure & syntax  
  - Arrays / ArrayLists for skill storage  
  - Loops & conditional statements for processing  
  - Scanner for user input  
  - String formatting & structured console output  
  - Modular code (methods: `calculateGrade()`, `printReport()`)  

---

Sample Output  

=== Student Skill Evaluator ===

Enter student's name: Khushi
Enter student ID: CSE101
Enter mark for Programming (0-100): 95
Enter mark for Communication (0-100): 88
Enter mark for Problem-Solving (0-100): 92
Enter mark for Teamwork (0-100): 85
Enter mark for Creativity (0-100): 90

Add another student? (y/n): n

=== Report: All Students ===
Student: Khushi (ID: CSE101)
Individual skill scores:
Programming : 95.00
Communication : 88.00
Problem-Solving : 92.00
Teamwork : 85.00
Creativity : 90.00
Total marks: 450.00
Average score: 90.00
Grade: A (Excellent)
Feedback: Outstanding performance! Keep up the excellent work. Weakest area: Teamwork.

Top Performer(s):
Khushi (ID: CSE101) - Average: 90.00, Grade: A (Excellent)

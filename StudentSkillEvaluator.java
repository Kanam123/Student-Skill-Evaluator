import java.util.*;

/**
 * StudentSkillEvaluator.java
 * Console-based student skill evaluator.
 * Collects marks for multiple skills, computes total/average, assigns grade,
 * prints report and top performer.
 */
public class StudentSkillEvaluator {

    static final String[] SKILLS = {
        "Programming", "Communication", "Problem-Solving", "Teamwork", "Creativity"
    };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Student> students = new ArrayList<>();

        System.out.println("=== Student Skill Evaluator ===");

        boolean more = true;
        while (more) {
            System.out.print("\nEnter student's name: ");
            String name = sc.nextLine().trim();

            System.out.print("Enter student ID: ");
            String id = sc.nextLine().trim();

            double[] marks = new double[SKILLS.length];
            for (int i = 0; i < SKILLS.length; i++) {
                marks[i] = readMark(sc, SKILLS[i]);
            }

            Student s = new Student(name, id, marks);
            s.calculate(); // compute total, average, grade, feedback
            students.add(s);

            System.out.print("\nAdd another student? (y/n): ");
            String ans = sc.nextLine().trim().toLowerCase();
            more = ans.equals("y") || ans.equals("yes");
        }

        if (students.isEmpty()) {
            System.out.println("\nNo students entered. Exiting.");
            sc.close();
            return;
        }

        System.out.println("\n\n=== Report: All Students ===");
        for (Student s : students) {
            s.printReport();
            System.out.println("-------------------------------");
        }

        // Display top performer(s)
        List<Student> top = topPerformers(students);
        System.out.println("\nTop Performer(s):");
        for (Student t : top) {
            System.out.printf("%s (ID: %s) - Average: %.2f, Grade: %s%n",
                              t.name, t.id, t.average, t.grade);
        }

        sc.close();
    }

    // Read a valid mark 0-100 with prompt
    private static double readMark(Scanner sc, String skill) {
        double mark = -1;
        while (true) {
            System.out.printf("Enter mark for %s (0-100): ", skill);
            String line = sc.nextLine().trim();
            try {
                mark = Double.parseDouble(line);
                if (mark < 0 || mark > 100) {
                    System.out.println("Please enter a value between 0 and 100.");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Try again.");
            }
        }
        return mark;
    }

    // Find student(s) with highest average
    private static List<Student> topPerformers(List<Student> students) {
        List<Student> list = new ArrayList<>();
        double best = -1;
        for (Student s : students) {
            if (s.average > best) {
                best = s.average;
                list.clear();
                list.add(s);
            } else if (Double.compare(s.average, best) == 0) {
                list.add(s);
            }
        }
        return list;
    }

    // Student inner class
    static class Student {
        String name;
        String id;
        double[] marks;
        double total;
        double average;
        String grade;
        String feedback;

        Student(String name, String id, double[] marks) {
            this.name = name;
            this.id = id;
            this.marks = Arrays.copyOf(marks, marks.length);
        }

        void calculate() {
            total = 0;
            for (double m : marks) total += m;
            average = total / marks.length;
            grade = calculateGrade(average);
            feedback = generateFeedback(average, marks);
        }

        private String calculateGrade(double avg) {
            // Sample grading logic:
            // 90-100 -> A, 75-89 -> B, 60-74 -> C, 40-59 -> D, Below 40 -> F
            if (avg >= 90) return "A (Excellent)";
            if (avg >= 75) return "B (Good)";
            if (avg >= 60) return "C (Average)";
            if (avg >= 40) return "D (Needs Improvement)";
            return "F (Fail)";
        }

        private String generateFeedback(double avg, double[] marks) {
            // Personalized feedback based on average and weakest skill
            int weakestIndex = 0;
            for (int i = 1; i < marks.length; i++) {
                if (marks[i] < marks[weakestIndex]) weakestIndex = i;
            }

            StringBuilder fb = new StringBuilder();
            if (avg >= 90) {
                fb.append("Outstanding performance! Keep up the excellent work.");
            } else if (avg >= 75) {
                fb.append("Good job — you're doing well. Focus on refining your skills.");
            } else if (avg >= 60) {
                fb.append("Decent performance. A bit more practice will improve results.");
            } else if (avg >= 40) {
                fb.append("Needs improvement. Consider extra practice or guidance.");
            } else {
                fb.append("Poor performance. Immediate action and help recommended.");
            }

            fb.append(" Weakest area: ").append(SKILLS[weakestIndex]).append(".");
            return fb.toString();
        }

        void printReport() {
            System.out.printf("Student: %s (ID: %s)%n", name, id);
            System.out.println("Individual skill scores:");
            for (int i = 0; i < marks.length; i++) {
                System.out.printf("  %-15s : %.2f%n", SKILLS[i], marks[i]);
            }
            System.out.printf("Total marks: %.2f%n", total);
            System.out.printf("Average score: %.2f%n", average);
            System.out.printf("Grade: %s%n", grade);
            System.out.printf("Feedback: %s%n", feedback);
        }
    }
}
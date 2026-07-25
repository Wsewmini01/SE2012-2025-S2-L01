import java.util.Scanner;

public class Marks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of students: ");
        int n = scanner.nextInt();

        double[][] marks = new double[n][3];

        System.out.println("Entering the marks for all students");
	for (int i = 0; i < n; i++) {
            System.out.println("Student " + (i + 1) + ":");
	    System.out.print("Mathematics (Subject 1): ");
            marks[i][0] = scanner.nextDouble();
	    System.out.print("Chemistry (Subject 2): ");
            marks[i][1] = scanner.nextDouble();
	    System.out.print("Physics (Subject 3): ");
            marks[i][2] = scanner.nextDouble();
        }

        boolean keepRunning = true;

        while (keepRunning) {
            System.out.println("\n==== MENU ====");
            System.out.println("1. Add / Edit all marks for student");
            System.out.println("2. Update a mark");
            System.out.println("3. Get the average of a subject");
            System.out.println("4. Get the average of a student");
            System.out.println("5. Get the total mark of a student");
            System.out.println("6. Exit");
            System.out.print("Enter choice (1-6): ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Student ID: ");
                    int addId = scanner.nextInt();

                    if (isValidStudent(addId, n)) {
                        System.out.println("Enter new marks for Student " + addId + ":");

                        System.out.print(" Mathematics: ");
                        marks[addId - 1][0] = scanner.nextDouble();

                        System.out.print(" Chemistry: ");
                        marks[addId - 1][1] = scanner.nextDouble();

                        System.out.print(" Physics: ");
                        marks[addId - 1][2] = scanner.nextDouble();

                        System.out.println("Marks updated.");
                    } else {
                        System.out.println("Invalid Student ID.");
                    }
                    break;

                case 2:
                    System.out.print("Enter Student ID: ");
                    int updateId = scanner.nextInt();

                    System.out.print("Enter Subject ID (1=Math, 2=Chem, 3=Phys): ");
                    int subjectId = scanner.nextInt();

                    if (isValidStudent(updateId, n) && isValidSubject(subjectId)) {
                        System.out.print("Enter the new mark: ");
                        marks[updateId - 1][subjectId - 1] = scanner.nextDouble();

                        System.out.println("Mark successfully updated.");
                    } else {
                        System.out.println("Invalid Student or Subject ID.");
                    }
                    break;

                case 3:
                    System.out.print("Enter Subject ID to get average: ");
                    int avgSubjId = scanner.nextInt();

                    if (isValidSubject(avgSubjId)) {
                        double sum = 0;

                        for (int i = 0; i < n; i++) {
                            sum += marks[i][avgSubjId - 1];
                        }

                        System.out.println("Average for Subject " + avgSubjId + ": " + (sum / n));
                    } else {
                        System.out.println("Invalid Subject ID.");
                    }
                    break;

                case 4:
                    System.out.print("Enter Student ID to get average: ");
                    int avgStudId = scanner.nextInt();

                    if (isValidStudent(avgStudId, n)) {
                        double sum = marks[avgStudId - 1][0]
                                + marks[avgStudId - 1][1]
                                + marks[avgStudId - 1][2];

                        System.out.println("Average for Student " + avgStudId + ": " + (sum / 3.0));
                    } else {
                        System.out.println("Invalid Student ID.");
                    }
                    break;

                case 5:
                    System.out.print("Enter Student ID to get total: ");
                    int totalStudId = scanner.nextInt();

                    if (isValidStudent(totalStudId, n)) {
                        double sum = marks[totalStudId - 1][0]
                                + marks[totalStudId - 1][1]
                                + marks[totalStudId - 1][2];

                        System.out.println("Total mark for Student " + totalStudId + ": " + sum);
                    } else {
                        System.out.println("Invalid Student ID.");
                    }
                    break;

                case 6:
                    keepRunning = false;
                    System.out.println("Exiting program!!!");
                    break;

                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 6.");
                    break;
            }
        }

        scanner.close();
    }

    private static boolean isValidStudent(int id, int n) {
        return id >= 1 && id <= n;
    }

    private static boolean isValidSubject(int id) {
        return id >= 1 && id <= 3;
    }
}

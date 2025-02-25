public class CourseMain12 {
    public static void main(String[] args) {
        Course12 course1 = new Course12();
        Course12 course2 = new Course12("CS101", "Data Structures", 3, 4);

        System.out.println("\nDefault Course:");
        course1.print();

        System.out.println("\nParameterized Course:");
        course2.print();

        System.out.println("\nUpdating Course Details:");
        course2.changeCredit(4);
        course2.addHour(2);
        course2.reduceHour(3);
    }
}

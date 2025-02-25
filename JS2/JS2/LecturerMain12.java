public class LecturerMain12 {
    public static void main(String[] args) {
        Lecturer12 lecturer1 = new Lecturer12();
        Lecturer12 lecturer2 = new Lecturer12("L001", "Dr. John Doe", true, 2010, "Computer Science");

        System.out.println("\nDefault Lecturer:");
        lecturer1.print();

        System.out.println("\nParameterized Lecturer:");
        lecturer2.print();

        System.out.println("\nUpdating Lecturer Details:");
        lecturer2.setStatus(false);
        System.out.println("Tenure: " + lecturer2.calculateTenure(2024) + " years");
        lecturer2.changeExpertiseField("Artificial Intelligence");
    }
}

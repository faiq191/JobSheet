class Lecturer12 {
    private String lecturerID;
    private String name;
    private boolean status;
    private int startYear;
    private String expertiseField;

    public Lecturer12() {
        this.lecturerID = "Unknown";
        this.name = "Unknown";
        this.status = false;
        this.startYear = 0;
        this.expertiseField = "Unknown";
    }

    public Lecturer12(String lecturerID, String name, boolean status, int startYear, String expertiseField) {
        this.lecturerID = lecturerID;
        this.name = name;
        this.status = status;
        this.startYear = startYear;
        this.expertiseField = expertiseField;
    }

    public void print() {
        System.out.println("Lecturer ID: " + lecturerID);
        System.out.println("Name: " + name);
        System.out.println("Status: " + (status ? "Active" : "Inactive"));
        System.out.println("Start Year: " + startYear);
        System.out.println("Expertise Field: " + expertiseField);
    }

    public void setStatus(boolean status) {
        this.status = status;
        System.out.println("Status updated to: " + (status ? "Active" : "Inactive"));
    }

    public int calculateTenure(int yearNow) {
        return yearNow - this.startYear;
    }

    public void changeExpertiseField(String newField) {
        this.expertiseField = newField;
        System.out.println("Expertise Field updated to: " + newField);
    }
}
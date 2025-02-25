class Course12 {
    private String courseID;
    private String name;
    private int credit;
    private int hour;

    public Course12() {
        this.courseID = "Unknown";
        this.name = "Unknown";
        this.credit = 0;
        this.hour = 0;
    }

    public Course12(String courseID, String name, int credit, int hour) {
        this.courseID = courseID;
        this.name = name;
        this.credit = credit;
        this.hour = hour;
    }

    public void print() {
        System.out.println("Course ID: " + courseID);
        System.out.println("Name: " + name);
        System.out.println("Credit: " + credit);
        System.out.println("Hour: " + hour);
    }

    public void changeCredit(int newCredit) {
        this.credit = newCredit;
        System.out.println("Credit updated to: " + newCredit);
    }

    public void addHour(int hour) {
        this.hour += hour;
        System.out.println("Hours increased by " + hour + ", total hours: " + this.hour);
    }

    public void reduceHour(int hour) {
        if (this.hour - hour >= 0) {
            this.hour -= hour;
            System.out.println("Hours reduced by " + hour + ", total hours: " + this.hour);
        } else {
            System.out.println("Reduction not possible. Remaining hours: " + this.hour);
        }
    }
}
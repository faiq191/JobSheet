public class ExcuseLetter {
    String id;
    String name;
    String className;
    char typeOfExcuse;
    int duration;

    public ExcuseLetter() {}

    public ExcuseLetter(String id, String name, String className, char type, int duration) {
        this.id = id;
        this.name = name;
        this.className = className;
        this.typeOfExcuse = type;
        this.duration = duration;
    }

    public void displayLetter() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Class: " + className);
        System.out.println("Type of Excuse: " + (typeOfExcuse == 'S' ? "Sick" : "Other"));
        System.out.println("Duration: " + duration + " days");
    }
}

public class Triangle {
    public int base;
    public int height;

    // Default constructor
    public Triangle() {
        this.base = 0;
        this.height = 0;
    }

    // Constructor with parameters
    public Triangle(int a, int t) {
        this.base = a;
        this.height = t;
    }

    // Method to calculate area
    public double countArea() {
        return 0.5 * base * height;
    }

    // Method to calculate perimeter (assuming an equilateral triangle for simplicity)
    public int countPerimeter() {
        return 3 * base;
    }

    public static void main(String[] args) {
        // Creating an array of Triangle objects
        Triangle[] trArray = new Triangle[4];

        // Initializing objects with given values
        trArray[0] = new Triangle(10, 4);
        trArray[1] = new Triangle(20, 10);
        trArray[2] = new Triangle(15, 6);
        trArray[3] = new Triangle(25, 10);

        // Displaying the area and perimeter for each triangle
        for (int i = 0; i < trArray.length; i++) {
            System.out.println("Triangle " + i + ":");
            System.out.println("Area: " + trArray[i].countArea());
            System.out.println("Perimeter: " + trArray[i].countPerimeter());
            System.out.println();
        }
    }
}

// Circle Class:
// Imagine you are creating an application for an art supply store. Create a Circle class that represents a circle,
// including attributes like radius and area, and implement methods to calculate the area and perimeter. 
// This will help artists better understand the measurements of their work!

public class Circle {
    // Attributes
    private double radius;
    private static final double PI = Math.PI;

    // Default constructor
    public Circle() {
        this.radius = 1.0;
    }

    // Constructor with parameter
    public Circle(double radius) {
        if (radius <= 0) {
            throw new IllegalArgumentException("Radius must be greater than zero");
        }
        this.radius = radius;
    }

    // Getter and Setter
    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        if (radius <= 0) {
            throw new IllegalArgumentException("Radius must be greater than zero");
        }
        this.radius = radius;
    }

    // Method to calculate area
    public double calculateArea() {
        return PI * Math.pow(radius, 2);
    }

    // Method to calculate perimeter (circumference)
    public double calculatePerimeter() {
        return 2 * PI * radius;
    }

    // Method to calculate diameter
    public double calculateDiameter() {
        return 2 * radius;
    }

    // toString method for textual representation
    @Override
    public String toString() {
        return String.format("Circle [Radius: %.2f, Area: %.2f, Perimeter: %.2f]",
                radius, calculateArea(), calculatePerimeter());
    }

    // Main method for testing
    public static void main(String[] args) {
        // Testing the Circle class
        Circle circle1 = new Circle();
        System.out.println("Default circle: " + circle1);

        Circle circle2 = new Circle(5.0);
        System.out.println("Circle with radius 5: " + circle2);

        // Changing the radius
        circle2.setRadius(7.5);
        System.out.println("Circle after changing radius to 7.5: " + circle2);

        // Calculating specific measurements
        System.out.printf("Diameter: %.2f%n", circle2.calculateDiameter());
    }
}
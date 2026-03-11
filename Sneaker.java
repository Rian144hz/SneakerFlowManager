package entities;

public class Sneaker {
    private String model;
    private String mark;
    private int size;
    private double price;

    public Sneaker(String model, String mark, int size, double price) {
        this.model = model;
        this.mark = mark;
        this.size = size;
        this.price = price;
    }
    public void displayDetails() {
        System.out.println("--- entities.Sneaker Detail ---");
        System.out.println("Model: " + this.model);
        System.out.println("Mark: " + this.mark);
        System.out.println("Size: " + this.size);
        System.out.printf("Price: R$ %.2f%n", this.price);
        System.out.println("---------------------------");
    }

    public double getPrice() {
        return price;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}

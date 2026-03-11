package entities;

import java.util.ArrayList;

public class stock {
    private ArrayList<Sneaker> SneakerList;

    public stock() {
        this.SneakerList = new ArrayList<>();
    }

    public void addSneaker(Sneaker s) {
        SneakerList.add(s);
    }

    public boolean removeSneaker(String removeModelToSearch) {

        for (int i = 0; i < SneakerList.size(); i++) {
            if (SneakerList.get(i).getModel().equalsIgnoreCase(removeModelToSearch)) {
                SneakerList.remove(i);
                System.out.println("-----sneaker" + "[ " + removeModelToSearch + "] removed-----");
                return true;
            }

        }

        System.out.println("No sneakers found for this model.");
        return false;

    }

    public void listAll() {
        if (SneakerList.isEmpty()) {
            System.out.println("Stock is empty!");
        } else {
            for (Sneaker s : SneakerList) {
                s.displayDetails();
            }
        }
    }

    public void searchByMark(String markToSearch) {
        boolean found = false;
        System.out.println("\n---Results for Mark" + " [" + markToSearch + "] " + "---");
        for (Sneaker s : SneakerList) {
            if (s.getMark().equalsIgnoreCase(markToSearch)) {
                s.displayDetails();
                found = true;
            }

        }
        if (!found) {
            System.out.println("No sneakers found for this mark.");
        }

    }

    public double calculateTotalValue() {
        double total = 0;
        for (Sneaker s : SneakerList) {
            total += s.getPrice();
        }
        return total;
    }

}

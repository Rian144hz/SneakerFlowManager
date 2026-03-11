package application;
import entities.Sneaker;
import entities.stock;
import entities.SneakerDAO;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        stock myStock = new stock();
        SneakerDAO dao = new SneakerDAO();
        int option = -1;
        List<Sneaker> DataList = dao.getAll();
        for (Sneaker s : DataList) {
            myStock.addSneaker(s);
        }
        int registered = DataList.size();
        System.out.println("Welcome to SneakerFlow Manager!");
        while (option != 0) {
            System.out.println("\n--- MAIN MENU ---");
            System.out.println("1 - Register New Sneaker");
            System.out.println("2 - Search By Mark");
            System.out.println("3 - Remove By Model");
            System.out.println("4 - List all registered sneakers");
            System.out.println("5 - display total value");
            System.out.println("0 - Out");
            System.out.print("Choose one option: ");
            option = sc.nextInt();
            sc.nextLine();
            switch (option) {
                case 1:
                    System.out.println("---- Register New Sneaker-----");
                    System.out.print("Model: ");
                    String model = sc.nextLine();
                    System.out.print("Mark: ");
                    String mark = sc.nextLine();
                    System.out.print("Size: ");
                    int size = sc.nextInt();
                    System.out.print("Price: ");
                    double price = sc.nextDouble();
                    Sneaker newSneaker = new Sneaker(model, mark, size, price);
                    myStock.addSneaker(newSneaker);

                    dao.save(newSneaker);

                    System.out.println("Sneaker successfully registered.");
                    registered++;
                    break;
                case 2:
                    System.out.println("------ Search by mark------");
                    System.out.print("Enter mark name to search: ");
                    String searchMark = sc.nextLine();
                    myStock.searchByMark(searchMark);
                    break;

                case 3:
                    if (registered <= 0) {
                        System.out.println(("------no registered sneakers------"));
                    } else {
                        System.out.println("------ Remove by model------");
                        System.out.print("Enter model name to search: ");
                        String searchModel = sc.nextLine();//
                        if (myStock.removeSneaker(searchModel)) {
                            SneakerDAO daoDelete = new SneakerDAO();
                            daoDelete.deleteByModel(searchModel);
                            registered--;
                        }

                    }
                    break;

                case 4:
                    System.out.println("------List all registered sneakers------");
                    if (registered <= 0) {
                        System.out.println(("------no registered sneakers------"));
                    } else {
                        System.out.println("\n-----CURRENT STOCK-----\n");
                        myStock.listAll();
                    }
                    break;

                case 5:

                    System.out.println("----- Dislay total value -----");

                    System.out.printf("Total Value in Stock: R$ %.2f%n",
                            myStock.calculateTotalValue());
                    break;

                case 0:
                    System.out.println("Outing.... see you later!");
                    break;
                default:
                    System.out.println("Invalid option!");

            }

        }
        sc.close();
    }

}


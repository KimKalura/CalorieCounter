import java.util.Scanner;

public class CalorieCounter {

    public static void main(String[] args) {
        int selection = 0;
        ProductCatalog productCatalog = new ProductCatalog();
        Scanner console = new Scanner(System.in);
        do {
            printMenu();
            selection = console.nextInt();
            performSelectedAction(selection, productCatalog);

        } while (selection != 6);
    }

    public static void addProduct(ProductCatalog productCatalog) {
        Scanner console = new Scanner(System.in);
        System.out.println("Introduceti detaliile produsului:");
        System.out.print("Numele: ");
        String name = console.nextLine();
        System.out.print("Grasimi: ");
        int fats = console.nextInt();
        System.out.print("Carbohidrati: ");
        int carbohydrates = console.nextInt();
        System.out.print("Proteine: ");
        int proteins = console.nextInt();
        boolean result = productCatalog.addProduct(new Product(name, fats, carbohydrates, proteins));
        if (!result) {
            System.out.println("Catalogul este plin sau produsul exista deja.");
        } else {
            System.out.println("Produsul a fost adaugat cu succes!");
        }

    }

    public static void computeCalories() {
        Scanner console = new Scanner(System.in);
        System.out.println("Introduceti detaliile produsului:");
        System.out.print("Grasimi: ");
        int fats = console.nextInt();
        System.out.print("Carbohidrati: ");
        int carbohydrates = console.nextInt();
        System.out.print("Proteine: ");
        int proteins = console.nextInt();
        int kcal = Product.computeCalories(fats, carbohydrates, proteins);
        System.out.println("Produsul are: " + kcal + " kcal");
    }

    public static void deleteProduct(ProductCatalog productCatalog) {
        Scanner console = new Scanner(System.in);
        System.out.println("Introduceti numele produsului pe care vreti sa il stergeti:");
        System.out.print("Numele: ");
        String name = console.nextLine();
        if (!productCatalog.deleteProduct(name)) {
            System.out.println("Produsul cu numele: " + name + " nu exista");
        } else {
            System.out.println("Produsul a fost sters cu succes!");
        }
    }

    public static void getProduct(ProductCatalog productCatalog) {
        Scanner console = new Scanner(System.in);
        System.out.println("Introduceti numele produsului pe care il cautati:");
        System.out.print("Numele: ");
        String name = console.nextLine();
        Product productFound = productCatalog.findProductByName(name);
        if (productFound == null) {
            System.out.println("Produsul cu numele: " + name + " nu exista");
        } else {
            System.out.println(productFound);
        }
    } 

    public static void performSelectedAction(int selection, ProductCatalog productCatalog) {
        switch (selection) {
            case 1:
                addProduct(productCatalog);
                break;
            case 2:
                computeCalories();
                break;
            case 3:
                productCatalog.printProducts();
                break;
            case 4:
                deleteProduct(productCatalog);
                break;
            case 5:
                getProduct(productCatalog);
                break;
            case 6:
                System.out.println("EXIT");
                break;
            default:
                System.out.println("Optiunea introdusa nu exista");
        }
    }

    public static void printMenu() {
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println("MENIU: ");
        System.out.println("1. Adauga produs in catalog si calculeaza-i caloriile");
        System.out.println("2. Calculeaza caloriile pentru un produs fara a fi adaugat in catalog");
        System.out.println("3. Afiseaza toate produsele din catalog si caloriile pentru fiecare");
        System.out.println("4. Sterge un produs din catalog");
        System.out.println("5. Gaseste produs dupa nume");
        System.out.println("6. Iesi din aplicatie");
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println("Introdu optiunea aleasa:");
    }
}


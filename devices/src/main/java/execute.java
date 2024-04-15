import controller.PhoneContoller;
import model.Phone;
import java.sql.SQLException;
import java.util.Scanner;

public class execute {

    private static PhoneContoller phoneContoller;

    public static void insertPhone(Phone phone) throws SQLException {
        phoneContoller.insertPhone(phone);
        getAllPhones();
    }

    public static void getAllPhones() throws SQLException {
        for (Phone phone: phoneContoller.getAllPhones()) {
            System.out.println(phone.toString());
        }
    }

    public static void getPhoneById(int id) throws SQLException {
        System.out.println(phoneContoller.getPhoneById(id).toString());
    }

    public static void deletePhone(int id) throws SQLException {
        phoneContoller.deletePhone(id);
        getAllPhones();
    }

    public static void updatePhone(Phone phone) throws SQLException {
        phoneContoller.updatePhone(phone);
        getPhoneById(phone.getId());
    }



    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            int i = -1;
            Phone phone = new Phone();
            phoneContoller = new PhoneContoller();

            while (i != 0) {
                System.out.println("Phone catalog please select an option \n");
                System.out.println("0. Exit \n");
                System.out.println("1. Consult all phones \n");
                System.out.println("2. Consult phone by identifier \n");
                System.out.println("3. Delete phone by identifier \n");
                System.out.println("4. Update phone by identifier \n");
                System.out.println("5. Insert phone  \n");
                System.out.println("Enter option :");
                i = Integer.parseInt(scanner.nextLine());
                switch (i) {
                    case 1:
                        getAllPhones();
                        break;
                    case 2:
                        System.out.println("Enter identifier :");
                        getPhoneById(Integer.parseInt(scanner.nextLine()));
                        break;
                    case 3 :
                        System.out.println("Enter identifier :");
                        deletePhone(Integer.parseInt(scanner.nextLine()));
                        break;
                    case 4 :
                        System.out.println("Enter identifier :");
                        phone.setId(Integer.parseInt(scanner.nextLine()));
                        System.out.println("Information for the identifier \n");
                        getPhoneById(phone.getId());
                        System.out.println("Enter model :");
                        phone.setModel(scanner.nextLine());
                        System.out.println("Enter so :");
                        phone.setSo(scanner.nextLine());
                        System.out.println("Enter price :");
                        phone.setPrice(Integer.parseInt(scanner.nextLine()));
                        System.out.println("Enter camara :");
                        phone.setCamara(scanner.nextLine());
                        updatePhone(phone);
                        break;
                    case 5 :
                        System.out.println("Enter model :");
                        phone.setModel(scanner.nextLine());
                        System.out.println("Enter so :");
                        phone.setSo(scanner.nextLine());
                        System.out.println("Enter price :");
                        phone.setPrice(Integer.parseInt(scanner.nextLine()));
                        System.out.println("Enter camara :");
                        phone.setCamara(scanner.nextLine());
                        insertPhone(phone);
                        break;

                    default:
                        System.out.println("Enter valid option :");
                }

            }
            System.out.println("See you later");

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

}

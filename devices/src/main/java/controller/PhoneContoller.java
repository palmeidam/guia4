package controller;

import model.Phone;
import repository.SQLiteCRUD;

import java.sql.SQLException;
import java.util.ArrayList;

public class PhoneContoller {

    public PhoneContoller() throws SQLException {
        SQLiteCRUD.createTablePhones();
    }

    public void insertPhone(Phone phone) throws SQLException {
        SQLiteCRUD.insertPhone(phone);
        System.out.println("Inserted phone");
    }

    public ArrayList<Phone> getAllPhones() throws SQLException {
        return SQLiteCRUD.getAllPhones();
    }

    public Phone getPhoneById(int id) throws SQLException {
        return SQLiteCRUD.getPhonesById(id);
    }

    public void deletePhone(int id) throws SQLException {
        SQLiteCRUD.deleteById(id);
        System.out.println("Deleted phone: " + id);
    }

    public void updatePhone(Phone phone) throws SQLException {
        SQLiteCRUD.updateById(phone);
        System.out.println("Updated phone: " + phone.getId());
    }
}

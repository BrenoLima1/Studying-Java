package com.dbexample;

import com.dbexample.View.UserView;
import com.dbexample.controller.UserController;
import com.dbexample.model.User;

public class Main {
    public static void main(String[] args) {
        UserController controller = new UserController();
        UserView view = new UserView();

       boolean running = true;
while (running) {
    int option = view.readMenuOption();

    switch (option) {
        case 1:
            // view.printAllUsers(controller.getAllUsers());
            break;
        case 2:
            User novo = view.readUser();
            if (controller.createUser(novo)) {
                view.printMessage("User created successfully!");
            } else {
                view.printMessage("Error creating user.");
            }
            break;
        case 3:
           int idUser = view.readUserID();
            User userUpdate = view.readUser();
            if (controller.updateUser(idUser, userUpdate)) {
                view.printMessage("User updated successfully!");
            } else {
                view.printMessage("Error updating user.");
            }
            break;
        case 4:
            view.printMessage("Delete is still not implemented.");
            break;
        case 5:
            view.printMessage("Enter the user id: ");
            int id = view.scanner.nextInt();
            view.scanner.nextLine();

            User user = controller.readUser(id);
            if (user != null) {
                view.printUser(user);
            } else {
                view.printMessage("User not found.");
            }
            break;
        case 0:
            running = false;
            view.printMessage("Goodbye...");
            break;
        default:
            view.printMessage("Invalid option!");
            break;
    }
}
view.closeScanner();
    }
}

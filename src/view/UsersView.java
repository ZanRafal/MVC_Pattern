package view;

import bean.User;
import controller.Controller;
import model.DataModel;

import java.util.List;

public class UsersView implements View {

    private Controller controller;

    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }

    @Override
    public void refesh(DataModel dataModel) {
        System.out.println("All users:");
        List<User> users = dataModel.getUserList();
        for (User user : users) {
            System.out.println("\t" + user);
        }
        System.out.println("====================================");
    }

    public void fireShowAllUsersEvent() {
        controller.onShowAllUsers();
    }
}

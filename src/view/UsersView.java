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
        System.out.println("All " + (dataModel.isDisplayDeletedUserList() ? "deleted " : "") + "users:");
        for (User user : dataModel.getUsers()) {
            System.out.println("\t" + user);
        }
        System.out.println("====================================");
    }

    public void fireShowAllUsersEvent() {
        controller.onShowAllUsers();
    }

    public void fireShowDeletedUsersEvent() {
        controller.onShowAllDeletedUsers();
    }

    public void fireOpenUserEditFormEvent(long id) {
        controller.onOpenUserEditForm(id);
    }
}

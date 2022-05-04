package view;

import controller.Controller;
import model.DataModel;

public class EditUserView implements View {
    private Controller controller;

    @Override
    public void refesh(DataModel dataModel) {
        System.out.println("User to be edited:");
        System.out.println("\t" + dataModel.getActiveUser());
        System.out.println("======================================================================");
    }

    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void fireUserDeletedEvent(long id) {
        controller.onDeleteUser(id);
    }

    public void fireUserDataChangedEvent(String name, long id, int level) {
        controller.onChangeUserData(name, id, level);
    }
}

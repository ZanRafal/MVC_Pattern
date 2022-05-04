import controller.Controller;
import model.MainModel;
import model.Model;
import view.EditUserView;
import view.UsersView;

public class TestMain {
    public static void main(String[] args) {
        Model model = new MainModel();
        UsersView usersView = new UsersView();
        EditUserView editUserView = new EditUserView();
        Controller controller = new Controller();

        usersView.setController(controller);
        editUserView.setController(controller);

        controller.setModel(model);
        controller.setUsersView(usersView);
        controller.setEditUserView(editUserView);

        usersView.fireShowAllUsersEvent();
        usersView.fireOpenUserEditFormEvent(126L);
        editUserView.fireUserDeletedEvent(124L);
        editUserView.fireUserDataChangedEvent("~Katz~", 126L, 99);
        usersView.fireShowDeletedUsersEvent();
    }
}

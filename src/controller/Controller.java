package controller;

import model.Model;
import view.EditUserView;
import view.UsersView;

public class Controller {
    private Model model;
    private UsersView usersView;
    private EditUserView editUserView;

    public void setEditUserView(EditUserView editUserView) {
        this.editUserView = editUserView;
    }
    public void setModel(Model model) {
        this.model = model;
    }

    public void setUsersView(UsersView usersView) {
        this.usersView = usersView;
    }

    public void onShowAllUsers() {
        model.loadUsers();
        usersView.refesh(model.getDataModel());
    }

    public void onShowAllDeletedUsers() {
        model.loadDeletedUsers();
        usersView.refesh(model.getDataModel());
    }

    public void onOpenUserEditForm(long userId) {
        model.loadUserById(userId);
        editUserView.refesh(model.getDataModel());
    }

    public void onDeleteUser(long id) {
        model.deleteUserById(id);
        usersView.refesh(model.getDataModel());
    }

    public void onChangeUserData(String name, long id, int level) {
        model.changeUserData(name,id,level);
        usersView.refesh(model.getDataModel());
    }
}

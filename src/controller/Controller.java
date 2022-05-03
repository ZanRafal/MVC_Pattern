package controller;

import model.Model;

public class Controller {
    Model model;

    public void showAllUsers() {
        model.loadUsers();
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }
}

package model;

import bean.User;

import java.util.ArrayList;
import java.util.List;

public class FakeModel implements Model {
    private final DataModel dataModel = new DataModel();

    @Override
    public DataModel getDataModel() {
        return dataModel;
    }

    @Override
    public void loadUsers() {
        List<User> users = new ArrayList<>();
        users.add(new User("Sigismund Djikstra", 11, 1));
        users.add(new User("Płotka", 21, 1));
    }
}

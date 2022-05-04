package model;

import bean.User;
import model.service.UserService;
import model.service.UserServiceImpl;

import java.util.List;

public class MainModel implements Model {
    private final UserServiceImpl userService = new UserServiceImpl();
    private final DataModel dataModel = new DataModel();

    @Override
    public DataModel getDataModel() {
        return dataModel;
    }

    @Override
    public void loadUsers() {
        List<User> users = userService.getUsersBetweenLevels(1 , 100);
        dataModel.setUsers(users);
        dataModel.setDisplayDeletedUserList(false);
    }

    public void loadDeletedUsers() {
        List<User> users = userService.getAllDeletedUsers();
        dataModel.setUsers(users);
        dataModel.setDisplayDeletedUserList(true);
    }

    @Override
    public void loadUserById(long userId) {
        User user = userService.getUsersById(userId);
        dataModel.setActiveUser(user);
    }

    @Override
    public void deleteUserById(long id) {
        userService.deleteUser(id);
        List<User> users = getAllUsers();
        dataModel.setUsers(users);
    }

    private List<User> getAllUsers() {
        List<User> allUsers = userService.getUsersBetweenLevels(1, 100);
        allUsers = userService.filterOnlyActiveUsers(allUsers);

        return allUsers;
    }

    @Override
    public void changeUserData(String name, long id, int level) {
        userService.createOrUpdateUser(name, id, level);
        List<User> users = getAllUsers();
        dataModel.setUsers(users);
    }
}

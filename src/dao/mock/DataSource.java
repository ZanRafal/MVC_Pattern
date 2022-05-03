package dao.mock;

import bean.User;

import java.util.LinkedList;
import java.util.List;

public class DataSource {
    private static DataSource myInstance = new DataSource();

    public static DataSource getInstance() {
        return myInstance;
    }

    //Implementacja Singleton
    private DataSource() {}

    private List<User> users = new LinkedList<User>() {{
        add(new User("Geralt", 1231, 1));
        add(new User("Triss", 1241, 2));
        add(new User("Yennefer", 1521, 1));
        add(new User("Ciri", 1261, 2));
    }};

    private long maxUserId = 1261;

    public List<User> getUsers() {
        return users;
    }

    public User createOrUpdate(User newUser) {
        if (newUser == User.NULL_USER)
            return User.NULL_USER;

        //nowy Użytkownik
        if (newUser.getId() == 0)
            return createNewUser(newUser);
        else
            return updateUser(newUser);
    }

    private User createNewUser(User newUser) {
        User clone = newUser.clone(++maxUserId);
        users.add(clone);
        return clone;
    }

    private User updateUser(User newUser) {
        for(User user : users) {
            if(user.getId() == newUser.getId()) {
                user.setName(newUser.getName());
                user.setLevel(newUser.getLevel());
                return user;
            }
        }
        return User.NULL_USER;
    }
}

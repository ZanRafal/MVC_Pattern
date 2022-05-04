package dao.mock;

import bean.User;

import java.util.LinkedList;
import java.util.List;

public class DataSource {
    private final static DataSource instance = new DataSource();

    public static DataSource getInstance() {
        return instance;
    }

    //Implementacja Singleton
    private DataSource() {}

    private final List<User> users = new LinkedList<>() {{
        add(new User("Geralt", 123L, 1));
        add(new User("Triss", 124L, 2));
        add(new User("Yennefer", 152L, 1));
        add(new User("Ciri", 126L, 2));
    }};

    private long maxUserId = 126L;

    public List<User> getUsers() {
        return users;
    }

    public User createOrUpdate(User newUser) {
        if (newUser == User.NULL_USER)
            return User.NULL_USER;

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

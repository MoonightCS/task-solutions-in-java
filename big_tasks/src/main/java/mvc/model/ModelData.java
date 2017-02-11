package mvc.model;


import mvc.bean.User;

import java.util.List;

public class ModelData {
    private List<User> users;
    private User activeUser;
    private boolean displayDeletedUserList;

    public boolean isDisplayDeletedUserList() {
        return displayDeletedUserList;
    }

    public User getActiveUser() {
        return activeUser;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setActiveUser(User activeUser) {
        this.activeUser = activeUser;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public void setDisplayDeletedUserList(boolean displayDeletedUserList) {
        this.displayDeletedUserList = displayDeletedUserList;
    }
}

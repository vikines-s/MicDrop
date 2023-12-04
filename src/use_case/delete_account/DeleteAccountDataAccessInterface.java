package use_case.delete_account;

import entity.User;
public interface DeleteAccountDataAccessInterface {
    User get(String username);
    void save(User user);
    void deleteAccount(String username);
    boolean existsByName(String username);
}

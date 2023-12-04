package data_access;

import entity.User;
import use_case.delete_account.DeleteAccountDataAccessInterface;

import java.util.HashMap;
import java.util.Map;

public class InMemoryUserDataAccessObject implements DeleteAccountDataAccessInterface {
    public Map<String, String> accounts = new HashMap<>();
    public void save(String username) {
        accounts.put(username, username);
    }
    public boolean existsByName(String identifier) {
        return accounts.containsKey(identifier);
    }

    public User get(String username) {
        return null;
    }

    public void deleteAccount(String username) {
        accounts.remove(username);
    }
}

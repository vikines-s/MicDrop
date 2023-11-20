package data_access;

import entity.User;
import entity.UserFactory;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
public class FileUserDataAcessObject {

    private final File csvFile;
    private final Map<String, Integer> headers = new LinkedHashMap<>();
    private final Map<String, User> accounts = new HashMap<>();
    private UserFactory userFactory;

    public FileUserDataAcessObject(String csvPath, UserFactory userFactory) throws IOException {
        this.userFactory = userFactory;

        csvFile = new File(csvPath);

        headers.put("username", 0);
        headers.put("creation time", 1);


    }
}

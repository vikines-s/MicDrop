package entity;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CommonUserTest {
    private CommonUser user;
    private ArrayList<String> array;
    private ArrayList<String> myList;
    @BeforeAll
    void init(){
        user = new CommonUser("Mila");
        array = new ArrayList<>();
    }
    @BeforeEach
    void init2(){
        myList = new ArrayList();
    }
    @Test
    void getName() {
        assertEquals("Mila", user.getName());
    }
    @Test
    void getBirthdate() {
        assertEquals(user.getBirthdate(), null);
    }
    @Test
    void setBirthdate() {
        user.setBirthdate("May");
        assertEquals(user.getBirthdate(), "May");
    }
    @Test
    void getFavouriteArtists() {
        assertEquals(user.getFavouriteArtists(), array);
    }
    @Test
    void setTopArtists() {
        myList.add("bob");
        myList.add("joe");
        myList.add("jim");
        myList.add("jill");
        myList.add("jess");
        user.setTopArtists(myList);
        assertEquals(user.getFavouriteArtists(), myList);
    }
    @Test
    void getTopTracks() {
        assertEquals(user.getTopTracks(), array);
    }
    @Test
    void setTopTracks() {
        myList.add("hi");
        myList.add("bye");
        myList.add("no");
        myList.add("yes");
        myList.add("maybe");
        user.setTopTracks(myList);
        assertEquals(user.getTopTracks(), myList);
    }
    @Test
    void getTopGenres() {
        assertEquals(user.getTopGenres(), array);
    }
    @Test
    void setTopGenres() {
        myList.add("rap");
        myList.add("pop");
        myList.add("hiphop");
        myList.add("rnb");
        myList.add("jazz");
        user.setTopTracks(myList);
        assertEquals(user.getTopTracks(), myList);
    }
}
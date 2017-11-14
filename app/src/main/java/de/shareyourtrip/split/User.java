package de.shareyourtrip.split;

/**
 * Created by Maxim on 09.11.2017.
 */

public class User{
    private String avatarURL;

    public User(String avatarURL, String userName) {
        this.avatarURL = avatarURL;
        this.userName = userName;
    }

    private String userName;

    public String getAvatarURL() {
        return avatarURL;
    }

    public void setAvatarURL(String avatarURL) {
        this.avatarURL = avatarURL;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}

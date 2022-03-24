package com.janwes.pojo;

import java.io.Serializable;

/**
 * @author Janwes
 * @version 1.0
 * @package com.janwes.pojo
 * @date 2021/7/20 18:15
 * @description
 */
public class UserInfo implements Serializable {
    private String username;
    private String gender;

    public UserInfo() {
    }

    public UserInfo(String username, String gender) {
        this.username = username;
        this.gender = gender;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "username='" + username + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}

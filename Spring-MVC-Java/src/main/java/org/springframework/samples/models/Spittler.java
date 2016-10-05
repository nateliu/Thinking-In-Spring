package org.springframework.samples.models;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by Administrator on 2016/10/5 0005.
 */
public class Spittler {
    private Long id;
    @NotNull
    @Size(min = 2, max = 30, message="{firstName.size}")
    private String firstName;
    @NotNull
    @Size(min = 2, max = 30, message="{lastName.size}")
    private String lastName;
    @NotNull
    @Size(min = 4, max = 50, message="{userName.size}")
    private String userName;
    @NotNull
    @Size(min = 5, max = 16, message="{passWord.size}")
    private String passWord;
    @NotNull
    @Size(min = 5, max = 16)
    private String email;

    public Spittler() {
    }

    public Spittler(String firstName, String lastName, String userName, String passWord,String email) {
        this(null, firstName, lastName, userName, passWord, email);
    }

    public Spittler(Long id, String firstName, String lastName, String userName, String passWord,String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.passWord = passWord;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

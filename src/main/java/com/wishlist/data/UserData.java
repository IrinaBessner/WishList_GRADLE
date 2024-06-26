package com.wishlist.data;

import com.wishlist.models.User;

public class UserData {

    public static final String NAME = "Lena";
    public static final String SECONDNAME = "Dudkina";
    public static final String EMAIL = "dudkina@web.de";
    public static final String PASSWORD = "Berlin2024!";
    public static final String CONFPASSWORD = "Berlin2024!";


    public static final User USER_DUDKINA_SIGNUP = new User(
            "Lena",
            "Dudkina",
            "dudkina@web.de",
            "Berlin2024!",
            "Berlin2024!");

    public static final User USER_DUDKINA_LOGIN = new User("dudkina@web.de",
            "Berlin2024!");

    public static final User USER_DUDKINA_LOGIN_WRONG_PASSWORD = new User("dudkina@web.de",
            "$20muencheN");

    public static final User USER_DUDKINA_WITHOUT_PASSWORD = new User("Lena",
            "Dudkina",
            "dudkina@web.de",
            "",
            "");

    public static final User USER_DUDKINA_INVALID_EMAIL = new User("Lena",
            "Dudkina",
            "dudkina",
            "Berlin2024!",
            "Berlin2024!");

    public static final User USER_DUDKINA_WITHOUT_EMAIL = new User("Lena",
            "Dudkina",
            "",
            "Berlin2024!",
            "Berlin2024!");
}
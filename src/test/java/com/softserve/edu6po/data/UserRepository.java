package com.softserve.edu6po.data;

public final class UserRepository {

    private UserRepository() {
    }

    public static User getDefault() {
        return  getValid();
    }

    public static User getValid() {
        return new User()
                .setEmail("exqcndksfmcgtmtmdt@enotj.com")
                .setPassword("Qwerty_1")
                //.setPassword(System.getenv("USER_PASSWORD"))
                .setUsername("Qwerty1");
    }

    public static User getInvalid() {
        return new User()
                .setEmail("hahaha@gmail.com")
                .setPassword("Qwerty_1")
                //.setPassword(System.getenv("USER_PASSWORD"))
                .setUsername("Qwerty1");
    }

    /*
    public static List<User> fromCsv() {
        return fromCsv("users.csv");
    }

    public List<User> fromExcel(String filename) {
        return User.getByLists(new ExcelReader(filename).getAllCells());
    }
    */
}

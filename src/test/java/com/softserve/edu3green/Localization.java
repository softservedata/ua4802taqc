package com.softserve.edu3green;

public enum Localization {
    EN("e","sign up"),
    UA("u", "Зареєструватися ");

    private String shortText;
    private String signupText;

    private Localization(String shortText, String signupText) {
        this.shortText = shortText;
        this.signupText = signupText;
    }

    public String getShortText() {
        return shortText;
    }

    public String getSignupText() {
        return signupText;
    }
}

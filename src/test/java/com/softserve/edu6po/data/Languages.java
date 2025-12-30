package com.softserve.edu6po.data;

public enum Languages {
    EN("e","sign up"),
    UA("u", "зареєструватися");

    private String shortText;
    private String signupText;

    private Languages(String shortText, String signupText) {
        this.shortText = shortText;
        this.signupText = signupText;
    }

    public String getShortText() {
        return shortText;
    }

    public String getSignupText() {
        return signupText;
    }

    @Override
    public String toString() {
        return "Localization{" +
                "shortText='" + shortText + '\'' +
                ", signupText='" + signupText + '\'' +
                '}';
    }
}

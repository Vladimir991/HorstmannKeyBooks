package ChapterNine.UIComponentsInSwing.DataExchange;

public class User {
    private String name;
    private char[] password;

    public User(String aName, char[] aPassword) {
        name = aName;
        password = aPassword;
    }

    public String getName() {
        return name;
    }

    public void setName(String aName) {
        name = aName;
    }

    public char[] getPassword() {
        return password;
    }
}

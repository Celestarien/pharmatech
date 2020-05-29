package objects;

public class User {
    /* ATTRIBUTS */
    private String name;
    private String password;

    /* CONSTRUCTEURS */
    public User() {
    }

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    /*METHODES INTERNES*/
    public String getId(){
        return this.name+this.password;
    }

    /* GETTERS & SETTERS */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}

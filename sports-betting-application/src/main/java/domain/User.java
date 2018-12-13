package domain;

abstract class User {

    public String name;
    public String password;
    public Boolean enabled;

    abstract void say();
}

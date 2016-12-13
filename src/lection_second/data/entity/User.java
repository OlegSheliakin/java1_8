package lection_second.data.entity;

import java.util.Optional;

/**
 * Created by Oleg on 10.12.2016.
 */
public class User {

    private String name;
    private String gender;
    private Integer age;
    private TYPE type;

    public enum TYPE{
        TEENAGER, ADULT, OTHER
    }

    public User (){}

    public User(String name, String gender, Integer age, TYPE type) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.type = type;
    }

    public String getName() {
        return Optional.ofNullable(name).orElse("empty");
    }

    public String getGender() {
        return Optional.ofNullable(gender).orElse("empty");
    }

    public Integer getAge() {
        return Optional.ofNullable(age).orElse(-1);
    }

    public TYPE getType() {
        return type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setType(TYPE type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        if (gender != null ? !gender.equals(user.gender) : user.gender != null) return false;
        return age != null ? age.equals(user.age) : user.age == null;

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        result = 31 * result + (age != null ? age.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + getName() + '\'' +
                ", gender='" + getGender() + '\'' +
                ", age=" +getAge() +
                '}';
    }
}

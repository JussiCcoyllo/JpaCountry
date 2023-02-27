package be.intecbrussel.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class President {
    @Id
    private String name;
    private int age;


    public President(String name, int age){
        this.name = name;
        this.age = age;
    }

    protected President(){

    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "President{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

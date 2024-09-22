package org.acme.quarkussocial.dtos;

public class CreateUserRequest {
    private String name;
    private String age;

    // Getter para o campo 'name'
    public String getName() {
        return name;
    }

    // Setter para o campo 'name'
    public void setName(String name) {
        this.name = name;
    }

    // Getter para o campo 'age'
    public String getAge() {
        return age;
    }

    // Setter para o campo 'age'
    public void setAge(String age) {
        this.age = age;
    }
}

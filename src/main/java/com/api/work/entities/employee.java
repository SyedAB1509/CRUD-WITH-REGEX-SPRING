package com.api.work.entities;

import com.api.work.Validation.DynamicField;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Entity
@Table(name = "employee")
public class employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;
    @NotNull(message = "Name cannot be null.")
//    @Schema(description = "Name of the user", example = "Name can't be empty")
//    @Pattern(regexp = "^[A-Za-z\\s]+$", message = "Invalid name. Only alphabetic characters are allowed.")
    @Size(max = 50, message = "Name must be at most 50 characters long.")
    @DynamicField()
    private String name;

    @NotNull(message = "Address cannot be null.")
    @Schema(description = "Address of the user", example = "Address can't be empty")
    @Size(max = 100, message = "Address must be at most 100 characters long.")
    private String address = "Please Provide Your Address";
    @NotNull(message = "Age cannot be null.")
    @Min(value = 0, message = "Age must be at least 0.")
    @Max(value = 100, message = "Age must be at most 100.")
    private int age;

    public employee(long id, String name, String address, int age) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.age = age;
    }

    @Override
    public String toString() {
        return "employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", age=" + age +
                '}';
    }

    public employee() {
        super();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


}

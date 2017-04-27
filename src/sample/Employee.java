package sample;


import javafx.beans.property.*;

import java.io.Serializable;

public class Employee implements Serializable {

    private StringProperty name;
    private StringProperty lastName;
    private StringProperty gender;
    private StringProperty depNumber;
    private FloatProperty salary;
    private IntegerProperty age;
    private IntegerProperty childNumber;
    private StringProperty marital;

    public Employee(Builder builder) {
        this.name = builder.name;
        this.lastName = builder.lastName;
        this.gender = builder.gender;
        this.depNumber = builder.depNumber;
        this.salary = builder.salary;
        this.age = builder.age;
        this.childNumber = builder.childNumber;
        this.marital = builder.marital;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name=" + name +
                ", lastName=" + lastName +
                ", gender=" + gender +
                ", depNumber=" + depNumber +
                ", salary=" + salary +
                ", age=" + age +
                ", childNumber=" + childNumber +
                ", marital=" + marital +
                '}';
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public String getLastName() {
        return lastName.get();
    }

    public StringProperty lastNameProperty() {
        return lastName;
    }

    public String getGender() {
        return gender.get();
    }

    public StringProperty genderProperty() {
        return gender;
    }

    public String getDepNumber() {
        return depNumber.get();
    }

    public StringProperty depNumberProperty() {
        return depNumber;
    }

    public float getSalary() {
        return salary.get();
    }

    public FloatProperty salaryProperty() {
        return salary;
    }

    public int getAge() {
        return age.get();
    }

    public IntegerProperty ageProperty() {
        return age;
    }

    public int getChildNumber() {
        return childNumber.get();
    }

    public IntegerProperty childNumberProperty() {
        return childNumber;
    }

    public String getMarital() {
        return marital.get();
    }

    public StringProperty maritalProperty() {
        return marital;
    }

    public static final class Builder {
        private StringProperty name;
        private StringProperty lastName;
        private StringProperty gender;
        private StringProperty depNumber;
        private FloatProperty salary;
        private IntegerProperty age;
        private IntegerProperty childNumber;
        private StringProperty marital;

        public Builder(String name ,String lastName, String gender, String depNumber, float salary, Integer age ) {
            this.name = new SimpleStringProperty(name);
            this.lastName = new SimpleStringProperty(lastName);
            this.gender = new SimpleStringProperty(gender);
            this.depNumber = new SimpleStringProperty(depNumber);
            this.salary = new SimpleFloatProperty(salary);
            this.age = new SimpleIntegerProperty(age);
        }


        public Builder childNumber(Integer val) {
            this.childNumber = new SimpleIntegerProperty(val);
            return this;
        }

        public Builder marital(String val) {
            this.marital = new SimpleStringProperty(val);
            return this;
        }

        public Employee build() {
            return new Employee(this);
        }
    }
}



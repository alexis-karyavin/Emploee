package com.company;

import java.util.Calendar;

public class Manager extends Employee{
    private double bonus;

    public Manager() {
        this.bonus = 0;
    }

    public Manager (String name, int salary) {
        super(name, salary, 1970, 1, 1);
    }

    public Manager(String name, int salary, int year, int mounth, int data, double bonus) {
        super(name, salary, year, mounth, data);
        this.bonus = bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public int getSalary() {
        var salary = (double)super.getSalary();
        salary = salary * this.bonus;
        return (int)salary;
    }

    @Override
    public String toString() {
       return super.getName() + " " + super.getSalary() * this.bonus + " " + super.getDateOfEmployment();
    }
}

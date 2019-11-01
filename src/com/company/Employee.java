package com.company;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Employee {
    private String name;
    private int salary;
    private GregorianCalendar dateOfEmployment;
    private int id;
    static int iterator = 1;

    public Employee () {
        this.name = "";
        this.salary = 0;
        this.dateOfEmployment = new GregorianCalendar(1970, 1, 1);
        this.id = this.iterator;
        this.iterator++;
    }

    public Employee (String name, int salary) {
        this.name = name;
        this.salary = salary;
        this.dateOfEmployment = new GregorianCalendar(1970, 1, 1);
        this.id = this.iterator;
        this.iterator++;
    }

    public Employee (String name, int salary, int year, int mounth, int data) {
        this.name = name;
        this.salary = salary;
        this.dateOfEmployment = new GregorianCalendar(year, mounth, data);
        this.id = this.iterator;
        this.iterator++;
    }

    public String getName() {
        return this.name;
    }

    public int getSalary() {
        return this.salary;
    }

    public String getDateOfEmployment() {
        return this.dateOfEmployment.get(Calendar.DATE) + "." + this.dateOfEmployment.get(Calendar.MONTH) + "." + this.dateOfEmployment.get(Calendar.YEAR);
    }

    public long getExperienceDay() {
        Date startDate =  this.dateOfEmployment.getTime();
        Date endDate = new Date();
        long diff = endDate.getTime() - startDate.getTime();
        return (diff / (1000L*60L*60L*24L));
    }

    public long getExperienceYear() {
        GregorianCalendar endYear = new GregorianCalendar();
        return endYear.get(Calendar.YEAR) - this.dateOfEmployment.get(Calendar.YEAR);

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

//    public void setDateOfEmployment(String date) {
//       this.dateOfEmployment = date;
//    }

    public String toString() {
        return this.name + " " + this.salary + " " + this.getDateOfEmployment();
    }
}

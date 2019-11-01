package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;


class ForFrame extends JFrame {

    public ForFrame() {

        setSize(400,300);
        setTitle("Система 'Сотрудниики - Менеджеры'");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        PanelGridAddEmployee grid = new PanelGridAddEmployee();
        Container contentPanel = getContentPane();
        contentPanel.add(grid);
        pack();
    }
}

class PanelGridAddEmployee extends JPanel {
    public ArrayList<Employee> emp;
    public PanelGridAddEmployee() {
        setLayout(new GridLayout(0, 2, 10, 10));

        emp = new ArrayList<Employee>();

        JButton btnAdd = new JButton("Добавить");
        JButton btnRemove = new JButton("Удалить");


        JLabel labelName = new JLabel("ФИО");
        TextField txbName = new TextField("", 8);

        JLabel labelData = new JLabel("Дата вступления в должность");
        TextField txbData = new TextField("", 8);

        JLabel labelSalary = new JLabel("Зарплата");
        TextField txbSalary = new TextField("", 8);

        String[] position = {
                "Рабочий",
                "Менеджер"
        };

        JComboBox cmbPosition = new JComboBox(position);
        var self = this;

        DefaultListModel<Employee> model = new DefaultListModel<>();
        JList<Employee> list = new JList<Employee>(model);
        JScrollPane sp = new JScrollPane(list);
//        sp.setViewportView(list);

        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
                Calendar cal  = Calendar.getInstance();
                try {
                    cal.setTime(df.parse(txbData.getText()));
                } catch (Exception ex) {
                    System.out.println(ex);
                }

                if(cmbPosition.getSelectedItem().toString() == "Менеджер") {
                    model.addElement(new Manager(txbName.getText(), Integer.parseInt(txbSalary.getText()), cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DATE), 1.2));
                } else {
                    Employee employee = new Employee(txbName.getText(), Integer.parseInt(txbSalary.getText()), cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DATE));
                    System.out.println(employee);
                    model.addElement(employee);
                }
                self.revalidate();
            }
        });

        btnRemove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = list.getSelectedIndex();
                model.remove(id);
            }
        });

        add(labelName);
        add(txbName);
        add(labelData);
        add(txbData);
        add(labelSalary);
        add(txbSalary);
        add(new JPanel());
        add(cmbPosition);
        add(new JPanel());
        add(btnAdd);
//        add(list);
        add(sp);
        add(btnRemove);
    }
}

public class Main {

    public static void main(String[] args) {

//        Employee emp[]=new Employee[8];
//        emp[0]=new Employee("Irina Alekseeva", 43000, 2000, 11, 1);
//        emp[1]=new Employee("Oleg Olegov", 34000, 2002, 2, 14);
//        emp[2]=new Employee("Olga Kirova", 21000, 2005, 1, 1);
////      использование перегрузки конструкторов
//        emp[3]=new Employee("Anna Sorina", 4000);
//        emp[4]=new Employee("Pavel Lunin", 12000);
//        emp[5]=new Employee();
//        emp[6]=new Employee();
//        emp[7] = new Manager("Pavel Semenov",50000,2012,12,3,1.2);
//
//
//
//        //Меняем ЗП
//        for (int i=0; i<emp.length; i++) {
//            if( emp[i] instanceof Manager ) {
//                ((Manager)emp[i]).setBonus(1.6);
//            }
//            var salary = emp[0].getSalary();
//            salary = salary + 1000;
//            emp[i].setSalary(salary);
//        }
//        for (int i=0; i<emp.length; i++){
//            System.out.println(emp[i]);
//        }
//
//        System.out.println("Experiens: " + emp[0].getExperienceDay() + " days");

        ForFrame fr = new ForFrame();
        fr.setVisible(true);
    }
}

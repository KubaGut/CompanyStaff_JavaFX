package sample.dataBase;


import sample.Employee;
import sample.Main;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TextFile implements Serializable{

    Main main;

    public void exportToFile() throws IOException {
            File output = new File( "C://Users//Gutek//Desktop//CompanyStaff.txt" );
            PrintWriter pw = new PrintWriter(output);
            for(Employee p : main.getList()){
                pw.println (p.getLastName() + " " + p.getName() + " " + p.getGender() + " " +
                        p.getDepNumber() + " " + p.getSalary() + " " + p.getAge() + " " + p.getChildNumber());
            }
            pw.close();
        }

    public void exportToFileEncrypted() throws IOException {
        File output = new File( "C://Users//Gutek//Desktop//CompanyStaff.txt" );
        PrintWriter pw = new PrintWriter(output);
        List<Employee> lista = new ArrayList<Employee>();
        lista = main.getList();

        for(Employee p : lista) {
            String nazwisko = "" + p.getLastName().charAt(0);
            for (int i = 1; i < p.getLastName().length() - 1; i++){
                nazwisko += "*";
            }
            nazwisko += p.getLastName().charAt(p.getLastName().length()-1);
            pw.println (nazwisko + " " + p.getName() + " " + p.getGender() + " " +
                    p.getDepNumber() + " " + p.getSalary() + " " + p.getAge() + " " + p.getChildNumber());
        }

        pw.close();


    }

    public void setMain (Main main){
        this.main = main;
    }
}

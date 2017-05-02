package sample.dataBase;


import sample.Employee;
import sample.Main;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class HTML {

    Main main;

    public void exportToHTML() throws IOException, ClassNotFoundException{

        File outputhtml = new File( "C://Users//Gutek//Desktop//CompanyStaff.html" );
        PrintWriter pw = new PrintWriter(outputhtml);

        pw.println("<!DOCTYPE html>");
        pw.println("<html>");
        pw.println("    <head>");
        pw.println("        <meta charset="+"utf-8"+">");
        pw.println("        <title>Company</title> ");
        pw.println("    </head>");
        pw.println("<body>");
        pw.println("<table>");
        pw.println("<thead>");
        pw.println("    <tr>");
        pw.println("        <th>Nazwisko</th>");
        pw.println("        <th>Imie</th>");
        pw.println("        <th>Plec</th>");
        pw.println("        <th>Numer Dzialu</th>");
        pw.println("        <th>Placa</th>");
        pw.println("        <th>Wiek</th>");
        pw.println("    </tr>");
        pw.println("</thead>");
        pw.println("<tbody>");

        for(Employee p : main.getList()){

            pw.println("<tr>");

            pw.println("        <td>" + p.getLastName() + "</td>");
            pw.println("        <td>" + p.getName() + "</td>");
            pw.println("        <td>" + p.getGender() + "</td>");
            pw.println("        <td>" + p.getDepNumber() + "</td>");
            pw.println("        <td>" + p.getSalary() + "</td>");
            pw.println("        <td>" + p.getAge() + "</td>");

            pw.println("</tr>");
        }

        pw.println("</tbody>");
        pw.println("</table>");

        pw.close();
    }



    public void setMain (Main main){
        this.main = main;
    }
}

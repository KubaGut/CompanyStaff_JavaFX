package sample.dataBase;

import com.google.gson.Gson;
import sample.Main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class JSON {

    Main main;

    public void exportToJson() throws FileNotFoundException {
       String json = new Gson().toJson(main.getList());
        File output = new File( "C://Users//Gutek//Desktop//CompanyStaff.json" );
        PrintWriter pw = new PrintWriter(output);
        pw.println(json);
        pw.close();
    }



    public void setMain (Main main){
        this.main = main;
    }
}

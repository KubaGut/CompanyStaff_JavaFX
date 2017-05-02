package sample.dataBase;


import sample.Employee;
import sample.Main;

import java.sql.*;

import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;

public class JDBC {

    public static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    public static final String DB_URL = "jdbc:mysql://localhost/company?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    public static final String USER = "root";
    public static final String PASSWORD = "kuba";

    private static JDBC instance;
    private Connection connection;
    private PreparedStatement preparedStatement;
    private Statement statement;
    private Statement openStatement;
    Main main;


    public void JDBC() {

    }

    public static JDBC getInstance() {
            if (instance == null ){
                instance = new JDBC();
            }
        return instance;
    }

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName(JDBC_DRIVER);
        instance.connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
        return instance.connection;
    }
    public void getData() throws SQLException, ClassNotFoundException {
        statement = getConnection().createStatement();
        statement.executeUpdate("TRUNCATE employee");
        String insert = "INSERT INTO employee VALUES (? , ? , ? , ? , ? , ? , ? , ? )";
        preparedStatement = getConnection().prepareStatement(insert);

        for (Employee p : main.getList()) {
            preparedStatement.setString(1, p.getName());
            preparedStatement.setString(2, p.getLastName());
            preparedStatement.setString(3, p.getGender());
            preparedStatement.setString(4, p.getDepNumber());
            preparedStatement.setFloat(5, p.getSalary());
            preparedStatement.setInt(6, p.getAge());
            preparedStatement.setInt(7, p.getChildNumber());
            preparedStatement.setString(8, p.getMarital());
            preparedStatement.executeUpdate();
        }
        preparedStatement.close();
        getConnection().close();
    }
    public void open() throws SQLException, ClassNotFoundException {
        openStatement = getConnection().createStatement();
        ResultSet resultSet = openStatement.executeQuery("SELECT * FROM employee");

            while (resultSet.next()){
                Employee employee = new Employee(new Employee.Builder(resultSet.getString("name"), resultSet.getString("lastName"),
                        resultSet.getString("gender"),resultSet.getString("depNumber"),resultSet.getFloat("salary"),
                        resultSet.getInt("age")). childNumber(resultSet.getInt("childNumber")).marital(resultSet.getString("marital")));
                main.getList().add(employee);
            }

    }

    public void setMain (Main main){
        this.main = main;
    }

}

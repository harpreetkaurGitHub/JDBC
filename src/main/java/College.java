import java.sql.*;
import java.util.HashMap;
import java.util.Map;

import static java.sql.DriverManager.getConnection;

public class College {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_url = "jdbc:mysql://localhost:3306/college";
    static final String USER = "root";
    static final String PASS = "root";
   static  Statement  statement = null;
//   DatabaseMetaData databaseMetaData = DB_url.getMataData();

    public  void addStudent(int rollNo , String name) throws SQLException {
        statement.executeUpdate("INSERT INTO student VALUES ('"+name+"',"+rollNo+")");
        System.out.println("ADDed students into database");
    }
    public void updateStudentByName(int rollno,String name) throws SQLException {
        statement.executeUpdate("UPDATE student SET name '"+name+"' WHERE rollno = "+rollno);
        System.out.println("Updated students into database");
    }
    public void removeStudent(int rollNo) throws SQLException {
        statement.executeUpdate("DELETE FROM student WHERE rollno=" + rollNo);
        System.out.println("remove students from database");
    }
    public Map<String,Object> getALlStudentData() throws SQLException {
        ResultSet resultSet = statement.executeQuery("select * from student");
        Map<String,Object> studentMap= new HashMap<>();
        while (resultSet.next()) {
            studentMap.put(resultSet.getString("name"),resultSet.getInt("rollno"));
        }
        return studentMap;
    }
    public void addStudentContacts(int phoneno,String city,String state) throws SQLException{
        statement.executeUpdate("INSERT INTO student_contacts VALUES("+phoneno+",'"+city+"','"+state+"') ");
    }
    public void getContacts() throws SQLException {
        ResultSet resultSet = statement.executeQuery("select student.rollno , student_contacts.* FROM student INNER JOIN student_contacts ON student.rollno = student_contacts.phoneno");

        while (resultSet.next()) {
            System.out.println(resultSet.getInt("phoneno"));
            System.out.println(resultSet.getInt("rollno"));
        }
    }

    public static void main(String[] args) {
        Connection connection = null;
        try {
            connection = getConnection(DB_url,USER,PASS);
            statement = connection.createStatement();
                College college= new College();
//                college.addStudent(101,"tannu");
//                college.addStudent(102,"tannu1");
//                college.addStudent(103,"tannu2");
                HashMap<String,Object>studentMap=(HashMap<String, Object>) college.getALlStudentData();
            System.out.println(studentMap);
//                college.removeStudent(102);
//                college.addStudentContacts(101,"gurgaon","haryana");
//                college.addStudentContacts(102,"mohali","punjab");
//                college.addStudentContacts(103,"ambala","haryana");
//                college.getContacts();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        finally{
            try {
                if (connection!=null) {
                    connection.close();
                }
                if (statement!=null) {
                    statement.cancel();
                }
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

// todo 1.one to one and many,join primary key,union key,forein key,delete students

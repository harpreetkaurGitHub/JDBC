package AccountCRUDoperations;

import java.sql.*;

public class CleanUpTheJDBC {
    public static void main(String[] args) {
        try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/mydb","harpreet","00000000");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from account");
        ){
            System.out.println(connection);

            // create the account
            int result = statement.executeUpdate("insert into account values(1,'harpreet','kaur',100000)");
            System.out.println(result + "rows got inserted into table");

            // update the account
//            int result = statement.executeUpdate("update account set bal=500000 where accno=1");
//            System.out.println(result+" rows got updated");

            // delete my account
//            int result = statement.executeUpdate("delete from account where accno=1");
//            System.out.println(result + " rows got deleted");

            // read the data
            while (resultSet.next()){

                System.out.println(resultSet.getInt(1));
                System.out.println(resultSet.getString(2));
                System.out.println(resultSet.getString(3));
                System.out.println(resultSet.getInt(4));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        // when you declare connection in try block you id not need to close the connection jvm atomatically close it!!!
        finally {
            // still if you want to do it you can do here
        }
    }
}

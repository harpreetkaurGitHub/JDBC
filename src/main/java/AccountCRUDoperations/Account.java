package AccountCRUDoperations;
import java.sql.*;

public class Account {
    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/mydb","harpreet","00000000");
            System.out.println(connection);
            Statement statement = connection.createStatement();

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
            ResultSet resultSet = statement.executeQuery("select * from account");
            while (resultSet.next()){

                System.out.println(resultSet.getInt(1));
                System.out.println(resultSet.getString(2));
                System.out.println(resultSet.getString(3));
                System.out.println(resultSet.getInt(4));

//                String firstname = resultSet.getString("firstname");
//                String lastname = resultSet.getString("lastname");
//                int account_no = resultSet.getInt("accno");
//                int balance = resultSet.getInt("bal");
//
//                System.out.println(firstname + lastname + account_no + balance);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

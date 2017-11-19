import java.sql.*;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String url = "jdbc:mysql://192.168.51.6:3306/atschool101"; //строка подключения
        String login = "*";
        String password = "*";

        Class.forName("com.mysql.jdbc.Driver"); // драйвер, который будет использоваться.
        Connection connection = DriverManager.getConnection(url, login, password); //соединяемся с БД

        //получаем Statement
//        Statement st = connection.createStatement();
        //Выполняем запрос. Используем метод execute, поскольку никаких данных в ответ мы не получаем
//        st.execute("CREATE TABLE peoples (id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, login VARCHAR(255), password VARCHAR(255), description VARCHAR(255))");

        //Предварительно скомпилированный запрос, на месте будущих данных placeholders (знаки вопроса)
//        PreparedStatement ps = connection.prepareStatement("INSERT INTO peoples (`login`, `password`, `description`) VALUES (?, ?, ?)");
        //устанавливаем конкретные данные на места placeholder'ов
//        ps.setString(1, "user");
//        ps.setString(2, "user");
//        ps.setString(3, "учетная запись пользователя");
//        ps.execute(); // выплняем запрос.
//
        //переиспользуем наш предварительно скомпилированный запрос
//        ps.setString(1, "admin");
//        ps.setString(2, "admin");
//        ps.setString(3, "учетная запись администратора");
//        ps.execute();

        Statement st = connection.createStatement();
        //поскольку нам нужен результат, используем executeQuery
        ResultSet rs = st.executeQuery("SELECT * FROM peoples");

        while (rs.next()) {//двигаем указатель набора результатов на 1 строку вниз
            System.out.println("Запись №" + rs.getRow() +
                    "\nlogin: " + rs.getString("login") +
                    "\npassword: " + rs.getString("password") +
                    "\ndescription: " + rs.getString("description"));
        }

    }
}

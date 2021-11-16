package jdbcsample;

import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/lab1", "root", "root");
            Statement statement = connection.createStatement();
            System.out.println("SELECT");
            System.out.println("Введите название фильма:");
            String film_name = scanner.nextLine();
            PreparedStatement prepareStatement = connection.prepareStatement("SELECT * FROM film WHERE name = ?");
            prepareStatement.setString(1,film_name);
            ResultSet resultSet = prepareStatement.executeQuery();

            while (resultSet.next()) {

                System.out.println("id: " + resultSet.getInt(1)+";" + " " + "name: " + resultSet.getString(2)+";" + " " + "genre: " + resultSet.getString(3)+";" + " " + "price: " +
                        resultSet.getInt(4)+";" + " " + "age_limit: " + resultSet.getInt(5)+";" + " " + "availability_of_3D: " +  resultSet.getInt(6)+";" + " " +  "duration: " + resultSet.getString(7)+";");
            }

            System.out.println("INSERT");

            System.out.println("Введите название фильма:");
            String film_nam = scanner.nextLine();

            System.out.println("Введите жанр фильма:");
            String film_genre = scanner.nextLine();

            System.out.println("Введите стоимость посещения фильма:");
            int film_price = scanner.nextInt();

            System.out.println("Введите возрастное ограничение фильма:");
            int film_age_limit = scanner.nextInt();

            System.out.println("Будет ли ваш фильм показываться в 3D? Введите 0, если нет. Если да, то - 1:");
            int film_availability_of_3D = scanner.nextInt();

            scanner.nextLine();

            System.out.println("Введите длительность фильма:");
            String film_duration = scanner.nextLine();

            PreparedStatement prepareStatement1 = connection.prepareStatement("INSERT INTO film VALUES (NUll,?,?,?,?,?,?)");

            prepareStatement1.setString(1,film_nam);
            prepareStatement1.setString(2,film_genre);
            prepareStatement1.setInt(3,film_price);
            prepareStatement1.setInt(4,film_age_limit);
            prepareStatement1.setInt(5,film_availability_of_3D);
            prepareStatement1.setString(6,film_duration);

            prepareStatement1.executeUpdate();

            System.out.println("DELETE");
            System.out.println("Введите дату сеанса:");
            String session_date = scanner.nextLine();
            PreparedStatement prepareStatement2 = connection.prepareStatement("DELETE FROM session WHERE session_date = ?");
            prepareStatement2.setString(1,session_date);
            prepareStatement2.executeUpdate();

            System.out.println("UPDATE");
            System.out.println("Введите время сеанса, которое хотите установить:");
            String session_time = scanner.nextLine();
            System.out.println("Введите id сеанса, для которого вы хотите изменить время:");
            String session_id = scanner.nextLine();
            PreparedStatement prepareStatement3 = connection.prepareStatement("UPDATE session SET session_time = ? WHERE session.id = ?");
            prepareStatement3.setString(1,session_time);
            prepareStatement3.setString(2,session_id);
            prepareStatement3.executeUpdate();
        }
                catch (Exception e){
            e.printStackTrace();

        }
    }
}

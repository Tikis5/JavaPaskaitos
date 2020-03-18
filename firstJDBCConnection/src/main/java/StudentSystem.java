import data.Student;
import jdbc.JDBCConnector;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentSystem {
    public static void main(String[] args) {
        StudentSystem system = new StudentSystem();
        Scanner scanner = new Scanner(System.in);
        int select;
        do {
            System.out.println(" __________________________");
            System.out.println("| 1. Ivesti nauja studenta |");
            System.out.println("| 2. Print all students    |");
            System.out.println("| 0. Pabaiga               |");
            System.out.println("|__________________________|");
            select = scanner.nextInt();

            switch (select){
                case 1:
                    system.createNewStudent(scanner);
                    break;
                case 2:
                    system.printStudents();
                    break;
                case 0:
                    System.out.println("sistema baigia darba");
                    break;
                default:
                    System.out.println("nera tokio veiksmo");
                    break;
            }
        }
        while (select != 0);
    }
    private void printStudents(){
        List<Student> students = new ArrayList<>();

        try {
            //1
            JDBCConnector jdbcConnector = new JDBCConnector();
            Connection connect = jdbcConnector.connect();
            if(connect == null){
                return;
            }
            //2
            Statement statement = connect.createStatement();
            //3
            ResultSet resultSet = statement.executeQuery("select * from students");
            while (resultSet.next()) {
                students.add(new Student(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("surname"),
                        resultSet.getString("phone"),
                        resultSet.getString("email")));
            }
        }
        catch (SQLException e){
            System.out.println("SQL Exeption");
        }

        students.forEach(System.out::println);
        /*if (students != null) {
        students.forEach(s ->{
            //System.out.println(s.getId());
            System.out.println(s.getId() + " " + s.getName()+ " " + s.getSurname()+ " " + s.getPhone()+ " " + s.getEmail());
        });
        }
        else {
            System.out.println("Studentu nera");
        }*/
    }
    private void createNewStudent(Scanner scanner){
        System.out.println("Iveskite studento varda");
        String name = scanner.next();
        System.out.println("iveskite Sstudento pavarde");
        String surname = scanner.next();
        System.out.println("Iveskite studento telefona");
        String phone = scanner.next();
        System.out.println("Iveskite studento pasto adresa");
        String email = scanner.next();

        JDBCConnector connector = new JDBCConnector();
        Connection connect = connector.connect();

        if (connect == null){
            System.out.println("cannot create student");
            return;
        }
        try{
            PreparedStatement statement = connect.prepareStatement("insert into students(name, surname, phone, email)values(?, ?, ?,?)");
            statement.setString(1, name);
            statement.setString(2, surname);
            statement.setString(3, phone);
            statement.setString(4, email);

            statement.execute();
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}

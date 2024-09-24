package controller;

import java.sql.*;  // Using 'Connection', 'Statement' and 'ResultSet' classes in java.sql package
import model.Food;

public class DBConnection {

    public boolean insertNewFood(Food food) {
        boolean result = false;
        Connection connection = null;
        Statement statement = null;
        try {
            // below two lines are used for connectivity.
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/lab07_db",
                    "root", "");

            
            statement = connection.createStatement();

            // สร้าง String nutrient ที่มีค่าสารอาหารต่าง ๆ คั่นด้วย ;
//            String nutrient = "";
//            int nl = food.getNutrient().length;
            
            // วนลูปสร้างแค่ food.getNutrient().length ลบ 1 เพื่อไม่ให้มี ; ปิดท้าย String
//            for(int i=0; i < nl - 1; i++){
//                nutrient = nutrient + food.getNutrient()[i] + ";";
//            }
            // เพิ่มค่า nutrient ตำแหน่งสุดท้ายเข้าไป
//            nutrient = nutrient + food.getNutrient()[nl-1];
            
String query = "INSERT INTO food "
                    + "(food_id, food_name,food_type,food_price) "
                    + "VALUES(' " + food.getId() + " ', "
                    +" ' " + food.getName() + " ',  "
                    +" ' " + food.getType()+ " ',  "
                     +" ' " + food.getPrice() +" ') "+"ON DUPLICATE KEY UPDATE food_name =VALUES(food_name),food_type =VALUES(food_type),food_price=VALUES(food_price)"; 

    System.out.println("........SQL: " + query);

 int i = statement.executeUpdate(query);
            if (i != 0) {
                result = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // ปิด statement และ connection
            try {
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;

    }

   
}

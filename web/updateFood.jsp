<%-- 
    Document   : updateFood
    Created on : Jul 18, 2024, 12:04:00 PM
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Food" %>
<!DOCTYPE html>
<html>
    <body>
        <% Food food = (Food) session.getAttribute("food");%>
        <p>แก้ไขข้อมูลอาหาร</p>
        <form action="AddNewFoodServlet">
           ชื่อ :<input type="text" name="food_name" value="<%= food.getName()%>"><br/>
            ID: <input type="text" name="food_id" value="<%=food.getId()%>"><br/>
            ประเภท : <input type="text" name="food_type" value="<%=food.getType()%>"><br/>
             ราคา :<input type="text" name="food_price" value="<%=food.getPrice()%>"><br/>
            
            <input type="submit" value="แก้ไข">            
        </form>
        <% session.removeAttribute("food"); %>
    </body>
</html>

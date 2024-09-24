<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Food" %>
<!DOCTYPE html>
<html>
    <body>
        <!-- get session object movie -->
        <% Food food = (Food) session.getAttribute("food");%>
        <p>อาหารที่เพิ่มได้แล้ว</p>
        id: <%=food.getId() %><br/>
        ชื่อ: <%= food.getName() %><br/>
        ราคา: <%=food.getPrice() %><br/>
        ประเภท: <%=food.getType() %><br/>
        <a href="updateFood.jsp"> แก้ไขข้อมูลอาหาร</a>
        <!-- ปุ่มกลับไปยังหน้า AddNewFood.html -->
<!--        <a href="AddNewFood.html">-->
<!--         <button type="button">กลับไปยังหน้าเพิ่มอาหาร</button>-->
        </a>
    </body>
</html>

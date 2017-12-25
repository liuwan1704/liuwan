<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改酒店信息</title>
</head>
<body>
 ${hotel }
<form action="updateHotel" method="post">
	<input type="hidden" name="hid" value="${hotel.hid }"/><br/>
	酒店名称:<input type="text" name="name" value="${hotel.name }"/><br/>
	联系方式:<input type="text" name="contact" value="${hotel.contact }"/><br/>
	酒店地址:<input type="text" name="address" value="${hotel.address }"/><br/>
	酒店特色:<input type="text" name="feature" value="${hotel.feature }"/><br/>
	酒店星级:<input type="text" name="level" value="${hotel.level }"/><br/>
	酒店服务:<input type="text" name="serverDesc" value="${hotel.serverDesc }"/><br/>
	服务时间:<input type="text" name="intime" value="${hotel.intime }"/>
	<input type="text" name="outtime" value="${hotel.outtime }"/><br/>
	<input type="submit" value="提交"/>
	<input type="reset" value="重置"/>
</form>
</body>
</html>
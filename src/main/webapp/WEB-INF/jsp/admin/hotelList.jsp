<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="./css/public.css">
<link rel="stylesheet" href="./css/hotelList.css">
<title>酒店列表</title>
</head>
<body>
<div class="wrap">
		<div class="header">
			<div class="con">
				<!-- 头部内容 -->
				<div class="con1">
					<!-- 其他内容 -->
						<div class="search">
						<input type="text" name="" value="">
						<a href="javascript:;"></a>			
						</div>
						<span class="xl"><a href="#">行李箱</a></span>
						<span class="dc"><a href="#">注册</a></span>	
						<span class="dc"><a href="#">登陆</a></span>
						<span class="DH">400-820-8820</span>
						<span class="DH2"></span>	
				</div>
				<div class="con2">
						<span class="consy"><a class="shouye" href="<% request.getContextPath();%>getHotels?pageNum=1"></a></span>
						<span class="con20"><a href="addHotel">添加酒店</a></span>
				</div>
			</div>
		</div>
		<div id="content">
			<c:forEach	items="${hotels }" var="s">
				<div class="Hotel_Detail">
				<div class="hotel_pics">
					<img src="${s.hotelPics[0].picPath }" alt="${s.name }">
				</div>
				<div class="hotel_msg">
					<p class="hotel_name">${s.name }</p>
					<div class="msg_bottom">
						<div class="msg_left">
							<p class="level">酒店星级:</p>
							<p class="level">联系方式:</p>
							<p class="level">酒店地址:</p>
							<p class="level">房间特色:</p>
							<p class="level">酒店服务:</p>
							<p class="level">服务时间:</p>
						</div>
						<div class="msg_mid">
							<p class="level_msg">${s.level }星</p>
							<p class="level_msg">${s.contact }</p>
							<p class="level_msg">${s.address }</p>
							<p class="level_msg">${s.feature }</p>
							<p class="level_msg">${s.serverDesc }</p>
							<p class="level_msg">${s.intime }--${s.outtime }</p>
						</div>
						<div class="msg_right">
							<a class="hotel_handel" href="getAllHouse?hid=${s.hid }">详情</a>
							<a class="hotel_handel" href="getHotel?hid=${s.hid }&pageNum=${pageNum}">修改</a>
							<a class="hotel_handel" href="deleteHotel?hid=${s.hid }&pageNum=${pageNum}">删除</a>
						</div>
					</div>
				</div>
			</div>
			<hr/>
			<div id="allPics">
				<c:forEach items="${s.hotelPics }" var="pic">
					<div class="hotelPicture"><img alt="酒店图片" src="${pic.picPath }"><a class="deletePic" href="deleteAHotelPicByPath?picPath=${pic.picPath}&pageNum=${pageNum }&hid=${s.hid}">删除</a></div>
				</c:forEach>
				<a class="addHotelPic" href="toAddHotelPic?hid=${s.hid }">添加图片</a>
			</div>
			<hr/>
			</c:forEach>
		</div>
		<hr/>
		<center id="cent">
			<a href="<% request.getContextPath();%>getHotels?pageNum=1">首页</a>&nbsp;&nbsp;
			<c:if test="${pageNum == 1 }">
				上一页&nbsp;&nbsp;
			</c:if>
			<c:if test="${pageNum != 1 }">
				<a href="<% request.getContextPath();%>getHotels?pageNum=${pageNum-1 }">上一页</a>&nbsp;&nbsp;
			</c:if>
			
			<c:if test="${pageNum == pageMax }">
				下一页&nbsp;&nbsp;
			</c:if>
			<c:if test="${pageNum != pageMax }">
				<a href="<% request.getContextPath();%>getHotels?pageNum=${pageNum+1 }">下一页</a>&nbsp;&nbsp;
			</c:if>
			<a href="<% request.getContextPath();%>getHotels?pageNum=${pageMax }">尾页</a><br/><br/>
		</center>
		<div class="footer">
			<div class="con1">
			<div>
				<ul>
					<li class="list">
						<ul style="margin:0 0 0 40px;">
							<li><h3><a href="#">关于遛弯</a></h3></li>
							<li><a href="3">公司简介</a></li>
							<li><a href="#">联系我们</a></li>
							<li><a href="#">诚聘英才</a></li>
							<li><a href="#">网站地图</a></li>
						</ul>
					</li>
					<li class="list">
						<ul>
							 <li><h3><a href="">帮助中心</a></h3></li>
							 <li><a href="">赴台手续</a></li>				
							 <li><a href="">遛弯玩法</a></li>				
							 <li><a href="">常见问题</a></li>							
						</ul>
					</li>
					<li class="list">
						<ul>
							<li><h3><a href="">网站条款</a></h3></li>
							<li><a href="">服务条款</a></li>
							<li><a href="">免责声明</a></li>
						</ul>
					</li>
					<li class="list">
						<ul>
							<li><h3><a href="">关注我们</a></h3></li>
							<li style="margin-top:15px;"><span><img src="./img/pageimg/VB.png" alt="微博">&nbsp;&nbsp;<img src="./img/pageimg/VX.png" alt="微信"></span></li>
						</ul>
					</li>
					<li class="list">
						<ul>
							<li><h3><strong>400&nbsp;820&nbsp;8820</strong></h3></li>
							<li>周一至周日</li>
							<li>9:00~20:00</li>
							<li class="zixun"></li>
						</ul>
					</li>
				</ul>
				</div>
				<!-- 底部内容 -->
			</div>
			<div class="con2">Copyright © 2013-2014 www.6waner.cn All Right Reserved. 京ICP备11</div>
		</div>
	</div>
</body>
</html>
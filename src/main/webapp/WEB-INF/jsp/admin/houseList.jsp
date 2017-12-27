<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="./css/public.css">
<link rel="stylesheet" href="./css/houseList.css">
<title>房间列表</title>
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
					<span class="consy"><a class="shouye" href="#"></a></span>
					<span class="con20"><a href="addHotel">添加酒店</a></span>
					<span class="con20"><a href="addHouse?hid=${hid }">添加房间</a></span>
				</div>
			</div>
		</div>
		<div class="banner"></div>
		<div id="content">
			<!-- 主要内容 -->			
			<ol id="title">
				<li class="picture"></li>
				<li class="house_msg">城市</li>
				<li class="house_msg">房间面积</li>
				<li class="house_msg">楼层</li>
				<li class="house_msg">是否无烟</li>
				<li class="house_msg">可居住人数</li>
				<li class="house_msg">价格</li>
				<li class="house_msg"></li>
				<li class="house_msg"></li>
			</ol>
			<c:forEach	items="${hotelPrices }" var="house">
				<ol class="house_message">
					<li class="house_pic"><a id="changePic" href="changeHousePic?hid=${hid }&housepid=${house.hpid }&picPath=${house.housePic[0].picPath}">修改</a><img class="photo" src="${house.housePic[0].picPath }" alt="酒店图片"></li>
					<li class="message_house">${house.province.cityName }</li>
					<li class="message_house">${house.area }</li>
					<li class="message_house">${house.floor }</li>
					<li class="message_house">${house.smoke }</li>
					<li class="message_house">${house.peomax }</li>
					<li class="message_house">${house.price }</li>
					<li class="house_btnnn">
						<a class="bbbtn" href="updateHouseMsg?hpid=${house.hpid }&hid=${hid}">修改</a>
					</li>
					<li class="house_btnnn">
						<a class="bbbtn" href="deleteHouse?hpid=${house.hpid }&hid=${hid}">删除</a>
					</li>
				</ol>
			</c:forEach>
		</div>
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
							 <li><a href=""赴台手续></a></li>				
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
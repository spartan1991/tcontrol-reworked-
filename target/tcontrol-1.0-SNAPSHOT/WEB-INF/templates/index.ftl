<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>TControl</title>
	<link rel="stylesheet" href="resources/css/index.style.css">
	<link href="https://fonts.googleapis.com/css?family=Raleway&display=swap" rel="stylesheet">
	<style type="text/css">
		.cwdtable {font-size:20px;color:#333333;width:100%;border-width: 1px;border-color: #729ea5;border-collapse: collapse;}
		.cwdtable th {font-size:20px;background:#d7ecef;border-width: 1px;padding: 8px;border-style: solid;border-color: #729ea5}
		.cwdtable tr {background:#f3f8f8;}
		.cwdtable td {font-size:20px;border-width: 2px;padding: 8px;border-style: solid;border-color: #729ea5;}
		.cwdtable th,.cwdtable td{text-align:center}
		.cwdtable tr:hover {background:#f1f4f4;}
	</style>

</head>
<body>
<header>
	<div class="topPanel">
		<div class="logo">
			<a href="/tcontrol_war_exploded/">
				<img class="graphiclogo" src="resources/img/logo/TConLogo1.png" width="50%" height="auto%" alt="Logo">
			</a>
		</div>

		<div class="authorization">
			<div class="loginText">
				<p><strong>Login:</strong>
				<p><strong>Password:</strong>
			</div>
			<div class="loginFields">
				<input maxlength="30" name="login"></p>
				<input type="password" maxlength="30" name="password"></p>
			</div>
		</div>
	</div>

	<nav>
		<div class="topnav" id="myTopnav">
			<a href="/tcontrol_war_exploded/">HOME</a>   <!--projects.html-->
			<a href="/tcontrol_war_exploded/graphics">GRAPHICS</a>   <!--projects.html-->
			<a href="#">SERVICE</a>   <!--services.html-->
			<a href="/tcontrol_war_exploded/addData">ADD(DATA)</a>   <!--contacts.html-->
			<a href="/tcontrol_war_exploded/authorization">AUTHORIZATION</a>         <!--about.html-->
			<a href="/tcontrol_war_exploded/registration">REGISTRATION</a>   <!--location.html-->
		</div>
	</nav>
</header>

<div>
	<ul class="datas">
		<div class="mobileTable">
			<table class="cwdtable" cellspacing="0" cellpadding="1" border="1">
				<thead>
				<tr>
					<th>Measurement ID</th>
					<th>Sensor-1</th>
					<th>Sensor-2</th>
					<th>Sensor-3</th>
				</tr>
				</thead>
				<tbody>
				<#list datas as data>
					<tr>
						<td>${data.getId()} </td>
<#--						<td>${data.getSensor1()} </td>-->
<#--						<td>${data.getSensor2()} </td>-->
<#--						<td>${data.getSensor3()} </td>-->

						<td><#if data.getSensor1()??>${data.getSensor1()}<#else>0</#if></td>
						<td><#if data.getSensor2()??>${data.getSensor2()}<#else>0</#if></td>
						<td><#if data.getSensor3()??>${data.getSensor3()}<#else>0</#if></td>
					</tr>
				</#list>
				</tbody>
			</table>
		</div>

	</ul>
</div>

<script src="resources/js/script.js"></script>
</body>
</html>
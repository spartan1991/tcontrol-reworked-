<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>TControl | Graphics</title>
    <link rel="stylesheet" href="resources/css/index.style.css">
    <link href="https://fonts.googleapis.com/css?family=Raleway&display=swap" rel="stylesheet">
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
            <!--<button type="submit">Submit</button>-->
        </div>
    </div>

    <nav>
        <div class="topnav" id="myTopnav">
            <a href="/tcontrol_war_exploded/">HOME</a>   <!--projects.html-->
            <a href="/tcontrol_war_exploded/graphics">GRAPHICS</a>   <!--projects.html-->
            <a href="#">SERVICE</a>   <!--services.html-->
            <a href="/tcontrol_war_exploded/addData">ADD(DATA)</a>   <!--contacts.html-->
            <a href="/tcontrol_war_exploded/authentication">AUTHORIZATION</a>         <!--about.html-->
            <a href="/tcontrol_war_exploded/registration">REGISTRATION</a>   <!--location.html-->
        </div>
    </nav>
</header>

<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<script type="text/javascript">
    google.charts.load('current', {'packages':['corechart']});
    google.charts.setOnLoadCallback(drawChart);

    function drawChart() {
        var data = google.visualization.arrayToDataTable([
            ['Time', 'Sensor-1', 'Sensor-2', 'Sensor-3'],
            <#list datas as data>
            ['',
                <#if data.getSensor1()??>${data.getSensor1()}<#else>0</#if>,
                <#if data.getSensor2()??>${data.getSensor2()}<#else>0</#if>,
                <#if data.getSensor3()??>${data.getSensor3()}<#else>0</#if>],
            </#list>
        ]);

        var options = {
            title: 'Diagram: Device-1',
            hAxis: {title: 'Time',  titleTextStyle: {color: '#333'}},
            vAxis: {minValue: 0},
            //backgroundColor: { fill:'transparent' }
        };

        var chart = new google.visualization.AreaChart(document.getElementById('chart_div'));
        chart.draw(data, options);
    }
</script>
<div id="chart_div" style="width: 90%; height: 500px; margin-right: auto; margin-left: auto;"></div>

<script src="resources/js/script.js"></script>
</body>
</html>
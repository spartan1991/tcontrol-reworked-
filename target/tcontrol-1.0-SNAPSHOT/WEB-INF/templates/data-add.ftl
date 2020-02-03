<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>product-add</title>
    <link rel="stylesheet" href="resources/css/data-add-style.css">
    <script type="text/javascript">
        function getFilename()
        {
            var theImg = document.getElementById('theImg');
            return theImg.value;
        }
    </script>
</head>
<body>

<div class="form-wrap">
    <div class="profile"><img src="resources/img/logo/sensor.png" width="100%" height="auto%" alt="Logo">
        <h1>Add temperature data</h1>
    </div>
    <form method="post" action="saveData" method="post" modelAttribute="data" enctype="multipart/form-data">

        <div class="device">
            <label for="device">Device</label>
            <input type="text" name="device" required>
        </div>

        <div class="sensor1">
            <label for="sensor1">Sensor-1</label>
            <input type="text" name="sensor1" required>
        </div>

        <div class="sensor2">
            <label for="sensor2">Sensor-2</label>
            <input type="text" name="sensor2" required>
        </div>

        <div class="sensor3">
            <label for="sensor3">Sensor-3</label>
            <input type="text" name="sensor3" required>
        </div>

        <button type="submit">Submit</button>
    </form>
</div>

</body>
</html>
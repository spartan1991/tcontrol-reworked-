<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>authorization</title>
    <link rel="stylesheet" href="resources/css/registration.form.style.css">
</head>
<body>

<div class="form-wrap">
    <div class="profile"><img src="resources/img/profilelogo/login.png" width="80%" height="auto%" alt="Logo">
        <h1>Authorization</h1>
    </div>
    <form method="post" action="saveUser" method="post" modelAttribute="user">
        <div>
            <label for="login">Login</label>
            <input type="text" name="login" required>
        </div>

<#--        <div>-->
<#--            <label for="email">E-mail</label>-->
<#--            <input type="email" name="email" required>-->
<#--        </div>-->

        <div>
            <label for="password">Password</label>
            <input type="password" name="password" required>
        </div>

        <button type="submit">Submit</button>
    </form>
</div>

</body>
</html>
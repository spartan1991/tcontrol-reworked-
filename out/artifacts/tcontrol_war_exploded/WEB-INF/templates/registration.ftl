<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>registration</title>
    <link rel="stylesheet" href="resources/css/registration.form.style.css">
</head>
<body>

<div class="form-wrap">
    <div class="profile"><img src="resources/img/profilelogo/male.png" width="80%" height="auto%" alt="Logo">
        <h1>Registration</h1>
    </div>
    <form method="post" action="saveUser" method="post" modelAttribute="user">
        <div>
            <label for="login">Login</label>
            <input type="text" name="login" required>
        </div>

        <div>
            <label for="email">E-mail</label>
            <input type="email" name="email" required>
        </div>

        <div>
            <label for="password">Password</label>
            <input type="password" name="password" required>
        </div>

        <div>
            <label for="repassword">Confirm password</label>
            <input type="password" required>
        </div>

        <div>
            <label for="country">Country</label>
            <select name="country">
                <option>Please select your country</option>
                <option value="Russia">Russia</option>
                <option value="Ukraine">Ukraine</option>
                <option value="Belarus">Belarus</option>
            </select>

            <div class="select-arrow"></div>
        </div>
        <button type="submit">Submit</button>
    </form>
</div>

</body>
</html>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>JavaWeb</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <script>
        function createUser() {
            var userName = document.getElementById("user_name").value;
            var userAge = document.getElementById("user_age").value;

            var xmlhttp = new XMLHttpRequest();   // new HttpRequest instance
            xmlhttp.open("POST", "http://localhost:8081/index/save");
            xmlhttp.setRequestHeader("Content-Type", "application/json");
            xmlhttp.send(JSON.stringify({name: userName, age: userAge}));

            loadUsers();
        }
        function loadUsers() {
            var xhttp = new XMLHttpRequest();
            xhttp.onreadystatechange = function () {
                if (this.readyState == 4 && this.status == 200) {
                    var users = JSON.parse(this.responseText);
                    var html = '<tr>\n' +
                        '        <th>User id</th>\n' +
                        '        <th>User name</th>\n' +
                        '        <th>User age</th>\n' +
                        '    </tr>';
                    for (var i = 0; i < users.length; i++) {
                        var user = users[i];
                        console.log(user);
                        html = html + '<tr><td>' + user.id + '</td>\n' +
                            '        <td>' + user.name + '</td>\n' +
                            '        <td>' + user.age + '</td>\n'
                    }
                    document.getElementById("usersList").innerHTML = html;
                }
            };
            xhttp.open("GET", "http://localhost:8081/index/findAll", true);
            xhttp.send();
        }
        loadUsers();
    </script>
</head>
<body class="w3-light-grey">
<div class="w3-container w3-blue-grey w3-opacity w3-right-align">
    <h1>Super app!</h1>
</div>

<div class="w3-container w3-center">
    <div class="w3-bar w3-padding-large w3-padding-24">
        <button class="w3-btn w3-hover-light-blue w3-round-large" onclick="location.href='/list'">List users</button>
        <button class="w3-btn w3-hover-green w3-round-large" onclick="location.href='/add'">Add user</button>
    </div>
    <div>
        <table id="usersList" onload="loadUsers()">
        </table>
        <form action="javascript:createUser()">
            <input id="user_name" placeholder="User name">
            <input id="user_age" placeholder="User age">
            <input type="submit"  >Create user</input>
        </form>
    </div>
</div>
</body>
</html>
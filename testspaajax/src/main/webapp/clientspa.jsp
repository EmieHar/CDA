<%--
  Created by IntelliJ IDEA.
  User: boede
  Date: 14/06/2024
  Time: 09:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>axios with jsp</title>
    <script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
    <script>
        function fetchData() {
        axios.get("ApiServlet")
            .then(function (response) {
                console.log(response.data);
                document.getElementById('result').innerText = JSON.stringify(response.data,null,2);
            })
            .catch(function(error){
                console.error(error);
                document.getElementById('result').innerText= 'Error:' + error;
            })

    }

    </script>
</head>
<body>

</body>
</html>

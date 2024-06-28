<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
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
<button onclick="fetchData()">fetch data</button>
<pre id="result"></pre>
<h1><%= "Hello World!" %>
</h1>
<br/>
<a href="hello-servlet">Hello Servlet</a>
</body>
</html>
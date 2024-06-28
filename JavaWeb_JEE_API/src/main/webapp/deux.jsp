<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Axios avec JSP</title>
    <script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
    <script>
        function fetchData(){
            axios.get("apiServlet")
                .then(function (response){
                    console.log(response.data);
                    document.getElementById('result').innerText = JSON.stringify(response.data,null,2);
                })
                .catch(function(error){
                console.log(error);
                document.getElementById('result').innerText = 'Error: ' + error;
                })
        }
    </script>
</head>
<body>
<h1><%= "Test Axios" %></h1>
<br/>
<button onclick="fetchData()">Fetch Data</button>
<pre id="result"></pre>

<a href="hello-servlet">Hello Servlet</a>
</body>
</html>
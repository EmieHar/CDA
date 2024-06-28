package org.example.javaweb_jee_api;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.json.stream.JsonGenerationException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "apiServlet", value = "/apiServlet")
public class ApiServlet extends HttpServlet {
    private String message;
    public void init(){ message = "Hello World!"; }
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("application/json");

        PrintWriter out = res.getWriter();
//        String dataJson1 = "{ \"nom\": \"smith \",\"prenom\": \"John\" }";
//        out.print(dataJson1);
//        Map<String, Object> map = new HashMap<>();
//// Convert a map having list of values.
//        String[] value1 = new String[] { "value11", "value12", "value13" };
//        String[] value2 = new String[] { "value21", "value22", "value23" };
//        map.put("key1", value1);
//        map.put("key2", value2);
//          String datajson2 = new ObjectMapper().writeValueAsString(map);
//        out.print(datajson2);

        User u = new User("sample", "User", "sample@user.com");

        ObjectMapper mapper = new ObjectMapper();
        try{
            String datajson3 = mapper.writeValueAsString(u);
            out.print(datajson3);
        }catch (JsonGenerationException | JsonMappingException e){
            e.printStackTrace();
        }
    }

    public void destroy(){

    }
}


package org.example.filtre_servlet.controler;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import org.example.filtre_servlet.model.Product;
import org.example.filtre_servlet.model.dao.ProduitDAO;
import org.example.filtre_servlet.model.dao.UserDAO;
import org.example.filtre_servlet.model.User;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "listproducts", value = "/listProducts")
public class ListProductsServlet extends HttpServlet {
    private ProduitDAO productDAO = new ProduitDAO();
    private UserDAO userDAO = new UserDAO();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        List<Product> products = productDAO.getProducts();
        session.setAttribute("products", products);

        String contextPath = request.getContextPath();
        User user = (User) session.getAttribute("user");

        if (user != null) {
            if (user.getRole().equals("USER")) {
                userDAO.createCartIfNotExists(user);
                response.sendRedirect(contextPath + "/products/listProducts.jsp");
            } else if (user.getRole().equals("ADMIN")) {
                response.sendRedirect(contextPath + "/admin/adminProducts.jsp");
            }
        } else {
            response.sendRedirect(contextPath + "/err.jsp");
        }
    }
}

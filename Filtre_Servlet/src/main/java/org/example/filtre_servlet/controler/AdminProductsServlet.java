package org.example.filtre_servlet.controler;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.filtre_servlet.model.Product;
import org.example.filtre_servlet.model.dao.ProduitDAO;
import org.example.filtre_servlet.model.User;

import java.io.IOException;
import java.util.List;

@WebServlet("/adminProducts/*")
public class AdminProductsServlet extends HttpServlet {
    private ProduitDAO produitDAO = new ProduitDAO();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getPathInfo(); // Utiliser getPathInfo() pour récupérer l'action
        HttpSession session = request.getSession();

        switch (action) {
            case "/createProduct":
                String nomProduct = request.getParameter("nomProduit");
                String description = request.getParameter("description");
                String photo = request.getParameter("photo");
                float prix = Float.parseFloat(request.getParameter("prix"));
                int stock = Integer.parseInt(request.getParameter("stock"));

                Product product = new Product(nomProduct, description, photo, prix, stock);
                boolean isCreated = produitDAO.createProduct(product);

                session.setAttribute("success", isCreated);
                response.sendRedirect(request.getContextPath() + "/admin/adminProducts.jsp");
                break;

            case "/modifyProduct":

                int id = Integer.parseInt(request.getParameter("productId"));
                String newName = request.getParameter("modifNomProduit");
                String newDescription = request.getParameter("modifDescription");
                String newPhoto = request.getParameter("modifPhoto");
                Float newPrix = Float.parseFloat(request.getParameter("modifPrix"));
                int newStock = Integer.parseInt(request.getParameter("modifStock"));

                Product selectedProduct = produitDAO.getProductById(id);
                Product updateProduct = new Product(newName, newDescription, newPhoto, newPrix, newStock);

                boolean isupdated = produitDAO.updateProduct(updateProduct,selectedProduct);

               session.setAttribute("successUpdate", isupdated);

                response.sendRedirect(request.getContextPath() + "/admin/adminProducts.jsp");
                break;

            case "/supprProduct":
                int idSelected = Integer.parseInt(request.getParameter("productId"));
                boolean isDeleted = produitDAO.deleteProduct(idSelected);
                session.setAttribute("successDelete", isDeleted);
                response.sendRedirect(request.getContextPath() + "/admin/adminProducts.jsp");
                break;

            default:
                response.sendRedirect(request.getContextPath() + "/admin/adminProducts.jsp");
                break;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        List<Product> products = produitDAO.getProducts();

        session.setAttribute("products", products);

        String contextPath = request.getContextPath();
        User user = (User) session.getAttribute("user");

        if (user != null) {
            if (user.getRole().equals("ADMIN")) {
                response.sendRedirect(contextPath + "/admin/adminProducts.jsp");
            } else if (user.getRole().equals("USER")) {
                response.sendRedirect(contextPath + "/products/listProducts.jsp");
            }
        } else {
            response.sendRedirect(contextPath + "/err.jsp");
        }
    }

}
package com.xmg.shopping.servlet;

import com.xmg.shopping.dao.IProductDao;
import com.xmg.shopping.dao.IProductDirDao;
import com.xmg.shopping.dao.impl.ProductDaoImpl;
import com.xmg.shopping.dao.impl.ProductDirDaoImpl;
import com.xmg.shopping.domain.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

@WebServlet("/product")
public class ProductServlet extends HttpServlet {

    IProductDao dao = null;
    IProductDirDao dirDao = null;

    @Override
    public void init() throws ServletException {
        dao = new ProductDaoImpl();
        dirDao = new ProductDirDaoImpl();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String cmd = req.getParameter("cmd");
        if ("edit".equals(cmd)) {
            edit(req,resp);
        } else if ("delete".equals(cmd)) {
            delete(req,resp);
        } else if ("update".equals(cmd)) {
            update(req,resp);
        } else  {
            list(req,resp);
        }
    }


    protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //1 接收请求参数
        //2 调用业务方法
        List<Product> products = dao.list();
        // 传递参数进去
        req.setAttribute("products", products);
        //3 界面跳转
        req.getRequestDispatcher("/WEB-INF/views/product/list.jsp").forward(req,resp);
    }

    protected void edit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 有添加和更新2种动作，如果带参数id过来，说明是更新，否则说明是添加
        String id = req.getParameter("id");
        if (id != null && !id.equals("")) {
            //查找出该id的货品，传递给编辑界面
            Product p = dao.get(Long.valueOf(id));
            req.setAttribute("product",p);
        }
        // 传递分类信息给edit界面
        req.setAttribute("dirs", dirDao.list());
        req.getRequestDispatcher("/WEB-INF/views/product/edit.jsp").forward(req,resp);
    }


    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        if (id != null && !id.equals("")) {
            dao.delete(Long.valueOf(id));
        }
        resp.sendRedirect("/product");
    }

    // 处理保存和更新的操作
    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 接收请求参数
        Product p = new Product();
        request2Obj(req, p);
        if (p.getId() != null && !p.getId().equals("")) {
            dao.update(p);
        } else {
            // 处理业务
            dao.save(p);
        }
        // 跳转到 list servlet 重新查询结果显示
        resp.sendRedirect("/product");
    }

    private void request2Obj(HttpServletRequest req, Product p) {
        String id = req.getParameter("id");
        String productName = req.getParameter("productName");
        String brand = req.getParameter("brand");
        String supplier = req.getParameter("supplier");
        String salePrice = req.getParameter("salePrice");
        String costPrice = req.getParameter("costPrice");
        String cutoff = req.getParameter("cutoff");
        String dir = req.getParameter("dir");

        // 这里用来区分 是保存 还是更新
        if (id != null && !id.equals("")) {
            p.setId(Long.valueOf(id));
        }

        // 不做判空了
        p.setProductName(productName);
        p.setBrand(brand);
        p.setSupplier(supplier);
        p.setSalePrice(new BigDecimal(salePrice));
        p.setCostPrice(new BigDecimal(costPrice));
        p.setCutoff(Double.valueOf(cutoff));
        p.setDir_id(Long.valueOf(dir));
    }


}

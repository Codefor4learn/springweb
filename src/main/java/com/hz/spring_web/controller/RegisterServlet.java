package com.hz.spring_web.controller;

import com.hz.spring_web.domain.Student;
import com.hz.spring_web.service.StudentService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String age = request.getParameter("age");

        //String config = "spring-mybatis.xml";
        //ApplicationContext ctx = new ClassPathXmlApplicationContext(config);

        WebApplicationContext ctx = null;
        //获取ServiceContext中的容器对象，创建好的容器对象拿来就用
        /*String key = WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE;
        Object attr = getServletContext().getAttribute(key);
        if( attr != null){
            ctx = (WebApplicationContext)attr;
        }*/

        //使用框架中的方法，获取容器对象
        ServletContext sc = getServletContext();
        ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(sc);

        StudentService studentService = (StudentService) ctx.getBean("studentService");
        System.out.println("容器对象信息======================" + ctx);

        Student student = new Student();
        student.setId(Integer.valueOf(id));
        student.setName(name);
        student.setEmail(email);
        student.setAge(Integer.parseInt(age));

        studentService.addStudent(student);

        // 给出结果页面
        request.getRequestDispatcher("result.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

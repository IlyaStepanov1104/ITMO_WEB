package ru.itmo.wp.servlet;

import com.google.gson.Gson;
import ru.itmo.wp.util.Message;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MessagesServlet extends HttpServlet {
    private final List<Message> allMessages = new ArrayList<>();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json");
        String requestURI = request.getRequestURI();
        if ("/message/auth".equals(requestURI)) {
            auth(request, response);
        } else if ("/message/add".equals(requestURI)) {
            add(request);
        } else if ("/message/findAll".equals(requestURI)) {
            findAll(response);
        }
    }

    private void findAll(HttpServletResponse response) throws IOException {
        String json = new Gson().toJson(allMessages);
        response.getWriter().print(json);
        response.getWriter().flush();
    }

    private void add(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String text = request.getParameter("text");
        String name = (String) session.getAttribute("user");
        allMessages.add(new Message(name, text));
    }

    private void auth(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        String name;
        Object sessionName = session.getAttribute("user");
        String submitName = request.getParameter("user");
        if (sessionName == null && submitName == null) name = "";
        else if (submitName != null) {
            name = submitName;
        } else name = (String) sessionName;
        session.setAttribute("user", name);
        String json = new Gson().toJson(name);
        response.getWriter().print(json);
        response.getWriter().flush();
    }

}

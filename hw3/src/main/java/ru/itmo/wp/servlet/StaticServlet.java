package ru.itmo.wp.servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;

public class StaticServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String uri = request.getRequestURI();
        String[] paths = uri.split("\\+");
        File file;
        String path;
        int i;
        for (i = paths.length - 1; i>= 0; i--) {
            path = paths[i];
            if (path.charAt(0) == '/'){
                file = new File("C:/Users/showd/OneDrive/Рабочий стол/Илья/1. Учёба/ИТМО/3 сем/Веб/ДЗ-3/src/main/webapp/static" + path);
            } else {
                file = new File("C:/Users/showd/OneDrive/Рабочий стол/Илья/1. Учёба/ИТМО/3 сем/Веб/ДЗ-3/src/main/webapp/static/" + path);
            }
            if(!file.isFile()){
                file = new File(getServletContext().getRealPath("/static" + uri));
            }
            if (file.isFile()) {
                response.setContentType(getServletContext().getMimeType(file.getName()));
                try (OutputStream outputStream = response.getOutputStream()) {
                    Files.copy(file.toPath(), outputStream);
                }
            } else {
                response.sendError(HttpServletResponse.SC_NOT_FOUND);
            }
        }
    }
}

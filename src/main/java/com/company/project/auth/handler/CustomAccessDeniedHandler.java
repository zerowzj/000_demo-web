package com.company.project.auth.handler;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.zookeeper.common.IOUtils;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author wangzhj
 */
public class CustomAccessDeniedHandler implements AccessDeniedHandler {


    protected static final Log logger = LogFactory.getLog(CustomAccessDeniedHandler.class);

    //~ Instance fields ================================================================================================

    private String errorPage;
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {

        String ajaxRequest = request.getHeader("X-Requested-With");
        // Set the 403 status code.
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        if("XMLHttpRequest".equals(ajaxRequest)){
            logger.info("ssssssssssssssssssss");

        } else {
            // Put exception into request scope (perhaps of use to a view)
            request.setAttribute(WebAttributes.ACCESS_DENIED_403, accessDeniedException);
            // Set the 403 status code.
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            PrintWriter out = null;
            try {
                out = response.getWriter();
//                out.println("<html>");
                out.println("<script>");
                out.println("alert('1111111')");
                out.println("</script>");
//                out.println("</html>");
                return;
            } catch (Exception ex) {
                ex.printStackTrace();
            } finally {
            }
       /*     // forward to error page.
            RequestDispatcher dispatcher = request.getRequestDispatcher(errorPage);
            dispatcher.forward(request, response);*/
        }
    }

    public void setErrorPage(String errorPage) {
        if ((errorPage != null) && !errorPage.startsWith("/")) {
            throw new IllegalArgumentException("errorPage must begin with '/'");
        }

        this.errorPage = errorPage;
    }
}

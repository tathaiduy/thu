/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cake.Filter;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author DuyTT
 */
public class RoleFilter implements Filter {

    private static final String login = "/login.jsp";
    private static final String welcomePage = "";
    private final String adminPage[] = {
        "cake-product-list.jsp", "index.jsp", "welcome.jsp", "user-insert.jsp", "cake-insert.jsp", "login.jsp", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",
        "bootstrap.min.css", "style.css", "style.css", "style.css", "fontawesome-all.css", "chartist.css", "bootstrap-select.css", "morris.css", "materialdesignicons.min.css", "c3.css", "flag-icon.min.css", "dataTables.bootstrap4.css", "buttons.bootstrap4.css", "select.bootstrap4.css", "fixedHeader.bootstrap4.css", "", "", "", "",
        "weather-icons.min.css", "tempusdominus-bootstrap-4.css", "moment.js", "tempusdominus-bootstrap-4.js", "datepicker.js",
        "bootstrap.bundle.js", "jquery.slimscroll.js", "main-js.js", "chartist.min.js", "jquery.sparkline.js", "raphael.min.js", "morris.js", "c3.min.js", "d3-5.4.0.min.js", "C3chartjs.js", "dashboard-ecommerce.js",
        "jquery-3.3.1.min.js", "bootstrap-select.js", "jquery.multi-select.js", "dataTables.bootstrap4.min.js", "buttons.bootstrap4.min.js", "data-table.js", "", "", "", "", "", "", "", "", "", "", "",
        "fa-solid-900.eot", "fa-solid-900d41d.eot", "fa-solid-900.woff", "fa-solid-900.ttf", "fa-solid-900.svg", "fa-brands-400.eot", "fa-brands-400.svg", "fa-brands-400.ttf", "fa-brands-400.woff", "fa-brands-400d41d.eot", "fa-regular-400.eot", "fa-regular-400.svg", "fa-regular-400.ttf", "fa-regular-400.woff", "fa-regular-400d41d.eot", "um.svg", "ca.svg", "ru.svg", "in.svg", "fr.svg", "vn.svg", "CircularStd-Black.woff", "CircularStd-BlackItalic.woff", "CircularStd-Bold.woff", "CircularStd-BoldItalic.woff", "CircularStd-Book.woff", "CircularStd-BookItalic.woff", "CircularStd-Medium.woff", "CircularStd-MediumItalic.woff", "materialdesignicons-webfontd41d.eot", "materialdesignicons-webfontdc99.eot", "materialdesignicons-webfontdc99", "materialdesignicons-webfontdc99.ttf", "materialdesignicons-webfontdc99.woff", "Simple-Line-Icons4c82.eot", "Simple-Line-Icons4c82.svg", "Simple-Line-Icons4c82.ttf", "Simple-Line-Icons4c82.woff", "Simple-Line-Iconsd41d.eot", "weathericons-regular-webfont.eot", "themify.ttf", "themify.woff", "themify9f24.eot", "themify9f24.svg", "themifyd41d.eot",
        "", "", "", "", "", "", "", "", "", "", "", "", "",};

    private final String userPage[] = {"fonts/icomoon/style.css",
        "tempusdominus-bootstrap-4.css",
        "css/bootstrap.min.css",
        "css/jquery-ui.css",
        "css/owl.carousel.min.css",
        "css/owl.theme.default.min.css",
        "css/owl.theme.default.min.css",
        "css/jquery.fancybox.min.css",
        "css/bootstrap-datepicker.css",
        "fonts/flaticon/font/flaticon.css",
        "css/aos.css",
        "css/jquery.mb.YTPlayer.min.css",
        "css/style.css",
        "js/jquery-3.3.1.min.js",
        "js/jquery-migrate-3.0.1.min.js",
        "js/jquery-ui.js",
        "js/popper.min.js",
        "js/bootstrap.min.js",
        "js/owl.carousel.min.js",
        "js/jquery.stellar.min.js",
        "js/jquery.countdown.min.js",
        "js/bootstrap-datepicker.min.js",
        "js/jquery.easing.1.3.js",
        "js/aos.js",
        "js/jquery.fancybox.min.js",
        "js/jquery.sticky.js",
        "js/jquery.mb.YTPlayer.min.js",
        "js/main.js",
        "about.html", "login.html", "login.jsp", "welcome.html", "cart.html", "contact.html", "cake.jsp", "cart.jsp", "cartnotfound.html", "checkout.jsp", "blog-single.html", "register.html", "welcome-user.html", "welcome.jsp",
        "favicon.ico", "bootstrap.min.css", "font-awesome.min.css", "icon-font.min.css", "animate.css", "hamburgers.min.css", "material-design-iconic-font.min.css",
        "animsition.min.css", "select2.min.css", "daterangepicker.css", "util.css", "main.css", "style.css",
        "jquery-3.2.1.min.js", "animsition.min.js", "popper.js", "bootstrap.min.js", "select2.min.js", "moment.min.js", "daterangepicker.js", "countdowntime.js", "main.js", "jquery.min.js", "moment.js", "tempusdominus-bootstrap-4.js", "datepicker.js", "",
        "Poppins-Regular.ttf", "Poppins-Medium.ttf", "Poppins-Bold.ttf", "Poppins-SemiBold.ttf", "Montserrat-Bold.ttf", "Montserrat-SemiBold.ttf", "Montserrat-Regular.ttf", "fontawesome-webfont.eot", "fontawesome-webfont.woff2", "fontawesome-webfont.woff", "fontawesome-webfont.ttf", "fontawesome-webfont.svg", "FontAwesome.otf",
        "Flaticon.eot", "Flaticon.woff2", "Flaticon.woff", "Flaticon.ttf", "Flaticon.svg", "icomoon.eot", "icomoon.ttf", "icomoon.woff", "icomoon.svg", "roboto-slab-v7-latin-300.eot", "roboto-slab-v7-latin-300.woff2", "roboto-slab-v7-latin-300.woff", "roboto-slab/roboto-slab-v7-latin-300.ttf", "roboto-slab-v7-latin-300.svg",
        "roboto-slab-v7-latin-regular.eot", "roboto-slab-v7-latin-regular.woff2", "roboto-slab-v7-latin-regular.woff", "roboto-slab-v7-latin-regular.ttf", "roboto-slab-v7-latin-regular.svg", "roboto-slab-v7-latin-700.eot", "roboto-slab-v7-latin-700.woff2", "roboto-slab-v7-latin-700.woff", "roboto-slab-v7-latin-700.ttf", "roboto-slab-v7-latin-700.svg", "", "",
        "logo.jpg", "banhmibotoi.jpg", "tart.jpg", "cheesecakeoreo.jpg", "banhmibotoisell.jpg", "cheesecakesell.png", "tartsell.jpg", "welcome.jpg", "coldcake.jpg", "hotcake.jpg", "aboutus.jpg", "bg-01.jpg", "howwestart.jpg",
        "video.jpg", "person1.jpg", "person2.jpg", "person3.jpg", "cakewelcome.jpg", "getintouch.jpg", "error.jsp", "bg.jpg", "body-bg.jpg",};

    private final String loginPage[] = {"favicon.ico", "bootstrap.min.css", "font-awesome.min.css", "icon-font.min.css", "animate.css", "hamburgers.min.css", "animsition.min.css", "select2.min.css", "daterangepicker.css", "util.css", "css/main.css", "welcome.jsp", "", "", "", "", "", "", "", "", "",
        "jquery-3.2.1.min.js", "animsition.min.js", "popper.js", "bootstrap.min.js", "select2.min.js", "moment.min.js", "daterangepicker.js", "countdowntime.js", "main.js", "", "", "", "", "", "", "", "", "", "", "",
        "Poppins-Regular.ttf", "Poppins-Medium.ttf", "Poppins-Bold.ttf", "Poppins-SemiBold.ttf", "Montserrat-Bold.ttf", "Montserrat-SemiBold.ttf", "Montserrat-Regular.ttf", "fontawesome-webfont.eot", "fontawesome-webfont.woff2", "fontawesome-webfont.woff", "font-awsome.css", "", "", "", "", "", "", "", "", "",
        "fontawesome-webfont.ttf", "fontawesome-webfont.svg", "FontAwesome.otf", "bg-01.jpg", "style.css", "bg.jpg", "", "", "", "", "", "", "", "", "", "", "", "", "",};
    private static final boolean debug = true;

    // The filter configuration object we are associated with.  If
    // this value is null, this filter instance is not currently
    // configured. 
    private FilterConfig filterConfig = null;

    public RoleFilter() {
    }

    private void doBeforeProcessing(ServletRequest request, ServletResponse response)
            throws IOException, ServletException {
        if (debug) {
            log("RoleFilter:DoBeforeProcessing");
        }

        // Write code here to process the request and/or response before
        // the rest of the filter chain is invoked.
        // For example, a logging filter might log items on the request object,
        // such as the parameters.
        /*
	for (Enumeration en = request.getParameterNames(); en.hasMoreElements(); ) {
	    String name = (String)en.nextElement();
	    String values[] = request.getParameterValues(name);
	    int n = values.length;
	    StringBuffer buf = new StringBuffer();
	    buf.append(name);
	    buf.append("=");
	    for(int i=0; i < n; i++) {
	        buf.append(values[i]);
	        if (i < n-1)
	            buf.append(",");
	    }
	    log(buf.toString());
	}
         */
    }

    private void doAfterProcessing(ServletRequest request, ServletResponse response)
            throws IOException, ServletException {
        if (debug) {
            log("RoleFilter:DoAfterProcessing");
        }

        // Write code here to process the request and/or response after
        // the rest of the filter chain is invoked.
        // For example, a logging filter might log the attributes on the
        // request object after the request has been processed. 
        /*
	for (Enumeration en = request.getAttributeNames(); en.hasMoreElements(); ) {
	    String name = (String)en.nextElement();
	    Object value = request.getAttribute(name);
	    log("attribute: " + name + "=" + value.toString());

	}
         */
        // For example, a filter might append something to the response.
        /*
	PrintWriter respOut = new PrintWriter(response.getWriter());
	respOut.println("<P><B>This has been appended by an intrusive filter.</B>");
         */
    }

    /**
     *
     * @param request The servlet request we are processing
     * @param response The servlet response we are creating
     * @param chain The filter chain we are processing
     *
     * @exception IOException if an input/output error occurs
     * @exception ServletException if a servlet error occurs
     */
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse rep = (HttpServletResponse) response;
        HttpSession session = req.getSession(true);
        String role = (String) session.getAttribute("ROLE");
        System.out.println("Role Session: " + role);
        String url = login;
        String uri = req.getRequestURI();
        System.out.println("uri" + uri);
        int lastIndex = uri.lastIndexOf("/");
        String resource = uri.substring(lastIndex + 1);
        if (resource.length() > 0) {
            if (uri.contains("Controller")) {
                url = "/" + resource;
            }
            if (uri.contains("/LoginController")) {
                req.getRequestDispatcher(url).forward(request, response);
            }
            
            if (uri.contains("/SearchCakeController")) {
                req.getRequestDispatcher(url).forward(request, response);
            }
           
            if (uri.contains("/AddCakeController")) {
                req.getRequestDispatcher(url).forward(request, response);
            }
            
            if (uri.contains("/DeleteCakeController")) {
                req.getRequestDispatcher(url).forward(request, response);
            }
            
            if (uri.contains("/CheckCartEmptyController")) {
                req.getRequestDispatcher(url).forward(request, response);
            }
            
            if (uri.contains("/UpdateCakeController")) {
                req.getRequestDispatcher(url).forward(request, response);
            }
            
            if (uri.contains("/MainController")) {
                req.getRequestDispatcher(url).forward(request, response);
            }
            
            if (uri.contains("/RegisterUsernameController")) {
                req.getRequestDispatcher(url).forward(request, response);
            }
            
            if (uri.contains("/GetCookiesController")) {
                req.getRequestDispatcher(url).forward(request, response);
            }
            
            if (uri.contains("/thuController")) {
                req.getRequestDispatcher(url).forward(request, response);
            }
            

        }
        if (role != null) {
            if (role.equals("admin")) 
            {
                if (uri.contains("/SearchBookAdminController")) {
                    req.getRequestDispatcher(url).forward(request, response);
                }
                
                
                if (uri.contains("/UpdateCakeAdminController")) {
                    req.getRequestDispatcher(url).forward(request, response);
                }
                
                if (uri.contains("/EditCakeAdminController")) {
                    req.getRequestDispatcher(url).forward(request, response);
                }
                
                if (uri.contains("/SearchUserAdminController")) {
                    req.getRequestDispatcher(url).forward(request, response);
                }
                if (uri.contains("/EditUserAdminController")) {
                    req.getRequestDispatcher(url).forward(request, response);
                }
                
                if (uri.contains("/UpdateUserAdminController")) {
                    req.getRequestDispatcher(url).forward(request, response);
                }
                
                if (uri.contains("/thuController")) {
                    req.getRequestDispatcher(url).forward(request, response);
                }
                if (uri.contains("/InsertUserAdminController")) {
                    req.getRequestDispatcher(url).forward(request, response);
                }
                
                if (uri.contains("/InsertCakeAdminController")) {
                    req.getRequestDispatcher(url).forward(request, response);
                }
                
                if (uri.contains("/InsertCakeAdminController")) {
                    req.getRequestDispatcher(url).forward(request, response);
                }
                
                
                if (uri.contains("/LogOutController")) {
                    req.getRequestDispatcher(url).forward(request, response);
                }
                
                if (uri.contains("/SearchDataTableBillController")) {
                    req.getRequestDispatcher(url).forward(request, response);
                }
                
                if (uri.contains("/MainAdminController")) {
                    req.getRequestDispatcher(url).forward(request, response);
                }
                
                

            } 
            else if (role.equals("user")) 
            {
                if (uri.contains("/ShowUserCartController")) {
                    req.getRequestDispatcher(url).forward(request, response);
                }
                
                if (uri.contains("/MainUserController")) {
                    req.getRequestDispatcher(url).forward(request, response);
                }
                
                if (uri.contains("/AddCakeUserController")) {
                    req.getRequestDispatcher(url).forward(request, response);
                }
                
            }
            if (uri.contains("/admin/")) {

                if (!role.equals("admin")) {
                    url = login;
                    req.getRequestDispatcher(url).forward(request, response);
                }

                if (role.equals("admin")) {

                    for (String s : adminPage) {
                        if (s.contains(resource)) {
                            System.out.println("uri admin page: " + uri);
                            System.out.println("resource admin page: " + resource);
                            req.getRequestDispatcher(resource).forward(request, response);
                            return;
                        }
                    }
                }

            } else if (uri.contains("/user/")) {
                if (!role.equals("user")) {
                    url = login;
                }

                if (role.equals("user")) {
                    for (String s : userPage) {
                        if (s.contains(resource)) {
                            System.out.println("url user page: " + url);
                            System.out.println("resource userpage: " + resource);
                            System.out.println("uri user page: " + uri);
                            req.getRequestDispatcher(resource).forward(request, response);
                            return;
                        }
                    }
                }
            }
        } else {
            if (uri.contains("/admin/") || uri.contains("/user/")) {

                for (String s : userPage) {
                    if (s.contains(resource)) {
                        System.out.println("resource not userpage or adminpage : " + resource);
                        //req.getRequestDispatcher(url).forward(request, response);
                        req.getRequestDispatcher(resource).forward(request, response);
                        return;
                    }
                }
                req.getRequestDispatcher("/login.html").forward(request, response);
            }
        }
        if (url != null) {
            for (String s : userPage) {
                if (s.contains(resource)) {
                    System.out.println("resource = " + resource);
                    req.getRequestDispatcher(resource).forward(request, response);
                    return;
                }
            }
            //req.getRequestDispatcher("/login.html").forward(request, response);
        } else {
            chain.doFilter(request, response);
        }

    }

    /**
     * Return the filter configuration object for this filter.
     */
    public FilterConfig getFilterConfig() {
        return (this.filterConfig);
    }

    /**
     * Set the filter configuration object for this filter.
     *
     * @param filterConfig The filter configuration object
     */
    public void setFilterConfig(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
    }

    /**
     * Destroy method for this filter
     */
    public void destroy() {
    }

    /**
     * Init method for this filter
     */
    public void init(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
        if (filterConfig != null) {
            if (debug) {
                log("RoleFilter:Initializing filter");
            }
        }
    }

    /**
     * Return a String representation of this object.
     */
    @Override
    public String toString() {
        if (filterConfig == null) {
            return ("RoleFilter()");
        }
        StringBuffer sb = new StringBuffer("RoleFilter(");
        sb.append(filterConfig);
        sb.append(")");
        return (sb.toString());
    }

    private void sendProcessingError(Throwable t, ServletResponse response) {
        String stackTrace = getStackTrace(t);

        if (stackTrace != null && !stackTrace.equals("")) {
            try {
                response.setContentType("text/html");
                PrintStream ps = new PrintStream(response.getOutputStream());
                PrintWriter pw = new PrintWriter(ps);
                pw.print("<html>\n<head>\n<title>Error</title>\n</head>\n<body>\n"); //NOI18N

                // PENDING! Localize this for next official release
                pw.print("<h1>The resource did not process correctly</h1>\n<pre>\n");
                pw.print(stackTrace);
                pw.print("</pre></body>\n</html>"); //NOI18N
                pw.close();
                ps.close();
                response.getOutputStream().close();
            } catch (Exception ex) {
            }
        } else {
            try {
                PrintStream ps = new PrintStream(response.getOutputStream());
                t.printStackTrace(ps);
                ps.close();
                response.getOutputStream().close();
            } catch (Exception ex) {
            }
        }
    }

    public static String getStackTrace(Throwable t) {
        String stackTrace = null;
        try {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            t.printStackTrace(pw);
            pw.close();
            sw.close();
            stackTrace = sw.getBuffer().toString();
        } catch (Exception ex) {
        }
        return stackTrace;
    }

    public void log(String msg) {
        filterConfig.getServletContext().log(msg);
    }

}

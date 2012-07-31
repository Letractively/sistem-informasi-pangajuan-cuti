<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>Sistem Informasi Pengambilan Cuti</title>
        <meta name="keywords" content="single, slider, free templates, website templates, CSS, HTML" />
        <meta name="description" content="Single Slider is a free CSS template provided by templatemo.com" />
        <link href="css/templatemo_style.css" rel="stylesheet" type="text/css" />

        <script src="js/jquery-1.2.6.min.js" type="text/javascript"></script>
        <script src="js/jquery.easing.1.3.js" type="text/javascript"></script>
        <script src="js/jquery.kwicks-1.5.1.pack.js" type="text/javascript"></script>

        <script type="text/javascript">
            $().ready(function() {  
                $('.kwicks').kwicks({  
                    max : 710,  
                    spacing : 0,  
                    sticky: true
                });  
            }); 
        </script>

        <script type="text/javascript" src="js/jquery-1-4-2.min.js"></script> 
        <link rel="stylesheet" href="css/slimbox2.css" type="text/css" media="screen" /> 
        <script type="text/JavaScript" src="js/slimbox2.js"></script> 

    </head>

    <body>

        <div id="templatemo_wrapper">
            <div id="templatemo_main">

                <div id="site_title">
                    <h1><a href="http://www.templatemo.com">Free CSS Templates</a></h1>
                </div>

                <div id="templatemo_content">
                    <ul class="inner">

                        <li id="home"><span class="header"></span>
                            <h2 >Login</h2>
                            <div id="contact_form"  class="col_w280 float_l">
                                <%  //if(request.getAttribute("failed") != null){
                                    //  out.println("<h3><font color='red'>" + request.getAttribute("failed") +"</font></h3>");  
                                    //}
                                %>
                                <form method="post" name="contact" action="/SisInfPengambilanCuti/Login">
                                    <table>
                                        <tr>
                                            <td>Username: </td>
                                            <td>
                                                <input type="text" id="author" name="usr" class="required input_field" />
                                            </td></tr>

                                        <tr>
                                            <td> Password : </td>
                                            <td>
                                                <input type="password" id="author" name="pwd" class="required input_field" />
                                            </td>
                                        </tr>

                                        <tr>
                                            <td></td>
                                            <td>
                                                <input value="LOGIN" type="submit" id="author" name="author" class="required input_field" />
                                            </td>
                                        </tr>
                                    </table>
                                </form>
                            </div>
                        </li>


                    </ul>

                </div> <!-- END of content -->
            </div> <!-- END of templatemo_main -->
            <div id="templatemo_footer">Copyright � 2048 Your Company Name | <a href="http://www.iwebsitetemplate.com" target="_parent">Website Templates</a> by <a href="http://www.templatemo.com" target="_parent">Free CSS Templates</a></div>
        </div> <!-- END of templatemo_wrapper -->

    </body>
</html>
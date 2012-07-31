<%-- 
    Document   : insertKaryawan
    Created on : Jul 28, 2012, 10:43:18 AM
    Author     : suriojiwandono
--%>
<%
    String log = (String) session.getAttribute("loginAdmin");
    if (log != null) {
%>
<%@page import="java.util.Calendar"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>Administrator - Sistem Informasi Pengambilan Cuti</title>
        <meta name="keywords" content="single, slider, free templates, website templates, CSS, HTML" />
        <meta name="description" content="Single Slider is a free CSS template provided by templatemo.com" />
        <link href="../css/templatemo_style.css" rel="stylesheet" type="text/css" />

        <script src="../js/jquery-1.2.6.min.js" type="text/javascript"></script>
        <script src="../js/jquery.easing.1.3.js" type="text/javascript"></script>
        <script src="../js/jquery.kwicks-1.5.1.pack.js" type="text/javascript"></script>

        <script type="text/javascript">
            $().ready(function() {  
                $('.kwicks').kwicks({  
                    max : 710,  
                    spacing : 0,  
                    sticky: true
                });  
            }); 
        </script>


        <script language="javascript">
            var i;
            function date(i){
                var form1 = document.getElementById("formContact");
                var tahun = document.contact.cmbTahun.value;
                var tahun = document.contact.cmbTanggal.value;
                document.contact.cmbTanggal.options.length=0;
                //document.contact.cmbTanggal.value == "1";
                
                if(i == "februari" && tahun % 4 != 0){   
            <% for (int a = 1; a <= 28; a++) {
            %>
                        form1.cmbTanggal.options[<%= a%>] =new Option('<%= a%>','<%= a%>');
            <%
                }
            %>
                    } else if (i == "februari" && tahun % 4 == 0){
            <% for (int a = 1; a <= 29; a++) {
            %>
                        form1.cmbTanggal.options[<%= a%>] =new Option('<%= a%>','<%= a%>');
            <%
                }
            %>
                    } else if(i == "januari" || i == "maret" || i=="mei" || i =="juli" || i == "agustus" || i == "oktober" || i == "desember"){
            <% for (int a = 1; a <= 31; a++) {
            %>
                        form1.cmbTanggal.options[<%= a%>] =new Option('<%= a%>','<%= a%>');
            <%
                }
            %>
                    } else {
            <% for (int a = 1; a <= 30; a++) {
            %>
                        form1.cmbTanggal.options[<%= a%>] =new Option('<%= a%>','<%= a%>');
            <%
                }
            %>
                    }
                }
        </script>

        <script type="text/javascript" src="../js/jquery-1-4-2.min.js"></script> 
        <link rel="stylesheet" href="../css/slimbox2.css" type="text/css" media="screen" /> 
        <script type="text/JavaScript" src="../js/slimbox2.js"></script> 

    </head>
    <body>

        <div id="templatemo_wrapper">
            <div id="templatemo_main">

                <div id="site_title">
                    <h1><a href="http://www.templatemo.com">Free CSS Templates</a></h1>
                </div>
<p align="right"><a href="../adminLogout">LOG OUT</a></p>
                <div id="templatemo_content">
                    <ul class="kwicks">
                        <li id="cuti"><span class="header"></span>
                            <div class="inner">
                                <h2>Tambah Karyawan</h2>
                                <div id="contact_form"  class="col_w280 float_l">
                                    <%
                                        HttpSession hs = request.getSession();
                                        ServletContext sc = getServletContext();
                                        Object status = sc.getAttribute("validation");

                                        if (cuti.DateTimeCuti.validator) {
                                            out.print("KOSONG");
                                            cuti.DateTimeCuti.validator = false;
                                        }
                                    %>
                                    <form method="post" id="formContact" name="contact" action="../insertKaryawan">
                                        <table>
                                            <tr>
                                                <td>Nama: </td>
                                                <td>
                                                    <input type="text" id="author" name="txtNama" class="required input_field" />
                                                </td></tr>
                                            <tr>
                                                <td>Jenis Kelamin : </td>
                                                <td>
                                                    <select name=cmbJenkel>
                                                        <option value=Laki-laki>Laki - laki</option>
                                                        <option value=Perempuan>Perempuan</option>
                                                    </select>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>Alamat: </td>
                                                <td>
                                                    <input type="text" id="author" name="txtAlamat" class="required input_field" />
                                                </td>
                                            </tr>

                                            <tr>
                                                <td>Tanggal Lahir: </td>
                                                <td>
                                                    <select id=tgl name=cmbTanggal>
                                                        <%
                                                            for (int i = 1; i <= 31; i++) {
                                                                if (i <= 9) {
                                                        %>
                                                        <option value=0<%= i%>>0<%= i%></option>
                                                        <%                                                                    } else {
                                                        %>
                                                        <option value=<%= i%>><%= i%></option>
                                                        <%
                                                                }
                                                            }
                                                        %>
                                                    </select>
                                                    <select name=cmbBulan onchange="date(document.contact.cmbBulan.value);">                                                      
                                                        <option value=januari selected="true">Januari</option>
                                                        <option value=februari>Februari</option>
                                                        <option value=maret>Maret</option>
                                                        <option value=april>April</option>
                                                        <option value=mei>Mei</option>
                                                        <option value=juni>Juni</option>
                                                        <option value=juli>Juli</option>
                                                        <option value=agustus>Agustus</option>
                                                        <option value=september>September</option>
                                                        <option value=oktober>Oktober</option>
                                                        <option value=november>November</option>
                                                        <option value=desember>Desember</option>
                                                    </select>
                                                    <select name=cmbTahun onchange="date(document.contact.cmbBulan.value);">                                                      
                                                        <%
                                                            Calendar c = Calendar.getInstance();
                                                            int batasAwal = c.get(Calendar.YEAR) - 60;
                                                            int batasAkhir = c.get(Calendar.YEAR) - 17;
                                                            for (int i = batasAwal; i <= batasAkhir; i++) {
                                                        %>
                                                        <option value=<%= i%>><%= i%></option>    
                                                        <%
                                                            }
                                                        %>
                                                    </select>
                                                </td>
                                            </tr>

                                            <tr>
                                                <td></td>
                                                <td>
                                                    <input type="submit" id="author" name="author" value="Tambah" class="required input_field" />
                                                </td>
                                            </tr>
                                        </table>
                                    </form>
                                </div>
                            </div>
                        </li>

                    </ul>
                </div> <!-- END of content -->
            </div> <!-- END of templatemo_main -->
            <div id="templatemo_footer">Copyright © 2048 Your Company Name | <a href="http://www.iwebsitetemplate.com" target="_parent">Website Templates</a> by <a href="http://www.templatemo.com" target="_parent">Free CSS Templates</a></div>
        </div> <!-- END of templatemo_wrapper -->

    </body>
</html>
<% }

                                                        
        else {
response.sendRedirect("index.jsp");
    }
%>
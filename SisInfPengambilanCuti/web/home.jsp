<%@page import="entity.HistoryCuti"%>
<%@page import="java.util.List"%>
<%@page import="javax.persistence.EntityManager"%>
<%@page import="javax.persistence.Persistence"%>
<%@page import="javax.persistence.EntityManagerFactory"%>
<%@page import="dao.HistoryCutiDAOImpl"%>
<%@page import="dao.HistoryCutiDAO"%>
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
                    <ul class="kwicks">

                        <li id="home"><span class="header"></span>
                            <div class="inner">
                                <h2>Selamat datang <% out.println(session.getAttribute("user")); %></h2>
                                <p><em>Teknologi Persisten</em><br/><a href="Logout">Logout</a></p>
                                <!--						<div class="col_half float_r">
                                <p></p>
                                <h3>Overview</h3>

                                <ul class="templatemo_list">
                                        <li>Maecenas ac odio</li>
                                        <li>Fusce risus tortor</li>
                                        <li>Proin facilisis ulla</li>
                                        <li>Sed vel justo quis</li>
                                        <li>Ut tristique sagittis</li>
                                </ul>
                        </div>
                                -->
                            </div>
                        </li>

                        <li id="cuti"><span class="header"></span>
                            <div class="inner">
                                <h2>Pengajuan Cuti</h2>
                                <div id="contact_form"  class="col_w280 float_l">
                                    <form method="post" name="contact" action="#">
                                        <table>
                                            <tr>
                                                <td>Nama: </td>
                                                <td>
                                                    <input type="text" id="author" name="author" class="required input_field" />
                                                </td></tr>
                                            <tr>
                                                <td>Jenis Cuti : </td>
                                                <td>
                                                    <select name="jenis_cuti">
                                                        <option value="liburan">Liburan</option>
                                                        <option value="keperluan_keluarga">Keperluan Keluarga</option>
                                                    </select>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>Dari Tanggal: </td>
                                                <td>
                                                    <input type="text" id="author" name="author" class="required input_field" />
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>Sampai Tanggal: </td>
                                                <td>
                                                    <input type="text" id="author" name="author" class="required input_field" />
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>Keterangan: </td>
                                                <td>
                                                    <textarea rows="2" cols="20"></textarea>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td></td>
                                                <td>
                                                    <input type="submit" id="author" name="author" class="required input_field" />
                                                </td>
                                            </tr>
                                        </table>
                                    </form>
                                </div>
                            </div>
                        </li>
                        <li id="cuti"><span class="header"></span>
                            <div class="inner">
                                <h2><% if(!session.getAttribute("user").equals("administrator")) {
                                    out.println("You don't have permission to access this page");
                                } else {
                                    out.println("History Cuti Pegawai<br/>");
                                %></h2>
                                <%
                                    out.println("<table><tr><th>No</th>");
                                    out.println("<th>Nama Karyawan</th>");
                                    out.println("<th>Awal Cuti</th>");
                                    out.println("<th>Akhir Cuti</th>");
                                    out.println("<th>Alasan</th>");
                                    out.println("<th>Status</th>");
                                    out.println("<th>Action</th></tr>");
                                    EntityManagerFactory emf = Persistence.createEntityManagerFactory("SisInfPengambilanCutiPU");
                                    EntityManager em = emf.createEntityManager();
                                    HistoryCutiDAO hcdao = new HistoryCutiDAOImpl(em);
                                    List<HistoryCuti> listCuti = hcdao.gets();
                                    int i = 1;
                                    for(HistoryCuti hc : listCuti){
                                        out.println("<tr><td>"+i+"</td>");
                                        out.println("<td>"+hc.getKaryawan().getNamakaryawan()+"</td>");
                                        out.println("<td>"+hc.getTglawalcuti()+"</td>");
                                        out.println("<td>"+hc.getTglakhircuti()+"</td>");
                                        out.println("<td>"+hc.getAlasan()+"</td>");
                                        out.println("<td>"+hc.getStatus()+"</td>");
                                        out.println("<td><a href='/SisInfPengambilanCuti/ApproveCuti?id="+hc.getId()+"'>Approve</a></td></tr></table>");
                                        i++;
                                    }
                                   }%>
                            </div>
                        </li>

                        <li id="cuti"><span class="header"></span>
                            <div class="inner">
                                <h2>Cuti</h2>
                            </div>
                        </li>

                        <li id="cuti"><span class="header"></span>
                            <div class="inner">
                                <h2>Cuti</h2>
                            </div>
                        </li>

                    </ul>

                </div> <!-- END of content -->
            </div> <!-- END of templatemo_main -->
            <div id="templatemo_footer">Copyright © 2048 Your Company Name | <a href="http://www.iwebsitetemplate.com" target="_parent">Website Templates</a> by <a href="http://www.templatemo.com" target="_parent">Free CSS Templates</a></div>
        </div> <!-- END of templatemo_wrapper -->

    </body>
</html>
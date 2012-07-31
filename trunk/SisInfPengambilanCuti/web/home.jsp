<%@page import="entity.HistoryCuti"%>
<%@page import="java.util.List"%>
<%@page import="javax.persistence.EntityManager"%>
<%@page import="javax.persistence.Persistence"%>
<%@page import="javax.persistence.EntityManagerFactory"%>
<%@page import="dao.HistoryCutiDAOImpl"%>
<%@page import="dao.HistoryCutiDAO"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xht

<%@page import="java.util.Calendar"%>
<%@page import="cuti.DateTimeCuti"%>
<%@page import="entity.HistoryCuti"%>
<%@page import="dao.HistoryCutiDAOImpl"%>
<%@page import="dao.HistoryCutiDAO"%>
<%@page import="entity.Karyawan"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.KaryawanDAOImpl"%>
<%@page import="dao.KaryawanDAO"%>
<%@page import="javax.persistence.EntityManager"%>
<%@page import="javax.persistence.Persistence"%>
<%@page import="javax.persistence.EntityManagerFactory"%>
<%@page import="dao.LoginKaryawanDAOImpl"%>
<%@page import="dao.LoginKaryawanDAO"%>
<%
    String log = (String) session.getAttribute("user");
    if (log != null) {
%>
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
        <script language="javascript">
            var i;
            function date(i){
                var form1 = document.getElementById("formContact1");
                var tahun = document.contact1.cmbTahun1.value;
                document.contact1.cmbTanggal1.options.length=0;
                //document.contact.cmbTanggal.value == "1";
                
                if(i == "februari" && tahun % 4 != 0){   
            <% for (int a = 1; a <= 28; a++) {
            %>
                        form1.cmbTanggal1.options[<%= a%>] =new Option('<%= a%>','<%= a%>');
            <%
                }
            %>
                    } else if (i == "februari" && tahun % 4 == 0){
            <% for (int a = 1; a <= 29; a++) {
            %>
                        form1.cmbTanggal1.options[<%= a%>] =new Option('<%= a%>','<%= a%>');
            <%
                }
            %>
                    } else if(i == "januari" || i == "maret" || i=="mei" || i =="juli" || i == "agustus" || i == "oktober" || i == "desember"){
            <% for (int a = 1; a <= 31; a++) {
            %>
                        form1.cmbTanggal1.options[<%= a%>] =new Option('<%= a%>','<%= a%>');
            <%
                }
            %>
                    } else {
            <% for (int a = 1; a <= 30; a++) {
            %>
                        form1.cmbTanggal1.options[<%= a%>] =new Option('<%= a%>','<%= a%>');
            <%
                }
            %>
                    }
                }
                function date2(i){
                    var form1 = document.getElementById("formContact1");
                    var tahun = document.contact1.cmbTahun2.value;
                    document.contact1.cmbTanggal2.options.length=0;
                    //document.contact.cmbTanggal.value == "1";
                
                    if(i == "februari" && tahun % 4 != 0){   
            <% for (int a = 1; a <= 28; a++) {
            %>
                        form1.cmbTanggal2.options[<%= a%>] =new Option('<%= a%>','<%= a%>');
            <%
                }
            %>
                    } else if (i == "februari" && tahun % 4 == 0){
            <% for (int a = 1; a <= 29; a++) {
            %>
                        form1.cmbTanggal2.options[<%= a%>] =new Option('<%= a%>','<%= a%>');
            <%
                }
            %>
                    } else if(i == "januari" || i == "maret" || i=="mei" || i =="juli" || i == "agustus" || i == "oktober" || i == "desember"){
            <% for (int a = 1; a <= 31; a++) {
            %>
                        form1.cmbTanggal2.options[<%= a%>] =new Option('<%= a%>','<%= a%>');
            <%
                }
            %>
                    } else {
            <% for (int a = 1; a <= 30; a++) {
            %>
                        form1.cmbTanggal2.options[<%= a%>] =new Option('<%= a%>','<%= a%>');
            <%
                }
            %>
                    }
                }
        </script>

        <script type="text/javascript" src="js/jquery-1-4-2.min.js"></script> 
        <link rel="stylesheet" href="css/slimbox2.css" type="text/css" media="screen" /> 
        <script type="text/JavaScript" src="js/slimbox2.js"></script> 
        <script language="javascript">
            function cekValidasi (form){
                
                if(form.alasancuti.value == ""){
                    alert("Inputkan Alasan Cuti");
                    return false;
                    form.alasancuti.focus();
                } else {
                    return true;
                }
            }
        </script>
    </head>
    <%
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SisInfPengambilanCutiPU");
        EntityManager em = emf.createEntityManager();

        KaryawanDAO daoKaryawan = new KaryawanDAOImpl(em);
        Karyawan k = new Karyawan();

        String idd = session.getAttribute("user").toString();
        k = daoKaryawan.get(Long.parseLong(idd));

        //String status;
        HistoryCutiDAO hcdao = new HistoryCutiDAOImpl(em);
        List<HistoryCuti> cuti = hcdao.getByIdKaryawanAccept(k);
        List<HistoryCuti> listHistory = hcdao.getById(k);
        if (new DateTimeCuti().checkTime(listHistory.get(listHistory.size() - 1).getTglawalcuti(),
                listHistory.get(listHistory.size() - 1).getTglakhircuti(), 1)) {
            hcdao.approveCuti(listHistory.get(listHistory.size() - 1).getId(), "Denied");
        }
    %>
    <body>

        <div id="templatemo_wrapper">
            <div id="templatemo_main">

                <div id="site_title">
                    <h1><a href="http://www.templatemo.com">Free CSS Templates</a></h1>
                </div>
                <p align="right"><a href="Logout">LOG OUT</a></p>
                <div id="templatemo_content">
                    <ul class="kwicks">

                        <li id="home"><span class="header"></span>
                            <div class="inner">

                                <h2>Selamat datang <%= k.getNamakaryawan()%></h2>
                                <p><em>Teknologi Persisten</em></p>
                                <div id="contact_form"  class="col_w280 float_l">
                                    <%
                                        if (DateTimeCuti.cekPending) {
                                            out.print("<font color='red'>Anda Sudah Request Sebelumnya</font>");
                                            DateTimeCuti.cekPending = false;
                                        }

                                    %>
                                    <form method="post" name="contact" action="UpdateNotif">
                                        <table >
                                            <tr>
                                                <td> <input type="hidden" name="usrname" value=<% out.println(session.getAttribute("user"));%> /> </td>
                                            </tr>
                                            <%
                                                if (k.getNotifikasi().equalsIgnoreCase("true")) {
                                                    String clr = "red";
                                            %>
                                            <tr><td align="left" >  Request : <font color=<%= clr%>><%= listHistory.get(listHistory.size() - 1).getStatus()%></font></td></tr>
                                            <tr><td align="left">Tanggal <%= new DateTimeCuti().Bulan(listHistory.get(listHistory.size() - 1).getTglawalcuti())%>
                                                    s/d <%= new DateTimeCuti().Bulan(listHistory.get(listHistory.size() - 1).getTglakhircuti())%> </td></tr>
                                            <tr><td align="left"><input type='submit' name='OKBtn' value='OK'/></td></tr>

                                            <% }
                                            %>
                                        </table>
                                    </form>
                                </div>
                            </div>
                        </li>
                        <li id="profile"><span class="header"></span>
                            <div class="inner">
                                <%
                                    String ttl = new DateTimeCuti().Bulan(k.getTtl());
                                %>
                                <h2>Profile</h2>
                                <div id="contact_form"  class="col_w280 float_l">

                                    <form method="post" name="contact" action="#">
                                        <table>

                                            <tr>
                                                <td width="40%" align="left">Nama     </td>
                                                <td width="60%" align="left">: <%= k.getNamakaryawan()%></td>
                                            </tr>
                                            <tr>
                                                <td width="40%" align="left">Tanggal Lahir </td>
                                                <td width="60%" align="left">: <%= ttl%> </td>
                                            </tr>
                                            <tr>
                                                <td width="40%" align="left">Jenis Kelamin</td>
                                                <td width="60%" align="left">: <%= k.getJenkel()%> </td>

                                            </tr>
                                            <tr>
                                                <td width="40%" align="left">Alamat</td>
                                                <td width="60%" align="left">: <%= k.getAlamat()%> </td>

                                            </tr>
                                        </table>
                                    </form>
                                </div>
                            </div>
                        </li>
                        <li id="request"><span class="header"></span>
                            <div class="inner">
                                <h2>Request Cuti</h2>
                                <div id="contact_form"  class="col_w280 float_l">
                                    <form method="post" name="contact1" action="RequestCuti" id="formContact1">
                                        <table width="100%">
                                            <tr>
                                                <td> <input type="hidden" name="usrname" value=<% out.println(session.getAttribute("user"));%> /> </td>
                                            </tr>

                                            <tr>
                                                <td align="left">Nama </td>
                                                <td align="left">: <%= k.getNamakaryawan()%></td>
                                            </tr>   
                                            <tr>
                                                <td align="left">Awal:</td>
                                                <td>
                                                    <select id=tgl name=cmbTanggal1>
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
                                                    <select name=cmbBulan1 onchange="date(document.contact1.cmbBulan1.value);">                                                      
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
                                                    <select name=cmbTahun1 onchange="date(document.contact1.cmbBulan1.value);">                                                      
                                                        <%
                                                            Calendar c = Calendar.getInstance();
                                                            int batasAwal = c.get(Calendar.YEAR);
                                                            int batasAkhir = c.get(Calendar.YEAR) + 3;
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
                                                <td align="left">Akhir:   </td>
                                                <td>
                                                    <select id=tgl name=cmbTanggal2>
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
                                                    <select name=cmbBulan2 onchange="date2(document.contact1.cmbBulan2.value);">                                                      
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
                                                    <select name=cmbTahun2 onchange="date2(document.contact1.cmbBulan2.value);">                                                      
                                                        <%
                                                            Calendar cc = Calendar.getInstance();
                                                            int batasAwal1 = cc.get(Calendar.YEAR);
                                                            int batasAkhir1 = cc.get(Calendar.YEAR) + 3;
                                                            for (int i = batasAwal1; i <= batasAkhir1; i++) {
                                                        %>
                                                        <option value=<%= i%>><%= i%></option>    
                                                        <%
                                                            }
                                                        %>
                                                    </select>
                                                </td>
                                            </tr> 
                                            <tr>
                                                <td align="left">Alasan: </td>
                                                <td align="left">
                                                    <textarea rows="2" cols="20" name="alasancuti"></textarea>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td></td>
                                                <td align="left">
                                                    <input type="submit" id="author" name="submitrequest" class="required input_field" onclick="return cekValidasi(this.form)" />
                                                </td>
                                            </tr>
                                        </table>
                                    </form>
                                </div>
                            </div>
                        </li>
                        <li id="history"><span class="header"></span>
                            <div class="inner">
                                <h2>History</h2>
                                <div id="contact_form"  class="col_w280 float_l">
                                    <form method="post" name="contact" action="#">
                                        <%
                                            if (cuti.size() > 0) {
                                        %>
                                        <table border="1">
                                            <tr>
                                                <th>ID</th>
                                                <th>Awal Cuti</th>
                                                <th>Akhir Cuti</th>
                                                <th>Alasan</th>
                                                <th>Status</th>
                                            </tr>
                                            <%
                                                    for (int i = 0; i < cuti.size(); i++) {
                                                        long id = cuti.get(i).getId();
                                                        String tglAkhir = cuti.get(i).getTglakhircuti();
                                                        String tglAwal = cuti.get(i).getTglawalcuti();
                                                        String alasan = cuti.get(i).getAlasan();
                                                        String status = cuti.get(i).getStatus();
                                                        // Karyawan k1 = cuti.get(i).getKaryawan();

                                                        out.println("<tr><td>");
                                                        out.println(id + "</td><td>");
                                                        out.println(tglAkhir + "</td><td>");
                                                        out.println(tglAwal + "</td><td>");
                                                        out.println(alasan + "</td><td>");
                                                        out.println(status + "</td></tr>");

                                                    }
                                                } else {
                                                    out.print("Data tidak ada");
                                                }
                                            %>
                                        </table>
                                    </form> 
                                </div>
                            </div>
                        </li>
                        <li id="setting"><span class="header"></span>
                            <div class="inner">
                                <h2>Change Password</h2>
                                <div id="contact_form"  class="col_w280 float_l">
                                    <form method="post" name="contact" action="UpdatePwd">
                                        <table>   
                                            <tr>
                                                <td> <input type="hidden" name="usrname" value=<% out.println(session.getAttribute("user"));%> /> </td>

                                            </tr>
                                            <tr>
                                                <td width="70%" align="left">New Password :</td>
                                                <td>
                                                    <input type="password" id="author" name="newpwd" class="required input_field" />
                                                </td>
                                            </tr>
                                            <tr>
                                                <td width="70%" align="left">Confirm : </td>
                                                <td>
                                                    <input type="password" id="author" name="confpwd" class="required input_field" />
                                                </td>
                                            </tr>                                            
                                            <tr>
                                                <td></td>
                                                <td>
                                                    <input value="Ubah" type="submit" id="author" name="author" class="required input_field" />
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
<% } else {
        response.sendRedirect("index.jsp");
    }
%>ml">
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
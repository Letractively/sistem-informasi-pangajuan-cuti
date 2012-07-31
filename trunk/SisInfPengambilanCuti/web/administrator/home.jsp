<%-- 
    Document   : home
    Created on : Jul 28, 2012, 10:43:18 AM
    Author     : suriojiwandono
--%>
<%@page import="cuti.DateTimeCuti"%>
<%
    String log = (String) session.getAttribute("loginAdmin");
    if (log != null) {
%>
<%@page import="entity.Karyawan"%>
<%@page import="dao.KaryawanDAOImpl"%>
<%@page import="dao.KaryawanDAO"%>
<%@page import="javax.persistence.Persistence"%>
<%@page import="javax.persistence.EntityManager"%>
<%@page import="javax.persistence.EntityManagerFactory"%>
<%@page import="dao.HistoryCutiDAO"%>
<%@page import="dao.HistoryCutiDAOImpl"%>
<%@page import="entity.HistoryCuti"%>
<%@page import="java.util.List"%>
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

        <script type="text/javascript" src="../js/jquery-1-4-2.min.js"></script> 
        <link rel="stylesheet" href="../css/slimbox2.css" type="text/css" media="screen" /> 
        <script type="text/JavaScript" src="../js/slimbox2.js"></script> 
      
    </head>
    <%
        DateTimeCuti date = new DateTimeCuti();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SisInfPengambilanCutiPU");
        EntityManager em = emf.createEntityManager();
        // History Accept
        HistoryCutiDAO daoHistory = new HistoryCutiDAOImpl(em);
        List<HistoryCuti> dataHistory = daoHistory.getByStatus("Accept");
        // Pending
        HistoryCutiDAO daoPending = new HistoryCutiDAOImpl(em);
        List<HistoryCuti> dataPending = daoPending.getByStatus("Pending");
        // Karyawan
        KaryawanDAO karyawanDao = new KaryawanDAOImpl(em);
        List<Karyawan> dataKaryawan = karyawanDao.getStatusKerja("true");
    %>
    <body>
        <div id="templatemo_wrapper">
            <div id="templatemo_main">
                <div id="site_title">
                    <h1><a href="http://www.templatemo.com">Free CSS Templates</a></h1>
                </div>
                <p align="right"><a href="../adminLogout">LOG OUT</a></p>
                <div id="templatemo_content">
                    <ul class="kwicks">
                        <li id="home"><span class="header"></span>
                            <div class="inner">
                                <h2>Selamat datang di Halaman Administrator</h2>
                                <p><em>Sistem Informasi Pengambilan Cuti</em></p>
                            </div>
                        </li>
                        <li id="request"><span class="header"></span>
                            <div class="inner">
                                <h2>Request Cuti</h2>
                                <% if (dataPending.size() > 0) {%>
                                <table border="1">
                                    <tr>
                                        <th>No</th>
                                        <th>NIK</th>
                                        <th>Nama</th>
                                        <th>Awal</th>
                                        <th>Akhir</th>
                                        <th>Alasan</th>
                                        <th>Sisa Cuti</th>
                                        <th>Ditolak</th>
                                        <th>Diterima</th>
                                    </tr>
                                    <%
                                        for (int i = 0; i < dataPending.size(); i++) {

                                    %>
                                    <tr>
                                        <td><%= i + 1%></td>
                                        <td><%=dataPending.get(i).getKaryawan().getId()%></td>
                                        <td><%=dataPending.get(i).getKaryawan().getNamakaryawan()%></td>
                                        <td><%=dataPending.get(i).getTglawalcuti()%></td>
                                        <td><%=dataPending.get(i).getTglakhircuti()%></td>
                                        <td><%=dataPending.get(i).getAlasan()%></td>
                                        <td><%=dataPending.get(i).getKaryawan().getSisacuti()%></td>
                                        <td><a href="../RequestCutiAdmin?txtId=<%= dataPending.get(i).getId()%>&txtIdKaryawan=<%= dataPending.get(i).getKaryawan().getId()%>&txtCek=false">Ditolak</a></td>
                                        <td><a href="../RequestCutiAdmin?txtId=<%= dataPending.get(i).getId()%>&txtIdKaryawan=<%= dataPending.get(i).getKaryawan().getId()%>&txtCek=true">Diterima</a></td>
                                    </tr>
                                    <% }%>
                                </table>
                                <% } else {%>
                                <p><em>Tidak ada data</em></p>
                                <% }%>
                            </div>
                        </li>
                        <li id="list"><span class="header"></span>
                            <div class="inner">
                                <h2>Data Cuti</h2>
                                <% if (dataHistory.size() > 0) {%>
                                <table border="1">
                                    <tr>
                                        <th>No</th>
                                        <th>NIK</th>
                                        <th>Karyawan</th>
                                        <th>Sisa Cuti</th>
                                        <th>Awal Cuti</th>
                                        <th>Akhir Cuti</th>
                                        <th>Alasan</th>
                                        <th>Batalkan</th>
                                        <th>Status</th>
                                    </tr>
                                    <%
                                        for (int i = 0; i < dataHistory.size(); i++) {
                                            String tglAwal = dataHistory.get(i).getTglawalcuti();
                                            String tglAkhir = dataHistory.get(i).getTglakhircuti();
                                            if (new DateTimeCuti().checkTime(tglAwal, tglAkhir, 3)) {
                                    %>
                                    <tr>
                                        <td><%= i + 1%></td>
                                        <td><%=dataHistory.get(i).getKaryawan().getId()%></td>
                                        <td><%=dataHistory.get(i).getKaryawan().getNamakaryawan()%></td>
                                        <td><%=dataHistory.get(i).getKaryawan().getSisacuti()%></td>
                                        <td><%=dataHistory.get(i).getTglawalcuti()%></td>
                                        <td><%=dataHistory.get(i).getTglakhircuti()%></td>
                                        <td><%=dataHistory.get(i).getAlasan()%></td>                                        
                                        <%if (new DateTimeCuti().checkTime(tglAwal, tglAkhir, 0)) {%>
                                        <td>&nbsp;</td>
                                        <td bgcolor="green" >&nbsp;</td>
                                        <% } else if (new DateTimeCuti().checkTime(tglAwal, tglAkhir, 2)) {%>
                                        <td><a href="../requestCuti?txtId=<%= dataHistory.get(i).getId()%>&txtIdKaryawan=<%= dataHistory.get(i).getKaryawan().getId()%>&txtCek=false">Batalkan</a></td>
                                        <td bgcolor="orange">&nbsp;</td>
                                        <%}%>
                                    </tr>
                                    <%
                                            }
                                        }%>
                                </table>
                                <% } else {%>
                                <p><em>Tidak ada data</em></p>
                                <% }%>
                            </div>
                        </li>
                        <li id="history"><span class="header"></span>
                            <div class="inner">
                                <h2>History Cuti</h2>
                                <% if (dataHistory.size() > 0) {%>
                                <table border="1">
                                    <tr>
                                        <th>No</th>
                                        <th>NIK</th>
                                        <th>Karyawan</th>
                                        <th>Awal Cuti</th>
                                        <th>Akhir Cuti</th>
                                        <th>Alasan</th>
                                    </tr>
                                    <%
                                        for (int i = 0; i < dataHistory.size(); i++) {
                                            String tglAwal = dataHistory.get(i).getTglawalcuti();
                                            String tglAkhir = dataHistory.get(i).getTglakhircuti();
                                            if (new DateTimeCuti().checkTime(tglAwal, tglAkhir, 1)) {
                                    %>
                                    <tr>
                                        <td><%= i + 1%></td>
                                        <td><%=dataHistory.get(i).getKaryawan().getId()%></td>
                                        <td><%=dataHistory.get(i).getKaryawan().getNamakaryawan()%></td>
                                        <td><%=dataHistory.get(i).getTglawalcuti()%></td>
                                        <td><%=dataHistory.get(i).getTglakhircuti()%></td>
                                        <td><%=dataHistory.get(i).getAlasan()%></td>
                                    </tr>
                                    <% }
                                        }%>
                                </table>
                                <% } else {%>
                                <p><em>Tidak ada data</em></p>
                                <% }%>
                            </div>
                        </li>
                        <li id="karyawan"><span class="header"></span>
                            <div class="inner">
                                <h2>Karyawan</h2>
                                <div id="contact_form"  class="col_w280 float_l">
                                    <form method="post" name="contact" action="insertKaryawan.jsp">
                                        <input type="submit" id="author" name="author" value="Tambah Karyawan" class="required input_field" />
                                    </form>
                                </div>
<br></br>
                                <% if (dataKaryawan.size() > 0) {%>
                                <table border="1">
                                    <tr>
                                        <th>No</th>
                                        <th>NIK</th>
                                        <th>Karyawan</th>
                                        <th>Jenis Kelamin</th>
                                        <th>Alamat</th>
                                        <th>Tanggal Lahir</th>
                                        <th>Sisa Cuti</th>
                                        <th>Ubah</th>
                                    </tr>
                                    <%
                                        for (int i = 0; i < dataKaryawan.size(); i++) {
                                    %>
                                    <tr>
                                        <td><%= i + 1%></td>
                                        <td><%=dataKaryawan.get(i).getId()%></td>
                                        <td><%=dataKaryawan.get(i).getNamakaryawan()%></td>
                                        <td><%=dataKaryawan.get(i).getJenkel()%></td>
                                        <td><%=dataKaryawan.get(i).getAlamat()%></td>
                                        <td><%=dataKaryawan.get(i).getTtl()%></td>
                                        <td><%=dataKaryawan.get(i).getSisacuti()%></td>
                                        <td><a href='ubahKaryawan.jsp?txtId=<%= dataKaryawan.get(i).getId()%>
                                               &txtNama=<%= dataKaryawan.get(i).getNamakaryawan()%>
                                               &txtJenKel=<%= dataKaryawan.get(i).getJenkel()%>
                                               &txtAlamat=<%= dataKaryawan.get(i).getAlamat()%>
                                               &txtTanggallahir=<%= dataKaryawan.get(i).getTtl()%>'>Ubah</a></td>
                                    </tr>
                                    <% }%>
                                </table>
                                <% }%>
                            </div>
                        </li>
                    </ul>

                </div> <!-- END of content -->
            </div> <!-- END of templatemo_main -->
            <div id="templatemo_footer">Copyright � 2048 Your Company Name | <a href="http://www.iwebsitetemplate.com" target="_parent">Website Templates</a> by <a href="http://www.templatemo.com" target="_parent">Free CSS Templates</a></div>
        </div> <!-- END of templatemo_wrapper -->

    </body>
</html>
<% } else {
        response.sendRedirect("index.jsp");
    }
%>
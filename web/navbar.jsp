<%--
  Created by IntelliJ IDEA.
  User: usuario
  Date: 05/07/2017
  Time: 22:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="b" uri="http://bootstrapjsp.org/" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<jsp:include page="bootstrap.jsp"/>

        <nav class="navbar navbar-fixed-top navbar-default">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="index.jsp">Plan&Save</a>
                </div>
                <div id="navbar" class="navbar-collapse collapse">
                    <ul class="nav navbar-nav">
                        <li><a href="index.jsp">Home</a></li>
                        <li><a href="overview.jsp">Monitorea</a></li>
                        <li><a href="viewIncome.jsp">Tus ingresos</a></li>
                        <li><a href="viewExpense.jsp">Tus gastos</a></li>
                        <li><a href="#">Tus metas</a></li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">¿Deseas registrar algo?<span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><a href="formIncome.jsp">Ingresos</a></li>
                                <li><a href="formExpense.jsp">Gastos</a></li>
                                <li><a href="debt.jsp">Deudas</a></li>
                                <li role="separator" class="divider"></li>
                                <li><a href="#">Metas</a></li>
                            </ul>
                        </li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <li><p class="navbar-text">¿Ya tienes una cuenta?</p></li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown"><b>Ingresa</b> <span class="caret"></span></a>
                            <ul id="login-dp" class="dropdown-menu">
                                <li>
                                    <div class="row">
                                        <div class="col-md-12">
                                            Ingresar con
                                            <div class="social-buttons">
                                                <a href="#" class="btn btn-fb"><i class="fa fa-facebook"></i> Facebook</a>
                                                <a href="#" class="btn btn-tw"><i class="fa fa-twitter"></i> Twitter</a>
                                            </div>
                                            <s:form action="login" id="contact">
                                                <s:textfield name="email" placeholder="Email" size="100%"/>
                                                <s:password name="password" placeholder="Password" size="100%"/>
                                                <s:submit cssClass="btn btn-primary" value="Iniciar sesión"/>
                                            </s:form>
                                        </div>
                                        <div class="bottom text-center">
                                            ¿Nuevo aquí? <a href="signup.jsp"><b>Únete a nosotros</b></a>
                                        </div>
                                    </div>
                                </li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>



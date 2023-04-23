<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        <!-- Optional theme -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
        <!-- jQuery -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
        <!-- Latest compiled and minified JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
        <title>Benvinguda</title>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-md-8"></div>
                <div class="col-md-8">  
                    <nav>
                        <ul class="nav nav-pills">
                            <li role="presentation" class="active">
                                <a href="<spring:url value= '/'/>">
                                    Inici
                                </a>
                            </li>
                            <sec:authorize access="hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')">
                            <li role="Presentation" class="">
                                <a href="<c:url value="/j_spring_security_logout" />" class="btn btndanger btn-mini pull-right">desconnectar</a>
                            </li>
                            </sec:authorize>
                        </ul>    
                    </nav>
                </div>
            </div>
        </div>

        <section>
            <div class="jumbotron">
                <div class="container">
                    <h1> ${banner} </h1>
                                            
                        <p> ${tagline} </p>
                </div>
            </div>
        </section>
        <section class="container">
            <form:form modelAttribute="newDevice" class="form-horizontal">
                <fieldset>
                    <legend>Afegir Tablet</legend>
                   <div class="form-group">
                        <label class="control-label col-lg-2 col-lg-2" for="codi">Codi</label>
                        <div class="col-lg-10">
                            <form:input id="codi" path="codi" type="text" class="form:input-large"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-lg-2 col-lg-2" for="marca">Marca</label>
                        <div class="col-lg-10">
                            
                            <form:input id="marca" path="marca" type="text" class="form:input-large"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-lg-2 col-lg-2" for="preu">Preu</label>
                        <div class="col-lg-10">
                            <form:input id="preu" path="preu" type="number" class="form:input-large"/>
                        </div>
                    </div>   
                    <div class="form-group">
                        <label class="control-label col-lg-2 col-lg-2" for="pantalla">Mida de pantalla</label>
                        <div class="col-lg-10">
                            <form:input id="pantalla" path="pantalla" type="text" class="form:input-large"/>
                        </div>
                    </div>                     
                    <div class="form-group">
                        <label class="control-label col-lg-2 col-lg-2" for="resolucio">Resolució</label>
                        <div class="col-lg-10">
                            <form:input id="resolucio" path="resolucio" type="text" class="form:input-large"/>
                        </div>
                    </div>   
                    <div class="form-group">
                        <label class="control-label col-lg-2 col-lg-2" for="pes">Pes</label>
                        <div class="col-lg-10">
                            <form:input id="pes" path="pes" type="number" class="form:input-large"/>
                        </div>
                    </div>                           
                    <div class="form-group">
                        <label class="control-label col-lg-2 col-lg-2" for="estoc">Estoc</label>
                        <div class="col-lg-10">
                            <form:input id="estoc" path="estoc" type="number" class="form:input-large"/>
                        </div>
                    </div>  
                    <div class="form-group">
                        <div class="col-lg-offset-2 col-lg-10">
                            <input type="submit" id="btnAdd" class="btn btn-primary"
                                   value ="Crear"/>
                        </div>
                    </div> 
                </fieldset>
            </form:form>
        </section>
    </body>
</html>
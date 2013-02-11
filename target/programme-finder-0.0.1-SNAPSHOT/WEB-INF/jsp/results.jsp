<!doctype html>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
    <head>
        <meta charset="utf-8">
        <title>BBC Programme Finder</title>

        <meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <link href="http://twitter.github.com/bootstrap/assets/css/bootstrap.css" rel="stylesheet">
        <link href="http://twitter.github.com/bootstrap/assets/css/bootstrap-responsive.css" rel="stylesheet">
        <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
        <!--[if lt IE 9]>
          <script src="http://twitter.github.com/bootstrap/assets/js/html5shiv.js"></script>
        <![endif]-->

        <!-- Fav and touch icons -->
        <link rel="apple-touch-icon-precomposed" sizes="144x144" href="http://twitter.github.com/bootstrap/assets/ico/apple-touch-icon-144-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="114x114" href="http://twitter.github.com/bootstrap/assets/ico/apple-touch-icon-114-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="72x72" href="http://twitter.github.com/bootstrap/assets/ico/apple-touch-icon-72-precomposed.png">
        <link rel="apple-touch-icon-precomposed" href="http://twitter.github.com/bootstrap/assets/ico/apple-touch-icon-57-precomposed.png">
        <link rel="shortcut icon" href="http://twitter.github.com/bootstrap/assets/ico/favicon.png">
        <style type="text/css">


        </style>
    </head>

    <body>
        <div class="navbar navbar-fixed-top">
            <div class="navbar-inner">
                <div class="container">
                    <a href="/" class="brand">BBC Radio Programme Finder</a>
                </div>
            </div>
        </div>

        <div class="container-fluid">
            <div class="row-fluid">
                <div class="span12">
                    <div class="hero-unit">
                        <h2>Programmes</h2>
                        <c:choose>
                            <c:when test="${fn:length(episodes)>0}">
                                <p>${fn:length(episodes)} results found</p>
                            </c:when>
                            <c:otherwise>
                                No results found
                            </c:otherwise>                  
                                
                        </c:choose>
                        
                    </div>

                </div>
            </div>
            <%-- Loop through any returned episode data and display more details --%>
            <c:forEach items="${episodes}" var="episode">
                <div class="row-fluid">
                    <ul class="thumbnails">
                        <li class="span12">
                            <div class="thumbnail">
                                <img src="http://placehold.it/300x200&text=${episode.toplevel_container_title}" />
                                <div class="caption">
                                    <h3>${episode.toplevel_container_title}</h3>
                                    <h4>${episode.title}</h4>
                                    <p>${episode.synopsis}</p>
                                    <c:if test="${not empty episode.categories}">
                                        Tags: 
                                        <c:forEach items="${episode.categories}" var="category" varStatus="status">
                                            ${category.text}${not status.last ? ', ' : ''}
                                        </c:forEach>
                                    </c:if>
                                    <p></p>
                                    <c:choose>
                                        <c:when test="${episode.availability == 'FUTURE'}">
                                            <p><a href="http://www.bbc.co.uk${episode.my_url}" class="btn btn-primary">Coming Soon</a></p>
                                        </c:when>
                                        <c:when test="${episode.media_type == 'audio'}">
                                            <p><a href="http://www.bbc.co.uk${episode.my_url}" class="btn btn-primary">Listen</a></p>
                                        </c:when>
                                        <c:when test="${episode.media_type == 'video'}">
                                            <p><a href="http://www.bbc.co.uk${episode.my_url}" class="btn btn-primary">Watch</a></p>
                                        </c:when>
                                    </c:choose>
                                </div>
                            </div>
                        </li>                        
                    </ul>
                </div>
            </c:forEach>

        </div>           

        <script src="http://twitter.github.com/bootstrap/assets/js/jquery.js"></script>  

    </body>
</html>

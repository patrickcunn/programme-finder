<!doctype html>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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
                        <p>Enter your search term in the field below for suggestions or hit Search for detailed results</p>
                    </div>

                </div>
            </div>
            <div class="row-fluid">
                <div class="span12">
                    <h3>Search</h3>
                    <form:form method="POST" modelAttribute="search">
                        <form:errors path="*">
                            <c:forEach items="${messages}" var="message">
                                <div class="alert alert-error"> 
                                    <a class="close" data-dismiss="alert">×</a>  
                                    <strong>Error!</strong> ${message}
                                </div>
                            </c:forEach>
                        </form:errors>
                        <input id="searchTerm" name="searchTerm" type="text" class="span9 required" style="margin: 0 auto;" data-provide="typeahead" data-items="4" autocomplete="off">
                        <button type="submit" class="btn btn-primary">Search</button>
                        <!--
                         This is an example of how to customise the detailed search form to only show radio shows
                        <input type="hidden" name="serviceType" id="serviceType" value="radio"/>
                        -->
                    </form:form>

                </div>
            </div>
        </div>           

        <script src="http://twitter.github.com/bootstrap/assets/js/jquery.js"></script>  
        <script src="http://twitter.github.com/bootstrap/assets/js/bootstrap-typeahead.js"></script> 
        <script type="text/javascript" src="http://jzaefferer.github.com/jquery-validation/jquery.validate.js"></script>

        <script>
            var results,map;
            //Uses bootstrap typeahead functionality to get a dynamic list of Programmes
            $('#searchTerm').typeahead({
                minLength: 3,
                source: function(query, process) {
                    $.getJSON('search', { query: query}, function(data) {
                        results = [];
                        map = {};
                        for (i=0;i<data.length;i++){
                            map[data[i]['title']] = data[i]['link'];
                            results.push(data[i]['title']);
                        }
                        process(results);
                    });
                },
                updater: function (item) {
                    console.log(map[item]);
                    window.location.href = map[item];
                }
            });
            
            // Validates form entry
            $(document).ready(function(){
                $("#search").validate();
            });


        
        </script> 
    </body>
</html>

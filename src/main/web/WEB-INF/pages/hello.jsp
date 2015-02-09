<html ng-app>
<head>
    <title> Spring MVC + AngularJS Demo </title>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.8/angular.min.js"></script>
    <script>
        function Hello($scope, $http) {
            $http.get('http://localhost:8080/beci/springcontent.json').
                    success(function(data) {
                        $scope.profileModel = data;
                    });
        }
    </script>
</head>

<body>

    <div ng-controller="Hello">
        <h2>Spring MVC + AngularJS Demo</h2>
        <p>First Name : {{profileModel.firstName}}</p>
        <p>Last Name : {{profileModel.lastName}}</p>
    </div>

</body>

<%--<script>--%>
    <%--function Hello($scope, $http) {--%>
        <%--$http.get('http://localhost:8080/beci/springcontent').--%>
                <%--success(function(data) {--%>
                    <%--$scope.user = data;--%>
                <%--});--%>
    <%--}--%>
    <%--require([--%>
        <%--'dojo/dom',--%>
        <%--'dojo/dom-construct'--%>
    <%--], function (dom, domConstruct) {--%>
        <%--var greetingNode = dom.byId('greeting');--%>
        <%--domConstruct.place('<i> Dojo!</i>', greetingNode);--%>
    <%--});--%>

    <%--require([--%>
        <%--'dojo/dom',--%>
        <%--'dojo/fx',--%>
        <%--'dojo/domReady!'--%>
    <%--], function (dom, fx) {--%>
        <%--// The piece we had before...--%>
        <%--var greeting = dom.byId('greeting');--%>
        <%--greeting.innerHTML += ' from Dojo!';--%>

        <%--// ...but now, with an animation!--%>
        <%--fx.slideTo({--%>
            <%--node: greeting,--%>
            <%--top: 100,--%>
            <%--left: 200--%>
        <%--}).play();--%>
    <%--});--%>

<%--</script>--%>

<%--<script>--%>

<%--//    dojo.ready(function(){--%>
<%--//        alert('Ready');--%>
<%--//    });--%>
<%--//--%>
<%--//    function test(){--%>
<%--//        alert('test')--%>
<%--//    }--%>
<%--//</script>--%>

</html>
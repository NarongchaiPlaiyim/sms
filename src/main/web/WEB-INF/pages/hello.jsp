<html>
<script src="//ajax.googleapis.com/ajax/libs/dojo/1.10.1/dojo/dojo.js"></script>

<body>
    <a href="http://www.becicorp.com/"><h1>Welcome to BECi corporation Co.,Ltd</h1></a>
    Please enter your name: <input type="text" id="name" />


    <button data-dojo-type="dijit.form.Button" id="helloButton">
        Hello World!
    </button>
    <h1 id="greeting">Hello</h1>

    <form>
        <button dojoType="dijit.form.Button" id="cssxSelectClass1">
            onclick
            <script type="dojo/method" event="onClick">
                function test(){
                    alert('Ready');
                }
            </script>
        </button>
    </form>

</body>

<script>

    require([
        'dojo/dom',
        'dojo/dom-construct'
    ], function (dom, domConstruct) {
        var greetingNode = dom.byId('greeting');
        domConstruct.place('<i> Dojo!</i>', greetingNode);
    });

    require([
        'dojo/dom',
        'dojo/fx',
        'dojo/domReady!'
    ], function (dom, fx) {
        // The piece we had before...
        var greeting = dom.byId('greeting');
        greeting.innerHTML += ' from Dojo!';

        // ...but now, with an animation!
        fx.slideTo({
            node: greeting,
            top: 100,
            left: 200
        }).play();
    });

</script>

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
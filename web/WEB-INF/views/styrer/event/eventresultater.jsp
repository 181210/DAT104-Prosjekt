<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="../../../partials/header.jsp" />
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<script src="public/js/charts/eventResultater.js"></script>
<script type="text/javascript">

// Create our data table.
var array = [ ['Tid', 'Fornoyd', 'Noytral', 'Misfornoyd'], 
<c:forEach items="${requestScope.formaterteTilbakemeldinger}" var="t">
	[new Date("${t.tid.toString()}"), ${t.fornoyd}, ${t.noytral}, ${t.misfornoyd}],
</c:forEach>
];

</script>
<c:set var = "a" scope = "request" value = "${aktivitet}"/>
<c:set var = "e" scope = "request" value = "${event}"/>
</head>
<body>

<h2>${a.navn}:</h2>
<h1>Tilbakemeldinger for "${e.navn}":</h1>
<div id="dashboard_div">
  <div id="chart_div"></div>
  <div id="filter_div"></div>
  <button class="ui blue basic button" id="byttKnapp"
		onclick="switchView()">Bytt graf</button>
		<button class="ui green basic button" id="green"
		onclick="showColumn(1, this.id)">Vis forn�yd</button>
		<button class="ui orange basic button" id="orange"
		onclick="showColumn(2, this.id)">Vis n�ytral</button>
		<button class="ui red basic button" id="red"
		onclick="showColumn(3, this.id)">Vis misforn�yd</button>
		<button class="ui blue basic button" id="visAlleKnapp"
		onclick="showAll()">Vis alle</button>
</div>
</body>
</html>
<jsp:include page="../../../partials/footer.jsp" />
<html>
<head>
<title></title>
</head>
<body>
<%
	WbdProductionHelper helper = null;
	JspHelper jh = null;
	String snippetVar_myProperty;
	String snippetVar_thisNavpoint;
%>
<!--START-->
<%@page import="tooltwist.wbd.WbdProductionHelper"%>
<%@page import="com.dinaa.data.XData"%>
<%@page import="tooltwist.misc.JspHelper"%>
<%@page import="tooltwist.ecommerce.AutomaticUrlParametersMode"%>
<%@page import="tooltwist.ecommerce.RoutingUIM"%>
<%
	// Get the production helper for this widget
//	TemplateProductionHelper h = (TemplateProductionHelper) helper;
//	XData data = h.getData(jh);
%>

<script %%idDefinition%%type="text/template">
<h1>YEAH.<br>
fname: {{firstName}}<br>
surname:{{lastName}}</h1>
Blog: {{blogURL}}
</script>

<span id="sampleArea">Good evening</span><br>

	
<!--END-->
</body>
</html>

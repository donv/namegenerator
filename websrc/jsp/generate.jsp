<%@ taglib uri="/WEB-INF/struts-bean.tld"  prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-form.tld"  prefix="form" %>
<%@ taglib uri="/WEB-INF/struts-html.tld"  prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
        
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html:html>
<head>
  <meta http-equiv="Content-Style-Type" content="text/css">
  <link href="<html:rewrite page="/theme/Master.css" />" rel="stylesheet" type="text/css">
  <title>Generer Navn</title>
</head>

<body>

<form:form type="generateForm" action="generate.jsp" focus="count" method="post" scope="session">

<table>
<logic:present name="lists">
<tr>
  <td>Kombinasjon</td>
  <td>
    <form:select property="combinationName">
<bean:define id="lists" name="lists" />
<logic:iterate id="list" name="lists" type="String">
      <form:option value="<%=list%>"><%=list%></form:option>
</logic:iterate>
    </form:select>
  </td>
</tr>
</logic:present>

<tr>
  <td>Uniqueness</td>
  <td>
    <form:select property="uniqueness">
      <form:option value="history">Historically Unique</form:option>
      <form:option value="local">Locally Unique</form:option>
      <form:option value="none">Not Unique</form:option>
    </form:select>
  </td>
</tr>

<tr>
  <td>Predictability</td>
  <td>
    <form:text property="predictability" maxlength="3" size="3" />
  </td>
</tr>

<tr>
  <td>Tries</td>
  <td>
    <form:text property="tries" maxlength="3" size="3" />
  </td>
</tr>

<tr>
  <td>Count</td>
  <td>
    <form:text property="count" maxlength="3" size="3" />
    <form:submit property="cmd" value="Generate" />
  </td>
</tr>

</table>
</form:form>

<logic:present name="names">

<h2>Generated names</h2>

<form:form type="useForm" action="/use" method="post" scope="session">

<table>

<logic:iterate name="names" id="name" indexId="index" >
<tr>
	<td align="right">
		<%=index%>
	</td>
	<td>
	    <form:checkbox property="marked" />
	</td>
	<td>
		<%=name%>
	</td>
</tr>
</logic:iterate>

<tr>
	<td>
	</td>
	<td>
	</td>
	<td>
	    <form:submit property="cmd" value="Use" />
	    <form:submit property="cmd" value="Use and Promote" />
	    <form:submit property="cmd" value="Ignore" />
	</td>
</tr>

</table>

</form:form>

</logic:present>

</body>
</html:html>

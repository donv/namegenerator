<%@ taglib uri="/WEB-INF/struts-bean.tld"
        prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-form.tld"
        prefix="form" %>
<%@ taglib uri="/WEB-INF/struts-html.tld"
        prefix="html" %>
        
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
<tr>
  <td>Kombinasjon</td>
  <td>
    <form:select property="combinationName">
      <form:option value="DvergeNavn">Dvergenavn</form:option>
      <form:option value="CitydwellerNavn">Citydwellernavn</form:option>
    </form:select>
  </td>
</tr>

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
  <td>Count</td>
  <td>
    <form:text property="count" maxlength="3" size="3" />
    <form:submit property="cmd" value="Generate" />
  </td>
</tr>

</table>
</form:form>

</body>
</html>

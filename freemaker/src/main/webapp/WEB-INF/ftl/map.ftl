<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<#if obj?exists>
 <#list obj?keys as key> 
    <tr>
            <td>${key}</td>
            <td>${obj[key]}</td>
    </tr>
 </#list>
 </#if>
</body>
</html>
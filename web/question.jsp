<%@ page import="model.Poll" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Question" %>
<%@ page import="model.Answer" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
<h1>Насколько вы жизнелюбивы</h1>
<form action="/result" method="post">
<%
    List<Question> all = (List<Question>) request.getAttribute("allQuestions");
    for (Question question : all) {%>
<h2><%=question.getText()%>
</h2>
    <fieldset>
<%List<Answer> allAnswers = (List<Answer>) request.getAttribute("list");

for (Answer answer : allAnswers){
    if (answer.getQuestionId() == question.getId()){
%>

        <input id="<%=answer.getId()%>" type="checkbox" value="<%=answer.getId()%>" name="answerId" style="display: flex"><label for="<%=answer.getId()%>"><%=answer.getText()%>
    </label>
        <%
    }
}
%>

</fieldset>
<%
    }
%>
    <input type="submit" name="Enter">
</form>

</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>用户列表</title>
</head>
<body>

<table>
    <thead>
    <tr>
        <th>标题</th>
        <th>语言</th>
    </tr>
    </thead>
    <tbody id="movieList"></tbody>
</table>
<script type="text/javascript" src="/static/jsrender/jsrender.min.js"></script>
<script id="movieTemplate" type="text/x-jsrender">
	<tr>
		<td>{{>title}}</td>
		<td>
			{{if languages}}
				Alternative languages: <em>{{>languages}}</em>.
			{{else subtitles}}
				Original language only... <br/>subtitles in <em>{{>subtitles}}</em>.
			{{else}}
				Original version only, without subtitles.
			{{/if}}
		</td>
	</tr>
</script>
<script>
    var movies = [
        {
            title: "title1",
            languages: "English and French",
            subtitles: "English"
        },
        {
            title: "title2",
            subtitles: "French and Spanish"
        },
        {
            title: "title3"
        },
        {
            title: "title4",
            languages: "Mandarin and Chinese"
        }
    ];

    $("#movieList").html($("#movieTemplate").render(movies));
</script>
</body>
</html>
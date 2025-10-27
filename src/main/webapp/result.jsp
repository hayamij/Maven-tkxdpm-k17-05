<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html>

<html>
<head>
    <title>Kết quả - Nhân 2 số</title>
    <style>
        .result-box {
            padding: 20px;
            margin: 20px 0;
            border-radius: 10px;
            text-align: center;
        }
        .chan {
            background-color: #ffcccc;
            color: red;
        }
        .le {
            background-color: #ccffcc;
            color: green;
        }
        .result-number {
            font-size: 24px;
            font-weight: bold;
        }
        .chan-le-text {
            font-size: 32px;
            font-weight: bold;
            margin-top: 10px;
        }
    </style>
</head>
<body>
    <h1>Kết quả</h1>

    <c:choose>
        <c:when test="${not empty errorMessage}">
            <div style="color:red;">${errorMessage}</div>
        </c:when>
        <c:otherwise>
            <div class="result-box ${model.laChan ? 'chan' : 'le'}">
                <div class="result-number">Kết quả: ${model.result}</div>
                <div class="chan-le-text">${model.laChan ? 'CHẴN' : 'LẺ'}</div>
            </div>
        </c:otherwise>
    </c:choose>

    <a href="${pageContext.request.contextPath}/index.jsp">Quay lại</a>
</body>
</html>

<%@include file="taglib.jsp"%>
<c:set var="title" value="Search Results" />
<c:import url="head.jsp"/>
<c:import url="nav.jsp"/>

<script type="text/javascript" class="init">
    $(document).ready( function () {
        $('#userTable').DataTable();
    } );
</script>
<html>
<body>

<div class="container-fluid">
    <h2>Search Results: </h2>
    <table id="userTable" class="display" cellspacing="0" width="100%">
        <thead>
        <th>Name</th>
        <th>User Name</th>
        </thead>
        <tbody>
        <c:forEach var="user" items="${users}">
            <tr>
                <td>${user.firstName} ${user.lastName}</td>
                <td>${user.userName}</td>
            </tr>


        </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>

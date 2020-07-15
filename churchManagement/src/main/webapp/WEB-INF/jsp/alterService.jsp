<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:import url="include/header.jsp"></c:import>

<div class="container" style="margin-top: 30px">
	<h3>Liturgy</h3>
	<ul class="nav nav-tabs">
		<li class="nav-item"><a class="nav-link" href="reading">Reading</a>
		</li>
		<li class="nav-item"><a class="nav-link active" href="alterService">Alter
				Service</a></li>
	</ul>
	<div class="row">

		<div class="col-sm-8">
			<div class="panel-body">

				<table id="recruitmentList"
					class="table table-striped table-bordered" style="width: 100%">
					<thead>
						<tr>
							<th>Alter Server</th>
							<th>Date</th>
							<th>Name</th>
							
						</tr>
					</thead>

					<tbody>

						<c:forEach items="${alterServiceMapList}" var="alterServiceMap">

							<tr>
								<td><c:out value="${alterServiceMap.alterService.alterServiceType}"></c:out></td>
								<td><f:formatDate value="${alterServiceMap.alterServiceDate}"
										pattern="MM/dd/yyyy" /></td>
								<td><c:out value="${alterServiceMap.member.firstName} ${alterServiceMap.member.lastName}"></c:out></td>
								<td><a href="editAlterService?id=${alterServiceMap.alterServiceMapId}">Edit</a> / <a
									href="deleteAlterService?id=${alterServiceMap.alterServiceMapId}">Delete</a></td>
							</tr>
						</c:forEach>

					</tbody>

				</table>
			</div>
		</div>



		<div class="col-sm-4">
			<div class="panel panel-primary">
				<div class="panel-heading">User Entry</div>
				<div class="panel-body">

					<form:form id="AlterServiceMapForm" name="AlterServiceMapForm" action="processAlterService"
						method="post" modelAttribute="alterServiceMap">

						<form:hidden path="alterServiceMapId" id="alterServiceMapId" />

						<div class="form-group">
							<label for="">Alter Server</label>
							<form:select path="alterService.alterServiceId" id="alterServiceType">
								<form:option value="${null}">Select AlterService</form:option>
								<form:options items="${alterServiceTypeList}" itemLabel="alterServiceType"
									itemValue="alterServiceId" />
							</form:select>
							<div class="help-block with-errors"></div>
						</div>

						<div class="form-group">
							<label for="alterServiceDate">Date</label>

							<form:input path="alterServiceDate" id="alterServiceDate" name="alterServiceDate"
								cssClass="form-control" placeholder="AlterServicet Date MM/DD/YYYY" required="true" />
							<p>
								<form:errors path="alterServiceDate" cssStyle="color:red"></form:errors>
								<p />
						</div>

						<div class="form-group">
							<label for="member">Assigned To</label>
							<form:select path="member.memberId" id="member">
								<form:option value="${null}">Select One</form:option>
								<form:options items="${memberList}" itemLabel="fullName"
									itemValue="memberId" />
							</form:select>
							<div class="help-block with-errors"></div>
						</div>

						<button type="submit" class="btn btn-default">Submit</button>

						<button type="button" class="btn btn-default"
							onclick="location.href='/clearAlterService'">Clear</button>
					</form:form>

				</div>
			</div>
		</div>
	</div>
</div>
</div>

<c:import url="include/footer.jsp"></c:import>
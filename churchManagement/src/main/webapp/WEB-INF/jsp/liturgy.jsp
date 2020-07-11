<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:import url="include/header.jsp"></c:import>

<div class="container" style="margin-top: 30px">
	<h3>Liturgy</h3>
	<ul class="nav nav-tabs">
		<li class="nav-item"><a class="nav-link active" href="#">Reading</a>
		</li>
		<li class="nav-item"><a class="nav-link" href="#">Alter
				Service</a></li>
	</ul>
	<div class="row">

		<div class="col-sm-8">
			<div class="panel-body">

				<table id="recruitmentList"
					class="table table-striped table-bordered" style="width: 100%">
					<thead>
						<tr>
							<th>Reading</th>
							<th>Description</th>
							<th>Date</th>
							<th>Name</th>
							
						</tr>
					</thead>

					<tbody>

						<c:forEach items="${readingMapList}" var="readingMap">

							<tr>
								<td><c:out value="${readingMap.reading.readingType}"></c:out></td>
								<td><c:out value="${readingMap.readingDesc}"></c:out></td>
								<td><f:formatDate value="${readingMap.readingDate}"
										pattern="MM/dd/yyyy" /></td>
								<td><c:out value="${readingMap.member.firstName} ${readingMap.member.lastName}"></c:out></td>
								<td><a href="editReading?id=${readingMap.readingMapId}">Edit</a> / <a
									href="deleteReading?id=${readingMap.readingMapId}">Delete</a></td>
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

					<form:form id="ReadingMapForm" name="ReadingMapForm" action="processReading"
						method="post" modelAttribute="readingMap">

						<form:hidden path="readingMapId" id="readingMapId" />

						<div class="form-group">
							<label for="readingType">Reading Type</label>
							<form:select path="reading.readingId" id="readingType">
								<form:option value="${null}">Select Reading</form:option>
								<form:options items="${readingTypeList}" itemLabel="readingType"
									itemValue="readingId" />
							</form:select>
							<div class="help-block with-errors"></div>
						</div>

						<div class="form-group">
							<label for="readingDate">Date</label>

							<form:input path="readingDate" id="readingDate" name="readingDate"
								cssClass="form-control" placeholder="Readingt Date MM/DD/YYYY" required="true" />
							<p>
								<form:errors path="readingDate" cssStyle="color:red"></form:errors>
								<p />
						</div>


						<div class="form-group">
							<label for="readingDesc">Description:</label>
							<form:input path="readingDesc" id="readingDesc" name="readingDesc"
								placeholder="Description" cssClass="form-control" />
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
							onclick="location.href='/clearReading'">Clear</button>
					</form:form>

				</div>
			</div>
		</div>
	</div>
</div>
</div>

<c:import url="include/footer.jsp"></c:import>
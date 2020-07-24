<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:import url="include/header.jsp"></c:import>
<script>
	function WardDetailsDispay(eventType) {
		var wardDetailsField = document.getElementById("wardDetails");
		if (eventType === "Ward") {
			alert("ward")
			wardDetailsField.style.display = "block";
		} else {
			alert("common")
			wardDetailsField.style.display = "none";
		}
	}
</script>
<h3>Events</h3>

<div class="container" style="margin-top: 30px">
	<div class="row">

		<div class="col-sm-8">
			<div class="panel-body">

				<table id="recruitmentList"
					class="table table-striped table-bordered" style="width: 100%">
					<thead>
						<tr>
							<th>Name</th>
							<th>Date</th>
							<th>Description</th>
							<th>Type</th>
							<th>Ward</th>
							<th>Action</th>
						</tr>
					</thead>

					<tbody>

						<c:forEach items="${eventsList}" var="event">

							<tr>
								<td><c:out value="${event.eventName}"></c:out></td>
								<td><f:formatDate value="${event.eventDate}"
										pattern="MM/dd/yyyy" /></td>
								<td><c:out value="${event.eventDesc}"></c:out></td>
								<td><c:out value="${event.eventType}"></c:out></td>
								<td><c:out value="${event.ward.wardName}"></c:out></td>
								<td><a href="editEvent?id=${event.eventId}">Edit</a> / <a
									href="deleteEvent?id=${event.eventId}">Delete</a></td>
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

					<form:form id="EventsForm" name="EventsForm" action="processEvent"
						method="post" modelAttribute="event">

						<form:hidden path="eventId" id="eventId" />

						<div class="form-group">
							<label for="eventName">Name</label>

							<form:input path="eventName" id="eventName" name="eventName"
								cssClass="form-control" placeholder="Event Name" required="true" />
							<p>
								<form:errors path="eventName"></form:errors>
							<p />
						</div>

						<div class="form-group">
							<label for="eventDate">Date</label>

							<form:input path="eventDate" id="eventDate" name="eventDate"
								cssClass="form-control" placeholder="EventDate" required="true" />
							<p>
								<form:errors path="eventDate" cssStyle="color:red"></form:errors>
							<p />
						</div>


						<div class="form-group">
							<label for="eventDesc">Description:</label>
							<form:input path="eventDesc" id="eventDesc" name="eventDesc"
								placeholder="Description" cssClass="form-control" />
						</div>

						<%-- <div class="form-group">
							<label for="eventType">Type:</label>

							<form:input path="eventType" id="eventType" name="eventType"  placeholder="Type"
								cssClass="form-control" required="true" />
							<p>
								<form:errors path="eventType"></form:errors>
							<p />
						</div> --%>

						<div class="form-group">
							<label for="eventType">Type:</label>
							<form:select id="eventType" path="eventType"
								onchange="WardDetailsDispay(this.value)">
								<form:option value="${null}">Select One</form:option>
								<form:options items="${eventTypeList}" />
							</form:select>
							<div class="help-block with-errors"></div>
						</div>


						<div class="form-group" id="wardDetails">
							<label for="ward">Ward: </label>
							<form:select path="ward.wardId" id="wardId">
								<form:option value="${null}">Select One</form:option>
								<form:options items="${wardList}" itemLabel="wardName"
									itemValue="wardId" />
							</form:select>
							<div class="help-block with-errors"></div>
						</div>

						<button type="submit" class="btn btn-default">Submit</button>

						<button type="button" class="btn btn-default"
							onclick="location.href='/clearEvent'">Clear</button>
					</form:form>

				</div>
			</div>
		</div>
	</div>
	<c:import url="include/footer.jsp"></c:import>
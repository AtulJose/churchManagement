<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:import url="include/header.jsp"></c:import>


<div style="margin-top: 30px; margin-left: 20px; margin-right: 20px">
	<h3>Contact list</h3>
	<div class="row">

		<div class="col-sm-9">
			<div class="panel-body">

				<table id="mainTable" class="table table-condensed"
					style="width: 100%">
					<thead>
						<tr>
							<th style="width: 70%; text-align: center">Members</th>
							<th style="text-align: center">Family</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>
								<table id="MemberDetails" class="table table-bordered">
									<thead>
										<tr>
											<th>Name</th>
											<th>Role</th>
											<th>Phone</th>
											<th>Email</th>
											<th style="width: 10%">Actions</th>
										</tr>
									</thead>

								</table>
							</td>
							<td>
								<table id="FamilyDetails"
									class="table table-striped table-bordered">
									<thead>
										<tr>
											<th>Address</th>
											<th>Family</th>
											<th style="width: 10%">Actions</th>
										</tr>
									</thead>

								</table>


							</td>
						</tr>
						<c:forEach items="${familyList}" var="family">
							<tr>
								<td>
									<table id="MemberDetails"
										class="table table-striped table-bordered">

										<tbody>

											<c:forEach items="${family.memberList}" var="member">

												<tr>
													<td><c:out
															value="${member.firstName} ${member.lastName}"></c:out></td>
													<td><c:out value="${member.relationshipToFamily}"></c:out></td>
													<td><c:out value="${member.phone}"></c:out></td>
													<td><c:out value="${member.email}"></c:out></td>
													<td style="width: 10%"><a
														href="editEvent?id=${member.memberId}">Edit</a> / <a
														href="deleteEvent?id=${member.memberId}">Delete</a></td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
								</td>
								<td>
									<table id="FamilyDetails"
										class="table table-striped table-bordered">
										<tbody>

											<tr>
												<td><c:out value="${family.addressLn1}" /><br />
												<c:out value="${family.addressLn2}" /><br />
												<c:out value="${family.city}" /><br />
												<c:out value="${family.state},${family.zip}" /></td>
												<td><c:out value="${family.familyName}"></c:out></td>
												<td style="width: 10%"><a
													href="editEvent?id=${family.familyId}">Edit</a> / <a
													href="deleteEvent?id=${family.familyId}">Delete</a></td>
											</tr>
										</tbody>
									</table>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>



		<div class="col-sm-3">
			<div class="panel panel-primary" id="memberEntry">
				<div class="panel-heading">User Entry</div>
				<div class="panel-body">

					<%-- <form:form id="EventsForm" name="EventsForm" action="processEvent"
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
								cssClass="form-control" />
						</div>

						<div class="form-group">
							<label for="eventType">Type:</label>

							<form:input path="eventType" id="eventType" name="eventType"
								cssClass="form-control" required="true" />
							<p>
								<form:errors path="eventType"></form:errors>
							<p />
						</div>


						<div class="form-group">
							<label for="ward">Ward</label>
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
					</form:form> --%>

				</div>
			</div>
		</div>
	</div>
</div>


<c:import url="include/footer.jsp"></c:import>
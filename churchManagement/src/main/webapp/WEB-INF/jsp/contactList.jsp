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
														href="editFamily?id=${member.memberId}">Edit</a> / <a
														href="deleteFamily?id=${member.memberId}">Delete</a></td>
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
												<td><c:out value="${family.addressLn1}" /><br /> <c:out
														value="${family.addressLn2}" /><br /> <c:out
														value="${family.city}" /><br /> <c:out
														value="${family.state},${family.zip}" /></td>
												<td><c:out value="${family.familyName}"></c:out></td>
												<td style="width: 10%"><a
													href="editFamily?id=${family.familyId}">Edit</a> / <a
													href="deleteFamily?id=${family.familyId}">Delete</a> / <a
														href="addMemeber?id=${family.familyId}">Add Member</a>
													</td>
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
			<div class="panel panel-primary" id="FamilyEntry">
				<div class="panel-heading">Family Entry</div>
				<div class="panel-body">

					<form:form id="FamilyForm" name="FamilyForm" action="processFamily"
						method="post" modelAttribute="family">

						<form:hidden path="familyId" id="familyId" />

						<div class="form-group">
							<label for="familyName">Name</label>

							<form:input path="familyName" id="familyName" name="familyName"
								cssClass="form-control" placeholder="Family Name"
								required="true" />
							<p>
								<form:errors path="familyName"></form:errors>
							<p />
						</div>
						<div class="form-group">
							<label for="city">City</label>

							<form:input path="city" id="city" name="city"
								cssClass="form-control" placeholder="City" required="true" />
							<p>
								<form:errors path="city"></form:errors>
							<p />
						</div>
						<div class="form-group">
							<label for="addressLn1">Street Address</label>

							<form:input path="addressLn1" id="addressLn1" name="addressLn1"
								cssClass="form-control" placeholder="Street address"
								required="true" />
							<p>
								<form:errors path="addressLn1"></form:errors>
							<p />
						</div>
						<div class="form-group">
							<label for="addressLn2">address Line 2</label>

							<form:input path="addressLn2" id="addressLn2" name="addressLn2"
								cssClass="form-control" placeholder="addressLn2" required="true" />
							<p>
								<form:errors path="addressLn2"></form:errors>
							<p />
						</div>
						<div class="form-group">
							<label for="zip">zip</label>

							<form:input path="zip" id="zip" name="zip"
								cssClass="form-control" placeholder="Cip" required="true" />
							<p>
								<form:errors path="zip"></form:errors>
							<p />
						</div>
						<div class="form-group">
							<label for="state">State</label>

							<form:input path="state" id="state" name="state"
								cssClass="form-control" placeholder="State" required="true" />
							<p>
								<form:errors path="state"></form:errors>
							<p />
						</div>
						<div class="form-group">
							<label for="nativePlace">Native Place</label>

							<form:input path="nativePlace" id="nativePlace"
								name="nativePlace" cssClass="form-control"
								placeholder="Native Place" required="true" />
							<p>
								<form:errors path="nativePlace"></form:errors>
							<p />
						</div>
						
						<div class="form-group">
							<label for="userId">userId</label>

							<form:input path="userId" id="userId" name="userId"
								cssClass="form-control" placeholder="userId" required="true" />
							<p>
								<form:errors path="userId" cssStyle="color:red"></form:errors>
							<p />
						</div>

						<div class="form-group">
							<label for="familyType">Password</label>

							<form:input path="password" id="password" name="password"
								cssClass="form-control" required="true" />
							<p>
								<form:errors path="password"></form:errors>
							<p />
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


<c:import url="include/footer.jsp"></c:import>
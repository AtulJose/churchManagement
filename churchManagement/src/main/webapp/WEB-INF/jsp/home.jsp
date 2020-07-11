<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:import url="include/header.jsp"></c:import>
	<div class="container" style="margin-top: 30px">
		<div class="row">

			<div class="col-sm-8">
				<div class="fakeimg">Fake Image</div>
				<h3>OUR MISSION</h3>
				<p>St. Thomas Syro-Malabar Catholic Mission was established by
					Bishop Mar Jacob Angadiath on December 15, 2013 at the Presentation
					of Our Lady Catholic Church in Denver, Colorado. Mar Jacob
					Angadiath celebrated the Holy Qurbana and confirmed the
					Syro-Malabar community in Denver to be a Mission Church under the
					St. Thomas Eparchy of Chicago for North America. The Bishop
					appointed Fr. Jacob (Shaji) Chennathu to be the first Director of
					the St. Thomas Mission. Syro-Malabar Catholics have had a long
					presence in the Rocky Mountain area and the appointment of the
					Mission Church is a testament to the faith and perseverance of
					those who have lived the faith of St. Thomas in Colorado for the
					last four decades. There are around 40 families who are part of
					Syro-Malabar rite, living around Denver metro area. In May 2016,
					the Syro-Malabar services were shifted to Annunciation church and
					started with mass on every Sunday at 3 PM.</p>
				<br>

			</div>

			<div class="col-sm-4">
				<h2>Upcoming Events</h2>

				<div style="height: 250px; overflow-y: scroll;">
					<div class="panel-body">

						<table id="recruitmentList"
							class="table table-striped table-bordered" style="width: 100%">
							<thead>
								<tr>
									<th>Event Date</th>
									<th>Event Name</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${upcomingEventsList}" var="event">
									<tr>
										<td><f:formatDate value="${event.eventDate}"
												pattern="MM/dd/yyyy" /></td>
										<td>${event.eventName}</td>
									</tr>
								</c:forEach>
							</tbody>
							
						</table>
					</div>
				</div>

	<h2>Liturgy</h2>

				<div style="height: 200px; overflow-y: scroll;">
					<div class="panel-heading">Readings assigned to you</div>
					<div class="panel-body">

						<table id="recruitmentList"
							class="table table-striped table-bordered" style="width: 100%">
							<thead>
								<tr>
									<th>Date</th>
									<th>Type</th>
									<th>Details</th>
									<th>Member</th>
									
									
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${upcomingReadings}" var="readingMap">
									<tr>
										<td><f:formatDate value="${readingMap.readingDate}"
												pattern="MM/dd/yyyy" /></td>
										<td>${readingMap.reading.readingType}</td>
										<td>${readingMap.readingDesc}</td>
										<td>${readingMap.member.fullName}</td>
									</tr>
								</c:forEach>
							</tbody>
							
						</table>
					</div>
				</div>
<br>
				<div style="height: 200px; overflow-y: scroll;">
					<div class="panel-heading">Alter Service assigned to you</div>
					<div class="panel-body">

						<table id="recruitmentList"
							class="table table-striped table-bordered" style="width: 100%">
							<thead>
								<tr>
									<th>Event Date</th>
									<th>Event Name</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${upcomingEventsList}" var="event">
									<tr>
										<td><f:formatDate value="${event.eventDate}"
												pattern="MM/dd/yyyy" /></td>
										<td>${event.eventName}</td>
									</tr>
								</c:forEach>
							</tbody>
							
						</table>
					</div>
				</div>

				<hr class="d-sm-none">
			</div>
		</div>
	</div>

<c:import url="include/footer.jsp"></c:import>

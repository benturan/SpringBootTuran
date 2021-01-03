<%@ page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>



<c:forEach items="${ana}" var="anakategori">
	<li class="has-submenu"><a href="/filter${anakategori.categoryid}">${anakategori.categoryname}<i
			class="fa fa-chevron-down"></i></a>
		<ul class="submenu">
			<c:forEach items="${alt}" var="altkategori">
				<c:if
					test="${altkategori.parentcategoryid == anakategori.categoryid}">
					<li class="has-submenu"><a href="/filter${altkategori.categoryid}">${altkategori.categoryname}</a>
						<ul class="sub-submenu">
							<c:forEach items="${alt}" var="altkategori2">

								<c:if
									test="${altkategori2.parentcategoryid == altkategori.categoryid}">
									<li><a href="/filter${altkategori2.categoryid}">${altkategori2.categoryname }</a></li>
								</c:if>

							</c:forEach>
						</ul></li>
				</c:if>
			</c:forEach>
			<li class="offer">
				<div class="col-1"></div>
				<div class="col-2"></div>
			</li>
		</ul></li>
</c:forEach>



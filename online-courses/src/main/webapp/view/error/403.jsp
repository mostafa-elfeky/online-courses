<!DOCTYPE html>
<html lang="en">

<%@ include file="/view/layout/header.jsp"%>

<body>
	
	<div id="page">
		
	<%@ include file="/view/layout/menu.jsp"%>
	<!-- /header -->
	
	<main>
		<div id="error_page">
			<div class="container">
				<div class="row justify-content-center text-center">
					<div class="col-xl-7 col-lg-9">
						<h2>403 <i class="icon_error-triangle_alt"></i></h2>
						<p>You don't have access to this page.</p>
					</div>
				</div>
				<!-- /row -->
			</div>
			<!-- /container -->
		</div>
		<!-- /error_page -->
	</main>
	<!--/main-->
	
	<%@ include file="/view/layout/footer.jsp"%>
	
	<!--/footer-->
	</div>
	
</body>
</html>
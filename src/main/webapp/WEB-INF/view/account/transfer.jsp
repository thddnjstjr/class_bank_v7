<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!-- header.jsp -->
<%@ include file="/WEB-INF/view/layout/header.jsp"%>

<!-- start of content.jsp(xxx.jsp) -->
<div class="col-sm-8">
	<h2>이체 요청(인증)</h2>
	<h5>Bank App에 오신걸 환영합니다</h5>
	<!-- 예외적으로 로그인은 보안 때문에 post로 던지자 -->
	<form action="/account/transfer" method="post">
		<div class="form-group">
			<label for="amount">입금 금액:</label>
			<input type="number" class="form-control" placeholder="Enter amount" id="amount" name="amount"value="1000">
		</div>
		<div class="form-group">
			<label for="dAccountNumber">입금 계좌 번호:</label>
			<input type="text" class="form-control" placeholder="Enter account number" id="dAccountNumber" name="dAccountNumber" value="1111">
		</div>
		<div class="form-group">
			<label for="wAccountNumber">출금 계좌 번호:</label>
			<input type="text" class="form-control" placeholder="Enter account number" id="wAccountNumber" name="wAccountNumber" value="1111">
		</div>
		<div class="form-group">
			<label for="pwd">출금 계좌 비밀 번호 :</label>
			<input type="password" class="form-control" placeholder="Enter password" id="pwd" name="password"value="1234">
		<div class="text-right">
		<button type="submit" class="btn btn-primary">입금 요청</button>
		</div>
	</form>
</div>
<!--  end of content.jsp(xxx.jsp) -->

<!-- footer.jsp -->
<%@ include file="/WEB-INF/view/layout/footer.jsp"%>

<%@ page language="java" pageEncoding="utf-8"%>
<div class="container h-100 ">
	<div class="row h-100 justify-content-center align-items-center">
		<div class="col-10 col-md-8 col-lg-6">
			<form class="form shadow-sm rounded" action="loginPost" method="post">
				<label class="form-label">로그인</label>

				<div class="form-group">
					<input type="text" class="form-control" id="user-id"
						placeholder="아이디" name="userId">
				</div>
				<div class="form-group">
					<input type="password" class="form-control" id="user-password"
						placeholder="비밀번호" name="userPass">
				</div>
				<label> <input type="checkbox" name="useCookie">ID
					저장
				</label>
				<button type="submit"
					class="form-btn btn btn-primary btn-customized">로그인</button>

				<div class="form-group">
					새로운 계정이 필요하신 경우 <a href="/customer/regist">회원가입</a>.
				</div>
			</form>
		</div>
	</div>
</div>
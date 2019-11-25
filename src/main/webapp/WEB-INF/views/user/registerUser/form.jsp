<%@ page language="java" pageEncoding="utf-8"%>
<div class="container">
    <div class="row justify-content-center align-items-center">
        <div class="col-10 col-md-8 col-lg-6">
            <form class="form shadow-sm rounded" action="" method="post">
                <label class="form-label">회원가입</label>

                <div class="form-group">
                    <input type="text" class="form-control" id="user-id" placeholder="아이디" name="user-id">
                </div>
                <div class="form-group">
                    <input type="password" class="form-control" id="user-password" placeholder="비밀번호" name="user-password">
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" id="user-password-confirm" placeholder="비밀번호 확인" name="user-password-confirm">
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" id="user-name" placeholder="이름" name="user-name">
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" id="user-email" placeholder="이메일" name="user-email">
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" id="user-phone" placeholder="전화번호" name="user-phone">
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" id="user-address" placeholder="주소" name="user-address">
                </div>
                <button type="submit" class="form-btn btn btn-primary btn-customized">회원가입</button>

                <div class="form-group">계정을 갖고 계신 경우  <a href="/sample/user/login">로그인</a>.</div>
            </form>
        </div>
    </div>
</div>
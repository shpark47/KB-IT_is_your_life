const loginBtn = document.getElementById('loginBtn');
const errorBox = document.getElementById('errorBox');
const successBox = document.getElementById('successBox');
const id = document.getElementById('userId');
const pw = document.getElementById('userPw');

// 메시지 초기화 함수
// 로그인 시도 전에 기존 메시지를 모두 숨기고 초기화
function resetMessages() {
  // 메시지 영역 숨기기
  errorBox.classList.add('hidden');
  successBox.classList.add('hidden');
  helperLink.classList.add('hidden');

  // 메시지 내용 초기화
  errorBox.textContent = '';
  successBox.textContent = '';
}

loginBtn.addEventListener('click', () => {
  resetMessages();
  if (id.value == 'admin' && pw.value == '1234') {
    successBox.textContent = '로그인에 성공했습니다.';
    successBox.classList.remove('hidden');
  } else {
    if (id.value != 'admin') {
      errorBox.textContent = '아이디가 틀렸습니다.';
    } else {
      errorBox.textContent = '비밀번호가 틀렸습니다.';
    }
    errorBox.classList.remove('hidden');
  }
});

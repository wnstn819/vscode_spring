document
  .getElementById("loginForm")
  .addEventListener("submit", async function (event) {
    event.preventDefault(); // 기본 폼 제출 방지

    const username = document.getElementById("username").value;
    const password = document.getElementById("password").value;

    // 백엔드로 요청
    try {
      const response = await fetch("/api/login", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify({ id: username, password: password }),
      });

      const message = await response.text();

      if (response.ok) {
        document.getElementById("responseMessage").style.color = "green";
        document.getElementById("responseMessage").innerText = "로그인 성공!";
      } else {
        document.getElementById("responseMessage").style.color = "red";
        document.getElementById("responseMessage").innerText =
          message || "로그인 실패";
      }
    } catch (error) {
      document.getElementById("responseMessage").style.color = "red";
      document.getElementById("responseMessage").innerText =
        "서버 오류: " + error.message;
    }
  });

/* --- Cadastro --- */
const formCadastro = document.querySelector(".container-cadastro form");

formCadastro.addEventListener("submit", function (event) {
  event.preventDefault();

  const email = document.getElementById("email-input").value.trim();
  const username = document.getElementById("username-input").value.trim();
  const senha = document.getElementById("senha-input").value.trim();
  const confirmacao = document.getElementById("confirmacao-senha-input").value.trim();

  if (!email || !username || !senha || !confirmacao) {
    alert("Por favor, preencha todos os campos!");
    return;
  }

  if (senha !== confirmacao) {
    alert("As senhas não coincidem!");
    return;
  }

 
  localStorage.setItem("emailCadastrado", email);
  localStorage.setItem("usuarioCadastrado", username);
  localStorage.setItem("senhaCadastrada", senha);

  alert("Conta criada com sucesso!");
  formCadastro.reset();
});

/* --- Login --- */
const loginForm = document.getElementById("login-form");

loginForm.addEventListener("submit", function (event) {
  event.preventDefault();

  const email = document.getElementById("email-login-input").value.trim();
  const senha = document.getElementById("senha-login-input").value.trim();

  const emailSalvo = localStorage.getItem("emailCadastrado");
  const senhaSalva = localStorage.getItem("senhaCadastrada");

  if (!emailSalvo) {
    alert("Nenhum usuário cadastrado ainda.");
    return;
  }

  if (email === emailSalvo && senha === senhaSalva) {
    alert("Login realizado com sucesso!");
    window.location.href = "boletos.html";
  } else {
    alert("E-mail ou senha incorretos!");
  }
});


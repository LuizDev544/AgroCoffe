document.addEventListener("DOMContentLoaded", function() {
    const form = document.querySelector("form");
    const botao = document.querySelector("button")
    const Inome = document.querySelector(".nome");
    const Iemail = document.querySelector(".email");
    const Isenha = document.querySelector(".senha");
    const Itel = document.querySelector(".tel");
    const Iendereco = document.querySelector(".endereco");
    const Icep = document.querySelector(".cep");

    function cadastrar() {
        console.log("Nome:", Inome.value);
        console.log("Email:", Iemail.value);
        console.log("Senha:", Isenha.value);
        console.log("Tel:", Itel.value);
        console.log("Endereço:", Iendereco.value);
        console.log("Cep:", Icep.value);

        fetch("http://localhost:8080/usuarios", {
            headers: {
                "Accept": "application/json",
                "Content-Type": "application/json"
            },
            method: "POST",
            body: JSON.stringify({    
                nome: Inome.value,
                email: Iemail.value,
                senha: Isenha.value,
                tel: Itel.value,
                endereco: Iendereco.value,
                cep: Icep.value
            })
        })
        .then(function (res) {
            if (res.ok) {
                alert("Usuário cadastrado com sucesso!");
                limpar();
            } else {
                alert("Erro ao cadastrar usuário. Verifique os dados.");
            }
        })
        .catch(function (error) {
            alert("Erro de conexão com o servidor!");
            console.error(error);
        });
    }

    function limpar () {
        Inome.value = "";
        Iemail.value = "";
        Isenha.value = "";
        Itel.value = "";
        Iendereco.value = "";
        Icep.value = "";
    };

    form.addEventListener("submit", function (event){
        event.preventDefault();
        cadastrar();
    });
});
// Máscaras
$('#telefone').mask('(00) 00000-0000', { 
    placeholder: '(DDD) 12345-6789'
});

$('#cep').mask('00000-000', {
    placeholder: '012345-678'
});

$.validator.addMethod("senhaForte", function(value, element) {
    return this.optional(element) || /^(?=.*[a-z])(?=.*[A-Z]).{8,}$/.test(value);
}, "A senha deve conter pelo menos 8 caracteres, com letras maiúsculas e minúsculas.");

// Validação do formulário
$('form').validate({
    rules: {
        nome: { required: true },
        email: { required: true, email: true },
        telefone: { required: true },
        endereco: { required: true },
        cep: { required: true },
        senha: { 
            required: true,
            senhaForte: true
        }
    },
    errorClass: "is-invalid", 
    validClass: "is-valid", 
    highlight: function(element) {
        $(element).addClass('is-invalid').removeClass('is-valid');
    },
    unhighlight: function(element) {
        $(element).removeClass('is-invalid').addClass('is-valid');
    },
    submitHandler: function(form) {
        alert("Seu cadastro foi enviado com sucesso!");
        form.reset();
        $('.is-invalid, .is-valid').removeClass('is-invalid is-valid'); 
    },
    invalidHandler: function() {
        alert("Por favor, preencha os campos para prosseguir com o cadastro!");
    }
});

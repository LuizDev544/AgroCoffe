$('#tel').mask('(00) 00000-0000', {
    placeholder: '(DDD) 12345-6789'
});

$('#cep').mask('00000-000', {
    placeholder: '012345-678'
});

$('form').validate({
    rules: {
        nome: { required: true },
        email: { required: true, email: true },
        tel: { required: true },
        endereco: { required: true },
        cep: { required: true },
        senha: { required: true }
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
        cadastrar();
    },
    invalidHandler: function() {
        alert("Por favor, preencha os campos para prosseguir com o cadastro!");
    }
});

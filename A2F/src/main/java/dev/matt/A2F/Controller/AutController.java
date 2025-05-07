package dev.matt.A2F.Controller;

import dev.matt.A2F.modelo.Usuario;
import dev.matt.A2F.repositorio.RepositorioUser;
import dev.matt.A2F.servico.ServicoDoisFat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.warrenstrange.googleauth.GoogleAuthenticatorKey;

//Indica que uma classe é um controlador WEB REST
@RestController
//Ajuda a mapear URLS HTTP para métodos controladores
@RequestMapping("/autenticacao")
public class AutController {

    @Autowired
    private RepositorioUser usuarioRepositorio;

    @Autowired
    private ServicoDoisFat doisFatoresServico;

    //Registrando novo usuário com ativação de dois fatores
    @PostMapping("/registrar")
    public String registrar(@RequestParam String nome, @RequestParam String senha) {
        // Criar um novo usuário
        Usuario usuario = new Usuario();
        usuario.setNome(nome);
        usuario.setSenha(senha);

        // Gerando um segredo e salvando apenas a chave 
        GoogleAuthenticatorKey segredo = doisFatoresServico.gerarSegredo();
        usuario.setSegredo2FA(segredo.getKey()); 

        // Ativa 2FA
        usuario.setDoisFatoresAtivado(true);
        // salva o usuário no banco de dados
        usuarioRepositorio.save(usuario);

        // gera um URL do QR Code para escanear no app Google Authenticator
        return doisFatoresServico.gerarQRCode(nome, segredo);
    }

    //Verificação do código de dois fatores
    @PostMapping("/verificar")
    public boolean verificar(@RequestParam String nome,@RequestParam int codigo) {
        // Buscar usuário no banco
        Usuario usuario = usuarioRepositorio.findByNome(nome)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        // Validar código
        return doisFatoresServico.validarCodigo(usuario.getSegredo2FA(), codigo);
    }
}


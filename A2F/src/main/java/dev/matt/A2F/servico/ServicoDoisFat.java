package dev.matt.A2F.servico;

import com.warrenstrange.googleauth.GoogleAuthenticator;
import com.warrenstrange.googleauth.GoogleAuthenticatorKey;
import com.warrenstrange.googleauth.GoogleAuthenticatorQRGenerator;
import org.springframework.stereotype.Service;

@Service
public class ServicoDoisFat {

    private final GoogleAuthenticator gAuth = new GoogleAuthenticator();

    public GoogleAuthenticatorKey gerarSegredo() {
        return gAuth.createCredentials();
    }

    public String gerarQRCode(String nomeUsuario, GoogleAuthenticatorKey segredo) {
        return GoogleAuthenticatorQRGenerator.getOtpAuthURL("App2FA", nomeUsuario, segredo);
    }

    public boolean validarCodigo(String segredo, int codigo) {
        return gAuth.authorize(segredo, codigo);
    }
}

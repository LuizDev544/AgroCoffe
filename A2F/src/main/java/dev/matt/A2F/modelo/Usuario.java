package dev.matt.A2F.modelo;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //campos para serem salvo no banco de dados
    private Long id;               // ID do usuário

    private String nome;           // Nome do usuário

    private String senha;          // Senha do usuário

    private String segredo2FA;     // Segredo do Google Authenticator usado para validação

    private boolean doisFatoresAtivado;  // Indica se o 2FA está ativado para o usuário
    
 // GETTERS E SETTERS

	public void setNome(String nome) {
		this.nome = nome;
		
	}
	
	public String getnome() {
		return nome;
	}
    
    public String getSenha() {
    	return senha;
    }
    
	public void setSenha(String senha) {
		this.senha = senha;
		
	}
	
	public String getSegredo2FA() {
        return segredo2FA;
    }

    public void setSegredo2FA(String segredo2FA) {
        this.segredo2FA = segredo2FA;
    }

    public boolean isDoisFatoresAtivado() {
        return doisFatoresAtivado;
    }

    public void setDoisFatoresAtivado(boolean doisFatoresAtivado) {
        this.doisFatoresAtivado = doisFatoresAtivado;
    }

}
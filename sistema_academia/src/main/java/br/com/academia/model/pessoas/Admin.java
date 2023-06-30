package br.com.academia.model.pessoas;

import br.com.academia.model.sistema.Academia;

public class Admin extends Usuario{

    public Admin() {
    }

    public Admin(Academia academia, int id, String nome, String login, String senha) {
        super(id, academia, nome, login, senha);

    }
}

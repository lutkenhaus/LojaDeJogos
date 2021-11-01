public class Cliente {
    private String cpf;
    private String nome;
    private String nickname;
    private String senha;

    public Cliente(String cpf, String nome, String nickname, String senha) {
        this.cpf = cpf;
        this.nome = nome;
        this.nickname = nickname;
        this.senha = senha;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNickname() {
        return this.nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getSenha() {
        return this.senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean igual(Cliente outro){
        return this.cpf.equals(outro.cpf);
    }

    public boolean ehMenorQue(Cliente outro){
        return this.cpf.compareTo(outro.cpf) < 0;
    }

    public String dadosCliente() {
        String auxDados="---------------------\n";
        auxDados+= "CPF: " + this.cpf + "\n";
        auxDados+= "Nome: " + this.nome + "\n";
        auxDados+= "Nickname: " + this.nickname + "\n";
        auxDados+= "Senha: " + this.senha + "\n";
        return auxDados;
    }

}

package org.example.obj;

public class User {
    // Atributos (encapsulados)
    private int id;
    private String username;
    private String password;

    // Construtor padrão
    public User() {
    }

    // Construtor com parâmetros
    public User(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Método para exibir informações do usuário
    public void printInfo() {
        System.out.println("ID: " + id + ", Usuário: " + username);
    }
}

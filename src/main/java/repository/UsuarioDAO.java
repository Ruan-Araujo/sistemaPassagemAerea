package repository;

import model.Usuario;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UsuarioDAO {
    private final String USUARIOS_PATH = "src/main/resources/usuarios.txt";
    private List<Usuario> usuarios;

    public List<Usuario> listarUsuarios() {
        usuarios = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(USUARIOS_PATH)))) {
            String user = br.readLine();
            while (user != null) {
                List<String> dados = Arrays.asList(user.split(";"));
                int id = Integer.parseInt(dados.get(0));
                String nome = dados.get(1);
                String cpf = dados.get(2);
                String senha = dados.get(3);
                Usuario usuario = new Usuario(id, nome, cpf, senha);
                usuarios.add(usuario);
                user = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return usuarios;
    }

    public void adicionarUsuarios(Usuario usuario) {
        StringBuilder usuarioString = usuarioToString(usuario);
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(USUARIOS_PATH, true)))){
            bw.append(usuarioString);
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deletarUsuario(Usuario usuario) {
        List<Usuario> usuariosList = listarUsuarios();
        limparArquivoTexto();
        if (usuariosList.size() != 1) {
            usuariosList.removeIf(e -> e.equals(usuario));
            usuariosList.forEach(this::adicionarUsuarios);
        }
    }

    private void limparArquivoTexto(){
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(USUARIOS_PATH)))){
            bw.append("");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private StringBuilder usuarioToString(Usuario usuario){
        StringBuilder usuarioString = new StringBuilder();
        int id = usuario.getId();
        String nome = usuario.getNome();
        String cpf = usuario.getCpf();
        String senha = usuario.getSenha();
        usuarioString.append(id).append(";");
        usuarioString.append(nome).append(";");
        usuarioString.append(cpf).append(";");
        usuarioString.append(senha);
        return usuarioString;
    }
}

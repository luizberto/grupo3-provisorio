package br.com.sporty.api.SportyAPI;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/user")
public class UsuarioController {

    List<Usuario> listaUser = new ArrayList<>();

    @PostMapping("/login")
    public String login(@RequestBody String email, @RequestBody String senha){
        for(Usuario u: listaUser){
            if(u.getEmail().equals(email) && u.getSenha().equals(senha)){
                if(u.getAutenticado()){
                    return "Usuario já está logado";
                }else{
                    u.setAutenticado(true);
                    return "Usuario logado com sucesso";
                }
            }
        }
        return "Usuario não encontrado";
    }

    @PostMapping("/logoff")
    public String logoff(@RequestBody String email){
        for(Usuario u: listaUser){
            if(u.getEmail().equals(email)){
                if(!u.getAutenticado()){
                    return "Usuario não está logado";
                }else{
                    u.setAutenticado(false);
                    return "Usuário saiu";
                }
            }
        }
        return "Usuario não encontrado";
    }

    @PostMapping("/jogador")
    public String addUserJogador(@RequestBody UsuarioJogador u){
        listaUser.add(u);
        u.setId(listaUser.size());
        return "Cadastrado";
    }
    @PostMapping("/dono")
    public String addUserDono(@RequestBody UsuarioDono u){
        listaUser.add(u);
        u.setId(listaUser.size());
        return "Cadastrado";
    }
    @GetMapping()
    public List<Usuario> exibirUsers(){
        return listaUser.stream()
                .sorted(Comparator.comparing(Usuario::getId))
                .collect(Collectors.toList());
    }
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable int id){
        for(Usuario user: listaUser){
            if(user.getId() == id){
                listaUser.remove(user);
                return "Usuario removido";
            }
        }
        return "Usuario não encontrado";
    }


}

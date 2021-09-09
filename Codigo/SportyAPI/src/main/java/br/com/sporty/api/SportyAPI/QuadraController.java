package br.com.sporty.api.SportyAPI;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/quadra")
public class QuadraController {

    List<Quadra> listaQuadra = new ArrayList<>();

    @GetMapping()
    public List<Quadra> exibirQuadra(){
        return listaQuadra.stream()
                .sorted(Comparator.comparing(Quadra::getId))
                .collect(Collectors.toList());
    }
    @PostMapping()
    public String addQuadra(@RequestBody Quadra q){
        listaQuadra.add(q);
        q.setId(listaQuadra.size());
        return "Quadra cadastrada";
    }
    @DeleteMapping("/{id}")
    public String deleteQuadra(@PathVariable int id){
        for(Quadra q: listaQuadra){
            if(q.getId() == id){
                listaQuadra.remove(q);
                return "Quadra removida";
            }
        }
        return "Quadra não encontrada";
    }


    @GetMapping("/{id}/partida")
    public List<Partida> exibirPartidas(@PathVariable int id){
        Boolean encontrado = false;
        for(Quadra q: listaQuadra){
            return new ArrayList<>(q.getPartidas());
        }
        return null;
    }
    @PostMapping("/{id}/partida")
    public String addPartida(@PathVariable int id, @RequestBody Partida p){

        for(Quadra q: listaQuadra){
            if(q.getId() == id){
                q.addPartida(p);
                p.setId(q.getPartidas().size());
                return "Partida criada";
            }
        }
        return "Quadra não encontrada";
    }
    @DeleteMapping("/{id}/partida/{idPartida}")
    public String deletePartida(@PathVariable int id, @PathVariable int idPartida){
        for(Quadra q: listaQuadra){
            if(q.getId() == id) {
                for (Partida p : q.getPartidas()) {
                    if (p.getId() == idPartida) {
                        q.deletePartida(p);
                        return "Partida deletada";
                    }
                }
            }
        }
        return "Partida não encontrada";
    }

}

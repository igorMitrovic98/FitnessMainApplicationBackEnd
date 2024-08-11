package unibl.etf.ip.fitnessappbackend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import unibl.etf.ip.fitnessappbackend.dtos.DiaryDTO;
import unibl.etf.ip.fitnessappbackend.models.Diary;
import unibl.etf.ip.fitnessappbackend.services.DiaryService;

import java.util.List;


@RestController
@RequestMapping("/diary")
public class DiaryController {

    @Autowired
    private DiaryService diaryService;

    @PostMapping("/{username}")
    public String save(@RequestBody DiaryDTO diaryDTO,@PathVariable("username") String username) {
        System.out.println("CONTROLLER DIARY");
        return diaryService.save(username).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) {
        diaryService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable("id") Integer id,
                       @RequestBody DiaryDTO diaryDTO) {
        diaryService.update(id, diaryDTO);
    }

    @GetMapping("/{username}")
    public Diary getById(@PathVariable("username") String username) {
        return diaryService.getByUsername(username);
    }

    @GetMapping
    public List<Diary> getAll(){
        return diaryService.getAll();
    }

    @GetMapping("/check/{username}")
    public boolean check(@PathVariable("username") String username){
        return diaryService.check(username);
    }
}

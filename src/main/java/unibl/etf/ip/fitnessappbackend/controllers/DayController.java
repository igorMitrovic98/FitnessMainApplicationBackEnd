package unibl.etf.ip.fitnessappbackend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import unibl.etf.ip.fitnessappbackend.dtos.DayDTO;
import unibl.etf.ip.fitnessappbackend.models.Day;
import unibl.etf.ip.fitnessappbackend.services.DayService;
import unibl.etf.ip.fitnessappbackend.services.PdfService;

import java.io.ByteArrayOutputStream;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/day")
public class DayController {

    @Autowired
    private DayService dayService;

    @Autowired
    private PdfService pdfService;

    @PostMapping
    public String save(@RequestBody DayDTO dayDTO) {
        return dayService.save(dayDTO);
    }

    @DeleteMapping("/{id}+{id2}")
    public void delete(@PathVariable("id") Date id,@PathVariable("id2") Integer id2) {
        dayService.delete(id,id2);
    }

    @PutMapping("/{id}+{id2}")
    public void update(@PathVariable("id") Date id,@PathVariable("id2") Integer id2,
                       @RequestBody DayDTO dayDTO) {
        dayService.update(id,id2, dayDTO);
    }

    @GetMapping("/{diaryid}")
    public List<Day> getById(@PathVariable("diaryid") Integer diaryid) {
        return dayService.getDaysByDiaryId(diaryid);
    }

    @GetMapping
    public List<Day> getAll(){
        return dayService.getAll();
    }
    @GetMapping("/single/{diaryId}")
    public boolean checkDay(@PathVariable("diaryId")Integer diaryId){
        return dayService.checkDay(diaryId);
    }

    @GetMapping("/pdf/{diaryId}")
    public ResponseEntity<byte[]> downloadPdf(@PathVariable("diaryId")Integer diaryId) throws Exception {
        List<Day> dayList = dayService.getDaysByDiaryId(diaryId);
        ByteArrayOutputStream baos = pdfService.generatePdf(dayList);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData("filename", "diary.pdf");
        headers.setContentLength(baos.size());
        return new ResponseEntity<>(baos.toByteArray(), headers, HttpStatus.OK);
    }
}

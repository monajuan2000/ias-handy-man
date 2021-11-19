package com.ias.calculator.api.api.business;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ias.calculator.api.api.entities.ReportEntity;
import com.ias.calculator.api.api.repositories.ReportRepository;
import com.ias.calculator.api.api.services.ReportService;
import com.ias.calculator.constants.TypeHour;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReportServiceImp implements ReportService {

    @Autowired
    private ReportRepository reportRepository;

    @Override
    public List<ReportEntity> findAll() {
        return this.reportRepository.findAll();
    }

    @Override
    public ReportEntity findById(Long id) {
        return this.reportRepository.findById(id).orElseThrow();
    }

    @Override
    public ReportEntity save(ReportEntity technicalEntity) {
        return this.reportRepository.save(technicalEntity);
    }

    @Override
    public ReportEntity update(ReportEntity technicalEntity) {
        return this.reportRepository.saveAndFlush(technicalEntity);
    }

    @Override
    public void delete(Long id) {
        this.reportRepository.deleteById(id);
    }

    @Override
    public List<ReportEntity> findByTechnical(Long id) {
        return reportRepository.findByTechnical(id);
    }

    @Override
    public Map<String, Long> numberOfHours(Long id, String wk) throws ParseException {
        List<ReportEntity> entities = reportRepository.findByTechnical(id);
        Long totalHours = 0L;
        Date date = null;
        String week = "";
        String day = "";
        String h1 = "";
        String h2 = "";
        Date d1 = null;
        Date d2 = null;
        Long NORMALHOURS = 0L;
        Long NIGHTHOURS = 0L;
        Long SUNDAYHOURS = 0L;
        Long NORMALHOURSEXTRA = 0L;
        Long NIGHTHOURSEXTRA = 0L;
        Long SUNDAYHOURSEXTRA = 0L;
        HashMap<String, Long> map = new HashMap<String, Long>();

        DateFormat dateFormatHour = new SimpleDateFormat("hh:mm");
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        for (ReportEntity element : entities) {
            h1 = element.getStartHour();
            h2 = element.getFinalHour();
            d1 = dateFormatHour.parse(h1);
            d2 = dateFormatHour.parse(h2);
            totalHours += ((d2.getTime() - d1.getTime()) / (1000 * 60));
            String f1 = element.getDate();
            date = dateFormat.parse(f1);
            week = new SimpleDateFormat("w").format(date);
            day = new SimpleDateFormat("EE").format(date);

            if(week == wk){
               if(d1.getHours() >= 7 && d2.getHours()<=20 && day == "vie."){
                    NORMALHOURS += ((d2.getTime() - d1.getTime()) / (1000 * 60));
               }
            }
            
        }
        map.put(TypeHour.NORMALHOURS.toString(), NORMALHOURS);
        map.put(TypeHour.NIGHTHOURS.toString(), NIGHTHOURS);
        map.put(TypeHour.SUNDAYHOURS.toString(), SUNDAYHOURS);
        map.put(TypeHour.NORMALHOURSEXTRA.toString(), NORMALHOURSEXTRA);
        map.put(TypeHour.NIGHTHOURSEXTRA.toString(), NIGHTHOURSEXTRA);
        map.put(TypeHour.SUNDAYHOURSEXTRA.toString(), SUNDAYHOURSEXTRA);
        return map;
    }

    @Override
    public String dia() throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = dateFormat.parse("2021-11-19");
        return  new SimpleDateFormat("EEE").format(date);
    }

}
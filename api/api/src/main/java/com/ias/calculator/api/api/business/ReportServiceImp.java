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
    private DateFormat dateFormatHour = new SimpleDateFormat("hh:mm");
    private DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

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
    public Map<String, Float> numberOfHours(Long id, String wk) throws ParseException {
        List<ReportEntity> entities = reportRepository.findByTechnical(id);
        Long NORMALHOURS = 0L;
        Long NIGHTHOURS = 0L;
        Long SUNDAYHOURS = 0L;
        Long NORMALHOURSEXTRA = 0L;
        Long NIGHTHOURSEXTRA = 0L;
        Long SUNDAYHOURSEXTRA = 0L;
        Long TOTALHOURS = 0L;
        Long TOTALHOURSWEEK = 0L;

        for (ReportEntity element : entities) {
            Date d1 = this.dateFormatHour.parse(element.getStartHour());
            Date d2 = this.dateFormatHour.parse(element.getFinalHour());
            TOTALHOURS += ((d2.getTime() - d1.getTime()) / (1000 * 60));
            Date date = this.dateFormat.parse(element.getDate());
            String week = new SimpleDateFormat("w").format(date);
            String day = new SimpleDateFormat("EE").format(date);
            Long result = ((d2.getTime() - d1.getTime()) / (1000 * 60));
            if (week.equals(wk)) {
                if (TOTALHOURSWEEK < 2880L) {
                    if (!day.equals("dom.")) {
                        if (d1.getHours() >= 7 && d2.getHours() <= 20) {
                            NORMALHOURS += result;
                            TOTALHOURSWEEK += result;
                        } else {
                            NIGHTHOURS += result;
                            TOTALHOURSWEEK += result;
                        }
                    } else {
                        SUNDAYHOURS += result;
                        TOTALHOURSWEEK += result;
                    }
                } else {
                    if (!day.equals("dom.")) {
                        if (d1.getHours() >= 7 && d2.getHours() <= 20) {
                            NORMALHOURSEXTRA += result;
                            TOTALHOURSWEEK += result;
                        } else {
                            NIGHTHOURSEXTRA += result;
                            TOTALHOURSWEEK += result;
                        }
                    } else {
                        SUNDAYHOURSEXTRA += result;
                        TOTALHOURSWEEK += result;
                    }
                }
            }

        }
        return this.createMap(NORMALHOURS, NIGHTHOURS, SUNDAYHOURS, NORMALHOURSEXTRA, NIGHTHOURSEXTRA, SUNDAYHOURSEXTRA,
                TOTALHOURS, TOTALHOURSWEEK);
    }

    @Override
    public Map<String, Float> createMap(Long NORMALHOURS, Long NIGHTHOURS, Long SUNDAYHOURS, Long NORMALHOURSEXTRA,
            Long NIGHTHOURSEXTRA, Long SUNDAYHOURSEXTRA, Long TOTALHOURS, Long TOTALHOURSWEEK) {
        HashMap<String, Float> map = new HashMap<String, Float>();
        map.put(TypeHour.NORMALHOURS.toString(), (float) (NORMALHOURS)/60);
        map.put(TypeHour.NIGHTHOURS.toString(), (float) (NIGHTHOURS)/60);
        map.put(TypeHour.SUNDAYHOURS.toString(), (float) (SUNDAYHOURS)/60);
        map.put(TypeHour.NORMALHOURSEXTRA.toString(), (float) (NORMALHOURSEXTRA)/60);
        map.put(TypeHour.NIGHTHOURSEXTRA.toString(), (float) (NIGHTHOURSEXTRA)/60);
        map.put(TypeHour.SUNDAYHOURSEXTRA.toString(), (float) (SUNDAYHOURSEXTRA)/60);
        map.put(TypeHour.TOTALHOURS.toString(), (float) (TOTALHOURS)/60);
        map.put(TypeHour.TOTALHOURSWEEK.toString(), (float) (TOTALHOURSWEEK)/60);
        return map;
    }
}

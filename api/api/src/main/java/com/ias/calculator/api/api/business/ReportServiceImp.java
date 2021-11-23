package com.ias.calculator.api.api.business;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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
    private DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");

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
    public Map<String, Float> extractInf(Long id, String wk) throws ParseException {
        List<ReportEntity> reportEntities = this.reportRepository.findByTechnical(id);
        Map<String, Float> map = new HashMap<String, Float>();
        Calendar calendarOne = Calendar.getInstance();
        Calendar calendarTwo = Calendar.getInstance();
        for (ReportEntity element : reportEntities) {
            Date dateStartHour = this.dateFormat.parse(element.getDate() + " " + element.getStartHour());
            Date dateFinalHour = this.dateFormat.parse(element.getDate() + " " + element.getFinalHour());
            calendarOne.setTime(dateStartHour);
            calendarTwo.setTime(dateFinalHour);
            int[] numberOfHoursInMinutes = this.calculator(calendarOne, calendarTwo);
            map = this.calculatorHours(wk, numberOfHoursInMinutes);
        }
        return map;
    }

    @Override
    public int[] calculator(Calendar calendarOne, Calendar calendarTwo) {
        int[] numberOfHoursInMinutes = new int[6];
        int dateStartMinutes = calendarOne.get(Calendar.HOUR_OF_DAY) * 60;
        int dateFinalMinutes = calendarTwo.get(Calendar.HOUR_OF_DAY) * 60;
        int dateStartMinutesMax = calendarOne.get(Calendar.MINUTE);
        int dateFinalMinutesMax = calendarTwo.get(Calendar.MINUTE);
        int week = calendarTwo.get(Calendar.WEEK_OF_YEAR);
        int weekDay = calendarTwo.get(Calendar.DAY_OF_WEEK);
        numberOfHoursInMinutes[0] = dateStartMinutes;
        numberOfHoursInMinutes[1] = dateStartMinutesMax;
        numberOfHoursInMinutes[2] = dateFinalMinutes;
        numberOfHoursInMinutes[3] = dateFinalMinutesMax;
        numberOfHoursInMinutes[4] = week;
        numberOfHoursInMinutes[5] = weekDay;
        return numberOfHoursInMinutes;
    }

    @Override
    public Map<String, Float> calculatorHours(String wk, int[] numberOfHoursInMinutes) throws ParseException {
        Map<String, Float> map = new HashMap<String, Float>();
        String week = String.valueOf(numberOfHoursInMinutes[4]);
        Float NORMALHOURS = (float) 0;
        Float NIGHTHOURS = (float) 0;
        Float SUNDAYHOURS = (float) 0;
        // Float NORMALHOURSEXTRA = null;
        // Float NIGHTHOURSEXTRA = null;
        // Float SUNDAYHOURSEXTRA = null;
        Float TOTALHOURS = (float) 0;
        Float TOTALHOURSWEEK = (float) 0;
        if (wk.equals(week)) {
            
        } else {
            System.out.println("No hay registros para mostrar");
        }
        map.put(TypeHour.NORMALHOURS.toString(), NORMALHOURS);
        map.put(TypeHour.NIGHTHOURS.toString(), NIGHTHOURS);
        map.put(TypeHour.SUNDAYHOURS.toString(), SUNDAYHOURS);
        return map;
    }
}

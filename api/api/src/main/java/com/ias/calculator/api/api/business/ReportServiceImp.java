package com.ias.calculator.api.api.business;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

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
        Map<String, Float> map1 = new HashMap<String, Float>();
        Map<String, Float> map2 = new HashMap<String, Float>();
        float NORMALHOURS = 0, NIGHTHOURS = 0, SUNDAYHOURS = 0;
        float TOTALHOURS = 0, TOTALHOURSWEEK = 0;
        float NORMALHOURSEXTRA = 0, NIGHTHOURSEXTRA = 0, SUNDAYHOURSEXTRA = 0;
        Calendar calendarOne = Calendar.getInstance();
        Calendar calendarTwo = Calendar.getInstance();

        for (ReportEntity element : reportEntities) {
            Date dateStartHour = this.dateFormat.parse(element.getDate() + " " + element.getStartHour());
            Date dateFinalHour = this.dateFormat.parse(element.getDate() + " " + element.getFinalHour());
            calendarOne.setTime(dateStartHour);
            calendarTwo.setTime(dateFinalHour);
            int[] numberOfHoursInMinutes = this.calculator(calendarOne, calendarTwo);
            int a = (int) TOTALHOURSWEEK;

            if (a <= 2880) {
                map1 = this.calculatorHours(wk, numberOfHoursInMinutes);
                NORMALHOURS += map1.get("NORMALHOURS");
                NIGHTHOURS += map1.get("NIGHTHOURS");
                TOTALHOURS += map1.get("TOTALHOURS");
                TOTALHOURSWEEK += map1.get("TOTALHOURSWEEK");
                SUNDAYHOURS += map1.get("SUNDAYHOURS");
            } else {
                map1 = this.calculatorHoursExtra(wk, numberOfHoursInMinutes);
                NORMALHOURSEXTRA += map1.get("NORMALHOURSEXTRA");
                NIGHTHOURSEXTRA += map1.get("NIGHTHOURSEXTRA");
                SUNDAYHOURSEXTRA += map1.get("SUNDAYHOURSEXTRA");
                TOTALHOURS += map1.get("TOTALHOURS");
                TOTALHOURSWEEK += map1.get("TOTALHOURSWEEK");
            }
        }
        map2.put(TypeHour.NORMALHOURS.toString(), NORMALHOURS/60);
        map2.put(TypeHour.NIGHTHOURS.toString(), NIGHTHOURS/60);
        map2.put(TypeHour.SUNDAYHOURS.toString(), SUNDAYHOURS/60);
        map2.put(TypeHour.NORMALHOURSEXTRA.toString(), NORMALHOURSEXTRA/60);
        map2.put(TypeHour.SUNDAYHOURSEXTRA.toString(), SUNDAYHOURSEXTRA/60);
        map2.put(TypeHour.NIGHTHOURSEXTRA.toString(), NIGHTHOURSEXTRA/60);
        map2.put(TypeHour.TOTALHOURSWEEK.toString(), TOTALHOURSWEEK/60);
        map2.put(TypeHour.TOTALHOURS.toString(), TOTALHOURS/60);
        return map2;
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
        int weekDay = numberOfHoursInMinutes[5];
        int startMinutes = numberOfHoursInMinutes[0];
        int startMax = numberOfHoursInMinutes[1];
        int finalMinutes = numberOfHoursInMinutes[2];
        int finalMax = numberOfHoursInMinutes[3];

        float NORMALHOURS = 0;
        float NIGHTHOURS = 0;
        float SUNDAYHOURS = 0;
        float TOTALHOURS = 0;
        float TOTALHOURSWEEK = 0;
        if (wk.equals(week)) {
            if (weekDay != 7) {
                for (int i = startMinutes / 60; i < finalMinutes / 60; i++) {
                    while (i < 7) {
                        NIGHTHOURS = i + 1 - (startMinutes / 60);
                        break;
                    }
                    while (i >= 7 && i < 20) {
                        NORMALHOURS = i + 1 - (startMinutes / 60) - NIGHTHOURS;
                        break;
                    }
                    while (i >= 20) {
                        NIGHTHOURS = i + 1 - (startMinutes / 60) - NORMALHOURS;
                        break;
                    }
                }
            } else {
                SUNDAYHOURS = (finalMinutes + finalMax) - (startMinutes + startMax);
                TOTALHOURS = (finalMinutes + finalMax) - (startMinutes + startMax);
                TOTALHOURSWEEK = (finalMinutes + finalMax) - (startMinutes + startMax);
            }
            NIGHTHOURS = NIGHTHOURS * 60;
            NORMALHOURS = NORMALHOURS * 60;
            TOTALHOURS = (finalMinutes + finalMax) - (startMinutes + startMax);
            TOTALHOURSWEEK = (finalMinutes + finalMax) - (startMinutes + startMax);
        } else {
            System.out.println("no hay datos para esta semana " + weekDay);
        }
        map.put(TypeHour.NORMALHOURS.toString(), NORMALHOURS);
        map.put(TypeHour.NIGHTHOURS.toString(), NIGHTHOURS);
        map.put(TypeHour.SUNDAYHOURS.toString(), SUNDAYHOURS);
        map.put(TypeHour.TOTALHOURS.toString(), TOTALHOURS);
        map.put(TypeHour.TOTALHOURSWEEK.toString(), TOTALHOURSWEEK);
        return map;
    }

    @Override
    public Map<String, Float> calculatorHoursExtra(String wk, int[] numberOfHoursInMinutes) throws ParseException {
        Map<String, Float> map = new HashMap<String, Float>();
        String week = String.valueOf(numberOfHoursInMinutes[4]);
        int weekDay = numberOfHoursInMinutes[5];
        int startMinutes = numberOfHoursInMinutes[0];
        int startMax = numberOfHoursInMinutes[1];
        int finalMinutes = numberOfHoursInMinutes[2];
        int finalMax = numberOfHoursInMinutes[3];

        float NORMALHOURSEXTRA = 0;
        float NIGHTHOURSEXTRA = 0;
        float SUNDAYHOURSEXTRA = 0;
        float TOTALHOURS = 0;
        float TOTALHOURSWEEK = 0;
        if (wk.equals(week)) {
            if (weekDay != 7) {
                for (int i = startMinutes / 60; i < finalMinutes / 60; i++) {
                    while (i < 7) {
                        NIGHTHOURSEXTRA = i + 1 - (startMinutes / 60);
                        break;
                    }
                    while (i >= 7 && i < 20) {
                        NORMALHOURSEXTRA = i + 1 - (startMinutes / 60) - NIGHTHOURSEXTRA;
                        break;
                    }
                    while (i >= 20) {
                        NIGHTHOURSEXTRA = i + 1 - (startMinutes / 60) - NORMALHOURSEXTRA;
                        break;
                    }
                }
            } else {
                SUNDAYHOURSEXTRA = (finalMinutes + finalMax) - (startMinutes + startMax);
                TOTALHOURS = (finalMinutes + finalMax) - (startMinutes + startMax);
                TOTALHOURSWEEK = (finalMinutes + finalMax) - (startMinutes + startMax);
            }
            NIGHTHOURSEXTRA = NIGHTHOURSEXTRA * 60;
            NORMALHOURSEXTRA = NORMALHOURSEXTRA * 60;
            TOTALHOURS = (finalMinutes + finalMax) - (startMinutes + startMax);
            TOTALHOURSWEEK = (finalMinutes + finalMax) - (startMinutes + startMax);
        } else {
            throw new NoSuchElementException("Valor no presente");
        }
        map.put(TypeHour.NORMALHOURSEXTRA.toString(), NORMALHOURSEXTRA);
        map.put(TypeHour.NIGHTHOURSEXTRA.toString(), NIGHTHOURSEXTRA);
        map.put(TypeHour.SUNDAYHOURSEXTRA.toString(), SUNDAYHOURSEXTRA);
        map.put(TypeHour.TOTALHOURS.toString(), TOTALHOURS);
        map.put(TypeHour.TOTALHOURSWEEK.toString(), TOTALHOURSWEEK);
        return map;
    }

}

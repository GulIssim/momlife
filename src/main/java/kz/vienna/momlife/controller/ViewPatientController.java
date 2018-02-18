package kz.vienna.momlife.controller;

import kz.vienna.momlife.model.entity.Patient;
import kz.vienna.momlife.model.entity.Pregnancy;
import kz.vienna.momlife.repository.PatientRepository;
import kz.vienna.momlife.repository.PregnancyRepository;
import kz.vienna.momlife.util.Helper;
import kz.vienna.momlife.util.IController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Controller
public class ViewPatientController extends IController {
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private PregnancyRepository pregnancyRepository;

    @RequestMapping(value = "/patient/{id}/pregnancies", method = RequestMethod.GET)
    public String viewPatient(@PathVariable("id") int id, Model model) {
        Patient patient = patientRepository.findOne((long) id);
        model.addAttribute("patient", patient);
        model.addAttribute("pregnanciesList", patient.getPregnancies());
        model.addAttribute("pregnancy", new Pregnancy());
        model.addAttribute("statuses", Helper.getStatuses());
        model.addAttribute("pregnancyStatuses",Helper.getStatuses() );
       // model.addAttribute("status", "");
        return "view-patient";
    }

    @RequestMapping(value = "/patient/{patient_id}/pregnancy/{pregnancy_id}/delete", method = RequestMethod.POST)
    public String deletePregnancy(@PathVariable("patient_id") int patientId,
                                  @PathVariable("pregnancy_id") int pregnancyId,
                                  Model model) {
        Pregnancy pregnancy = pregnancyRepository.findOne((long) pregnancyId);
        pregnancyRepository.delete((long) pregnancyId);
        return REDIRECT + "patient/" + patientId + "/pregnancies";
    }

    @RequestMapping(value = "/patient/{patient_id}/add/pregnancy", method = RequestMethod.POST)
    public String addPregnancy(@PathVariable("patient_id") int patientId,
                               @RequestParam("startTime") String startTime,
                               @RequestParam("endTime") String endTime,
                               @RequestParam("status") String statusOption,
                               Model model) {

        DateFormat df = new SimpleDateFormat("yyyy-mm-dd", Locale.getDefault());
        Patient patient = patientRepository.findOne((long) patientId);

        Pregnancy pregnancy = new Pregnancy();

        try {
            Date startDate = df.parse(startTime);
            Date endDate = df.parse(endTime);
            pregnancy.setStart_time(startDate);
            pregnancy.setEnd_time(endDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        pregnancy.setPatient(patient);

        pregnancy.setStatus(statusOption);

        pregnancyRepository.save(pregnancy);

        return REDIRECT + "patient/" + patientId + "/pregnancies";


    }
}

package v1.agendamento.nexo.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import v1.agendamento.nexo.dto.AppointmentFormDTO;
import v1.agendamento.nexo.service.AppointmentService;
import v1.agendamento.nexo.service.ClinicServiceService;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final ClinicServiceService clinicServiceService;
    private final AppointmentService appointmentService;

    @GetMapping("/")
    public String home(Model model) {
        if (!model.containsAttribute("appointmentForm")) {
            model.addAttribute("appointmentForm", new AppointmentFormDTO());
        }
        model.addAttribute("services", clinicServiceService.findAllServices());
        return "home";
    }

    @PostMapping("/appointments")
    public String createAppointment(
            @Valid @ModelAttribute("appointmentForm") AppointmentFormDTO appointmentForm,
            BindingResult bindingResult,
            Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("services", clinicServiceService.findAllServices());
            return "home";
        }

        try {
            v1.agendamento.nexo.model.Appointment appointment = appointmentService.createAppointment(appointmentForm);
            model.addAttribute("successMessage", "Consulta agendada com sucesso! Entraremos em contato via WhatsApp para confirmação.");
            model.addAttribute("scheduledAppointment", appointment);
            model.addAttribute("appointmentForm", new AppointmentFormDTO());
        } catch (Exception e) {
            model.addAttribute("errorMessage", e.getMessage());
            model.addAttribute("services", clinicServiceService.findAllServices());
            return "home";
        }

        model.addAttribute("services", clinicServiceService.findAllServices());
        return "home";
    }
}

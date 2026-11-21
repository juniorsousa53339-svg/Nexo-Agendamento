package v1.agendamento.nexo.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
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
            RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            String errorMsg = bindingResult.getAllErrors().get(0).getDefaultMessage();
            redirectAttributes.addFlashAttribute("errorMessage", errorMsg);
            redirectAttributes.addFlashAttribute("appointmentForm", appointmentForm);
            return "redirect:/#agendar";
        }

        try {
            appointmentService.createAppointment(appointmentForm);
            redirectAttributes.addFlashAttribute("successMessage", "Consulta agendada com sucesso! Entraremos em contato via WhatsApp para confirmação.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", e.getMessage());
            redirectAttributes.addFlashAttribute("appointmentForm", appointmentForm);
        }

        return "redirect:/#agendar";
    }
}

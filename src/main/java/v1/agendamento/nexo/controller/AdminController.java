package v1.agendamento.nexo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import v1.agendamento.nexo.model.Appointment;
import v1.agendamento.nexo.model.enums.AppointmentStatus;
import v1.agendamento.nexo.service.AppointmentService;
import v1.agendamento.nexo.service.PatientService;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {

    private final AppointmentService appointmentService;
    private final PatientService patientService;

    @GetMapping
    public String dashboard(
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date,
            Model model) {

        LocalDate targetDate = (date != null) ? date : LocalDate.now();
        List<Appointment> dailyAppointments = appointmentService.findAppointmentsByDate(targetDate);
        List<Appointment> upcomingAppointments = appointmentService.findUpcomingAppointments();

        model.addAttribute("selectedDate", targetDate);
        model.addAttribute("dailyAppointments", dailyAppointments);
        model.addAttribute("upcomingAppointments", upcomingAppointments);
        model.addAttribute("totalToday", appointmentService.countAppointmentsToday());
        model.addAttribute("totalCompleted", appointmentService.countCompletedAppointments());
        model.addAttribute("totalPending", appointmentService.countPendingAppointments());
        model.addAttribute("totalPatients", patientService.countTotalPatients());
        model.addAttribute("statuses", AppointmentStatus.values());

        return "admin/dashboard";
    }

    @PostMapping("/appointments/{id}/status")
    public String updateStatus(
            @PathVariable Long id,
            @RequestParam AppointmentStatus status,
            RedirectAttributes redirectAttributes) {
        try {
            appointmentService.updateStatus(id, status);
            redirectAttributes.addFlashAttribute("successMessage", "Status do agendamento atualizado com sucesso!");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", e.getMessage());
        }
        return "redirect:/admin";
    }
}

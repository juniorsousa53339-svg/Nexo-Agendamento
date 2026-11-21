package v1.agendamento.nexo.exception;

import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    public String handleBusinessException(BusinessException ex, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("errorMessage", ex.getMessage());
        return "redirect:/#agendar";
    }

    @ExceptionHandler(BindException.class)
    public String handleBindException(BindException ex, RedirectAttributes redirectAttributes) {
        String errorMsg = ex.getBindingResult().getAllErrors().stream()
                .findFirst()
                .map(err -> err.getDefaultMessage())
                .orElse("Erro de validação nos dados informados.");
        redirectAttributes.addFlashAttribute("errorMessage", errorMsg);
        return "redirect:/#agendar";
    }
}

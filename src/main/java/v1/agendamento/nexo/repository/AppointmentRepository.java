package v1.agendamento.nexo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import v1.agendamento.nexo.model.Appointment;
import v1.agendamento.nexo.model.enums.AppointmentStatus;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    List<Appointment> findByAppointmentDateOrderByAppointmentTimeAsc(LocalDate appointmentDate);

    List<Appointment> findByStatus(AppointmentStatus status);

    List<Appointment> findByAppointmentDateGreaterThanEqualOrderByAppointmentDateAscAppointmentTimeAsc(LocalDate date);

    @Query("SELECT a FROM Appointment a WHERE a.appointmentDate = :date AND a.appointmentTime = :time AND a.status <> 'CANCELADO'")
    List<Appointment> findActiveAppointmentsAtTime(@Param("date") LocalDate date, @Param("time") LocalTime time);

    boolean existsByServiceId(Long serviceId);

    long countByAppointmentDate(LocalDate date);

    long countByStatus(AppointmentStatus status);
}

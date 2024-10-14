package pe.com.cibertec.Lp2_t2.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import pe.com.cibertec.Lp2_t2.model.EmpleadoEntity;
import pe.com.cibertec.Lp2_t2.service.EmpleadoService;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class EmpleadoController {

    private final EmpleadoService empleadoService;

    @GetMapping("/listar_empleados")
    public String index(Model model) {
        List<EmpleadoEntity> listarEmpleados = empleadoService.buscarEmpleados();
        model.addAttribute("list_empleado", listarEmpleados);
        return "lista_empleados";
    }

    @GetMapping("/detalle_empleado/{dniEmpleado}")
    public String verDetalle(Model model, @PathVariable("dniEmpleado") String dniEmpleado) {
        EmpleadoEntity empleadoEncontrado = empleadoService.buscarEmpleadoPorDni(dniEmpleado);
        if (empleadoEncontrado != null) {
            model.addAttribute("empleado", empleadoEncontrado);
        } else {
            model.addAttribute("errorMessage", "Empleado no encontrado.");
        }
        return "detalle_empleado";
    }

    @GetMapping("/delete_empleado/{dniEmpleado}")
    public String deleteEmpleado(@PathVariable("dniEmpleado") String dniEmpleado) {
        empleadoService.eliminarEmpleado(dniEmpleado);
        return "redirect:/listar_empleados";
    }

    @GetMapping("/registrar_empleado")
    public String mostrarRegistrarEmpleado(Model model) {
        model.addAttribute("empleado", new EmpleadoEntity());
        return "registrar_empleado";
    }

    @PostMapping("/registrar_empleado")
    public String registrarEmpleado(@ModelAttribute("empleado") EmpleadoEntity empleado, Model model) {
        
        if (empleadoService.buscarEmpleadoPorDni(empleado.getDniEmpleado()) != null) {
            model.addAttribute("errorMessage", "El empleado ya existe, usa otro DNI");
            model.addAttribute("empleado", empleado);
            return "registrar_empleado";
        }
        
        empleadoService.crearEmpleado(empleado);
        return "redirect:/listar_empleados";
    }

    @GetMapping("/editar_empleado/{dniEmpleado}")
    public String mostrarEditarEmpleado(@PathVariable("dniEmpleado") String dniEmpleado, Model model) {
        EmpleadoEntity empleadoEncontrado = empleadoService.buscarEmpleadoPorDni(dniEmpleado);
        if (empleadoEncontrado != null) {
            model.addAttribute("empleado", empleadoEncontrado);
        } else {
            model.addAttribute("errorMessage", "Empleado no encontrado.");
            return "redirect:/listar_empleados";
        }
        return "editar_empleado";
    }

    @PostMapping("/editar_empleado/{dniEmpleado}")
    public String editarEmpleado(@PathVariable("dniEmpleado") String dni, @ModelAttribute("empleado") EmpleadoEntity empleado) {
        empleadoService.actualizarEmpleado(dni, empleado);
        return "redirect:/listar_empleados";
    }
}
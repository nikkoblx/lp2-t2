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

    @GetMapping("/")
    public String listarEmpleados(Model model) {
        List<EmpleadoEntity> listarEmpleados = empleadoService.buscarEmpleados();
        model.addAttribute("list_empleado", listarEmpleados);
        return "listar_empleados";
    }

    @GetMapping("/detalle_empleado/{dni}")
    public String verDetalle(Model model, @PathVariable("dni") String dni) {
        EmpleadoEntity empleadoEncontrado = empleadoService.buscarEmpleadoPorDni(dni);
        if (empleadoEncontrado != null) {
            model.addAttribute("empleado", empleadoEncontrado);
        } else {
            model.addAttribute("errorMessage", "Empleado no encontrado.");
        }
        return "detalle_empleado";
    }

    @GetMapping("/delete/{dni}")
    public String deleteEmpleado(@PathVariable("dni") String dni) {
        empleadoService.eliminarEmpleado(dni);
        return "redirect:/";
    }

    @GetMapping("/registrar_empleado")
    public String mostrarRegistrarEmpleado(Model model) {
        model.addAttribute("empleado", new EmpleadoEntity());
        return "registrar_empleado";
    }

    @PostMapping("/registrar_empleado")
    public String registrarEmpleado(@ModelAttribute("empleado") EmpleadoEntity empleado, Model model) {
        
        if (empleadoService.buscarEmpleadoPorDni(empleado.getDni()) != null) {
            model.addAttribute("errorMessage", "El empleado ya existe, usa otro DNI");
            model.addAttribute("empleado", empleado);
            return "registrar_empleado";
        }
        
        empleadoService.crearEmpleado(empleado);
        return "redirect:/";
    }

    @GetMapping("/editar_empleado/{dni}")
    public String mostrarEditarEmpleado(@PathVariable("dni") String dni, Model model) {
        EmpleadoEntity empleadoEncontrado = empleadoService.buscarEmpleadoPorDni(dni);
        if (empleadoEncontrado != null) {
            model.addAttribute("empleado", empleadoEncontrado);
        } else {
            model.addAttribute("errorMessage", "Empleado no encontrado.");
            return "redirect:/listar_empleados";
        }
        return "editar_empleado";
    }

    @PostMapping("/editar_empleado/{dni}")
    public String editarEmpleado(@PathVariable("dni") String dni, @ModelAttribute("empleado") EmpleadoEntity empleado, Model model) {
        empleadoService.actualizarEmpleado(dni, empleado);
        return "redirect:/";
    }
}
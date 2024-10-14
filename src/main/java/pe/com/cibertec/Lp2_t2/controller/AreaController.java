package pe.com.cibertec.Lp2_t2.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import pe.com.cibertec.Lp2_t2.model.AreaEntity;
import pe.com.cibertec.Lp2_t2.service.AreaService;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class AreaController {

	private final AreaService areaService;

	@GetMapping("/listar_area")
	public String index(Model model) {
		List<AreaEntity> listarAreas = areaService.buscarArea();
		model.addAttribute("list_area", listarAreas);
		return "lista_area";
	}

	@GetMapping("/detalle_area/{id}")
	public String verDetalle(Model model, @PathVariable("id") Integer id) {
		AreaEntity areaEncontrada = areaService.buscarAreaPorId(id);
		model.addAttribute("area", areaEncontrada);
		return "detalle_area";
	}

	@GetMapping("/delete/{id}")
	public String deleteArea(@PathVariable("id") Integer id) {
		areaService.eliminarArea(id);
		return "redirect:/listar_area";
	}

	@GetMapping("/registrar_area")
	public String mostrarRegistrarArea(Model model) {
		model.addAttribute("area", new AreaEntity());
		return "registrar_area";
	}

	@PostMapping("/registrar_area")
	public String registrarArea(@ModelAttribute("area") AreaEntity area) {
		areaService.crearArea(area);
		return "redirect:/listar_area";
	}

	@GetMapping("/editar_area/{id}")
	public String mostrarEditarArea(@PathVariable("id") Integer id, Model model) {
		AreaEntity areaEncontrada = areaService.buscarAreaPorId(id);
		model.addAttribute("area", areaEncontrada);
		return "editar_area";
	}

	@PostMapping("/editar_area/{id}")
	public String editarArea(@PathVariable("id") Integer id, @ModelAttribute("area") AreaEntity area) {
		areaService.actualizarArea(id, area);
		return "redirect:/listar_area";
	}
}
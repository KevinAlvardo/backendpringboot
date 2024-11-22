package Controllers;

import Services.VehiculoService;
import entities.Vehiculo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehiculos")
public class VehiculoController {

    @Autowired
    private VehiculoService vehiculoService;

    @GetMapping
    public List<Vehiculo> listarVehiculos() {
        return vehiculoService.obtenerTodosLosVehiculos();
    }

    @GetMapping("/{id}")
    public Vehiculo obtenerVehiculo(@PathVariable Integer id) {
        return vehiculoService.obtenerVehiculoPorId(id);
    }

    @PostMapping
    public Vehiculo agregarVehiculo(@RequestBody Vehiculo vehiculo) {
        return vehiculoService.agregarVehiculo(vehiculo);
    }

    @PutMapping("/{id}")
    public Vehiculo actualizarVehiculo(@PathVariable Integer id, @RequestBody Vehiculo vehiculo) {
        return vehiculoService.actualizarVehiculo(id, vehiculo);
    }

    @DeleteMapping("/{id}")
    public void eliminarVehiculo(@PathVariable Integer id) {
        vehiculoService.eliminarVehiculo(id);
    }
}

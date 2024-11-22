package Services;

import Repositories.VehiculoRepository;
import entities.Vehiculo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehiculoService {

    @Autowired
    private VehiculoRepository vehiculoRepository;

    public List<Vehiculo> obtenerTodosLosVehiculos() {
        return vehiculoRepository.findAll();
    }

    public Vehiculo obtenerVehiculoPorId(Integer id) {
        return vehiculoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vehículo no encontrado con ID: " + id));
    }

    public Vehiculo agregarVehiculo(Vehiculo vehiculo) {
        return vehiculoRepository.save(vehiculo);
    }

    public Vehiculo actualizarVehiculo(Integer id, Vehiculo vehiculoActualizado) {
        Vehiculo vehiculo = obtenerVehiculoPorId(id);
        vehiculo.setMarca(vehiculoActualizado.getMarca());
        vehiculo.setModelo(vehiculoActualizado.getModelo());
        vehiculo.setAnio(vehiculoActualizado.getAnio());
        vehiculo.setColor(vehiculoActualizado.getColor());
        vehiculo.setTipoVehiculo(vehiculoActualizado.getTipoVehiculo());
        vehiculo.setEstado(vehiculoActualizado.getEstado());
        vehiculo.setUbicacionActual(vehiculoActualizado.getUbicacionActual());
        vehiculo.setKilometraje(vehiculoActualizado.getKilometraje());
        vehiculo.setTransmision(vehiculoActualizado.getTransmision());
        vehiculo.setCombustible(vehiculoActualizado.getCombustible());
        vehiculo.setPrecioPorDia(vehiculoActualizado.getPrecioPorDia());
        return vehiculoRepository.save(vehiculo);
    }

    public void eliminarVehiculo(Integer id) {
        vehiculoRepository.deleteById(id);
    }
}

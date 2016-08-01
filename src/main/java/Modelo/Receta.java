/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Spring.Mensajes;
import com.opensymphony.xwork2.validator.annotations.StringLengthFieldValidator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.apache.struts2.json.annotations.JSON;
import org.joda.time.LocalDateTime;

/**
 *
 * @author ang_2
 */
public class Receta implements Mensajes {

    private int id;
    private String nombre, fAlta, fBaja;
    private CategoriaReceta categoriaReceta;
    private Set<Ingrediente> ingredientes;
    private Set<DetalleReceta> recetas;
    private LocalDateTime fechaAlta, fechaBaja;

    public Receta() {
    }

    public Receta(String nombre, CategoriaReceta categoriaReceta, Set<Ingrediente> ingredientes, Set<DetalleReceta> recetas) {
        this.nombre = nombre;
        this.categoriaReceta = categoriaReceta;
        this.ingredientes = ingredientes;
        this.recetas = recetas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    @StringLengthFieldValidator(maxLength = "100", message = "La cantidad máxima de carácter es de 100", fieldName = "nombre")
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public CategoriaReceta getCategoriaReceta() {
        return categoriaReceta;
    }

    public void setCategoriaReceta(CategoriaReceta categoriaReceta) {
        this.categoriaReceta = categoriaReceta;
    }

    public Set<Ingrediente> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(Set<Ingrediente> ingredientes) {
        this.ingredientes = ingredientes;
    }

    public Set<DetalleReceta> getRecetas() {
        return recetas;
    }

    public void setRecetas(Set<DetalleReceta> recetas) {
        this.recetas = recetas;
    }

    public String getfAlta() {
        if (null == fechaAlta) {
            return null;
        }
        return fechaAlta.toString(mensajes.FECHAJSON);
    }

    public void setfAlta(String fAlta) {
        this.fAlta = fAlta;
    }

    public String getfBaja() {
        if (null == fechaBaja) {
            return null;
        }
        return fechaBaja.toString(mensajes.FECHAJSON);
    }

    public void setfBaja(String fBaja) {
        this.fBaja = fBaja;
    }

    @JSON(serialize = false)
    public LocalDateTime getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(LocalDateTime fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    @JSON(serialize = false)
    public LocalDateTime getFechaBaja() {
        return fechaBaja;
    }

    public void setFechaBaja(LocalDateTime fechaBaja) {
        this.fechaBaja = fechaBaja;
    }

    @Override
    public String toString() {
        return "Receta{" + "id=" + id + ", nombre=" + nombre + ", categoriaReceta=" + categoriaReceta + ", ingredientes=" + ingredientes + ", recetas=" + recetas + '}';
    }

    public void nueva(Set<Ingrediente> ingredientesSeleccionados, Set<DetalleReceta> recetasSeleccionados) {
        this.setIngredientes(ingredientesSeleccionados);
        this.setRecetas(recetasSeleccionados);
        this.setFechaAlta(new LocalDateTime());
    }

    public void darDeBaja() {
        this.setFechaBaja(new LocalDateTime());
    }

    public void actualizar(Receta receta, Set<Ingrediente> ingredientesSeleccionados, Set<DetalleReceta> recetasSeleccionados) {
        this.nombre = receta.getNombre();
        Map<Integer, DetalleReceta> mapDetalleRecetasRequest = new HashMap<>();
        if (recetasSeleccionados != null && !recetasSeleccionados.isEmpty()) {
            for (DetalleReceta i : recetasSeleccionados) {
                mapDetalleRecetasRequest.put(i.getReceta().getId(), i);
            }
        }
        //recorro todos los detalles recetas que estan en la bd, y verifico si en las que el usuario pasa no estan mas, si es el caso las elimino
        for (Iterator<DetalleReceta> iterator = recetas.iterator(); iterator.hasNext();) {
            DetalleReceta detalleRecetaEnBD = iterator.next();
            if (!mapDetalleRecetasRequest.containsKey(detalleRecetaEnBD.getReceta().getId())) {
                //es una eliminacion
                iterator.remove();
            }
        }
        for (Map.Entry<Integer, DetalleReceta> entry : mapDetalleRecetasRequest.entrySet()) {
            Integer idReceta = entry.getKey();
            DetalleReceta detalleRecetaRequest = entry.getValue();
            boolean flag = false;
            for (DetalleReceta detalleRecetaBD : recetas) {
                if (detalleRecetaBD.getReceta().getId() == idReceta) {
                    //si son iguales es una modificacion
                    detalleRecetaBD.actualizar(detalleRecetaRequest);
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                //es alta
                recetas.add(detalleRecetaRequest);
            }
        }
        Map<Integer, Ingrediente> mapIngredientesRequest = new HashMap<>();
        if (ingredientesSeleccionados != null && !ingredientesSeleccionados.isEmpty()) {
            for (Ingrediente i : ingredientesSeleccionados) {
                mapIngredientesRequest.put(i.getInsumo().getId(), i);
            }
        }
        //veo si en la lista que pasa el usuario se saco algun ingrediente, si es el caso elimino.
        for (Iterator<Ingrediente> iterator = ingredientes.iterator(); iterator.hasNext();) {
            Ingrediente ingredienteEnBD = iterator.next();
            if (!mapIngredientesRequest.containsKey(ingredienteEnBD.getInsumo().getId())) {
                //es una eliminacion
                iterator.remove();
            }
        }
        for (Map.Entry<Integer, Ingrediente> entry : mapIngredientesRequest.entrySet()) {
            Integer idInsumo = entry.getKey();
            Ingrediente ingredienteRequest = entry.getValue();
            boolean flag = false;
            for (Ingrediente ingredienteBD : ingredientes) {
                if (ingredienteBD.getInsumo().getId() == idInsumo) {
                    //si son iguales es una modificacion
                    ingredienteBD.actualizar(ingredienteRequest);
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                //es alta
                ingredientes.add(ingredienteRequest);
            }
        }

    }

}

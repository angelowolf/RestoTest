<div class="form-group">
    <label class="control-label" for="rol" name="rol">Roles *</label>
    <div class="checkbox">
        <label>
            <input type="checkbox" name="roles" id="rolUsuario" value="<%out.println(Modelo.Rol.Usuario);%>">Responsable de Usuario
        </label>
    </div>
    <div class="checkbox">
        <label>
            <input type="checkbox" name="roles" id="rolCocina" value="<%out.println(Modelo.Rol.Cocina);%>">Responsable de Cocina
        </label>
    </div>
    <div class="checkbox">
        <label>
            <input type="checkbox" name="roles" id="rolCaja" value="<%out.println(Modelo.Rol.Caja);%>">Responsable de Caja
        </label>
    </div>
    <div class="checkbox">
        <label>
            <input type="checkbox" name="roles" id="rolMesa" value="<%out.println(Modelo.Rol.Mesa);%>">Responsable de Mesa
        </label>
    </div>
    <div class="checkbox">
        <label>
            <input type="checkbox" name="roles" id="rolStock" value="<%out.println(Modelo.Rol.Stock);%>">Responsable de Stock
        </label>
    </div>
    <div class="checkbox">
        <label>
            <input type="checkbox" name="roles" id="rolMozo" value="<%out.println(Modelo.Rol.Mozo);%>">Mozo
        </label>
    </div>
    <span class="help-block"></span>
</div>
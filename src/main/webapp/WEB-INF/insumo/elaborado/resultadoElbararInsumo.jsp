<%@taglib uri="/struts-tags" prefix="s"%>
<p>Se va a Descontar Stock de los siguientes insumos brutos:</p>
<table class="table table-striped">
    <thead>
        <tr><th>Nombre</th><th>Cantidad Actual en Stock</th><th>Cantidad a Descontar</th></tr>
    </thead>
    <tbody>
        <s:iterator var="cadaBruto" value="brutos">

            <tr>
                <td>
                    <s:property value="#cadaBruto.nombre"/>
                </td>
                <td>
                    <s:property value="#cadaBruto.stock.cantidadActual"/>
                </td>
                <td>
                    <s:property value="#cadaBruto.cantidadDescontar"/>
                </td>
            </tr>

        </s:iterator>
    </tbody>
</table>